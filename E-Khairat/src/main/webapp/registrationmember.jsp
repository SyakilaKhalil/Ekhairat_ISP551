<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registration For Member</title>
	<link rel="stylesheet" href="registration.css">
	<script src="registration.js"></script>
</head>
<body>
	<h1 class="header">DAFTAR AKAUN AHLI BAHARU</h1>
	<br>
	<br>
	<div class = "box">
		<div class = "col-75">
			<div class = "containercart"><br>
				<form id="Resgistration" action="createNewMember" method="post">
					<div class= "row">
						<div class = "col-50">
							<label class="regis" for="fname">Nama</label>
							<input class = "extratext" type="text" id="fname" name="memberName" placeholder = "nama penuh pengguna" required>
		
							<label class="regis" for="id">Nombor Kad Pengenalan</label>
							<input type= "text" id="id" name="memberID" placeholder = "nombor kad" required>
							<p class = "extratext"><span style="color: red">*</span>Nombor telefon diisi tanpa simbol(-)</p>
		
							<label class="regis" for="nophone">Nombor Telefon Bimbit</label>
							<input type= "tel" id="nophone" name="memberContactNo" placeholder = "nombor telefon" required>
							<p class = "extratext"><span style="color: red">*</span>Nombor telefon diisi tanpa simbol(-) dan tanpa (+06)</p>
		
							<label class="regis" for="address">Alamat</label>
							<textarea rows = "5" cols = "60" class = "extratext" id="address" name="memberAddress" placeholder = "alamat pengguna" required></textarea>
		
							<label class="regis" for="mail">Email</label>
							<input class = "extratext" type="email" id="mail" name="memberEmail" placeholder = "email pengguna" required>
						</div>
						<div class ="col-50">
							<div class="infobox"><br>
								<p class="infotext"><span style="color: red">*</span>Semua maklumat hendaklah diisi dengan huruf besar <br><span style="color: red">*</span>Untuk log masuk setelah selesai pendaftaran, sila gunakan nombor kad pengenalan sebagai username<br><span style="color: red">*</span>Setelah selesai isi kesemua maklumat. Sila tekan 'DAFTAR AKAUN' untuk mengesahkan maklumat dan daftar</p><br>
							</div>
							
							<%--<label class="regis" id="passlabel"  for="pwd">Kata Laluan
							<input type="password" id="pwd"  name="memberPassword" placeholder = "password pengguna" required><br>
							<input type = "checkbox" id="passlabel"  onclick="passwordtoogle()">Papar Katalaluan
							</label> <p class = "extratext"></p>
		
							<label class="regis" id="passlabell" for="pwd1">Masukkan Kata Laluan Semula
							<input type="password" id="pwd1"  name="memberPasswordtest" placeholder = "password pengguna" onkeyUp="checkPass()" required><br>
							<input type = "checkbox" id="passlabel" onclick="passwordconfirmtoogle()">Papar Katalaluan
							 </label> <p class = "extratext"></p>--%>
							 
							<label class="regis"> Kata Laluan</label>
  							<input name="memberPassword" id="password" type="password" onkeyup='check();' pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
  							title="Mesti mengandungi sekurang-kurangnya satu nombor dan satu huruf besar dan huruf kecil, dan sekurang-kurangnya 8 atau lebih karakter." />
							<br>
							<input type = "checkbox" id="passlabel"  onclick="passwordtoogle()">Papar Katalaluan
							 <p class = "extratext"></p>
							<br> 
							<label class="regis"> Masukkan Kata Laluan Semula </label>
  							<input type="password" name="confirm_password" id="confirm_password"  onkeyup='check();' /> 
  							<span id='message'></span>
  							<br>
							<input type = "checkbox" id="passlabel" onclick="passwordconfirmtoogle()">Papar Katalaluan
							 <p class = "extratext">
							 
				 
							<%--<input type="hidden" name="action"  value="createKhairatmember">
							<button type="submit" class="button button1" name="submit" >Add</button><br><br>--%>
							
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<footer>
		<button class="backbtn" onclick="window.location.href='index.jsp';" >KEMBALI</button>
		<input type="hidden" form="Resgistration" name="action"  value="createKhairatmember">
		<button type="submit" form="Resgistration" class="button button1 btncart" name="submit" >DAFTAR AKAUN</button>
	</footer>
</body>
</html>