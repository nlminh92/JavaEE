package org.annonce.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AnnonceDelete")
public class AnnonceDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AnnonceDelete() {
        super();
            
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              String param = request.getParameter("id");
              Annonce annonce = new Annonce();
              try{
            	  
             
             DAO<Annonce> annonceDAO = new AnnonceDao(ConnectionDB.getInstance());
			 annonce = annonceDAO.find(Integer.parseInt(param));
			
			 annonceDAO.delete(annonce);
		if(annonce.getId() !=null){
			request.setAttribute("message", "Item deleted");
			request.setAttribute("annonceIdDeleted", annonce.getId());
		}	
              }catch (Exception e){
			request.getAttribute("message, Error exception");
			this.getServletContext().getRequestDispatcher("/jsp/AnnonceUpdate.jsp").forward(request, response);
			e.printStackTrace();
		}
			
		this.getServletContext().getRequestDispatcher("/AnnonceList").forward(request, response);
			
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		}	
	}
			


