<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

.button{
    background-color:#ACD1AF;
    color: #fff;
    border:none;
    border-radius:10px;
}
div.umum{
align:center;
background-colour:#ffe699;
}
</style>
<body>
<div class="umum">
<h2>PENGUMUMAN</h2>
<br>
<form action="createAnnouncement" method="post" onsubmit="time()">
	<label for="announce"></label>
	<textarea rows = "5" cols = "60" id="announce" name="announceDetail" placeholder = "pengumuman"></textarea>
	<input type="hidden" name="action" value="createAnnounce">
	<input class="button" type="submit" value="Hantar"/>
	</form>
	
	<a id="linkin" onclick="window.location.href='pengurusan_aktivti.jsp';">KEMBALI</a>
	</div>
</body>
</html>