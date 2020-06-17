import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// 初期化処理
		// 自キャラ生成

		// floor生成

		// room生成

		// enemy生成

		FightingObject m = new Momotaro();
		FightingObject o = new Oni("赤鬼");

		int count = 1;
		while (true) {
			System.out.println("ターン：" + count);

			m.attack(o);
			o.attack(m);
			if (m.getHp() <= 0 || Field.isEnemyWiped()) {
				break;
			}
			System.out.println("\n");

			count++;
			if (count > 100) {
				break;
			}
		}

		scanner.close();

	}

}
