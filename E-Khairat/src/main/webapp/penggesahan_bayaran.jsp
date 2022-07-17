<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="EkhairatDA.DB"%>
<%@page import="java.sql.*" %>
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
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Pengesahan Bayaran</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%!
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
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
        <div id="container-outer2">
        <div style="overflow-x:auto;">
            <h1 id="senarai">SENARAI NAMA AHLI MENUNGGU PENGESAHAN BAYARAN   </h1>
  		<form action="updatestatusbayaran" method="post">
        <input type=hidden name="id"  value="${id}">
        <table border="2">
            <tr>
                <th>ResitID</th><th>MemberID</th><th>Member Name</th><th>Tarikh dan Masa Bayaran</th><th>Papar Resit Transaksi</th><th>Sahkan Bayaran</th>
            </tr>
            <%
            String id;
            con = DB.getConnection();
            String sql = "select receiptid, memberid, membername, datentime from khairatpayment join khairatmember using (memberid) where status='Pending'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            id=rs.getString(1);
            %>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getTimestamp(4)%></td>
                <td><a href="displaykhairatpayment?receiptid=<%=rs.getString(1)%>">Papar</a></td>
                <td><a href="updatestatusbayaran?receiptid=<%=rs.getString(1)%>"onclick="ConfirmDelete()">Sahkan Bayaran</a></td>
            </tr>
            <%
            	}
            %>
            
        </table>
        </form>
</div>
</div>
    </header>
    <script>
function ConfirmDelete()
{
  return confirm("Anda pasti untuk detail adalah benar?");
}

</script>
</body>
</html>
