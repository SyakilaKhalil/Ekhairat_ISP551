<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Halaman Laporan</title>
<link rel="stylesheet" href="style.css">
</head>
<style type="text/css">
	.report{

			display: inline-block;
	}
	.button{
		align-items: center;
    margin: 0;
    padding: 0;
    background-color: #ffe699;

    border-radius: 50px;
}

}
</style>
<body>
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
				<b><a id="linkin" onclick="window.location.href='LAPORAN.jsp';">LAPORAN</a></b>
			</li><li id="link">
				<b><a id="linkin" href="">PENGESAHAN PEMBAYARAN</a></b>
			</li>
			<li id="link">
				<b><a id="linkin" href="">PENERIMAAN KHAIRAT</a></b>
			</li>
			<li id="link">
				<b><a id="linkin" href="">PENGURUSAN AKTIVITI</a></b>
			</li>
			<li id="log" class="log">
				<b><a id="linkin" onclick="window.location.href='staff.index.jsp';">LOG KELUAR</a></b>
			</li>
		</ul>
		<br>
		<div class="report">
			<div class="scroll2">
				<h3>LAPORAN KHAIRAT TAHUNAN</h3>
				<br>
			<form action="#">
		      <label for="lang">Sila pilih tahun</label>
		    <select name="languages" id="lang">
		        <option value="2020">2020</option>
		        <option value="2021">2021</option>
		        <option value="2022">2022</option>
      		</select>
			</form>


			<br>
			<div class="button">
				<li id="link1">
				<b><a id="linkin" href="">PAPAR LAPORAN</a></b>
			</li>
			</div>
			
	    </div>


	    	
			<div class="scroll2">
				<h3>LAPORAN KHAIRAT KESELURUHAN</h3>
				<br>
				<br>
			<br>
			<div class="button">
				<li id="link1">
				<b><a id="linkin" href="laporankewangan.jsp">PAPAR LAPORAN</a></b>
			</li>
			</div>
	    
</div>
		
					<div class="scroll2">
						<h3>SENARAI AHLI</h3>
						<br>
						<br>
					<br>
					<div class="button">
						<li id="link1">
						<b><a id="linkin" href="">PAPAR LAPORAN</a></b>
					</li>
					</div>
		</div>
		</div>
	</header>
</body>
</html>