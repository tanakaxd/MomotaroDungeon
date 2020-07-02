package Momotaro.Battle;

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
        return stairs / 5 + 1;
    }
}