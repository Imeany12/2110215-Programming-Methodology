package entity.ingredient;

import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Egg extends Ingredient implements Cookable {
	private int cookedPercentage;

	public Egg() {
		super("Egg");
		cookedPercentage = 0;
	}

	public void cook() {
		setCookedPercentage(getCookedPercentage() + 12);
		if (getCookedPercentage() > 0 && getCookedPercentage() <= 50) {
			setName("Raw Egg");
			setEdible(false);
		} else if (getCookedPercentage() > 50 && getCookedPercentage() <= 80) {
			setName("Sunny Side Egg");
			setEdible(true);
		} else if (getCookedPercentage() > 80 && getCookedPercentage() <= 100) {
			setName("Fried Egg");
			setEdible(true);
		} else if (getCookedPercentage() > 100) {
			setName("Burnt Egg");
			setEdible(false);
		}

	}

	public boolean isBurnt() {
		if (getCookedPercentage() > 100) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return StringUtil.formatNamePercentage(getName(), getCookedPercentage());
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}

	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = cookedPercentage;
	}

}
