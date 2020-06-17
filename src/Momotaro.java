
public class Momotaro extends FightingObject {

	public Momotaro() {
		super();
		this.setName("桃太郎");
		this.setHp(100);
		this.mp = 10;
		this.isDead = false;
		this.isEnemy = false;
	}

	public void attack(FightingObject opponent) {
		if (isDead)
			return;

		System.out.println(getName() + "の攻撃");

		int damage;
		// Scanner scanner = new Scanner(System.in);
		int option = Main.scanner.nextInt();

		switch (option) {
			case 1:
				damage = punch(opponent);
				break;
			case 2:
				damage = kick(opponent);
				break;
			case 3:
				damage = rengeki(opponent);
				break;
			default:
				damage = 0;
				break;
		}

		// int random = (int) (Math.random() * 50);
		// if (random < 10) {
		// damage = punch(opponent);
		// } else if (random < 20) {
		// damage = kick(opponent);
		// } else {
		// damage = rengeki(opponent);
		// }

		System.out.println(opponent.getName() + "に" + damage + "ダメージ");
		opponent.setHp(opponent.getHp() - damage);
	}

	public int punch(FightingObject oni) {
		System.out.println(getName() + "のパンチ！");
		int damage = 10;
		return damage;
	}

	public int kick(FightingObject oni) {
		System.out.println(getName() + "のキック！");
		int damage = 15;
		return damage;
	}

	public int rengeki(FightingObject oni) {
		System.out.println(getName() + "の連撃！");
		int damage = 30;
		return damage;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

}
