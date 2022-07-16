<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Login Page</title>
	<link rel="stylesheet" href="loginpage.css">
</head>
<body>
	<input type="hidden" id="status" value="<%=request.getAttribute("status")%>">
	<div>
		<img class="logo" src="Surau Al-Hidayah1.png">
	</div>
	<form method="post" action="loginmember">
		<label class="check align" for="khairat">Khairat</label>
		<input class = "checkbox" type="radio" id="khairat" name="khairatorstaff">
		<label class="check nextalign" for="staff">Staff</label>
		<input class = "checkbox" type="radio" id="staff" name="khairatorstaff">
		<p class="typemem">LOG MASUK SEBAGAI KHAIRAT</p>
		<div class="login">
			<label class="logintext" for="username">Nombor K/P</label>
			<input class="userbox" type="text" name="nomborkp" id="nomborkp" placeholder="Nombor Kad Pengenalan" required><br>
			<label class="logintext margin" for="password">Kata Laluan</label>
			<input class="passbox margin" type="password" name="pass" id="pass" placeholder="Kata Laluan" required>
		</div>
		<input type="submit" name="submitlogin" value="LOG MASUK" class="btnlogin" /><br>
	</form>
	<button class="regis" onclick="window.location.href='registrationmember.jsp';" >DAFTAR AKAUN BAHARU</button>

<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">

	<script type="text/javascript">
	var status = document.getElementById("status").value;
	if(status == "failed") {
		//swal("Sorry", "Wrong username or password", "error");
		alert("Wrong email or password");
	}
	</script>
</body>
</html>