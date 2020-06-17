
public class Oni extends FightingObject {

	public Oni(String name) {
		super();
		this.setName(name);
		this.setHp(100);
		this.mp = 10;
		setDead(false);
		this.isEnemy = true;

	}

	public void attack(FightingObject opponent) {
		if (isDead())
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
