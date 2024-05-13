package Hotel;

import java.util.LinkedList;

public class Hotel {
    // Array of LinkedLists to represent the stacks of rooms for each type, using generics
    private LinkedList<Room>[] roomStacks;

    public Hotel() {
        roomStacks = new LinkedList[4]; // Assuming 4 types: Single, Double, Suite, Deluxe
        for (int i = 0; i < roomStacks.length; i++) {
            roomStacks[i] = new LinkedList<>();
        }
        initializeRooms();
    }

    private void initializeRooms() {
        int roomNumber = 1;
        for (int type = 0; type < roomStacks.length; type++) {
            for (int i = 0; i < 5; i++) {
                roomStacks[type].push(new Room(roomNumber++, getTypeName(type)));
            }
        }
    }

    private String getTypeName(int typeIndex) {
        switch (typeIndex) {
            case 0: return "Single";
            case 1: return "Double";
            case 2: return "Suite";
            case 3: return "Deluxe";
            default: return "Unknown";
        }
    }

    public void displayRoomStacks() {
        for (int i = 0; i < roomStacks.length; i++) {
            System.out.println(getTypeName(i) + " Rooms Stack:");
            if (roomStacks[i].isEmpty()) {
                System.out.println("No rooms available.");
            } else {
                for (Room room : roomStacks[i]) {
                    System.out.println(room);
                }
            }
            System.out.println(); // Improve readability
        }
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.displayRoomStacks();
        // Implementation for reservations and file I/O to be added
    }
}
