<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Content</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="//cdn.ckeditor.com/4.7.2/full/ckeditor.js"></script>
</head>
<body>
<jsp:useBean id="DSyllabus" class="org.istqb.beans.DomainList" scope="page">
<% DSyllabus.getItems("Source"); %>
</jsp:useBean>
<jsp:useBean id="DLanguage" class="org.istqb.beans.DomainList" scope="page">
<% DLanguage.getItems("Language"); %>
</jsp:useBean>
<jsp:useBean id="DKLevel" class="org.istqb.beans.DomainList" scope="page">
<% DKLevel.getItems("Klevel"); %>
</jsp:useBean>


<div class="container">
     <%@ include file="menu.jsp" %>
	<div class="row">
		<div class="col-md-12">
			<div class="page-header"><h1>Content</h1></div>	
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
			<form action="listBO" method="post">
				<div class="form-group">
					<input type="hidden" value="${Content.getId() }" id=Id name="Id" class="form-control">
				</div>
				<div class="form-group">
					<label for="Extid">ExtID - this is the id related to the syllabus</label>
					<input type="text" value="${Content.getExtid() }" id=ExtID name="Extid" class="form-control">
				</div>
				<div class="form-group">
					<label for="Chapter">Chapter</label>
					<input type="text" value="${Content.getChapter() }" id=Chapter name="Chapter" class="form-control">
				</div>
      			<div class="form-group">
	      			<label for="KLevel">K-Level</label>
	      			<select class="form-control" id="Source" name="Source">
						<option>${Content.getKlevel() }</option>
        				<c:forEach var="item" items="${DKLevel.getCurrentItems() }">
            				<option value="${item}">${item}</option>
        				</c:forEach>
	      			</select>
      			</div>
				<div class="form-group">
					<label for="Content">Content</label>
					<textarea class="form-control" id="Content" name="Content" rows="5">${Content.getContent() }</textarea>
					<script>CKEDITOR.replace( 'Content' );</script>
				</div>
      			<div class="form-group">
	      			<label for="Source">Source</label>
	      			<select class="form-control" id="Source" name="Source">
						<option>${Content.getSource() }</option>
        				<c:forEach var="item" items="${DSyllabus.getCurrentItems() }">
            				<option value="${item}">${item}</option>
        				</c:forEach>
	      			</select>
      			</div>
				<div class="form-group">
					<label for="Time">How much time do you need for this chapter?</label>
					<input type="text" value="${Content.getTime() }" id=Time name="Time" class="form-control">
				</div>
				<div class="form-group">
					<input type="hidden" value="${Content.getRelatedto() }" id=RelatedTo name="RelatedTo" class="form-control">
				</div>
				<div class="form-group">
					<input type="hidden" value="${Content.getLoid() }" id=LOID name="LOID" class="form-control">
				</div>

				<div class="form-group">
					<input type="hidden" value="${Content.getSectionidpath() }" id=SectionIDPath name="SectionIDPath" class="form-control">
				</div>
				<div class="form-group">
					<input type="hidden" value="${Content.getSectionpath() }" id=SectionPath name="SectionPath" class="form-control">
				</div>
				<div class="form-group">
					<input type="hidden" value="${Content.getCreatedby() }" id=Createdby name="Createdby" class="form-control">
				</div>
      			<div class="form-group">
	      			<label for="Language">Language</label>
	      			<select class="form-control" id="Source" name="Source">
						<option>${Content.getLanguage() }</option>
        				<c:forEach var="item" items="${DLanguage.getCurrentItems() }">
            				<option value="${item}">${item}</option>
        				</c:forEach>
	      			</select>
      			</div>
				<div class="form-group">
					<input type="submit" value="Save" class="btn btn-primary">
					<a href="listContent?edit=0" class="btn btn-danger">Reset</a>
					<a href="listContent" class="btn btn-success">List</a>
				</div>
			</form>	
		</div>
	</div>
</div>

</body>
</html>