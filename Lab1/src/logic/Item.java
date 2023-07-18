package logic;

import exception.NameBlankException;

public class Item {

	private String itemName;
	private int price;

	// constructor
	public Item(String itemName) throws NameBlankException {
		// FILL CODE
		this.setItemName(itemName);
	}

	public Item(String itemName, int price) throws NameBlankException {
		// FILL CODE
		this.setItemName(itemName);
		this.setPrice(price);
	}

	// methods
	public boolean equals(Item other) {
		// FILL CODE
		if (this.itemName.equals(other.itemName)) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return itemName + " $" + price;
	}

	// getter & setter
	public String getItemName() {
		// FILL CODE
		return itemName;
	}

	public void setItemName(String itemName) throws NameBlankException {
		// FILL CODE
		if (itemName.isBlank()) {
			throw new NameBlankException();
		} else {
			this.itemName = itemName;
		}
	}

	public int getPrice() {
		// FILL CODE
		return price;
	}

	public void setPrice(int price) {
		// FILL CODE
		if (price < 0) {
			this.price = 0;
		} else {
			this.price = price;
		}
	}

}
