package fr.supinfo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;
@Entity
@Table(name="commandes")
public class Commande implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCommande;
	private String statut;
	@NotNull 
	@OneToOne
	@JoinColumn(name="idUser")
	User user;
	@ManyToMany(mappedBy="commandes")
	Collection<Voyage> voyages;
	
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Collection<Voyage> getVoyages() {
		return voyages;
	}
	public void setVoyages(Collection<Voyage> voyages) {
		this.voyages = voyages;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(String statut, User user, Collection<Voyage> voyages) {
		super();
		this.statut = statut;
		this.user = user;
		this.voyages = voyages;
	}
}
