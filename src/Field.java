import java.util.ArrayList;

public class Field {

	public static ArrayList<FightingObject> objectsOnField = new ArrayList<FightingObject>();

	public static void addFightingObject(FightingObject o) {
		objectsOnField.add(o);
		System.out.println(objectsOnField);
	}

	public static boolean isEnemyWiped() {
		boolean isEnemyWiped = true;
		for (FightingObject o : objectsOnField) {
			if (o.isEnemy())
				isEnemyWiped = isEnemyWiped && o.isDead();

		}
		return isEnemyWiped;
	}
}
