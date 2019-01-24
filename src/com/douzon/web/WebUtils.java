package com.douzon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtils {
	public static void forward(HttpServletRequest request, HttpServletResponse response, String location) throws IOException,ServletException{
		RequestDispatcher rd = request.getRequestDispatcher(location);
		rd.forward(request, response);
	}
}
