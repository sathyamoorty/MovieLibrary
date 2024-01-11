package com.java.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.java.dao.Admindao;
import com.java.dto.Moviedto;

@WebServlet("/update")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024)
public class updatemovie extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mid = Integer.parseInt(req.getParameter("mid"));
		String mname = req.getParameter("mname");
		double mprice = Double.parseDouble(req.getParameter("mprice"));
		double mrate = Double.parseDouble(req.getParameter("mrate"));
		String mgenre = req.getParameter("mgenre");
		String mlang = req.getParameter("mlang");
		Part mimage = req.getPart("mimage");

		Moviedto movies = new Moviedto();
		movies.setMid(mid);
		movies.setMname(mname);
		movies.setMprice(mprice);
		movies.setMrating(mrate);
		movies.setMgenre(mgenre);
		movies.setMlang(mlang);
		movies.setMimage(mimage.getInputStream().readAllBytes());

		Admindao dao = new Admindao();
		try {
			dao.updateMovie(movies);
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
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
