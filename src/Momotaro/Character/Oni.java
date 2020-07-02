package Momotaro.Character;

public class Oni extends Monster {

	public Oni() {
		super();

		this.setName("鬼" + count);
		this.id = count;
		this.maxHp = 50;
		this.hp = maxHp;
		this.maxMp = 0;
		this.mp = maxMp;
		this.agi = 3;
		this.att = 20;
		this.def = 2;
		this.isEnemy = true;
		this.hitTimes = 1;
	}

}
