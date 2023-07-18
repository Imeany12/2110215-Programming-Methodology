package logic.unit;

public class Sorcerer extends BaseCompetitor {

	public Sorcerer(String name) {
		super(name, 4, 2);
		
	}

	public Sorcerer(String name, int hp, int power) {
		super(name, hp, power);
	}

	public void lowerPower(BaseCompetitor enemy, int powerDown) {
		if ((powerDown)>=0) {
		enemy.setPower(enemy.getPower() - powerDown);
		}
	}
	

	public void attack(BaseCompetitor enemy) {
		if (enemy.getType().equals("Tiger")) {
			enemy.setHp(enemy.getHp() - (this.getPower() / 2));
		} else if (enemy.getType().equals("Sorcerer") || enemy.getType().equals("BaseCompetitor")) {
			enemy.setHp(enemy.getHp() - this.getPower());
		} else {
			enemy.setHp(enemy.getHp() - (this.getPower() * 3 / 2));
		}

	}

}
