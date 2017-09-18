package fr.supinfo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.supinfo.dao.DaoFactory;
import fr.supinfo.entities.Campus;
import fr.supinfo.entities.Commande;
import fr.supinfo.entities.User;
import fr.supinfo.entities.Voyage;
import fr.supinfo.metier.IClientMetier;
import fr.supinfo.validation.ValidationFormulaire;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/user/trip")
public class ClientController extends HttpServlet {
	IClientMetier client;
	public static String ID_SOURCE = "idSource";
	public static String ID_DEST = "idDest";
	public static String BOUTON = "bouton";
	Long idUser = null;
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int nb = client.getNombreUsers();
		List<Campus> lc = DaoFactory.getDao().getlistCampus();
		request.setAttribute("listeCampus", lc);
		this.getServletContext().getRequestDispatcher("/WEB-INF/connect.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long source = Long.parseLong(request.getParameter(ID_SOURCE));
		Long destination = Long.parseLong(request.getParameter(ID_DEST));
		String bouton = request.getParameter(BOUTON);
		Boolean existe = true;
		idUser = (Long) request.getSession().getAttribute("idUser");
		List<Voyage> listesVoyage = DaoFactory.getDao().getAllTrip();
		if (bouton.equals("addTrip")){
			Commande commande = null; 
			try {
				commande = DaoFactory.getDao().getCommandeUser(idUser);
			} catch (Exception e) {
				System.out.println("Message d erreur = "+e.getMessage());
			}
			
			if (commande == null){
				List<Voyage> v = new ArrayList<Voyage>();
				commande = new Commande("false", DaoFactory.getDao().getUser(idUser),v);
				existe = false;
			}
			List<Voyage> lv = (List<Voyage>) commande.getVoyages();
			Voyage selection = new Voyage();
			
			for (Voyage v : listesVoyage){
				if (v.getSource().equals(source) && v.getDestination().equals(destination) ){
					selection.setIdVoyage(v.getIdVoyage());
					selection.setCampusSource(v.getCampusSource());
					selection.setCampusDestination(v.getCampusDestination());
					selection.setNom(v.getNom());
					selection.setCampusDestination(v.getCampusDestination());
					selection.setCampusSource(v.getCampusSource());
				}
			}		
			lv.add(selection);
			commande.setVoyages(lv);
			if (existe == true){
				DaoFactory.getDao().modCommande(commande);
			}else{
				DaoFactory.getDao().addCommande(commande);
			}	
		}
		doGet(request, response);
	}

}
