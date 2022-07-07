package com.qa.ims.persistence.domain;

public class Item {

	private long id;
	private String ItemName;
	private long ItemPrice;

	public Item(String ItemName, long ItemPrice) {
		this.setItemName(ItemName);
		this.setItemPrice(ItemPrice); 
		
	}

	public Item(long id, String ItemName, long ItemPrice) {
		this.setId(id);
		this.setItemName(ItemName);
		this.setItemPrice(ItemPrice);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getItemPrice() {
		return ItemPrice;
	}

	public void setItemPrice(long itemPrice) {
		this.ItemPrice = itemPrice;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String ItemName) {
		this.ItemName = ItemName;
	} 



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ItemName == null) ? 0 : ItemName.hashCode());
		result = prime * result + (int) (ItemPrice ^ (ItemPrice >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (ItemName == null) {
			if (other.ItemName != null)
				return false;
		} else if (!ItemName.equals(other.ItemName))
			return false;
		if (ItemPrice != other.ItemPrice)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", ItemName=" + ItemName + ", ItemPrice=" + ItemPrice + "]";
	}
	



}
