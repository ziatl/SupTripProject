package fr.supinfo.metier;

import java.util.List;

import fr.supinfo.entities.Campus;
import fr.supinfo.entities.Commande;
import fr.supinfo.entities.User;
import fr.supinfo.entities.Voyage;

public interface IClientMetier extends IVisiteurMetier {
	public User getUser(Long i); // C
	public Commande getCommande(Long i); //C
	public Voyage getVoyage(Long i); //C
	public void deleteUser(Long i); // C
	public void deleteCommande(Long i); // C
	public void deleteVoyage(Long i); //C
	public void modUser(User u); // C
	public void modCommande(Commande c); // C
	public void modVoyage(Voyage c); // C
	public List<Voyage> listVoyageParCommande(Long idCommande); //C
	public List<Campus> getlistCampus(); // V
}
