package Hotel;

import java.util.Stack;

public class RoomManager {
    private Stack<Room> singleRooms = new Stack<>();
    private Stack<Room> doubleRooms = new Stack<>();
    private Stack<Room> suiteRooms = new Stack<>();
    private Stack<Room> deluxeRooms = new Stack<>();

    public RoomManager() {
        for (int i = 1; i <= 20; i++) {
            if (i <= 5) singleRooms.push(new Room(i, "Single"));
            else if (i <= 10) doubleRooms.push(new Room(i, "Double"));
            else if (i <= 15) suiteRooms.push(new Room(i, "Suite"));
            else deluxeRooms.push(new Room(i, "Deluxe"));
        }
    }

    public Stack<Room> getRooms(String roomType) {
        switch (roomType) {
            case "Single": return singleRooms;
            case "Double": return doubleRooms;
            case "Suite": return suiteRooms;
            case "Deluxe": return deluxeRooms;
            default: return null;
        }
    }
}
