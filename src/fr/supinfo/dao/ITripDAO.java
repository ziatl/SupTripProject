package fr.supinfo.dao;

import java.util.List;
import java.util.Map;

import fr.supinfo.entities.Campus;
import fr.supinfo.entities.Commande;

import fr.supinfo.entities.User;
import fr.supinfo.entities.Voyage;

public interface ITripDAO {
	public void addUser(User u); //V
	public void addCampus(Campus c); //Admin
	public void addVoyage(Voyage v); // C
	public void addCommande(Commande c); // C
	
	public Campus getCampus(Long i); // V
	public User getUser(Long i); // C
	public Commande getCommande(Long i);//C
	public Commande getCommandeUser(Long idUser); //C
	public Voyage getVoyage(Long i); //C
	
	public void deleteUser(Long i); // C
	public void deleteCommande(Long i); // C
	public void deleteVoyage(Long i); //C
	public void deleteCampus(Long i); //A
	
	public void modUser(User u); // C
	public void modCommande(Commande c); // C
	public void modVoyage(Voyage c); // C
	public void modCampus(Campus c); //
	
	public int getNombreUsers(); //V
	public List<Campus> getlistCampus(); // V
	public List<Voyage> getlistVoyageParCommande(Long idCommande); //C
	public int getNombreVoyagePossible();// V
	public List<String> getlistVoyageParVille(String source); // V
	
	
	public List<String> generetedTrip1(); // automatik
	public List<Voyage> getAllTrip(); // V
	public void generetedTripGo(); // automatik
	public void  deleteAllTrip();
	public List<Integer> getListIdBooster(); //V
	
	void generetedTripReturn();

}
