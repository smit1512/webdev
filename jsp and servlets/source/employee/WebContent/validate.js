function validate() {
	console.log("Hello")
	var Name = document.f1.name.value;
	var Email = document.f1.email.value;
	var Pno = document.f1.no.value;
	if (Name == "") {
		window.alert("Please enter your name.");
		return false;
	}
	if (Email == "") {
		window.alert("Please enter your email.");
		return false;
	}
	if (Pno == "") {
		window.alert("Please enter your phone no.");
		return false;
	}
	if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(f1.email.value))) {
		alert("You have entered an invalid email address!")
		return false;
	}
	if (!(/^\d{10}$/.test(f1.no.value))) {
		alert("You have entered an invalid Phone number!")
		return false;
	}
	return true;
}