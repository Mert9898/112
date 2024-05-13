package Room;

import java.lang.String;  // This is usually implicit and not necessary to import explicitly
import java.lang.Override; // This is also typically implicit

public class Room {
    private int roomNumber;
    private String roomType;
    private boolean isAvailable;

    // Constructor to initialize the room properties
    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true;  // Rooms are initially available
    }

    // Getter for room number
    public int getRoomNumber() {
        return roomNumber;
    }

    // Getter for room type
    public String getRoomType() {
        return roomType;
    }

    // Getter for availability
    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter for availability
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // Method to display room information
    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Room Type: " + roomType + ", Available: " + (isAvailable ? "Yes" : "No");
    }
}
