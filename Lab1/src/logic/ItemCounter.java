package logic;

public class ItemCounter {
	private Item item;
	private int amount;

	public ItemCounter(Item item) {
		this.setItem(item);
		this.setCount(1);
	}

	public ItemCounter(Item item, int count) {
		this.setItem(item);
		this.setCount(count);
		if (this.amount == 0) {
			this.amount = 1;
		}
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getCount() {
		return amount;
	}

	public void setCount(int amount) {
		if (amount < 1) {
			this.amount = 0;
		} else {
			this.amount = amount;
		}
	}

	public String toString() {
		return this.getItem() + " x" + this.getCount();
	}

}
