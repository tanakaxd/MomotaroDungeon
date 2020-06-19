import java.util.List;
import java.util.stream.Collectors;

public class Momotaro extends FightingObject {
	protected Weapon weapon;

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
		this.isEnemy = false;
		this.weapon = new Sude();

	}

	@Override
	public void doAttack(List<FightingObject> targets) {

		System.out.println("\nスキルを選択してください\n");

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

	public void rest() {
		healHp(20);
		healMp(5);
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
}
