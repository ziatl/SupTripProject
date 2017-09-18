package fr.supinfo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.annotations.FlushModeType;

import fr.supinfo.database.PersitanceManager;
import fr.supinfo.entities.Campus;
import fr.supinfo.entities.Commande;

import fr.supinfo.entities.User;
import fr.supinfo.entities.Voyage;

public class TripDAOImpl implements ITripDAO{
	@Override
	public void addUser(User u) {
		EntityManager em = PersitanceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(u);
		et.commit();
		em.close();	
	}
	@Override
	public void addCampus(Campus c){
		EntityManager em = PersitanceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
		em.close();	
		
	}
	
	@Override
	public void addCommande(Commande c){
		EntityManager em = PersitanceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
		em.close();	
	}
	@Override
	public Campus getCampus(Long i){
		EntityManager em = PersitanceManager.getEntityManager();
		return em.find(Campus.class, i);
	}
	@Override
	public User getUser(Long i){
		EntityManager em = PersitanceManager.getEntityManager();
		return em.find(User.class, i);
	}
	@Override
	public Commande getCommande(Long i){
		EntityManager em = PersitanceManager.getEntityManager();
		return em.find(Commande.class, i);
	}
	@Override
	public Commande getCommandeUser(Long idUser) {
		EntityManager em = PersitanceManager.getEntityManager();
		Query req = em.createQuery("select c from Commande c where c.user.idClient=:x");
		req.setParameter("x", idUser);
		return (Commande) req.getSingleResult();
	}
	@Override
	public Voyage getVoyage(Long i) {
		EntityManager em = PersitanceManager.getEntityManager();
		return em.find(Voyage.class, i);
	}
	@Override
	public void deleteUser(Long i) {
		EntityManager em = PersitanceManager.getEntityManager();
		em.remove(em.find(User.class, i));
		
	}
	@Override
	public void deleteCommande(Long i) {
		EntityManager em = PersitanceManager.getEntityManager();
		em.remove(em.find(Commande.class, i));
	}
	@Override
	public void deleteVoyage(Long i) {
		EntityManager em = PersitanceManager.getEntityManager();
		em.remove(em.find(Voyage.class, i));
		
	}
	@Override
	public void deleteCampus(Long i) {
		EntityManager em = PersitanceManager.getEntityManager();
		em.remove(em.find(Campus.class, i));
	}
	@Override
	public void modUser(User u) {
		EntityManager em = PersitanceManager.getEntityManager();
		em.merge(u);
	}
	@Override
	public void modCommande(Commande c) {
		EntityManager em = PersitanceManager.getEntityManager();
	
		em.merge(c);	
	}
	@Override
	public void modVoyage(Voyage c) {
		EntityManager em = PersitanceManager.getEntityManager();
		em.merge(c);
		
	}
	@Override
	public void modCampus(Campus c) {
		EntityManager em = PersitanceManager.getEntityManager();
		em.merge(c);
	}
	@Override
	public List<Campus> getlistCampus() {
		EntityManager em = PersitanceManager.getEntityManager();
		Query q = em.createQuery("select c from Campus c");
		return q.getResultList();
	}
	@Override
	public List<Voyage> getlistVoyageParCommande(Long idCommande) {
		EntityManager em = PersitanceManager.getEntityManager();
		Query req = em.createQuery("select v from Voyage v where v.commandes.idCommande=:x");
		req.setParameter("x", idCommande);
		return req.getResultList();
	}
	@Override
	public int getNombreUsers() {
		EntityManager em = PersitanceManager.getEntityManager();
		Query req= em.createQuery("select count(u.idCampus) from Campus u");
		return  (int) req.getSingleResult();
	}
	
	
	@Override
	public int getNombreVoyagePossible(){
		return DaoFactory.getDao().getAllTrip().size();
	}
	@Override
	public void addVoyage(Voyage v){
		EntityManager em = PersitanceManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(v);
		et.commit();
		em.close();	
	}


	@Override
	public List<Voyage> getAllTrip() {
		List<Voyage> resultat = new ArrayList<>();
		
		return resultat;
	}
	@Override
	public List<String> generetedTrip1() {
		List<Campus> l = DaoFactory.getDao().getlistCampus();
		EntityManager em = PersitanceManager.getEntityManager();
		List<String> liste = new ArrayList<String>();
		for (int i = 0; i < l.size(); i++) {
			for (int j = i+1; j < l.size(); j++) {		
				liste.add(l.get(i).getVille()+" - "+l.get(j).getVille());	
				liste.add(l.get(j).getVille()+" - "+l.get(i).getVille());			
			}	
		}
		return liste;	
	}
	@Override
	public List<String> getlistVoyageParVille(String ville) {
		EntityManager em = PersitanceManager.getEntityManager();
		//Query q = em.createQuery("select v from VoyageServlet v where v.nom like :x");
		List<String> retour = new ArrayList<String>();
		List<String> voyage = DaoFactory.getDao().generetedTrip1();
		String [] pats;
		for (String v : voyage) {
			pats = v.split(" - ");
			if (pats[0].equals(ville) || pats[1].equals(ville)){
				retour.add(v);
			}			
		}
		return retour;
	}
	@Override
	public void generetedTripGo() {	
	
	List<Campus> l = DaoFactory.getDao().getlistCampus();
	EntityManager em = PersitanceManager.getEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
		if (l.size()>1){
			String source = null;
			String destination = null;
			for (int i = 0; i < l.size(); i++) {
				
				for (int j = i+1; j < l.size(); j++) {					
				    try {
				    	Voyage v = new Voyage();
				    	source = l.get(i).getVille();
						v.setCampusSource(l.get(i));
						v.setSource(source);
					    destination = l.get(j).getVille();					
					    v.setCampusDestination(l.get(j));
					    v.setDestination(destination);
					    v.setNom(source+"-"+destination);
					    em.persist(v);					    
					} catch (Exception e) {
						System.out.println("**** message "+e.getMessage());
					}
				}	
			}		
		}
		et.commit();
		em.close(); 
	}
	@Override
	public void generetedTripReturn() {	
	
	List<Campus> l = DaoFactory.getDao().getlistCampus();
	EntityManager em = PersitanceManager.getEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	int id = 1;
		if (l.size()>1){
			String source = null;
			String destination = null;
			for (int i = 0; i < l.size(); i++) {
				for (int j = i+1; j < l.size(); j++) {					
				    try {
				    	Voyage v = new Voyage();
				    	
				    	source = l.get(i).getVille();
						v.setCampusSource(l.get(i));
					    destination = l.get(j).getVille();
					    v.setSource(destination);
					    v.setCampusDestination(l.get(j));
					    v.setDestination(source);
					    v.setNom(destination+"-"+source);
					    em.persist(v);	
					   
					} catch (Exception e) {
						System.out.println("**** message "+e.getMessage());
					}
				}	
			}		
		}
		et.commit();
		em.close(); 
	}
	@Override
	public List<Integer> getListIdBooster() {
		EntityManager em = PersitanceManager.getEntityManager();
		Query req = em.createQuery("select u.idBooster from User u ");
		return req.getResultList();
	}
	@Override
	public void deleteAllTrip() {
		EntityManager em = PersitanceManager.getEntityManager();
		em.remove("from VoyageServlet");
		Query req = em.createQuery("delete from VoyageServlet");
		req.executeUpdate();
	}
	public List<User> getAllUser(){
		EntityManager em = PersitanceManager.getEntityManager();
		Query req = em.createQuery("select f from User f");
		return req.getResultList();
	}
}
