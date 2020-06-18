import java.util.Random;

public class Room {

    private int roomType;

    public Room() {
        this.roomType = new Random().nextInt(3);
    }

    public void event(FightingObject m, int stairs) {
        switch (roomType) {
            case 0:
                System.out.println("何もなかった・・・");
                // 休憩する？
                break;
            case 1:
                System.out.println("アイテム発見");
                // 装備する？
                m.setWeapon(new Sword());
                break;
            case 2:
                System.out.println("敵が現れた");
                InitiateCombat(m, stairs);
                break;
            default:
                break;
        }
    }

    public void InitiateCombat(FightingObject m, int stairs) {
        Battle b = new Battle(m, stairs);
        b.iterate();
    }

}