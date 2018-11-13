<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery, Ajax and Servlet/JSP integration example</title>

<script src="//code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
	
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
 
 <link rel="stylesheet" type="text/json" href="https://cdn.datatables.net/plug-ins/1.10.19/i18n/Turkish.json">
 
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
	
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		var oTable = $('#tableId').dataTable( {
			"processing": true,
			"ajax": { "url" : "Deneme" , "dataSrc" : "demo" }
		} );
	} );
</script> 

</head>
<body>
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
</body>
</html>