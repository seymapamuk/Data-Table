<%@page import="com.control.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" contentType="text/javascript; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<?xml version="1.0" encoding="UTF-8"?>
<html> 
	<body>
	
	<script>
	
	function nameValidation() {
		
	    var input = document.getElementById("userName").value;
	    //alert(input);
	    
	    var check = true;
	    
	    if(input == ""){
	    	alert("Name can't be empty.");
	    	check = false;
	    }
	    
	    if(input.length < 3){
			alert("Name should have more than 3 characters");
			check = false;
		}
	    
	   if(/\d/.test(input)){
			alert("Names can't include digits.");
			input = input.slice(0, -1);
			
			while(/\d/.test(input))
				input = input.slice(0, -1);
				
			check = false;
		}
	   
	   document.getElementById("userName").value = input;
	}
	
	function surnameValidation() {
		
	    var input = document.getElementById("userSurname").value;
	    //alert(input);
	    
	    var check = true;
	    
	    if(input == ""){
	    	alert("Surname can't be empty.");
	    	check = false;
	    }
	    
	    if(input.length < 3){
			alert("Surname should have more than 3 characters");
			check = false;
		}
	    
	   if(/\d/.test(input)){
			alert("Surname can't include digits.");
			input = input.slice(0, -1);
			
			while(/\d/.test(input))
				input = input.slice(0, -1);
				
			check = false;
		}
	   
	   document.getElementById("userSurname").value = input;
	}
	
	function sicilValidation() {
		
	    var input = document.getElementById("userSicil").value;
	    //alert(input);
	    
	    var check = true;
	    
	    if(input == ""){
	    	alert("Sicil can't be empty.");
	    	check = false;
	    }
	    
	    if(input.length < 5){
			alert("Sicil should have more than 5 characters");
			check = false;
		}
	    
	   if(isNaN(input)){
			alert("Sicil should be a number.");
			input = input.slice(0, -1);
			
			while(isNaN(input))
				input = input.slice(0, -1);
				
			check = false;
		}
	   
	   document.getElementById("userSicil").value = input;
	}
	
	function depValidation() {
		
	    var input = document.getElementById("userDepartman").value;
	    //alert(input);
	    
	    var check = true;
	    
	    if(input == ""){
	    	alert("Department can't be empty.");
	    	check = false;
	    }
	    
	    if(input.length < 3){
			alert("Department should have more than 3 characters");
			check = false;
		}
	    
	    if(/\d/.test(input)){
			alert("Department shouldn't include digits.");
			input = input.slice(0, -1);
			
			while(/\d/.test(input))
				input = input.slice(0, -1);
				
			check = false;
		}
	   
	   document.getElementById("userDepartman").value = input;
	}
	
	function passValidation() {
		
		var lc = false;
		var uc = false;
		var num = false;
		
	    var input = document.getElementById("userSifre").value;
	    //alert(input);
	    
	    var check = true;
	    
	    if(input == ""){
	    	alert("Password can't be empty.");
	    	check = false;
	    }
	    
	    if(input.length < 8){
			alert("Password should have more than 8 characters");
			check = false;
		}
	    
	    var i = 0;
	    var temp = '';
	    
	    while (i <= input.length) {
	    	
	        temp = input.charAt(i);
	        
	        if (!isNaN(temp * 1))
	            num = true;
	        	
	        if (temp == temp.toUpperCase())
	            uc = true;

	        if (temp == temp.toLowerCase())
	            lc = true;
	
	        i++;
	    }
	    
	    if(!uc) {
	    	alert("Password should have at least one uppercase letter.");
	    	document.getElementById("userSifre").value = "";
	    }
	    
	    if(!lc) {
	    	alert("Password should have at least one lowercase letter.");
	    	document.getElementById("userSifre").value = "";
	    }
	    if(!num) {
	    	alert("Password should have at least one digit");
	    	document.getElementById("userSifre").value = "";
	    }
	    
	}
	
	</script>
	
	<form id="form" action="hello_servlet">
    <table>
    		<tr>
    			<td>Isim: </td>
    			<td><input type="text" name="userName" id="userName" onchange="nameValidation()"/></td>
    		</tr>
    		<tr>
    			<td>Soyisim: </td>
    			<td><input type="text" name="userSurname" id="userSurname" onchange="surnameValidation()"/></td>
    		</tr>
    		<tr>
    			<td>Sicil: </td>
    			<td><input type="text" name="userSicil" id="userSicil" onchange="sicilValidation()"/></td>
    		</tr>
    		<tr>
    			<td>Departman: </td>
    			<td><input type="text" name="userDepartman" id="userDepartman" onchange="depValidation()"/></td>
    		</tr>
    		<tr>
    			<td>Şifre: </td>
    			<td><input type="password" name="userSifre" id="userSifre" onchange="passValidation()"/></td>
    		</tr>
    </table>
    	
    	<input type="submit"  />
    	
	</form>
		
	</body>
</html>







	

