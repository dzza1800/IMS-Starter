package com.qa.ims.persistence.domain;

public class Item {

	private Long id;
	private String ItemName;
	private Double ItemPrice;

	public Item(String ItemName, Double ItemPrice) {
		this.setItemName(ItemName);
		this.setItemPrice(ItemPrice);
		
	}

	public Item(Long id, String firstName, Double ItemPrice) {
		this.setId(id);
		this.setItemName(firstName);
		this.setItemPrice(ItemPrice);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getItemPrice() {
		return ItemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		ItemPrice = itemPrice;
	}

	public String getItemtName() {
		return ItemName;
	}

	public void setItemName(String ItemName) {
		this.ItemName = ItemName;
	}

	@Override
	public String toString() {
		return "id:" + id + " Item Name:" + ItemName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ItemName == null) ? 0 : ItemName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ItemPrice == null) ? 0 : ItemPrice.hashCode());
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
		Item other = (Item) obj;
		if (getItemName() == null) {
			if (other.getItemName() != null)
				return false;
		} else if (!getItemName().equals(other.getItemName()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ItemPrice == null) {
			if (other.ItemPrice != null)
				return false;
		} else if (!ItemPrice.equals(other.ItemPrice))
			return false;
		return true;

	}

	public String getItemName() {
		// TODO Auto-generated method stub
		return ItemName;
	}

}
