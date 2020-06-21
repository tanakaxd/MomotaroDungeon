import java.util.List;
import java.util.stream.Collectors;

public class Momotaro extends Hero {

	public Momotaro() {
		super();
		this.setName("桃太郎");
		this.id = 0;
		this.maxHp = 10;
		this.hp = maxHp;
		this.maxMp = 30;
		this.mp = maxMp;
		this.agi = 10;
		this.att = 15;
		this.def = 10;
		this.mnd = 8;
		this.hitTimes = 1;
		this.isEnemy = false;
		this.weapon = new Sude();

	}

}
