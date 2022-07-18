<%@page import="EkhairatDA.DB"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<title>Senarai Ahli</title>
<link rel="stylesheet" href="style.css">
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
h1{
font-color:black;
font-size:28;
}
</style>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
    if(session.getAttribute("id")==null)
        response.sendRedirect("index.jsp");
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
            JUMLAH KEWANGAN KESELURUHAN 
        </h1>
        <%
            Connection con = null;
        	Connection connection = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            PreparedStatement p = null;
            ResultSet r = null;
            PreparedStatement a = null;
            ResultSet sa = null;
        %>
        <br><br><br>
        <div class="scroll">
        <br>
        <input type=hidden name="memberid"  value="${memberid}">
        <div class="infoSemasa">
        <table border="2">
                	<tr>
                    <th>TOTAL PEMBAYARAN KHAIRAT TELAH DISAHKAN</th><th>TOTAL PEMBAYARAN KHAIRAT BELUM DISAHKAN</th><th>TOTAL SUMBANGAN</th>
                	</tr>

            <%
            	con = DB.getConnection();
            	String sq = "select sum(paymentvalue) from khairatpayment where status='Disahkan'";
                p = con.prepareStatement(sq);
                r = p.executeQuery();
                String totalsah="";
                while(r.next()){
                totalsah = r.getString(1);
                %><tr>
                <td style="font-color:black">RM<%=totalsah %></td>
            <%}
                con = DB.getConnection();
            	String sqla = "select sum(paymentvalue) from khairatpayment where status='Pending'";
                a = con.prepareStatement(sqla);
                sa = a.executeQuery();
                String total="";
                while(sa.next()){
                total = sa.getString(1);
                %>
                <td style="font-color:black">RM<%=total %></td>
            <%
            }
        
            	connection = DB.getConnection();
            	String sql = "select sum(donationvalue) from donation";
                ps = connection.prepareStatement(sql);
                rs = ps.executeQuery();
                String totaldonate="";
                while(rs.next()){
                totaldonate = rs.getString(1);
                %>
                <td style="font-color:black">RM<%=totaldonate %></td>
                </tr>
            <%
            } 
            %>
        
			
			</table>
			</div>
			</div>
    </header>
</body>
</html>