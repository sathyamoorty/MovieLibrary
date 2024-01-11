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
import com.java.dto.Admindto;

@WebServlet("/adminsign")
public class AdminData extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int aid = Integer.parseInt(req.getParameter("aid"));
		String aname = req.getParameter("aname");
		long aphno = Long.parseLong(req.getParameter("aphno"));
		String amail = req.getParameter("amail");
		String apass = req.getParameter("apass");
		Admindto admin=new Admindto();
		admin.setAid(aid);
		admin.setAname(aname);
		admin.setAcon(aphno);
		admin.setAmail(amail);
		admin.setApass(apass);

		
		Admindao dao=new Admindao();
		try {
			int res=dao.saveAdmin(admin);
			if (res>0) 
			{
				RequestDispatcher rd=req.getRequestDispatcher("alogin.jsp");
				rd.include(req, resp);
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("asignup.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
