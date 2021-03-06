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

<br><br>
        <div class="info">
        <h1>
             INFO SEMASA

        </h1>
        </div>
		<%!
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
        %>
        <br><br><br>
        <div class="scroll">
        <br>
		<form action="uploadkhairatpayment" method="post">
        <input type=hidden name="staffid"  value="${staffid}">
        <div class="infoSemasa">
        <table border="2">
            <tr>
                <th>Tarikh & Masa</th><th>Pengumuman</th><th>Nama Staf</th><th>Buang Pengumuman</th>
                
            </tr>
            <%
            con = DB.getConnection();
            String sql = "select announcedatentime, announcedetail, staffid, staffname, announceid from announcement natural join khairatstaff order by announcedatentime";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            %>
            <tr>
            	<td><%=rs.getTimestamp(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(4)%></td>
                <td><a href='deleteAnnouncement?id=<%=rs.getString(5)%>' class="deleteannounce" style= "padding:10px;border-radius:20px;font-size:15px; background-color: #e60000">Padam</a></td>
            </tr>
            <%
                }
            %>
            
        </table>
        </div>
        </form>
			</div>
			<br>
			<div id="reka">
			<button class="reka" onclick="window.location.href='createannouncement.jsp';">REKA PENGUMUMAN</button>
			</div>
			<br>
    </header>
<script>

var elems = document.getElementsByClassName('deleteannounce');
var confirmIt = function (e) {
    if (!confirm('Anda pasti mahu padam pengumuman ini?')) e.preventDefault();
};
for (var i = 0, l = elems.length; i < l; i++) {
    elems[i].addEventListener('click', confirmIt, false);
}

</script>
</body>
</html>