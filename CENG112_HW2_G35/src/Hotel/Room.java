package Hotel;

public class Room {
    private int roomNumber;
    private String roomType;
    private boolean availability;

    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.availability = true;
    }

    // Getters and Setters
    public int getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public boolean isAvailable() { return availability; }
    public void setAvailability(boolean availability) { this.availability = availability; }
}
