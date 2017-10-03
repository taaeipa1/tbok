<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Release</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>

<div class="container">
     <%@ include file="menu.jsp" %>
	<div class="row">
		<div class="col-md-12">
			<div class="page-header"><h1>Release</h1></div>	
		</div>
	</div>
	
	<!-- place to set the message we defined in the servlet -->
	<div class="row">
		<div class="col-md-12">
			<div class="${tipoMensagem }">
				<p>${mensagem }</p>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<!--  action configuration in servlet doPost or doGet -->
			<form action="listRelease" method="post">
				<div class="form-group">
					<input type="hidden" value="${Release.getId() }" id=Id name="Id" class="form-control">
				</div>
				<div class="form-group">
					<label for="Source">Syllabus</label>
					<input type="text" value="${Release.getSource() }" id=Source name="Source" class="form-control">
				</div>
      			<div class="form-group">
	      			<label for="Language">Language</label>
	      			<select class="form-control" id="Language" name="Language">
						<option>${Release.getLanguage() }</option>
						<option>English</option>
						<option>German</option>
						<option>French</option>
	      			</select>
      			</div>
				<div class="form-group">
					<label for="Title">Title</label>
					<textarea class="form-control" id="Title" name="Title" rows="5">${Release.getTitle() }</textarea>
				</div>
				<div class="form-group">
					<label for="Sunset">Sunset</label>
					<input type="date" value="${Release.getSunset() }" id=Sunset name="Sunset" class="form-control">
				</div>
				<div class="form-group">
					<label for="Sunrise">Sunrise</label>
					<input type="date" value="${Release.getSunrise() }" id=Sunrise name="Sunrise" class="form-control">
				</div>
				
				<div class="form-group">
					<input type="submit" value="Save" class="btn btn-primary">
					<a href="listRelease?edit=0" class="btn btn-danger">Reset</a>
					<a href="listRelease" class="btn btn-success">List</a>
				</div>
			</form>	
		</div>
	</div>
</div>

</body>
</html>