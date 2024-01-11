package com.java.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.Admindao;
@WebServlet("/deletemovie")
public class DeleteMovie  extends HttpServlet
{
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   {
	int mid=Integer.parseInt(req.getParameter("mid"));
	Admindao dao=new Admindao();
	
	try {
		dao.delete(mid);
		req.setAttribute("movies", dao.getMovie());
		RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
		rd.include(req, resp);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
