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
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Halaman Utama</title>
<link rel="stylesheet" href="style.css">

<style>

.grid-container{
	display
}
</style>
</head>
<body>

    <header>
        <div class="topheader"></div>
        <img class="banner" src="Screenshot_243.jpg">
        <ul class="bar">
            <li id="link2">
                <b><a id="linkin2" onclick="window.location.href='HOMEPAGE_STAFF.jsp';">HALAMAN UTAMA</a></b>
            </li>
            <li id="link2">
                <b><a id="linkin2" onclick="window.location.href='AKAUN_STAFF.jsp';">AKAUN PENGGUNA</a></b>
            </li>
            <li id="link2">
                <b><a id="linkin2" onclick="window.location.href='.jsp';">LAPORAN</a></b>
            </li>
            <li id="link2">
                <b><a id="linkin2" onclick="window.location.href='.jsp';">PENGESAHAN PEMBAYARAN</a></b>
            </li>
            <li id="link2">
                <b><a id="linkin2" onclick="window.location.href='.jsp';">PENERIMAAN KHAIRAT</a></b>
            </li>
            <li id="link2">
                <b><a id="linkin2" onclick="window.location.href='.jsp';">PENGURUSAN AKTIVITI</a></b>
            </li>
            <li id="log" class="log">
                <b><a id="linkin2" onclick="window.location.href='staff.index.jsp';">LOG KELUAR</a></b>
            </li>
        </ul>
        
    </header>
    <div class="grid-container">
        <div id="">
             <div id="reka"><button class="reka" onclick="window.location.href='createannouncement.jsp';">REKA PENGUMUMAN</button>

            <h1 class="senarai">PEMGUMUMAN YANG DI HANTAR AKAN DISIARKAN DI HALAMAN UTAMA</h1>

           </div>
        </div>
           
           </div>
        <div id="form" >
            <h1 class="pengumuman">CIPTA AKTIVITI BAHARU</h1>

            <form action="uploadaktivity" method="post">
            <input type=hidden name="id"  value="${id}">
             <label for="tajuk">Tajuk aktiviti:</label>
             <input type="text" id="tajuk" name="tajuk"><br><br>
            <label for="tarikh">Tarikh:</label>
            <input type="date" id="tarikh" name="tarikh"><br><br>

            <label for="aktiviti">Taksiran aktiviti:</label>
            <input type="text" id="aktiviti" name="aktiviti"><br><br>

             <input type="submit" value="MUAT NAIK AKTIVITI">
            </form>
        </div>  
       
		
         <div id="">
            <h1 class="pengumuman">SENARAI AKTIVITI AKTIF</h1>
             
         </div>
</body>
</html>