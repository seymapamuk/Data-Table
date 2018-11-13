package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.client.WServImpService;
import com.client.WService;

public class HelloServlet extends HttpServlet { 
	
	private static final long serialVersionUID = 102831973239L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    String name = request.getParameter("userName");  
        
    String surname = request.getParameter("userSurname");

    int sicil = Integer.parseInt(request.getParameter("userSicil"));
    
    String departman = request.getParameter("userDepartman");
    
    String password = request.getParameter("userSifre");
    
    WServImpService wsimp = new WServImpService();
	WService ws = wsimp.getWServImpPort();
	
	String response1 = ws.newUser(sicil, surname, name, departman, password, true);
	
	System.out.println(response1);
	
	PrintWriter out = response.getWriter();
	
	if (response1.contains("Succesful")) {
		
    out.println (
    		"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\"> \n" +
    	      "<html> \n" +
    	        "<head> \n" +
    	          "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" +
    	        "</head> \n" +
    	        "<body> \n" +
    	        "<script> \n" +
    	        "function signed() { \n" +
    	        	"alert(\"You're signed up!\") } \n" +
    	        "</script> \n" +
    	          "<form action=\"login.jsf\"> \n" +
    	            "<script> signed(); </script> \n" +
    	          "Press the button to go to login screen.<br> \n" +
    	            "<input type=\"submit\" value=\"submit\"> \n" +
    	          "</form> \n" +
    	        "</body> \n" +
    	      "</html>" 
    	    );
	}
	
	else if(response1.contains("Failed")) {
		
		String errortype = response1.substring(6);
		
		 out.println (
		    		"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\"> \n" +
		    	      "<html> \n" +
		    	        "<head> \n" +
		    	          "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" +
		    	        "</head> \n" +
		    	        "<body> \n" +
		    	        "<script> \n" +
		    	        "function signed() { \n" +
		    	        	"alert(\"Something went wrong!\") } \n" +
		    	        "</script> \n" +
		    	          "<form action=\"jssign_up.jsf\"> \n" +
		    	          "<script> signed(); </script> \n" +
		    	          "Press the button to go to try again.<br> \n" +
		    	            "<input type=\"submit\" value=\"submit\"> \n" +
		    	            "Error type = " + errortype + 
		    	          "</form> \n" +
		    	        "</body> \n" +
		    	      "</html>" 
		    	    );
		}
  
	}
	
}