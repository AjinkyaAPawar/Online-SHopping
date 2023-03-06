package com.pratiti.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private byte allowed;

	private String type;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="payment")
	private List<Order> orders;

	public Payment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAllowed() {
		return this.allowed;
	}

	public void setAllowed(byte allowed) {
		this.allowed = allowed;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setPayment(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setPayment(null);

		return order;
	}

}