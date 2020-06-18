import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// 初期化処理
		int stairs = 3;
		// 自キャラ生成
		Momotaro m = new Momotaro();

		for (int stair = 1; stair <= stairs; stair++) {

			// floor生成
			// room生成
			// enemy生成
			Floor floor = new Floor(stair);

			floor.iterate(m);

		}

		scanner.close();

	}

}
