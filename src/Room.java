import java.util.Random;

public class Room {

    private int roomType;

    public Room() {
        this.roomType = new Random().nextInt(3);
    }

    public void event(Momotaro m, int stairs) {
        switch (roomType) {
            case 0:
                System.out.println("\n");
                System.out.println("何もなかった・・・");
                System.out.println("休憩する？");
                // 休憩する？
                break;
            case 1:
                System.out.println("\n");
                System.out.println("アイテム発見：刀を装備した");
                // 装備する？
                m.setWeapon(new Sword());
                break;
            case 2:
                System.out.println("\n");
                System.out.println("敵が現れた");
                InitiateCombat(m, stairs);
                break;
            default:
                break;
        }
    }

    public void InitiateCombat(Momotaro m, int stairs) {
        Battle b = new Battle(m, stairs);
        b.iterate();
    }

}