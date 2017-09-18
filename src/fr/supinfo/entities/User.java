package fr.supinfo.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUser;
	@NotNull
	@Column(nullable=false)
	private String nom;
	@NotNull
	@Column(nullable=false)
	private int idBooster;
	@NotNull
	@Column(nullable=false)
	private String prenom;
	@NotNull
	@Column(nullable=false)
	private String email;
	@NotNull
	@Column(nullable=false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name="idCampus")
	private Campus campus;
	
	public User(int idBooster, String nom, String prenom, String email, String password, Campus campus) {
		super();
		this.idBooster = idBooster;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.campus = campus;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public int getIdBooster() {
		return idBooster;
	}


	public void setIdBooster(int idBooster) {
		this.idBooster = idBooster;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Campus getCampus() {
		return campus;
	}


	public void setCampus(Campus campus) {
		this.campus = campus;
	}

}
