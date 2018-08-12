<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
</head>
<body>
	<div id="mainWrapper"
		style="width: 20%; margin-left: 5%; margin-top: 2%">
		<div class="panel panel-default">
			<div class="panel-heading"
				style="background-color: #81BC01; border-color: #81BC01;">
				<h3 class="panel-title">Please sign in</h3>
			</div>
			<div class="panel-body">
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Invalid username and password.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>You have been logged out successfully.</p>
					</div>
				</c:if>
				<c:if test="${not empty param.unauth}">
					<div class="alert alert-danger">
						<p>User does not have privilege to use this app</p>
					</div>
				</c:if>

				<c:url var="loginUrl" value="/login" />
				<form action="${loginUrl}" method="post" class="form-horizontal">
					<fieldset>
						<div class="form-group">
							<label class="input-group-addon" for="username"><i
								class="fa fa-user"></i></label> <input type="text" class="form-control"
								id="username" name="username" placeholder="Enter Username"
								required>
						</div>
						<div class="form-group">
							<label class="input-group-addon" for="password"><i
								class="fa fa-lock"></i></label> <input type="password"
								class="form-control" id="password" name="password"
								placeholder="Enter Password" required>
						</div>
						<div class="form-group">
							<label class="input-group-addon" for="appName"><i
								class="fa fa-lock"></i></label> <select name="appName"
								class="form-control" id="appName">
								<option value="APP1">app1</option>
								<option value="APP2">app2</option>
							</select>
						</div>
						<div class="checkbox">
			    	    	<label>
			    	    		<input name="remember-me" type="checkbox"> Remember Me
			    	    	</label>
			    	    </div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

						<div class="form-actions">
							<input type="submit"
								class="btn btn-block btn-primary btn-default" value="Log in">
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>

</body>
</html>