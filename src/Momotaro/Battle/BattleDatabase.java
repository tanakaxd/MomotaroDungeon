package Momotaro.Battle;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;
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
        return stairs / 5 + 1;
    }
}