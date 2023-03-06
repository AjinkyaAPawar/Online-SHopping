package com.pratiti.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private byte cancel;

	@Column(name="customer_id")
	private int customerId;

	private byte fulfilled;

	private int number;

	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	private Date orderDate;

	private byte paid;

	@Temporal(TemporalType.DATE)
	@Column(name="payment_date")
	private Date paymentDate;

	@Column(name="sales_tax")
	private int salesTax;

	@Temporal(TemporalType.DATE)
	@Column(name="shipment_date")
	private Date shipmentDate;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="order")
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to Payment
	@ManyToOne
	private Payment payment;

	//bi-directional many-to-one association to Shipper
	@ManyToOne
	private Shipper shipper;

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getCancel() {
		return this.cancel;
	}

	public void setCancel(byte cancel) {
		this.cancel = cancel;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public byte getFulfilled() {
		return this.fulfilled;
	}

	public void setFulfilled(byte fulfilled) {
		this.fulfilled = fulfilled;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public byte getPaid() {
		return this.paid;
	}

	public void setPaid(byte paid) {
		this.paid = paid;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getSalesTax() {
		return this.salesTax;
	}

	public void setSalesTax(int salesTax) {
		this.salesTax = salesTax;
	}

	public Date getShipmentDate() {
		return this.shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setOrder(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setOrder(null);

		return orderDetail;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Shipper getShipper() {
		return this.shipper;
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}

}