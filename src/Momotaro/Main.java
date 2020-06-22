package Momotaro;

import Momotaro.Character.Kintaro;
import Momotaro.Character.Momotaro;
import Momotaro.Dungeon.Floor;
import Momotaro.Output.Display;
import Momotaro.Party.Party;

public class Main {

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
			e.printStackTrace();
		} finally {
			System.out.println("Main finally block excuted!");
			Display.scanner.close();

		}

	}

}
