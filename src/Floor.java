import java.util.ArrayList;
import java.util.List;

public class Floor {

    private List<Room> rooms = new ArrayList<>();

    public Floor(int num) {
    	System.out.println("\n-------\n");
        System.out.println(num + "階へ突入");
        for (int i = 0; i < num; i++) {
            rooms.add(new Room());
        }
    }

    public void iterate(FightingObject m) {
        for (Room room : rooms) {
            room.event(m);
        }
    }
}