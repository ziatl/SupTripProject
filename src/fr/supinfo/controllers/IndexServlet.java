

package fr.supinfo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.supinfo.dao.DaoFactory;
import fr.supinfo.entities.Campus;
import fr.supinfo.metier.IClientMetier;
import fr.supinfo.metier.IVisiteurMetier;
import fr.supinfo.metier.MetierImpl;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	MetierImpl metier;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<Campus> listeCampus = DaoFactory.getDao().getlistCampus();
	req.setAttribute("listeCampus", listeCampus);
	this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
