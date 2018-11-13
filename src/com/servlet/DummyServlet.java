package com.servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.GetWorkerInfo;
import com.model.Worker;

public class DummyServlet extends HttpServlet{

	private static final long serialVersionUID = 511701817549571602L;
	public static Worker result = new Worker();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userInput;

		if(request.getParameter("userInput") != null) {
			userInput = request.getParameter("userInput").trim();
			result = GetWorkerInfo.search(userInput);		
		
		PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8), true);
		
		String json = "[\"" + result.getName() + "\", \"" + result.getSurname() + "\", \"" + result.getSicil() + "\", \"" + result.getDepartman() + "\"]";
		
		out.println(json);
		
		//out.setCharacterEncoding("UTF-8");
	}
	
		else {
			System.out.println("Something went wrong");
		}
	}
}
