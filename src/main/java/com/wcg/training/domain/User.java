package com.wcg.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblUser")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 802313006775149835L;

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;

	@Column(name="LoginName")
	private String loginName;
	
	@Column(name="Password")
	private String password;
	
/*	@OneToMany(mappedBy="userId")
	private List<Message> messages;*/
	
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

/*	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}	*/
}
