
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class BattleDatabase {
    private static BattleDatabase theInstance;

    private BattleDatabase() {

    }

    public static BattleDatabase getInstance() {
        if (theInstance == null) {
            theInstance = new BattleDatabase();
        }
        return theInstance;
    }

    public static int getEnemyAmountsForStairs(int stairs) {
        return stairs / 3 + 1;
    }
}