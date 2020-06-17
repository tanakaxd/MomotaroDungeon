import java.util.ArrayList;

public class Field {

	public static ArrayList<FightingObject> objectsOnField = new ArrayList<FightingObject>();
	public static ArrayList<FightingObject> friendsOnField = new ArrayList<FightingObject>();
	public static ArrayList<FightingObject> enemyOnField = new ArrayList<FightingObject>();

	public static void addFightingObject(FightingObject o) {
		objectsOnField.add(o);
		if (o.isEnemy) {
			enemyOnField.add(o);
		} else {
			friendsOnField.add(o);
		}
	}

	public static boolean isEnemyWiped() {
		boolean isEnemyWiped = true;
		for (FightingObject o : enemyOnField) {
			isEnemyWiped = isEnemyWiped && o.isDead();
		}
		return isEnemyWiped;
	}

	public static void clearObjects() {
		objectsOnField.clear();
		friendsOnField.clear();
		enemyOnField.clear();
	}
}
