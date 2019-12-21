<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MIXI GAMING - REGISTER</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="src/css/index.css">
</head>
<body>
	<div class="container">
		<div class="content-head">
			<div class="content-head-top">
				<a href="#" target="blank" class="signin-head">
                	<span class="glyphicon glyphicon-user"></span> LOGIN
            	</a>
				<a href="#" target="blank" class="signup-head">
                	<span class="glyphicon glyphicon-edit"></span> REGISTER
            	</a>
			</div>
			<div class="content-head-bot">
				<div class="logo-head-bot">
					<a href="#" target="blank"><img src="src/image/logomixi.png" class="image-logo-head"></a>
					<div class="slogan">
						<p><span class="compulsory">MIXI</span>GAMING FROM <span class="compulsory">DANANG</span> WITH <span class="compulsory">LOVE</span></p>
					</div>
				</div>
				<div class="info-head-bot">
					<div class="info-top">
						<img src="src/image/vn.png" class="image-info-head">
						<img src="src/image/anh.png" class="image-info-head">
						<a href="#" target="blank">
							<span class="glyphicon glyphicon-search glyphicon-plus"></span>
						</a>
					</div>
					<div class="info-bot">
						<p>Hotline: +999999999</p>
					</div>
				</div>
			</div>
		</div>
		<div class="form-container">
			<form>
				<div>
					<h2> SIGN UP</h2>
				</div>
				<div>
					<table>
						<tr >
							<td class="item-table"></td>
							<td>
								<input type="radio" name="user" value="individual">
								<label>Individual</label>
								<input type="radio" name="user" value="company">
								<label>Company</label>
							</td>
						</tr>
						<tr>
							<td class="item-table"><label>Name<span class="compulsory">*</span> : </label></td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td><label>Phone number<span class="compulsory">*</span> : </label></td>
							<td><input type="text" name="phonenumber"></td>
						</tr>
						<tr>
							<td><label>Day of birth<span class="compulsory">*</span> : </label></td>
							<td><input type="date" name="dob"></td>
						</tr>
						<tr>
							<td><label>Address : </label></td>
							<td><input type="text" name="address"></td>
						</tr>
						<tr>
							<td><label>Province/City : </label></td>
							<td>
								<select name="poc">
									<option value="danang">Da Nang</option>
									<option value="hochiminh">Ho Chi Minh</option>
									<option value="hanoi">Ha Noi</option>
									<option value="hue">Hue</option>
									<option value="thanhhoa">Thanh Hoa</option>
									<option value="quangbinh">Quang Binh</option>
									<option value="nghean">Nghe An</option>
									<option value="hatinh">Ha Tinh</option>
									<option value="phuyen">Phu Yen</option>
									<option value="ninhbinh">Ninh Binh</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><label>Gender : </label></td>
							<td>
								<input type="radio" name="gender" value="male">
								<label>Male</label>
								<input type="radio" name="gender" value="female">
								<label>Female</label>
							</td>
						</tr>
						<tr>
							<td><label>Email<span class="compulsory">*</span> : </label></td>
							<td><input type="email" name="email"></td>
						</tr>
						<tr>
							<td><label>Password<span class="compulsory">*</span> : </label></td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td><label>Confirm password<span class="compulsory">*</span> : </label></td>
							<td><input type="password" name="confirmpassword"></td>
						</tr>
					</table>
				</div>
				<div class="term">
					<input type="checkbox" name="term" value="0"  class="term-p">
					<p class="p">I agree with the terms of <span class="compulsory">MixiGaming</span></p>
				</div>
				<div>
					<input class="sign-up" type="submit" name="submit" value="Sign Up">
					<input class="reset" type="reset" name="reset" value="Reset">
				</div>
				<div>
					<p class="note">(<span class="compulsory">*</span>) Required Information</p>
				</div>
			</form>
		</div>
	</div>
</body>
</html>