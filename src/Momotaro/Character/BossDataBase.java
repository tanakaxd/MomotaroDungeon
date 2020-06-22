package Momotaro.Character;

import Momotaro.Dungeon.Floor;

public class BossDataBase {

    public static Boss getBossByStairs() {
        switch (Floor.bossFightsCounts) {
            case 1:
                return new Shura();
            default:
                return new Shura();
        }
    }

}