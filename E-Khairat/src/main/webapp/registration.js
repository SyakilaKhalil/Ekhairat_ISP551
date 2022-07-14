var check = function() {
  if (document.getElementById('password').value ==
    document.getElementById('confirm_password').value) {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'matching';
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'not matching';
  }
}

function passwordtoogle() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}

function passwordconfirmtoogle() {
  var x = document.getElementById("confirm_password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
var myInput = document.getElementById("password");

var letter = document.getElementById("letter");

var capital = document.getElementById("capital");

var number = document.getElementById("number");

var length = document.getElementById("length");

myInput.onfocus = function() {

 document.getElementById("message").style.display = "block";

}

myInput.onblur = function() {

  document.getElementById("message").style.display = "none";

}

myInput.onkeyup = function() {

    var lowerCaseLetters = /[a-z]/g;

  if(myInput.value.match(lowerCaseLetters)) {

    letter.classList.remove("invalid");

    letter.classList.add("valid");

  } else {

    letter.classList.remove("valid");

    letter.classList.add("invalid");

}


var upperCaseLetters = /[A-Z]/g;

  if(myInput.value.match(upperCaseLetters)) {

    capital.classList.remove("invalid");

    capital.classList.add("valid");

  } else {

    capital.classList.remove("valid");

    capital.classList.add("invalid");

  }

  var numbers = /[0-9]/g;

  if(myInput.value.match(numbers)) {

    number.classList.remove("invalid");

    number.classList.add("valid");

  } 
  else {

    number.classList.remove(
	"valid");

    number.classList.add("invalid");

  }

  if(myInput.value.length >= 8) {

    length.classList.remove("invalid");

    length.classList.add("valid");

  } 
   else {

    length.classList.remove("valid");

    length.classList.add("invalid");

  }
}
 