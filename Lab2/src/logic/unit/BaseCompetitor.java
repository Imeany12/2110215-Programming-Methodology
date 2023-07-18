package logic.unit;

public class BaseCompetitor {
	private String name;
	private int power;
	private int hp;

	public BaseCompetitor(String name) {
		this.name = name;
		this.power = 3;
		this.hp = 5;
	}

	public BaseCompetitor(String name, int hp, int power) {
		this.name = name;
		this.setHp(hp);
		this.setPower(power);
	}

	public void attack(BaseCompetitor enemy) {
		enemy.setHp(enemy.getHp() - this.getPower());

	}

	public String getType() {
		return this.getClass().getSimpleName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		if (power < 1) {
			this.power = 1;
		} else {
			this.power = power;
		}
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		if (hp < 0) {
			this.hp = 0;
		} else {
			this.hp = hp;
		}

	}

}
