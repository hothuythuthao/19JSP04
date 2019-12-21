function checkChangePassword() {
	var oldPassword = document.getElementsByName("oldPassword")[0].value;
	var newPassword = document.getElementsByName("newPassword")[0].value;
	var reNewPassword = document.getElementsByName("reNewPassword")[0].value;
	if (oldPassword == "" || newPassword == "" || reNewPassword == "") {
		alert("Không được để trống");
		return false;
	} else if (newPassword != reNewPassword) {
		alert("Mật khẩu mới không giống nhau");
		return false;
	} else
		return true;
}

function checkSearchValue() {
	var values = document.getElementsByName("values")[0].value;
	if (values == "") {
		alert("Không được để trống");
		return false;
	} else
		return true;
}

function checkRegister() {
	var password = document.getElementsByName("password")[0].value;
	var confirmPassword = document.getElementsByName("confirmPassword")[0].value;
	if (password != confirmPassword) {
		alert("Mật khẩu không giống nhau");
		return false;
	}

	else
		return true;
}