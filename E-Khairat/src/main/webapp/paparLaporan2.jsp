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
            SENARAI AHLI 
        </h1>
        </div>
        <%!
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            PreparedStatement p = null;
            ResultSet r = null;
        %>
        <br><br><br>
        <div class="scroll">
        <br>
        <input type=hidden name="memberid"  value="${memberid}">
        <div class="infoSemasa">
        

            <%
           // DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
            String year = request.getParameter("yearinsert");
            System.out.println(year);
            //String dates = year+"/01/01 00:00:00.000";
            //String datee = year+"/12/31 00:00:00.000";
            //Date datestart = df.parse(dates);
            //Date dateend = df.parse(datee);
            
            if (year.equalsIgnoreCase("2020")){
            	con = DB.getConnection();
            	String sql = "select receiptid, memberid, membername, datentime, status from khairatpayment join khairatmember using (memberid) where datentime >= timestamp '2020-01-01 00:00:00' and datentime <= timestamp '2020-12-31 00:00:00'";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                %> <table border="2">
            	<tr>
                <th>Receiptid</th><th>Nombor KP</th><th>Nama</th><th>Tarikh dan Masa</th><th>Status Bayaran</th>
            	</tr> <%
                while (rs.next()) {
                %>
                <tr>
                	<td><%=rs.getString(1)%></td>
                    <td><%=rs.getString(2)%></td>
                    <td><%=rs.getString(3)%></td>
                    <td><%=rs.getTimestamp(4)%></td>
                    <td><%=rs.getString(5)%></td>
                </tr>
                
                <%
                }
                %> </table> <%
                String sq = "select sum(paymentvalue) from khairatpayment where datentime >= timestamp '2020-01-01 00:00:00' and datentime <= timestamp '2020-12-31 00:00:00'";
                p = con.prepareStatement(sq);
                r = p.executeQuery();
                String total="";
                while(r.next()){
                total = r.getString(1);
                %>
                <h1 style="font-color:black">Total Khairat payment RM:<%=total %></h1>
            <%}
                
            }else if(year.equalsIgnoreCase("2021")){
            	con = DB.getConnection();
            	String sql = "select receiptid, memberid, membername, datentime, status from khairatpayment join khairatmember using (memberid) where datentime >= timestamp '2021-01-01 00:00:00' and datentime <= timestamp '2021-12-31 00:00:00'";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                %> <table border="2">
            	<tr>
                <th>Receiptid</th><th>Nombor KP</th><th>Nama</th><th>Tarikh dan Masa</th><th>Status Bayaran</th>
            	</tr> <%
                while (rs.next()) {
                %>
                <tr>
                	<td><%=rs.getString(1)%></td>
                    <td><%=rs.getString(2)%></td>
                    <td><%=rs.getString(3)%></td>
                    <td><%=rs.getTimestamp(4)%></td>
                    <td><%=rs.getString(5)%></td>
                </tr>
                
                <%
                }
                %> </table> <%
                String sq = "select sum(paymentvalue) from khairatpayment where datentime >= timestamp '2021-01-01 00:00:00' and datentime <= timestamp '2021-12-31 00:00:00'";
                p = con.prepareStatement(sq);
                r = p.executeQuery();
                String total="";
                while(r.next()){
                total = r.getString(1);
                %>
                <h1 style="font-color:black">Total Khairat payment RM:<%=total %></h1>
            <%}
       
            }else if(year.equalsIgnoreCase("2022")){
            	con = DB.getConnection();
            	String sql = "select receiptid, memberid, membername, datentime, status from khairatpayment join khairatmember using (memberid) where datentime >= timestamp '2022-01-01 00:00:00' and datentime <= timestamp '2022-12-31 00:00:00'";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                %> <table border="2">
            	<tr>
                <th>Receiptid</th><th>Nombor KP</th><th>Nama</th><th>Tarikh dan Masa</th><th>Status Bayaran</th>
            	</tr> <%
                while (rs.next()) {
                %>
                <tr>
                	<td><%=rs.getString(1)%></td>
                    <td><%=rs.getString(2)%></td>
                    <td><%=rs.getString(3)%></td>
                    <td><%=rs.getTimestamp(4)%></td>
                    <td><%=rs.getString(5)%></td>
                </tr>
                
                <%
                }
                %> </table> <%
                String sq = "select sum(paymentvalue) from khairatpayment where datentime >= timestamp '2022-01-01 00:00:00' and datentime <= timestamp '2022-12-31 00:00:00'";
                p = con.prepareStatement(sq);
                r = p.executeQuery();
                String total="";
                while(r.next()){
                total = r.getString(1);
                %>
                <h1 style="font-color:black">Total Khairat payment RM:<%=total %></h1>
            <%}
            }
            %>
            
        </div>
			</div>
			
    </header>
</body>
</html>