package fr.supinfo.metier;

import java.util.List;


import fr.supinfo.dao.TripDAOImpl;
import fr.supinfo.entities.Campus;
import fr.supinfo.entities.Commande;
import fr.supinfo.entities.User;
import fr.supinfo.entities.Voyage;

public class MetierImpl {
	TripDAOImpl dao;
	public void addUser(User u) {
		dao.addUser(u);
		
	}
	
	public Campus getCampus(Long i) {
		
		return dao.getCampus(i);
	}
	
	public int getNombreUsers() {	
		return dao.getNombreUsers();
	}
	
	public List<Campus> listCampus() {	
		return dao.getlistCampus();
	}
	
	public User getUser(Long i) {
		return dao.getUser(i);
	}
	
	public Commande getCommande(Long i) {
		return dao.getCommande(i);
	}
	
	public Voyage getVoyage(Long i) {
		
		return dao.getVoyage(i);
	}
	
	public void deleteUser(Long i) {
		dao.deleteUser(i);
	}
	
	public void deleteCommande(Long i) {
		dao.deleteCommande(i);	
	}
	
	public void deleteVoyage(Long i) {
		dao.deleteVoyage(i);
	}
	
	public void modUser(User u) {
		dao.modUser(u);
	}
	
	public void modCommande(Commande c) {
		dao.modCommande(c);
	}
	
	public void modVoyage(Voyage c) {
		dao.modVoyage(c);
	}
	
	public List<Voyage> listVoyageParCommande(Long idCommande) {
		return dao.getlistVoyageParCommande(idCommande);
	}
	
	public List<Campus> getlistCampus() {
		return dao.getlistCampus();
	}
	
	public List<Voyage> getAllTrip() {
		
		return dao.getAllTrip();
	}
	public int getNombreVoyagePossible() {
		return dao.getNombreVoyagePossible();
	}
	
	public List<Integer> getListIdBooster() {
		
		return dao.getListIdBooster();
	}
	
	public void addCampus(Campus c) {
		dao.addCampus(c);	
	}
	
	
}
