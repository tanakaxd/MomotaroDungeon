import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// 初期化処理
		int stairs = 10;
		// 武器生成

		// 自キャラ生成
		Momotaro m = new Momotaro();
		try {
			for (int stair = 1; stair <= stairs; stair++) {

				// floor生成
				// room生成
				// enemy生成
				Floor floor = new Floor(stair);

				floor.iterate(m);
				// System.exit(0);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("finally block excuted!");
			scanner.close();

		}

	}

	// 引数は選択肢の数。範囲外の場合もう一度入力を求める
	public static int scanNextInt(int amounts) {
		int option;
		boolean ok = false;
		do {
			option = scanner.nextInt();
			if (option >= 1 && option <= amounts)
				ok = true;
		} while (!ok);
		return option - 1;
	}

	public static void displayChoices(String... lines) {
		for (int i = 0; i < lines.length; i++) {
			int num = i + 1;
			System.out.println(" " + num + " --> " + lines[i]);
		}
	}

}
