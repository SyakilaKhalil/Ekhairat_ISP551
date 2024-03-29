<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="EkhairatDA.DB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<% if(session.getAttribute("id")==null)
	response.sendRedirect("index.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sejarah Sumbangan</title>
<link rel="stylesheet" href="style.css">
</head>
<style>
div.sejarah{
padding-left:200px;
}
th,tr,td{
text-align: center;
}
table{
width:80%;
 border-collapse: collapse;
  border-radius: 1em;
  overflow: hidden;
}
h1{
padding-left: 20px;
color:black;
font-size:36px;
}
</style>
<body>
	<header>
		<div class="topheader"></div>
		<img class="banner" src="Screenshot_243.jpg">
		<ul class="bar">
			<li id="link">
				<b><a id="linkin" onclick="window.location.href='HOMEPAGE_MEMBER.jsp';">HALAMAN UTAMA</a></b>
			</li>
			<li id="link">
				<b><a id="linkin" onclick="window.location.href='AKAUN_PENGGUNA.jsp';">AKAUN PENGGUNA</a></b>
			</li>
			<li id="link">
				<b><a id="linkin" onclick="window.location.href='SEJARAH_PEMBAYARAN.jsp';">SEJARAH 
				& PEMBAYARAN</a></b>
			</li>
			<li id="log" class="log">
				<b><a id="linkin" onclick="window.location.href='index.jsp';">LOG KELUAR</a></b>
			</li>
			</ul>
			<h1>SEJARAH SUMBANGAN</h1>
			<div class="sejarah">
				<%!
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
        %>
        <form action="downloadkhairatpayment" method="post">
        <input type=hidden name="memberID"  value="${memberID}">
        <table border="2">
            <tr>
                <th>Nombor K/P</th><th>Tarikh Dan Masa</th><th>Jumlah Sumbangan</th><th>Papar Resit Transaksi</th>
            </tr>
            <%
            String memberid =(String)session.getAttribute("id");
            session.setAttribute("id",memberid);
            con = DB.getConnection();
            String sql = "select * from donation where memberid=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, memberid);
            rs = ps.executeQuery();
            while (rs.next()) {
            %>
            <tr>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getTimestamp(4)%></td>
                <td>RM<%=rs.getString(6)%></td>
                <td><a href="displayDonation?receiptid=<%=rs.getString(1)%>">Papar</a></td>
            </tr>
            <%
                }
            %>
            
        </table>
        </form>
			</div>
			<div class="button right1">
  			 	<b><a class="but_kem" onclick="window.location.href='SEJARAH_PEMBAYARAN.jsp';">KEMBALI</a></b>
   				
  			</div>
			
	</header>
</body>
</html>