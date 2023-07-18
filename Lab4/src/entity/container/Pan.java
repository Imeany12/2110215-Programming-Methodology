package entity.container;

import entity.base.Container;
import entity.base.Cookable;
import entity.base.Ingredient;

public class Pan extends Container{
	
	public Pan() {
		super("Pan",1);
	}
	
	public boolean verifyContent(Ingredient i) {
		if (i instanceof Cookable) {
			return true;
		}else {
			return false;
		}
	}

	public void cook() {
		if (!this.isEmpty()) {
			for(Ingredient ingredient :this.getContent()) {
				((Cookable) ingredient).cook();
			}
		}
	}
}
