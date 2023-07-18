package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.StringUtil;

public class Dish extends Container{
	private int dirty;
	
	public Dish() {
		super("Dish",4);
		setDirty(0);
	}
	
	public Dish(int dirty) {
		super("Dish",4);
		setDirty(dirty); 
	}
	
	public boolean isDirty() {
		if (this.dirty>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifyContent(Ingredient i) {
		if ((!this.isDirty())&&i.isEdible()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setDirty(int dirty) {
		if (dirty<=0) {
			this.dirty = 0;
			this.setName("Dish");
		} else {
			this.dirty = dirty;
			this.setName("Dirty Dish");
		}
	}
	
	public void clean(int amount) {
		setDirty(this.getDirty()-amount);
	}
	
	public String toString() {
		if (getName().equals("Dirty Dish")) {
			return StringUtil.formatNamePercentage(getName(), dirty);
		} else {
			return super.toString();
		}
	}

	public int getDirty() {
		return dirty;
	}
	
	

}
