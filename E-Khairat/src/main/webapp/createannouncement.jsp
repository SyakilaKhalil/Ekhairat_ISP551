<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body{
background-color:#ffe699;
text-align:center;
}
.button{
    background-color:#ACD1AF;
    color: #fff;
    border:none;
    border-radius:10px;
    padding:8px;
   }
.btn{
    background-color:red;
    color: #fff;
    border:none;
    border-radius:10px;
    padding:8px 10px;
   }
textarea{
width: 300px;
hight:500px;
}

</style>
<body>
<div class="umum">
<h2>PENGUMUMAN</h2>
<br>
<form action="createAnnouncement" method="post" onsubmit="time()">
	<label for="announce"></label>
	<textarea rows = "5" cols = "60" id="announce" name="announceDetail" placeholder = "Sila tulis pengumuman..."></textarea>
	<br>
	<input type="hidden" name="action" value="createAnnounce">
	<input class="button" type="submit" value="Hantar"/>
	</form>
	<div class="btn">
	<a id="linkin" onclick="window.location.href='HOMEPAGE_STAFF.jsp';">KEMBALI</a>
	</div>
	</div>
</body>
</html>