import java.util.List;
import java.util.Random;

public class Oni extends FightingObject {

	private static int count = 0;

	public Oni(String name) {
		super();
		count++;

		this.setName(name + count);
		this.id = count;
		this.maxHp = 50;
		this.hp = maxHp;
		this.maxMp = 0;
		this.mp = maxMp;
		this.agi = 3;
		this.att = 20;
		this.def = 2;
		this.mnd = 1;
		this.isDead = false;
		this.isEnemy = true;
		this.isActive = true;
	}

	@Override
	protected void doAttack(List<FightingObject> targets) {
		FightingObject opponent = targets.get(new Random().nextInt(targets.size()));
		int damage = (getAtt() - opponent.getDef());
		displayAttack(opponent, damage);

	}

	protected void displayAttack(FightingObject opponent, int damage) {
		// 最低1ダメージ
		damage = Math.max(1, damage);
		System.out.println(opponent.getName() + "に" + damage + "ダメージ!");
		opponent.setHp(opponent.getHp() - damage);
	}

}
