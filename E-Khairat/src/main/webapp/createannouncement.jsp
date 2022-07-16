<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="createAnnouncement" method="post" onsubmit="time()">
	<label for="announce">pengumuman</label>
	<textarea rows = "5" cols = "60" id="announce" name="announceDetail" placeholder = "pengumuman"></textarea>
	<input type="hidden" name="action" value="createAnnounce">
	<input class="button" type="submit">
	</form>
	<a id="linkin" onclick="window.location.href='pengurusan_aktivti.jsp';">KEMBALI</a>
</body>
</html>