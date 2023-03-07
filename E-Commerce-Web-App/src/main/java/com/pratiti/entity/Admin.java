package com.pratiti.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="admins")
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	private String name;

	private String password;

	//bi-directional many-to-one association to Retailer
	@OneToMany(mappedBy="admin")
	private List<Retailer> retailers;

	public Admin() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Retailer> getRetailers() {
		return this.retailers;
	}

	public void setRetailers(List<Retailer> retailers) {
		this.retailers = retailers;
	}

	public Retailer addRetailer(Retailer retailer) {
		getRetailers().add(retailer);
		retailer.setAdmin(this);

		return retailer;
	}

	public Retailer removeRetailer(Retailer retailer) {
		getRetailers().remove(retailer);
		retailer.setAdmin(null);

		return retailer;
	}

}