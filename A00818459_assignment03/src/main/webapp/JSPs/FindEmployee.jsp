<%@page import="ca.bcit.comp4656.employee.types.ResponseCode" %>
<jsp:useBean id="SearchMessage" class="ca.bcit.comp4656.employee.types.ResponseCode" scope="request"/>
<div class="sub-menu">
	<h5 class="row mx-1">Find An Employee By ID</h5>
	<div class="row">
		<form method="post">
			<label for="id">ID:</label>
			<input type="text" name="id" id="id" value="A0"/>
			<input type="submit" name="submit" id="submit" class="submit-button" value="Search">
		</form>
	</div>
	<p class="row mx-1">
		${SearchResponseCode.code} ${SearchResponseCode.description}
	</p>
</div>