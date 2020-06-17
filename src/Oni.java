
public class Oni extends FightingObject {

	private static int count = 0;

	public Oni(String name) {
		super();
		count++;

		this.setName(name + count);
		this.id = count;
		this.maxHp = 100;
		this.hp = maxHp;
		this.maxMp = 30;
		this.mp = maxMp;
		this.agi = 3;
		this.att = 20;
		this.def = 2;
		this.mnd = 1;
		this.isDead = false;
		this.isEnemy = true;
		this.isActive = true;
	}

	public void attack(FightingObject opponent) {
		if (isDead() || !isActive)
			return;

		System.out.println(getName() + "の攻撃");
		int damage = 15;
		System.out.println(opponent.getName() + "に" + damage + "ダメージ！");
		opponent.setHp(opponent.getHp() - damage);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
		System.out.println(getName() + "の現在HP：" + getHp());
		if (hp <= 0) {
			this.setDead(true);
			System.out.println(getName() + "は死亡した");
		}
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

}
