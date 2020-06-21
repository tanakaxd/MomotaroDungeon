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
        Display.displayChoices("はい");
        Display.scanNextInt(1);
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
        Display.delayedPrint("階段がある。次の階へ進みます");
    }

    public void initiateCombat(Party p, int stairs) {
        Display.delayedPrint("\n!!!! 敵が現れた !!!!");
        Battle b = new Battle(p, stairs);
        try {
            b.iterate();

        } catch (Exception e) {
            // 例外を一回中継する。キャッチして記録を表示した後、もう一度例外を発生させてMainまで伝播させる
            System.out.println("あなたの最終到達階層: " + this.stairs);
            e.printStackTrace();
            throw new MomotaroDeadException(null);
        } finally {
            System.out.println("Room finally block excuted!");
            Display.scanner.close();
        }
    }

    private void initiateRest(Party p) {
        Display.delayedPrint("\n何もない部屋だ");

        int count = 1;

        while (true) {
            if (count >= 2) {
                System.out.println("同じ部屋にとどまり続けると敵をおびき寄せるかもしれない…");
            }
            System.out.println("休憩する？");
            Display.displayChoices("はい", "いいえ");
            int option = Display.scanNextInt(2);
            switch (option) {
                case 0:

                    p.rest();
                    System.out.println(assaultRate);
                    if (Math.random() < assaultRate) {
                        initiateCombat(p, this.stairs);
                    }
                    assaultRate *= 2;
                    count++;
                    break;
                case 1:
                    return;
            }
        }
    }

    private void initiateEquip(Hero m) {
        Display.delayedPrint("\nアイテム発見！");
        Weapon weapon = WeaponManager.getWeapon();
        Display.delayedPrint(weapon.toDetailString());
        System.out.println("装備する？");
        Display.displayChoices("はい", "いいえ");
        int option = Display.scanNextInt(2);
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