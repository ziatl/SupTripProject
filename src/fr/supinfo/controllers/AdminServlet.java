package fr.supinfo.controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.PropertyValueException;

import fr.supinfo.dao.DaoFactory;
import fr.supinfo.entities.Campus;
import fr.supinfo.entities.Voyage;
import fr.supinfo.metier.IAdminMetier;
import fr.supinfo.metier.MetierImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
  
	MetierImpl metier;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*List<String> vv= DaoFactory.getDao().getlistVoyageParVille("Lome");		
		for(String l : vv){
			System.out.println("VoyageServlet == "+l+" !!!!");
		}*/
		//DaoFactory.getDao().generetedTrip1();
	
		/*List<String> liste = DaoFactory.getDao().generetedTrip();
		for(String l : liste){
			System.out.println("VoyageServlet == "+l+" !!!!");
		}
		System.out.println("VoyageServlet ==  !!!!");*/
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/addCampus.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
				String ville = request.getParameter("ville");
				int contact = Integer.parseInt(request.getParameter("contact"));
				String email = request.getParameter("email");
				String description = request.getParameter("description");
				Campus c = new Campus(ville, "Supinfo "+ville,contact, email, description);
				DaoFactory.getDao().addCampus(c);
				
				DaoFactory.getDao().generetedTripGo();
				DaoFactory.getDao().generetedTripReturn();
				
				
		} catch (RuntimeException e) {
			System.out.println("erreur venant de "+e.getMessage());
		}
		doGet(request, response);
	}

}
