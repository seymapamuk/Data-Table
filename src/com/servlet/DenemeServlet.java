package com.servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.GetWorkerInfo;
import com.model.Worker;


//@WebServlet("/GetUserServlet")
public class DenemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8), true);
		
		ArrayList<Worker> newList = new ArrayList<Worker>();

		newList = GetWorkerInfo.getWorker();
		
		String json = "{ \"demo\":[";
		
		for(Worker w : newList) {
			json += "[\"" + w.getSicil() + "\", \"" + w.getName() + "\", \"" + w.getSurname() + "\", \"" + w.getDepartman() + "\"],";
		}
		
		json = json.substring(0, json.length() - 1);
		
		json += "]}";
				
		out.println(json);
		
	}
}