package org.annonce.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AnnonceList")
public class AnnonceList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String connect = null;
       

    public AnnonceList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			DAO<Annonce> annonceDAO = new AnnonceDao(ConnectionDB.getInstance());
			ArrayList<Annonce> annonceList=annonceDAO.List();
			request.setAttribute("annonceList",annonceList);
		
	}
			catch(Exception e){
				e.printStackTrace();
			}
		  this.getServletContext().getRequestDispatcher("/AnnonceList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
	