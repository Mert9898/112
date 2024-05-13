package Room;

public class Room {
    private final int roomNumber;  // Make room number final as it shouldn't change after initial set
    private final String roomType; // Make room type final if it does not change
    private boolean isAvailable;

    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = validateRoomType(roomType);  // Validate room type during initialization
        this.isAvailable = true;  // Rooms are initially available
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    private String validateRoomType(String roomType) {
        switch (roomType) {
            case "Single":
            case "Double":
            case "Suite":
            case "Deluxe":
                return roomType;
            default:
                throw new IllegalArgumentException("Invalid room type specified.");
        }
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + 
               ", Room Type: " + roomType + 
               ", Available: " + (isAvailable ? "Yes" : "No");
    }
}
