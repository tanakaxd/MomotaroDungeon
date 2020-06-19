import java.util.Random;

public class Room {

    private int roomType;
    private double assaultRate;
    private int stairs;

    public Room() {
        this.roomType = new Random().nextInt(3);
        assaultRate = 0.1;
    }

    public void event(Momotaro m, int stairs) {
        this.stairs = stairs;
        switch (roomType) {
            case 0:
                initiateRest(m);
                break;
            case 1:
                initiateEquip(m);
                break;
            case 2:
                initiateCombat(m, stairs);
                break;
            default:
                break;
        }
    }

    public void initiateCombat(Momotaro m, int stairs) {
        System.out.println("\n敵が現れた");
        Battle b = new Battle(m, stairs);
        b.iterate();
    }

    private void initiateRest(Momotaro m) {
        System.out.println("\n何もない部屋だ");

        while (true) {
            System.out.println("休憩する？");
            Main.displayChoices("はい", "いいえ");
            int option = Main.scanNextInt(2);
            switch (option) {
                case 0:

                    m.rest();
                    System.out.println(assaultRate);
                    if (Math.random() < assaultRate) {
                        initiateCombat(m, this.stairs);
                    }
                    assaultRate *= 2;
                    break;
                case 1:
                    return;
            }
        }
    }

    private void initiateEquip(Momotaro m) {
        System.out.println("\nアイテム発見！");
        Weapon weapon = WeaponManager.getWeapon();
        System.out.println(weapon);
        System.out.println("装備する？");
        Main.displayChoices("はい", "いいえ");
        int option = Main.scanNextInt(2);
        switch (option) {
            case 0:
                m.setWeapon(weapon);
                break;
            case 1:
                return;
        }
    }

}