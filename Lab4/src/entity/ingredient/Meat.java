package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable,Cookable {
	private boolean chopState;
	private int cookedPercentage;
	
	public Meat() {
		super("Meat");
		chopState = false;
		cookedPercentage =0;
	}
	
	public void chop() {
		if (!this.isChopped()) {
			chopState = true;
			setName("Minced Meat");
		}
	}
	
	public boolean isChopped() {
		return chopState;
	}
	
	public void cook() {
		if (isChopped() == false) {
			setCookedPercentage(getCookedPercentage() + 10);
			if (getCookedPercentage() > 0 && getCookedPercentage() <= 50) {
				setName("Raw Meat");
				setEdible(false);
			} else if (getCookedPercentage() > 50 && getCookedPercentage() <= 80) {
				setName("Medium Rare Steak");
				setEdible(true);
			} else if (getCookedPercentage() > 80 && getCookedPercentage() <= 100) {
				setName("Well Done Steak");
				setEdible(true);
			} else if (getCookedPercentage() > 100) {
				setName("Burnt Steak");
				setEdible(false);
			}
		} else {
			setCookedPercentage(getCookedPercentage() + 15);
			if (getCookedPercentage() > 0 && getCookedPercentage() <= 80) {
				setName("Raw Burger");
				setEdible(false);
			} else if (getCookedPercentage() > 80 && getCookedPercentage() <= 100) {
				setName("Cooked Burger");
				setEdible(true);
			} else if (getCookedPercentage() > 100) {
				setName("Burnt Burger");
				setEdible(false);
			}
			
		}

	}
	
	public boolean isBurnt() {
		if (getCookedPercentage()>100) {
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
