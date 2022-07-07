package com.qa.ims.persistence.domain;

public class Order {
	
	private long order_id;
	private long customer_id;
	private long items_id;
	private String first_name;
	private String last_name;
	private String item_name;
	private long Quantity;
	private long totalPrice;
	


	public Order(long customer_id, long items_id, long Quantity) {
		setCustomer_id(customer_id);
		setItems_id(items_id);
		setQuantity(Quantity);
	}
	

	public Order(long order_id, long customer_id, long items_id, long Quantity ) {
		setOrder_id(order_id);
		setCustomer_id(customer_id);
		setItems_id(items_id);
		setQuantity(Quantity);
		
		
	}
	public Order(long order_id, long customer_id, String first_name, String last_name, long items_id, String item_name, long Quantity, long totalPrice) {
		setFirst_name(first_name);
		setLast_name(last_name);
		setItem_name(item_name);
		setOrder_id(order_id);
		setCustomer_id(customer_id);
		setItems_id(items_id);
		setQuantity(Quantity);
		setTotalPrice(totalPrice);

	}


	public long getOrder_id() {
		return order_id;
	}


	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}


	public long getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}


	public long getItems_id() {
		return items_id;
	}


	public void setItems_id(long items_id) {
		this.items_id = items_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getItem_name() {
		return item_name;
	}


	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


	public long getQuantity() {
		return Quantity;
	}


	public void setQuantity(long quantity) {
		Quantity = quantity;
	}


	public long getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Quantity ^ (Quantity >>> 32));
		result = prime * result + (int) (customer_id ^ (customer_id >>> 32));
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
		result = prime * result + (int) (items_id ^ (items_id >>> 32));
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + (int) (order_id ^ (order_id >>> 32));
		result = prime * result + (int) (totalPrice ^ (totalPrice >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (Quantity != other.Quantity)
			return false;
		if (customer_id != other.customer_id)
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		if (items_id != other.items_id)
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (order_id != other.order_id)
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customer_id=" + customer_id + ", items_id=" + items_id
				+ ", first_name=" + first_name + ", last_name=" + last_name + ", item_name=" + item_name + ", Quantity="
				+ Quantity + ", totalPrice=" + totalPrice + "]";
	}



}


