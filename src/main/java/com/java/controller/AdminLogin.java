package com.java.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.dto.Admindto;
import com.java.dao.Admindao;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String admail = req.getParameter("amail");
		String adpass = req.getParameter("apass");

		Admindao dao = new Admindao();

		try {
			Admindto admin = dao.findByEmail(admail);
			if (admin != null) {
				if (admin.getApass().equals(adpass)) {
					RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
					rd.include(req, resp);
				} else {
					req.setAttribute("messages", "password is wrong");
					RequestDispatcher rd = req.getRequestDispatcher("alogin.jsp");
					rd.include(req, resp);
				}

			} else {
				req.setAttribute("messages", "email is wrong");
				RequestDispatcher rd = req.getRequestDispatcher("alogin.jsp");
				rd.include(req, resp);
			}

		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}
}
