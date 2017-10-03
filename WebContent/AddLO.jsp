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

<jsp:useBean id="DomainList" class="org.istqb.beans.DomainList" scope="page">
<% DomainList.getItems("Source"); %>
</jsp:useBean>

<div class="container">
     <%@ include file="menu.jsp" %>
	<div class="row">
		<div class="col-md-12">
			<div class="page-header"><h1>Learning Objectives</h1></div>	
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
			<form action="listLO" method="post">
				<div class="form-group">
					<input type="hidden" value="${LO.getId() }" id=Id name="Id" class="form-control">
				</div>
				<div class="form-group">
					<label for="Source">Source - of which Syllabus is it?</label>
					<select class="form-control" id="Source" name="Source">
						<option>${LO.getSource() }</option>
        				<c:forEach var="item" items="${DomainList.getCurrentItems() }">
            				<option value="${item}">${item}</option>
        				</c:forEach>
	      			</select>
				</div>
				<div class="form-group">
					<label for="Level">Level - K1 - K7</label>
					<select class="form-control" id="Level" name="Level">
						<option>${LO.getLevel() }</option>
						<option>K1</option>
						<option>K2</option>
						<option>K3</option>
						<option>K4</option>
						<option>K5</option>
						<option>K6</option>
						<option>K7</option>
	      			</select>
				</div>
				<div class="form-group">
					<label for="Extid">ExtID - this is the id related to the syllabus</label>
					<input type="text" value="${LO.getExtid() }" id=ExtID name="Extid" class="form-control">
				</div>
				<div class="form-group">
					<label for="Topic">Topic - what's talking about</label>
					<input type="text" value="${LO.getTopic() }" id=Topic name="Topic" class="form-control">
				</div>
				<div class="form-group">
					<label for="Description">Description</label>
					<textarea class="form-control" id="Description" name="Description" rows="5">${LO.getDescription() }</textarea>
				</div>
      			<div class="form-group">
	      			<label for="Language">Language</label>
	      			<select class="form-control" id="Language" name="Language">
						<option>${LO.getLanguage() }</option>
						<option>English</option>
						<option>German</option>
						<option>French</option>
	      			</select>
      			</div>
				<div class="form-group">
					<label for="Createdby">Owner / last change of the record</label>
					<input type="text" value="${LO.getCreatedby() }" id=Createdby name="Createdby" class="form-control">
				</div>
				<div class="form-group">
					<label for="Relatedto">Link to a depending Learning objective</label>
					<input type="text" value="${LO.getRelatedto() }" id=Relatedto name="Relatedto" class="form-control">
				</div>
				<div class="form-group">
					<label for="Content">Relation to a given content</label>
					<input type="text" value="${LO.getContentid() }" id=ExtID name="Extid" class="form-control">
				</div>
				<div class="form-group">
					<input type="submit" value="Save" class="btn btn-primary">
					<a href="listLO?edit=0" class="btn btn-danger">Reset</a>
					<a href="listLO" class="btn btn-success">List</a>
				</div>
			</form>	
		</div>
	</div>
</div>

</body>
</html>