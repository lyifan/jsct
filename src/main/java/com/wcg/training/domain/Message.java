package com.wcg.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblMessage")
public class Message implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8788513876993712574L;

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;

	@Column(name="Message")
	private String messsage;
	
	@Column(name="UserID")
	private int userId;
	
	@OneToOne(mappedBy="id")
	private User user;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
