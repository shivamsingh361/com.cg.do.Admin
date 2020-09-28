package com.cg.go.admin.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_table")
public class Order {
	@Id
	@Column(name="order_id")
	private String order_id;
	@Column(name="user_id")
	private String user_id;
	@Column(name="status")
	private String status;
	@Column(name="amount")
	private double amount;
	@Column(name="order_date")
	private Date order_date;
	
	public Order() {
		super();
	}

	public Order(String order_id, String user_id, String status, String retailer_id, double amount, Date order_date) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.status = status;
		this.amount = amount;
		this.order_date = order_date;
	}

	public String getOrder_id() {
		return order_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getStatus() {
		return status;
	}

	public double getAmount() {
		return amount;
	}

	public Date getOrder_date() {
		return order_date;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", status=" + status + ", ammount=" + amount + ", order_date=" + order_date + "]";
	}
	
}
