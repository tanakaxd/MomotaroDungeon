package Momotaro.Character;

import java.util.Random;

public final class MonsterDatabase {
    private static MonsterDatabase theInstance;

    private MonsterDatabase() {

    }

    public static MonsterDatabase getInstance() {
        if (theInstance == null) {
            theInstance = new MonsterDatabase();
        }
        return theInstance;
    }

    public Monster getRandomMonster() {

        int random = new Random().nextInt(5);
        switch (random) {
            case 0:
                return new Oni();
            case 1:
                return new Tengu();
            case 2:
                return new Ochimusha();
            case 3:
                return new Nue();
            case 4:
                return new Kappa();

            default:
                return null;
        }
    }
}