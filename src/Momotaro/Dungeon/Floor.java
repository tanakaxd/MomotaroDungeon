package Momotaro.Dungeon;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;
import java.util.ArrayList;
import java.util.List;

public class Floor {

    private List<Room> rooms = new ArrayList<>();
    private int stairs;
    public static int bossFightsCounts = 0;

    public Floor(int num) {
        Display.delayedPrint("\n-------\n");
        Display.delayedPrint(num + "階へ突入した");
        stairs = num;
        for (int i = 0; i < num; i++) {
            rooms.add(new Room());
        }
        if (num % 5 == 0) {
            bossFightsCounts++;
            rooms.add(new Room(RoomType.BOSS));
            rooms.add(new Room(RoomType.ADDFRIEND));
        }
        rooms.add(new Room(RoomType.UPSTAIR));
    }

    public void iterate(Party p) {
        for (Room room : rooms) {
            room.event(p, stairs);
        }
    }
}