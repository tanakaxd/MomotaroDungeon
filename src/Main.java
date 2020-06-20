// docker run -d -p 8080:8080 plantuml/plantuml-server:tomcat

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static Scanner scanner = new Scanner(System.in);
	public static boolean isDelayed = true;

	public static void main(String[] args) {

		// 初期化処理
		int stairs = 10;
		// 武器生成

		// パーティ生成
		Party p = new Party(new Momotaro());
		// 自キャラ生成
		// Momotaro m = new Momotaro();

		try {
			for (int stair = 1; stair <= stairs; stair++) {

				// floor生成
				// room生成
				// enemy生成
				Floor floor = new Floor(stair);

				floor.iterate(p);
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

	public static void displayChoices(String... lines) {// 可変長引数
		for (int i = 0; i < lines.length; i++) {
			int num = i + 1;
			System.out.println(" " + num + " --> " + lines[i]);
		}
	}

	public static void delayedPrint(String... lines) {

		try {
			Thread.sleep(1100);
			for (int i = 0; i < lines.length; i++) {
				System.out.println(lines[i]);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Timer timer = new Timer(false);
		// TimerTask task = new TimerTask() {

		// @Override
		// public void run() {

		// for (int i = 0; i < lines.length; i++) {
		// System.out.println(lines[i]);
		// }

		// // System.out.flush();
		// }
		// };
		// timer.schedule(task, 500);
	}

}
