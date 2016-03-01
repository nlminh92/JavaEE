package org.annonce.servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AnonceAdd")
public class AnnonceAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AnnonceAdd() {
        super();
            
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		this.getServletContext().getRequestDispatcher("/AnnonceUpdate.jsp").forward(request, response);
			
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Annonce annonce = new Annonce();
		annonce.setTitle(request.getParameter("title"));
		annonce.setDescription(request.getParameter("description"));
		annonce.setAdress(request.getParameter("adress"));
		annonce.setMail(request.getParameter("mail"));
		
		if(request.getParameter("title")==null || request.getParameter("title").length()==0
			||	request.getParameter("description")==null || request.getParameter("description").length()==0
			||	request.getParameter("adress")==null || request.getParameter("adress").length()==0
			||	request.getParameter("mail")==null || request.getParameter("mail").length()==0){
			
			request.setAttribute("message", "Tous les champs sont obligatoires");
			request.setAttribute("annonce", annonce);
			this.getServletContext().getRequestDispatcher("/AnnonceAdd.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "Tous les champs sont OK");
		
			request.setAttribute("annonce", annonce);
			
			try{
				DAO<Annonce> annonceDAO = new AnnonceDao(ConnectionDB.getInstance());
				if(annonceDAO.create(annonce)){
				request.setAttribute("message",  "Item created!");	
				request.setAttribute("annonceTdCreated", annonce.getId());
				
				}
				
			}catch (Exception e){
				request.getAttribute("message, Error exception");
				this.getServletContext().getRequestDispatcher("/jsp/AnnonceAdd.jsp").forward(request, response);
				e.printStackTrace();
			}
			
			this.getServletContext().getRequestDispatcher("/AnnonceList").forward(request, response);
		
			
		}		
	}		
}

