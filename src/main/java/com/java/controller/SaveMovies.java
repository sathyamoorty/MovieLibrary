package com.java.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

@WebServlet("/moviepage")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024)
public class SaveMovies extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int mid = Integer.parseInt(req.getParameter("mid"));
		String mname = req.getParameter("mname");
		double mprice = Double.parseDouble(req.getParameter("mprice"));
		double mrate = Double.parseDouble(req.getParameter("mrate"));
		String mgenre = req.getParameter("mgenre");
		String mlang = req.getParameter("mlang");
		Part mimage = req.getPart("mimage");

		Moviedto movie = new Moviedto();
		movie.setMid(mid);
		movie.setMname(mname);
		movie.setMprice(mprice);
		movie.setMrating(mrate);
		movie.setMgenre(mgenre);
		movie.setMlang(mlang);
		movie.setMimage(mimage.getInputStream().readAllBytes());

		Admindao dao = new Admindao();

		try {
			
			dao.savamovies(movie);
			resp.sendRedirect("home.jsp");
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}

	}
}
