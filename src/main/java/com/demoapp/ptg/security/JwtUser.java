package com.demoapp.ptg.security;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.demoapp.ptg.models.Local;
import com.demoapp.ptg.models.Phone;
import com.demoapp.ptg.models.User;


public class JwtUser implements Serializable {

	private static final long serialVersionUID = -874071359709399690L;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private List<Phone> phones;
	
	private List<Local> local;
	
	private Date created_at;
	
	private Date last_login;
	
	public JwtUser() {
	}

	public JwtUser(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.phones = user.getPhones();
		this.created_at = user.getCreated_at();
		this.last_login = user.getLast_login();
		this.local = user.getLocal();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Local> getLocal() {
		return local;
	}

	public void setLocal(List<Local> local) {
		this.local = local;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	
}
