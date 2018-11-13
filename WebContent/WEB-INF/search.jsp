<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.control.Dummy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Dummy db = new Dummy();

	String query = request.getParameter("q");
	
	List<String> names = db.getData(query);

	Iterator<String> iterator = names.iterator();
	while(iterator.hasNext()) {
		String name = (String)iterator.next();
		out.println(name);
	}
%>