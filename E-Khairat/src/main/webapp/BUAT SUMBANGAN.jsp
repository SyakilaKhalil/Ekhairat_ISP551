<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% if(session.getAttribute("id")==null)
	response.sendRedirect("index.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buat Sumbangan</title>
<link rel="stylesheet" href="style.css">
</head>
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
				<b><a id="linkin" onclick="window.location.href='loginpage.jsp';">LOG KELUAR</a></b>
			</li>
			</ul>
			<form action="uploaddetail" method="post" enctype="multipart/form-data">
			<h1 id = "muatnaik">MUAT NAIK BUTIRAN TRANSAKSI</h1>
			<br>
			<br>
			<h3>JUMLAH SUMBANGAN: RM</h3>
			<input type="text" id="donate" name="" required>

 			 <div class="button">
 			 	<td>Muat Naik Gambar</td>
                <input type="file" name="filekhairat" accept="image" required>
                <input type="hidden" name="action"  value="createPayment">
                <input type="submit" value="Submit">
             </div>
  			 <div class="button right">
  			 	<b><a class="but_kem" onclick="window.location.href='SEJARAH_PEMBAYARAN.jsp';">KEMBALI</a></b>
   				
  			</div>
  			</form>
			
	</header>
</body>
</html>