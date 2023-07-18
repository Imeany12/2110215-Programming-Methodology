package logic.unit;

public class ToughMan extends BaseCompetitor{
	private int maxHp;

	public ToughMan(String name) {
		super(name,8, 4);
		this.setMaxHp(8);
	}

	public ToughMan(String name, int hp, int power) {
		super(name, hp, power);
		this.setMaxHp(hp);
	}

	public void heal(int healHp) {
		if (healHp<0){
			
		}else if ((healHp+this.getHp()>this.getMaxHp())){
			this.setHp(getMaxHp());
		}else {
			
			this.setHp(healHp+this.getHp());
			
		}
	}

	public void attack(BaseCompetitor enemy) {
		if (enemy.getType().equals("Sorcerer")) {
			enemy.setHp(enemy.getHp() - (this.getPower() / 2));
		} else if (enemy.getType().equals("ToughMan") || enemy.getType().equals("BaseCompetitor")) {
			enemy.setHp(enemy.getHp() - this.getPower());
		} else {
			enemy.setHp(enemy.getHp() - (this.getPower() * 3 / 2));
		}

	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		if (maxHp<0) {
			this.maxHp = 0;
			this.setHp(0);
		}else if (maxHp<this.getHp()){
			this.setHp(maxHp);
			this.maxHp =maxHp;
			
		
		}else {
			this.maxHp = maxHp; 
		}
	}

	
	

}
