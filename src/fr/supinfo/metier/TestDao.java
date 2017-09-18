package fr.supinfo.metier;

import java.util.List;
import java.util.Map;

import fr.supinfo.dao.DaoFactory;
import fr.supinfo.entities.Campus;
import fr.supinfo.entities.Commande;
import fr.supinfo.entities.User;
import fr.supinfo.entities.Voyage;

public class TestDao {

	public static void main(String[] args) {
		
		/*System.out.println("Vous pouvez faire : "+DaoFactory.getDao().getNombreVoyagePoossible() + "VoyageServlet");
		List<VoyageServlet> rec = DaoFactory.getDao().getAllTrip();
		for (VoyageServlet index : rec){
			System.out.println(index.getCampusSource());
		}*/
		
		
		Campus c = new Campus("lome", "togo", 939, "kkfkf", "dkkdgj");
		DaoFactory.getDao().addCampus(c);

//		User u = new User(233445, "bobo", "capitain", "zzz@ddd.fr", "full", DaoFactory.getDao().getCampus((long) 1));
//		DaoFactory.getDao().addUser(u);
		
//		Commande c = new Commande("bien",DaoFactory.getDao().getUser((long)1));
//		DaoFactory.getDao().addCommande(c);
		
		//VoyageServlet v = new VoyageServlet(DaoFactory.getDao().getCampus((long)1), DaoFactory.getDao().getCampus((long)2), DaoFactory.getDao().getCommande((long)1)
	}

}
