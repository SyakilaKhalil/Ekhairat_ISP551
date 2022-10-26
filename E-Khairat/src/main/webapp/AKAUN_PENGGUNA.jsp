<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% if(session.getAttribute("id")==null)
	response.sendRedirect("index.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Akaun Pengguna</title>
<link rel="stylesheet" href="style.css">
</head>
<style>

table, th, td {
  border: 1px solid  #f4a460;
  border-radius:2px;
}
table {
  width: 90%;
  margin-left:30px;
  margin-top:40px;
  font-size:18;
  background: white;
  border-colour:;
}
th,
td {
  padding: 5px;
  text-align: left;
}
.button1{
  border-radius: 12px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  cursor: pointer;
  margin: 4px 85%;
  padding: 11px;
  background-color: #4CAF50;
  margin-top:10px;
  font-family: serif, Helvetica; 
  background-color: #81bb7d;
	border: none;
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
				<b><a id="linkin" onclick="window.location.href='SEJARAH_PEMBAYARAN.jsp';">SEJARAH & PEMBAYARAN</a></b>
			</li>
			<li id="log" class="log">
				<b><a id="linkin" onclick="window.location.href='index.jsp';">LOG KELUAR</a></b>
			</li>
		</ul>
<br><br>
		<div class="info">
		<h1>
			 MAKLUMAT PENGGUNA
		</h1>
	    </div>
	    <br><br><br>
	    <div class="scroll">

	    	<form>

<div class="container" style="height: auto">

    <table>
    
    	<tr>
    	<th>NAMA:</th>
    	<td>${name}</td>
    	</tr>
    	
    	<tr>
    	<th>NOMBOR KAD PENGENALAN:</th>
    	<td>${id}</td>
    	</tr>
    	
    	<tr>
    	<th>NOMBOR TELEFON:</th>
    	<td>${contact}</td>
    	</tr>
    	
    	<tr>
    	<th>ALAMAT:</th>
    	<td>${address}</td>
    	</tr>
    	
    	<tr>
    	<th>EMAIL:</th>
    	<td>${email}</td>
    	</tr>
    	
    </table>
    <input type="hidden" name="memberid" value="${id}">
    <button type="submit"  class="button button1" name="submit" onclick="form.action='UPDATE_AKAUNPENGGUNA.jsp'">KEMASKINI</button>
	<a href='deleteMemberAccount?memberid=${id}' class="deleteakaun" style= "padding:10px;border-radius:15px;font-size:18px; background-color: #e60000">DIAKTIF</a>
</div>
</form>
</div>
</header>

<script>

var elems = document.getElementsByClassName('deleteakaun');
var confirmIt = function (e) {
    if (!confirm('Anda pasti mahu padam akaun ini?')) e.preventDefault();
};
for (var i = 0, l = elems.length; i < l; i++) {
    elems[i].addEventListener('click', confirmIt, false);
}

</script>
</body>
</html>