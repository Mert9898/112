package Hotel;

import java.util.LinkedList;

public class Hotel {
    // Array of LinkedLists to represent the stacks of rooms for each type
    private LinkedList<Room>[] roomStacks;

    // Constructor to initialize the hotel with room stacks
    public Hotel() {
        // Assuming 4 types: 0 - Single, 1 - Double, 2 - Suite, 3 - Deluxe
        roomStacks = new LinkedList[4];
        for (int i = 0; i < roomStacks.length; i++) {
            roomStacks[i] = new LinkedList<>();
        }
        initializeRooms();
    }

    // Method to initialize rooms in each stack
    private void initializeRooms() {
        // Create rooms and push them to the corresponding stack
        int roomNumber = 1;
        for (int type = 0; type < roomStacks.length; type++) {
            for (int i = 0; i < 5; i++) { // 5 rooms of each type
                Room room = new Room(roomNumber++, getTypeName(type));
                roomStacks[type].push(room);
            }
        }
    }

    // Helper method to convert type index to room type name
    private String getTypeName(int typeIndex) {
        switch (typeIndex) {
            case 0: return "Single";
            case 1: return "Double";
            case 2: return "Suite";
            case 3: return "Deluxe";
            default: return "Unknown";
        }
    }

    // Method to display all rooms in each stack
    public void displayRoomStacks() {
        for (int i = 0; i < roomStacks.length; i++) {
            System.out.println(getTypeName(i) + " Rooms Stack:");
            for (Room room : roomStacks[i]) {
                System.out.println(room);
            }
            System.out.println(); // Add a blank line for better readability
        }
    }

    // Main method to run the hotel system
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.displayRoomStacks();
        // Further implementation for reservations and file I/O can be added here
    }
}
