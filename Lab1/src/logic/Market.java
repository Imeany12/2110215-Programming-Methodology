package logic;

import java.util.ArrayList;

public class Market {

	// fields
	ArrayList<Item> allItems;

	// constructors
	public Market() {
		// FILL CODE
		this.allItems = new ArrayList<Item>();
	}

	public Market(ArrayList<Item> items) {
		// FILL CODE
		this.allItems = new ArrayList<Item>();
		this.addAllItems(items);

	}

	// methods
	public String toString() {
		String out = "\n";
		for (int i = 0; i < allItems.size(); i++) {
			out += i + 1;
			out += ". ";
			out += allItems.get(i).toString();
			out += "\n";
		}
		return out;
	}

	public void addAllItems(ArrayList<Item> items) {
		// FILL CODE
		if (items != null) {
			for (Item item : items) {
				boolean check = false;
				for (Item inlitem : allItems) {
					if (item.equals(inlitem)) {
						check = true;
						break;
					}
				}
				if (check) {
					System.out.println("\"" + item.getItemName() + "\" is duplicated, Item will not be added.");
				} else {
					allItems.add(item);
					System.out.println("\"" + item + "\" Added to the market.");
				}

			}

		}

	}

	public ArrayList<Item> getAllItems() {
		return allItems;
	}

}

// getter setters
// FILL CODE
