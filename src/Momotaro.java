import java.util.List;
import java.util.stream.Collectors;

public class Momotaro extends Hero {

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

		// 選択処理。モンスターは持たない
		System.out.println("\nスキルを選択してください\n");

		// スキルを使用可能かどうか判定

		// ダメージ計算
		weapon.calcDamage(this, targets);

		// あれば事後処理

	}

}
