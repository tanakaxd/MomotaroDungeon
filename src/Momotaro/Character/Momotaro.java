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
		this.att = 20;
		this.def = 10;
		this.hitTimes = 1;
		this.isEnemy = false;
		this.weapon = new Sude();

	}

}
