<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

	    	<form action="KhairatmemberHandler" method="post">

<div class="container" style="height: auto">

    <input type=hidden name="memberid"  value="${id}" >
    
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
    	
    	<tr>
    	<th>PASSWORD:</th>
    	<td>${password}</td>
    	
    	</tr>
    	
    </table>
    <input type="hidden" name="action" value="delete">
     <button type="submit"  class="button button1" name="submit" onclick="form.action='UPDATE_AKAUNPENGGUNA.jsp'">UPDATE</button>

    <%--<div class="row">
        <div class="col-25">
            <label>NAMA:</label>
            
        </div>
        <div class="col-75">
            <label>${name}</label>
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label>NOMBOR KAD PENGENALAN</label>
        </div>
        <div class="col-75">
            <label>${id}</label>
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label>NOMBOR TELEFON</label>
        </div>
        <div class="col-75">
            <label>${contact}</label>
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label>ALAMAT</label>
        </div>
        <div class="col-75">
            <label>${address}</label>
        </div>
        </div>
    <div class="row">
        <div class="col-25">
            <label>EMAIL</label>
        </div>
        <div class="col-75">
            <label>${email}</label>
        </div>
        </div>
    <div class="row">
        <div class="col-25">
            <label>PASSWORD</label>
        </div>
        <div class="col-75">
            <label>${password}</label>
        </div>
        </div>--%>





</div>
</form>
</div>
 
</header>
</body>
</html>