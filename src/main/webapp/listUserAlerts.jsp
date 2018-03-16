<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List UserAlerts</title>
</head>
<body>
<form action="removeUserAlerts" method="post">
	<table id="content" cellpadding="3" cellspacing="3" border="1" bordercolor="#CCCCCC">
		<thead>
			<tr>
				<td>#</td>
				<td>id</td>
				<td>Address</td>
				<td>Type</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="alert" items="${alerts}">
				<tr>
					<td><input type="checkbox" name="selectedAlerts" value="${alert.id}"/></td>
					<td>${alert.id}</td>
					<td>${alert.formattedAddress}</td>
					<td>${alert.alertType.name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="submit" value="Submit"/>
</form>
</body>
</html>