import java.util.List;
import java.util.Random;

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
		this.mnd = 1;
		this.isEnemy = true;
		this.hitTimes = 1;
	}

}
