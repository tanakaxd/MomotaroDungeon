import java.util.ArrayList;
import java.util.List;

public class Floor {

    private List<Room> rooms = new ArrayList<>();
    private int stairs;

    public Floor(int num) {
        Display.delayedPrint("\n-------\n");
        Display.delayedPrint(num + "階へ突入");
        stairs = num;
        for (int i = 0; i < num; i++) {
            rooms.add(new Room());
        }
        rooms.add(new Room(RoomType.UPSTAIR));
    }

    public void iterate(Party p) {
        for (Room room : rooms) {
            room.event(p, stairs);
        }
    }
}