<%@page import="EkhairatDA.DB"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Halaman Utama</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="popup.css">
<script src="testingpopup.js"></script>
</head>
<style>
div.infoSemasa{
padding-left: 120px;
}
th,tr{
text-align: center;
}
table{
width:80%;
 border-collapse: collapse;
  border-radius: 1em;
  overflow: hidden;
}
</style>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
    if(session.getAttribute("id")==null)
        response.sendRedirect("staff.index.jsp");
%>
    <header>
        <div class="topheader"></div>
        <img class="banner" src="Screenshot_243.jpg">
        <ul class="bar">
            <li id="link">
                <b><a id="linkin" onclick="window.location.href='HOMEPAGE_STAFF.jsp';">HALAMAN UTAMA</a></b>
            </li>
            <li id="link">
                <b><a id="linkin" onclick="window.location.href='AKAUN_STAFF.jsp';">AKAUN PENGGUNA</a></b>
            </li>
            <li id="link">
                <b><a id="linkin" onclick="window.location.href='laporan.jsp';">LAPORAN</a></b>
            </li>
            <li id="link">
                <b><a id="linkin" onclick="window.location.href='penggesahan_bayaran.jsp';">PENGESAHAN PEMBAYARAN</a></b>
            </li>
            <li id="link">
                <b><a id="linkin" onclick="window.location.href='khairatacceptor.jsp';">KHAIRAT</a></b>
            </li>
            <li id="log" class="log">
                <b><a id="linkin" onclick="window.location.href='staff.index.jsp';">LOG KELUAR</a></b>
            </li>
        </ul>
		<%!
            Connection connection = null;
            PreparedStatement stmt = null;
            ResultSet rst = null;
        %>
<form action="createNewAcceptor" method="post">
                        <select name="memberid" onchange="document.getElementById('vid').value=this.option[this.selectedIndex].text">
                            <option>Select One</option>
                   <%
                   connection = DB.getConnection();
                   stmt=connection.prepareStatement("Select memberid, membername from khairatmember order by memberid");
                   ResultSet rst=stmt.executeQuery();
                   while(rst.next())
                       {
                    %>
                            <option>No.K/P: <%=rst.getString("memberid")%> | Nama: <%=rst.getString("membername")%></option>
                     <%		session.setAttribute("memberidaccept", rst.getString("memberid"));

 						}
                     %>
                        </select>
                     
                    
                    <label class="" for="acceptorvalue">Jumlah Pemberian</label>
					<input class = "" type="number" id="acceptorvalue" name="acceptorvalue" placeholder = "Jumlah Pemberian" required>
                    <label for="acceptornote">Catatan Penerima</label>
					<textarea rows = "5" cols = "60" id="acceptornote" name="acceptornote" placeholder = "Sila tulis catatan penerimaan khairat..."></textarea>
					<input type="hidden" name="action" value="createAcceptor">
					<button type="submit" name="submit">Cipta Penerima</button>
</form>
<br><br>
        <div class="info">
        <h1>
             Penerimaan Khairat

        </h1>
        </div>
        <%!
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
        %>
		<form action="uploadkhairatpayment" method="post">
        <input type=hidden name="staffid"  value="${staffid}">
        <div class="infoSemasa">
        <table border="2">
            <tr>
                <th>ID Pengeluaran</th><th>Maklumat Penerima</th><th>Maklumat Pemberi</th><th>Jumlah Pemberian</th><th>Catatan</th>
                
            </tr>
            <%
            
            con = DB.getConnection();
            String sql = "select acceptorid,memberid, membername,staffid,staffname,acceptorvalue,acceptornote from khairatacceptor join khairatmember using (memberid) join khairatstaff using (staffid) order by acceptorid";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            %>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td>No.K/P: <%=rs.getString(2)%> Nama: <%=rs.getString(3)%> </td>
                <td>No.K/P: <%=rs.getString(4)%> Nama:<%=rs.getString(5)%></td>
                <td>RM<%=rs.getString(6)%></td>
                <td><%=rs.getString(7)%></td>
                <td><a href='deleteAcceptor?id=<%=rs.getString(1)%>' class="btn btn-danger" style= "padding:6px;border-radius:20px;font-size:15px; background-color: #e60000" onclick="ConfirmDelete()">Delete</a></td>
            </tr>
            <%
                }
            %>
            
        </table>
        </div>
        </form>
			<br>
			<br>
</header>
<div class="info">
        <h1>
             SENARAI AHLI YANG MAHU AKAUN MEREKA DIHAPUSKAN
        </h1>
        <form action="uploadkhairatpayment" method="post">
        <input type=hidden name="staffid"  value="${staffid}">
        <div class="infoSemasa">
        <table border="2">
            <tr>
                <th>memberid</th><th>membername</th><th>membercontactno</th><th>memberaddress</th><th>status</th>
                
            </tr>
            <%
            
            con = DB.getConnection();
            String sq = "select memberid, membername, membercontactno, memberaddress, request from khairatmember where request='DELETE AKAUN INI'";
            ps = con.prepareStatement(sq);
            rs = ps.executeQuery();
            while (rs.next()) {
            %>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><a href='deletemember?memberid=<%=rs.getString(1)%>' class="btn btn-danger" style= "padding:6px;border-radius:20px;font-size:15px; background-color: #e60000" onclick="ConfirmPadam()">Padam Akaun</a>
                <a href='aktifakaunsemula?memberid=<%=rs.getString(1)%>' class="btn btn-danger" style= "padding:6px;border-radius:20px;font-size:15px; background-color: #C1E1C1" onclick="ConfirmAktif()">Aktifkan Akaun Semula</a></td>
            </tr>
            <%
                }
            %>
            
        </table>
        </div>
        </form>
        
        </div>




<script>
function ConfirmPadam()
{
  return confirm("Anda pasti untuk padam akaun ini? Akaun ini akan dihapuskan serta merta");
}

function ConfirmAktif()
{
  return confirm("Anda pasti mahukan aktifkan semula akaun ini?");
}

function ConfirmDelete()
{
  return confirm("Anda pasti mahu padam penerimaan ini?");
}
</script>
</body>
</html>