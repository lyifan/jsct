package com.wcg.training.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblUser")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 802313006775149835L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "LoginName", nullable = false, unique = true)
	private String loginName;

	@Column(name = "Password", nullable = false)
	private String password;
	
	@Column(name = "Email", unique = true)
	private String email;
	
	@ManyToMany
	@JoinTable(name = "tblUserRole", joinColumns = { @JoinColumn(name = "UserID") }, inverseJoinColumns = {
			@JoinColumn(name = "RoleID") })
	private List<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
