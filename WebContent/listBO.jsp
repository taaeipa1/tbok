<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of all business outcomes</title>
<!--  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/datatables.bootstrap.min.css">  -->

<link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
</head>
<body>
<div class="container">


	<%@ include file="menu.jsp" %>
	<script>
		$(document).ready(function() {
		$('#botable').DataTable();
	} );
	</script>

	<div class="row">
		<div class="col-md-12">
			<div class="page-header"><h1>List Business Outcome</h1></div>	
		</div>

		<table id="botable" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>ExtID</th>
					<th>Description</th>
					<th>Language</th>
					<th></th>
					<th></th>
				</tr>	
			</thead>
			
			<tbody>
				<c:forEach var="item" items="${listBO }">
					<tr>
						<td>${item.id}</td>
						<td>${item.extid}</td>
						<td>${item.description}</td>
						<td>${item.language}</td>
						<td><a href="listBO?edit=${item.id}" class="btn btn-default">Edit</a></td>
						<td><a href="listBO?delete=${item.id}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete?')">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
			
			
		</table>
	</div>
</div>
</body>
</html>