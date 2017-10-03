<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Business Outcome</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>

<div class="container">
     <%@ include file="menu.jsp" %>
	<div class="row">
		<div class="col-md-12">
			<div class="page-header"><h1>Glossary</h1></div>	
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
			<form action="listGlossary" method="post">
				<div class="form-group">
					<input type="hidden" value="${Glossary.getId() }" id=Id name="Id" class="form-control">
				</div>
				<div class="form-group">
					<label for="Term">Term</label>
					<input type="text" value="${Glossary.getTerm() }" id=Term name="Term" class="form-control">
				</div>
				<div class="form-group">
					<label for="Definition">Definition</label>
					<textarea class="form-control" id="Definition" name="Definition" rows="5">${Glossary.getDefinition() }</textarea>
				</div>
				<div class="form-group">
					<label for="Area">Letter</label>
					<input type="text" value="${Glossary.getArea() }" id=Area name="Area" class="form-control">
				</div>
				<div class="form-group">
					<label for="Letter">Letter</label>
					<input type="text" value="${Glossary.getLetter() }" id=Letter name="Letter" class="form-control">
				</div>


				<div class="form-group">
					<input type="submit" value="Save" class="btn btn-primary">
					<a href="listBO?edit=0" class="btn btn-danger">Reset</a>
					<a href="listBO" class="btn btn-success">List</a>
				</div>
			</form>	
		</div>
	</div>
</div>

</body>
</html>