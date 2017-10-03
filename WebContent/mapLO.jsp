<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mapping Learning objectives</title>
<!--  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/datatables.bootstrap.min.css">  -->

<link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">

<link rel="stylesheet" type="text/css" href="css/redips/style.css">

</head>
<body onload="load()"> 

<!-- hidden div element needed for hover -->
<div id="hover-div" style="visibility:visible;background: #ffffff; position:absolute; top:0; left:0;">something to see</div>


<div class="container">

	<script type="text/javascript" src="js/redips/redips-drag-min.js"></script>
	<script type="text/javascript" src="js/redips/script.js"></script>
	
	<%@ include file="menu.jsp" %>
<!--	<script>
		$(document).ready(function() {
		$('#botable').DataTable();
	} );
	</script> -->
	<div class="row">
		<div class="col-md-12">
			<div class="page-header"><h1>Mapping Learning objectives</h1></div>	
		</div>
	</div>
	
	<div id="redips-drag">
		<table id="tbl1" class="tbl1">
			<colgroup>
				<col width="30"/>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>
			</colgroup>
			<tbody>
				<tr>
					<td colspan="8" class="redips-mark" id="message"><span>Message line</span></td>
				</tr>															
				<tr>
					<th></th>
					<th align="center">K1</th>
					<th align="center">K2</th>
					<th align="center">K3</th>
					<th align="center">K4</th>
					<th align="center">K5</th>
					<th align="center">K6</th>
					<th align="center">K7</th>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>					
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>					
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>
				</tr>
				<tr class="rd">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="rl">
					<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
					<td></td>
				</tr>
			</tbody>
		</table>
		<div class="form-group">
		<form id="formid" action="mapLO" method="post">
			<input type="hidden" name="mapping" id="mapping" value="TestHidden"/>
			<input type="submit" value="Save" class="btn btn-primary" onclick="save();" title="Store to page">
			<input type="button" value="Load" class="btn btn-primary" onclick="load();" title="Load from Server">
			<input type="button" value="Add row" class="btn btn-primary" onclick="appendRow()" title="Add a row">			
			<input type="button" value="Delete row" class="btn btn-danger" onclick="deleteRows()" title="Delete a row">
			<!-- <input type="submit" value="Save" class="btn btn-primary">  -->
		</form>
		<table id="tbl2" class="tbl2">
			<colgroup>
				<col width="30"/>
				<col width="100"/>
			</colgroup>
			<tbody>
				<tr>
					<th></th>
					<th align="center"></th>
				</tr>
					
				<c:forEach var="item" items="${listLO }">
					<tr class="rl">
						<td class="redips-rowhandler"><div class="redips-drag redips-row"></div></td>
						<td><div class="redips-drag blue" id="${item.id }">${item.extid} </div></td>
						<td>${item.source}</td>
						<td>${item.level}</td>
						<td>${item.topic}</td>
						<td>${item.description}</td>
					</tr>
					
				</c:forEach>
			</tbody>
		</table>
		

		<script type="text/javascript">
		    var lodet = createArray(500,6);
			var json;
  			var jsonnew;
			function getJSON() {
				json = ${mapping.getJsonObjectString()};
			}
			function setJSON() {
				document.getElementById('mapping').value=jsonnew;
	  		}
			function getLOArray() {
			var y = 0;
		    <c:forEach var="item1" items="${listLOAll }">
				lodet[y][0] = '<c:out value='${item1.id}'/>'; 
			    lodet[y][1] = '<c:out value='${item1.extid}'/>';
				lodet[y][2] = '<c:out value='${item1.source}'/>';
			    lodet[y][3] = '<c:out value='${item1.level}'/>';
				lodet[y][4] = '<c:out value='${item1.topic}'/>';
			    lodet[y][5] = '<c:out value='${item1.description}'/>';
			    y=y+1;
			    
			</c:forEach>
			}
			function getLO(aID) {
				var res = 0;
				for (var i=0;i<501;i++) {
					console.log(lodet[i][0]);
					  if(lodet[i][0]===aID) {
				    	 //alert("treffer " + i);
				    	 res=i;
				    	 i=501;
				     }
				}
				return res;
			}			
			function createArray(length) {
			    var arr = new Array(length || 0),
			        i = length;

			    if (arguments.length > 1) {
			        var args = Array.prototype.slice.call(arguments, 1);
			        while(i--) arr[length-1 - i] = createArray.apply(this, args);
			    }

			    return arr;
			}

		 </script>	
		
		
		</div>
	</div>
</div>
</body>
</html>