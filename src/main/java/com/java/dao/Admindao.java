package com.java.dao;

import java.sql.Blob;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.java.dto.Admindto;
import com.java.dto.Moviedto;

public class Admindao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql:///movielibrary", "root", "root");
	}

	public int saveAdmin(Admindto admin) throws ClassNotFoundException, SQLException {

		Connection conn = getConnection();
		PreparedStatement pt = conn.prepareStatement("insert into admin values(?,?,?,?,?)");
		pt.setInt(1, admin.getAid());
		pt.setString(2, admin.getAname());
		pt.setLong(3, admin.getAcon());
		pt.setString(4, admin.getAmail());
		pt.setString(5, admin.getApass());

		return pt.executeUpdate();

	}

	public Admindto findByEmail(String email) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from admin where amail=?");
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		Admindto admin = new Admindto();
		if (rs.next()) {
			admin.setAid(rs.getInt(1));
			admin.setAname(rs.getString(2));
			admin.setAcon(rs.getLong(3));
			admin.setAmail(rs.getString(4));
			admin.setApass(rs.getString(5));

			return admin;
		} else {
			return null;
		}

	}

	public int savamovies(Moviedto movie) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();

		PreparedStatement pt = conn.prepareStatement("insert into moviehub values(?,?,?,?,?,?,?)");
		pt.setInt(1, movie.getMid());
		pt.setString(2, movie.getMname());
		pt.setDouble(3, movie.getMprice());
		pt.setDouble(4, movie.getMrating());
		pt.setString(5, movie.getMgenre());
		pt.setString(6, movie.getMlang());
		Blob imageblob = new SerialBlob(movie.getMimage());
		pt.setBlob(7, imageblob);
		return pt.executeUpdate();

	}

	public List<Moviedto> getMovie() throws ClassNotFoundException, SQLException {

		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from moviehub");
		ResultSet rs = pst.executeQuery();
		List<Moviedto> movie = new ArrayList<Moviedto>();
		while (rs.next()) {
			Moviedto m = new Moviedto();
			m.setMid(rs.getInt(1));
			m.setMname(rs.getString(2));
			m.setMprice(rs.getDouble(3));
			m.setMrating(rs.getDouble(4));
			m.setMgenre(rs.getString(5));
			m.setMlang(rs.getString(6));

			Blob b = rs.getBlob(7);
			byte[] img = b.getBytes(1, (int) b.length());
			m.setMimage(img);
			movie.add(m);
		}

		return movie;

	}

	public int delete(int id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();

		PreparedStatement pt = conn.prepareStatement("delete from moviehub where mid=?");
		pt.setInt(1, id);

		return pt.executeUpdate();

	}

	public Moviedto findId(int mid) throws ClassNotFoundException, SQLException {

		Connection conn = getConnection();
		PreparedStatement pt = conn.prepareStatement("select * from moviehub where mid=?");
		pt.setInt(1, mid);
		ResultSet rs = pt.executeQuery();
		if (rs.next()) {
			Moviedto m = new Moviedto();
			m.setMid(rs.getInt(1));
			m.setMname(rs.getString(2));
			m.setMprice(rs.getDouble(3));
			m.setMrating(rs.getDouble(4));
			m.setMgenre(rs.getString(5));
			m.setMlang(rs.getString(6));
			Blob b = rs.getBlob(7);
			byte[] img = b.getBytes(1, (int) b.length());
			m.setMimage(img);
			return m;

		} else {
			return null;

		}

	}

	public int updateMovie(Moviedto movie) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pt = conn.prepareStatement("update moviehub set mname=?,mprice=?,mrating=?,mgenre=?,mlang=?,mimage=? where mid=?");
		pt.setInt(7, movie.getMid());
		pt.setString(1, movie.getMname());
		pt.setDouble(2, movie.getMprice());
		pt.setDouble(3, movie.getMrating());
		pt.setString(4, movie.getMgenre());
		pt.setString(5, movie.getMlang());
		Blob b = new SerialBlob(movie.getMimage());
		if (b.length() > 0) {

			pt.setBlob(6, b);

		} else {
			Moviedto m = findId(movie.getMid());
			Blob b1 = new SerialBlob((m.getMimage()));
			pt.setBlob(6, b1);
		}
		return pt.executeUpdate();

	}
}
