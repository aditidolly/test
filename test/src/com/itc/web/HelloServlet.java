package com.itc.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(urlPatterns={"/hello"})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(HelloServlet.class);
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init called");
	}
	public void destroy() {
		System.out.println("destroy called");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("doGet called");
		String name = request.getParameter("myname");
		String ipaddr = request.getRemoteAddr();
		String path = request.getServletPath();
		System.out.println("path: "+path);
		logger.info("Request from: "+name+", ip: "+ipaddr);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"ISO-8859-1\">");
		out.write("<title>My first web page</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Response from server</h1>");
		out.write("<h2>Hello "+name+", your IP is "+ipaddr+"</h2>");
		out.write("</body>");
		out.write("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost called");
		doGet(request, response);
	}

}
