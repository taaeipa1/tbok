<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of all Content</title>
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
			<div class="page-header"><h1>List Content</h1></div>	
		</div>

		<table id="botable" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>ExtID</th>
					<th>Chapter</th>
					<th>K-Level</th>
					<th>Content</th>
					<th>Source</th>					
					<th>Time request</th>
					<th>RelatedTo</th>
					<th>LO</th>
					<th>Created by</th>										
					<th>Language</th>
					<th></th>
					<th></th>
				</tr>	
			</thead>
			
			<tbody>
				<c:forEach var="item" items="${listContent }">
					<tr>
						<td>${item.id}</td>
						<td>${item.extid}</td>
						<td>${item.chapter}</td>
						<td>${item.klevel}</td>
						<td><textarea disabled rows="3">${item.content}</textarea></td>
						<td>${item.source}</td>
						<td>${item.time}</td>
						<td>${item.relatedto}</td>
						<td>${item.loid}</td>
						<td>${item.createdby}</td>
						<td>${item.language}</td>
						<td><a href="listContent?edit=${item.id}" class="btn btn-default">Edit</a></td>
						<td><a href="listContent?delete=${item.id}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete?')">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
			
			
		</table>
	</div>
</div>
</body>
</html>