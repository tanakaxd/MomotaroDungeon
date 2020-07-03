package Momotaro.Character;

import Momotaro.Item.Sude;

public class Momotaro extends Hero {

	public Momotaro() {
		super();
		this.setName("桃太郎");
		this.id = 0;
		this.maxHp = 100;
		this.hp = maxHp;
		this.maxMp = 30;
		this.mp = maxMp;
		this.agi = 10;
		this.att = 12;
		this.def = 12;
		this.hitTimes = 1;
		this.isEnemy = false;
		this.weapon = new Sude();

	}

}
