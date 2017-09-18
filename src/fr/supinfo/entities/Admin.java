package fr.supinfo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.sun.istack.internal.NotNull;
@Entity
@Table(name="admins")
public class Admin implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idAdmin;
	@NotNull
	@Column(nullable=false)
	private String login;
	@NotNull
	@Column(nullable=false)
	private String password;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	public Long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
