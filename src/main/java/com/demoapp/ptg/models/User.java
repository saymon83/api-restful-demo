package com.demoapp.ptg.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 3004049128350546151L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	@OneToMany(cascade = CascadeType.ALL)
	private List<Phone> phones;
	
	@NotNull
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Local> local;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = true)
	private Date last_login;

	public User() {
		super();
	}

	public User(@NotNull String firstName, @NotNull String lastName,
			@NotNull String email, @NotNull String password,
			@NotNull List<Phone> phones, @NotNull List<Local> local) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phones = phones;
		this.local = local;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
