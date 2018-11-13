<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.servlet.DummyServlet"%>
<%@page import="com.database.GetWorkerInfo"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" charset="utf-8" ></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/jquery.autocomplete.css" />
	<script src="resources/js/jquery.autocomplete.js"></script> 
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
</head>
<body>
	<h3>İsim</h3>
	<input type="text" id="input1" name="input1"/>
	<input type="button" id="button" name="button" value="Ara" > 
	
	<table cellpadding="0" cellspacing="0" border="0" id="tableId">
		<thead>
			<tr>
				<th width="10%">Sicil</th>
				<th width="10%">İsim</th>
				<th width="10%">Soyisim</th>
				<th width="10%">Departman</th>
			</tr>
		</thead>
	</table>
	
	<script>
	
	$('#document').ready(
			$("#input1").autocomplete("search.jsp"));
	</script>
	
	
	<script>
	$("#tableId").hide();
	
	$("#button").click(
	
	function showInfo(){
		
		var str = document.getElementById("input1").value;
		var userInput = "";
		var xhttp;
		
		if ( str == "" ) {
			return;
		}
		
		//$.get('Search', { userInput : str });
		
		xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if(this.readystate == 4 && this.status == 200){
				//data();
			}
		}
		
		$.get('Search', { userInput : str }, function(responseText) { $('#tableId').dataTable({ "processing" : true, "ajax" : { "url" : "Search", "data" : (responseText) } } ) } );
		
		$("#tableId").show();
	});
	
	</script>
	
</body>
</html>