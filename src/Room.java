import java.util.Random;

enum RoomType {
    NOTHING, COMBAT, TREASURE, UPSTAIR, BOSS
}

public class Room {

    private RoomType roomType;
    private double assaultRate;
    private int stairs;

    public Room() {
        this.roomType = getRandomRoomType();
        this.assaultRate = 0.1;
    }

    public Room(RoomType roomType) {
        this.roomType = roomType;
        this.assaultRate = 0.1;
    }

    public void event(Party p, int stairs) {
        System.out.println("\n次の部屋へ進みますか？");
        Main.displayChoices("はい");
        Main.scanNextInt(1);
        this.stairs = stairs;
        switch (roomType) {
            case NOTHING:
                initiateRest(p);
                break;
            case TREASURE:
                initiateEquip(p.getMainHero());
                break;
            case COMBAT:
                initiateCombat(p, stairs);
                break;
            case UPSTAIR:
                initiateUpstar();
                break;
            default:
                break;
        }
    }

    private void initiateUpstar() {
        Main.delayedPrint("階段がある。次の階へ進みます");
    }

    public void initiateCombat(Party p, int stairs) {
        Main.delayedPrint("\n!!!! 敵が現れた !!!!");
        Battle b = new Battle(p, stairs);
        b.iterate();
    }

    private void initiateRest(Party p) {
        Main.delayedPrint("\n何もない部屋だ");

        while (true) {
            System.out.println("休憩する？");
            Main.displayChoices("はい", "いいえ");
            int option = Main.scanNextInt(2);
            switch (option) {
                case 0:

                    p.rest();
                    System.out.println(assaultRate);
                    if (Math.random() < assaultRate) {
                        initiateCombat(p, this.stairs);
                    }
                    assaultRate *= 2;
                    break;
                case 1:
                    return;
            }
        }
    }

    private void initiateEquip(Hero m) {
        Main.delayedPrint("\nアイテム発見！");
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

    private RoomType getRandomRoomType() {
        int random = new Random().nextInt(3);
        switch (random) {
            case 0:
                return RoomType.COMBAT;
            case 1:
                return RoomType.TREASURE;
            case 2:
                return RoomType.NOTHING;
            default:
                System.out.println("invalid arguments");
                return null;

        }
    }

}