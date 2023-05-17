<%@page import="java.time.LocalDate" %>
<%@page import="ca.bcit.comp4656.employee.types.ResponseCode" %>
<div class="sub-menu">
	<h5 class="row mx-1">Add Employee</h5>
	<div class="row">
		<form method="post">
			<label for="id">ID:</label>
			<input type="text" name="id" id="id" placeholder="A00123456" value="A0" />
			<label for="firstName">First Name:</label>
			<input type="text" name="firstName" id="firstName" />
			<label for="lastName">Last Name:</label>
			<input type="text" name="lastName" id="lastName" />
			<label for="dob">Birth Date:</label>
			<input type="text" name="dob" id="dob" placeholder="yyyy/MM/dd"/>
			<input type="submit" name="submit" id="submit" value="Add Employee" />
			</form>
	</div>
	<p class="row mx-1">
		${AddResponseCode.code} ${AddResponseCode.description}
	</p>
</div>
