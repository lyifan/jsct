package com.wcg.training.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tblRole")
public class Role implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6586568244477373572L;

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;

	@Column(name="Name")
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private List<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
