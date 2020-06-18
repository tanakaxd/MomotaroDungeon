
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
	public void attack(FightingObject opponent) {
		super.attack(opponent);

		int damage = Math.max(1, this.att - opponent.getDef());
		closeAttack(opponent, damage);
	}

}
