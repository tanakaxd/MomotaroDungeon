
public class Momotaro extends FightingObject {

	// private float punchCoefficient = 1.1f;
	// private float kickCoefficient = 1.2f;
	// private float rengekiCoefficient = 1.5f;

	public Momotaro() {
		super();
		this.setName("桃太郎");
		this.id = 0;
		this.maxHp = 100;
		this.hp = maxHp;
		this.maxMp = 30;
		this.mp = maxMp;
		this.agi = 10;
		this.att = 15;
		this.def = 10;
		this.mnd = 8;
		this.isDead = false;
		this.isEnemy = false;
		this.isActive = true;
		this.weapon = new Sude();

	}

	@Override
	public void attack(FightingObject opponent) {
		super.attack(opponent);

		System.out.println("スキルを選択してください");
		int option = weapon.skillSelect();

		int damage = weapon.calcDamage(this, opponent, option);

		// 最低1ダメージ
		damage = Math.max(1, damage - opponent.getDef());
		System.out.println(opponent.getName() + "に" + damage + "ダメージ!");
		opponent.setHp(opponent.getHp() - damage);

	}

	// public int punch(FightingObject oni) {
	// System.out.println(getName() + "のパンチ！");
	// int damage = (int) (att * punchCoefficient);
	// return damage;
	// }

	// public int kick(FightingObject oni) {
	// System.out.println(getName() + "のキック！");
	// int damage = (int) (att * kickCoefficient);
	// return damage;
	// }

	// public int rengeki(FightingObject oni) {
	// System.out.println(getName() + "の連撃！");
	// int damage = (int) (att * rengekiCoefficient);
	// return damage;
	// }

}
