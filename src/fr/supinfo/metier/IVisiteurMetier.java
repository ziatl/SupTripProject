package fr.supinfo.metier;

import java.util.List;

import fr.supinfo.entities.Campus;
import fr.supinfo.entities.User;
import fr.supinfo.entities.Voyage;

public interface IVisiteurMetier {
	public void addUser(User u); //V
	public Campus getCampus(Long i); // V
	public int getNombreUsers(); //V
	public List<Campus> listCampus(); // V
	public List<Voyage> getAllTrip(); 
	public int getNombreVoyagePossible();//V
	public List<Campus> getlistCampus();
	public List<Integer> getListIdBooster();
}
