package fr.supinfo.metier;

import fr.supinfo.entities.Campus;

public interface IAdminMetier extends IClientMetier {
	public void addCampus(Campus c); //Admin
}
