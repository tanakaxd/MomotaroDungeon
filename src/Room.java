import java.util.Random;

public class Room {

    private int roomType;

    public Room() {
        this.roomType = new Random().nextInt(3);
    }

    public void event(FightingObject m) {
        switch (roomType) {
            case 0:
                System.out.println("何もなかった・・・");
                break;
            case 1:
                System.out.println("アイテム発見");
                break;
            case 2:
                System.out.println("敵が現れた");
                InitiateCombat(m);
                break;
            default:
                break;
        }
    }

    public void InitiateCombat(FightingObject m) {
        Battle b = new Battle(m);
        b.interate();
    }

}