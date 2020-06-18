import java.util.List;
import java.util.stream.Collectors;

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
		this.weapon = new Sword();

	}

	@Override
	public void doAttack(List<FightingObject> targets) {

		System.out.println("スキルを選択してください");

		weapon.calcDamage(this, targets);

	}

	public void initForCombat() {

		// ultimateの回復
		List<Skill> s = weapon.skills.stream().filter(x -> x instanceof UltimateSkill).collect(Collectors.toList());
		for (Skill skill : s) {
			((UltimateSkill) skill).refill();
		}
	}

	public void terminateForCombat() {
		// 戦闘が終わった時の処理
		// バフの状態を元に戻す等
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
