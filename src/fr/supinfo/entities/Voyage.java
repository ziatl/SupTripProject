package fr.supinfo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;
@Entity
@Table(name="voyages")
public class Voyage implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoyage;
	@NotNull
	@Column(nullable=false)
	private String nom;
	@NotNull
	@Column(nullable=false)
	private String source;
	@NotNull
	@Column(nullable=false)
	private String destination;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="idCampus1")
	private Campus campusSource;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="idCampus2")
	private Campus campusDestination;
	@ManyToMany
	Collection<Commande> commandes;

	public Voyage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Voyage(Campus campusSource, Campus campusDestination) {
		super();
		
		this.campusSource = campusSource;
		this.campusDestination = campusDestination;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom ;
	}
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Long getIdVoyage() {
		return idVoyage;
	}

	public void setIdVoyage(Long idVoyage) {
		this.idVoyage = idVoyage;
	}

	public Campus getCampusSource() {
		return campusSource;
	}

	public void setCampusSource(Campus campusSource) {
		this.campusSource = campusSource;
	}

	public Campus getCampusDestination() {
		return campusDestination;
	}

	public void setCampusDestination(Campus campusDestination) {
		this.campusDestination = campusDestination;
	}
}
