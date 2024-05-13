package Reservation;

public class Reservation {
    private int reservationID;
    private String customerName;
    private String roomType;

    public Reservation(int reservationID, String customerName, String roomType) {
        setReservationID(reservationID); // Ensure IDs are set through the setter to include validation
        this.customerName = customerName;
        setRoomType(roomType); // Ensure room types are validated
    }

    public int getReservationID() {
        return reservationID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setReservationID(int reservationID) {
        if (reservationID < 0) throw new IllegalArgumentException("Reservation ID must be non-negative.");
        this.reservationID = reservationID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setRoomType(String roomType) {
        if (!roomType.equals("Single") && !roomType.equals("Double") && !roomType.equals("Suite") && !roomType.equals("Deluxe")) {
            throw new IllegalArgumentException("Invalid room type specified.");
        }
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return String.format("Reservation ID: %d, Customer: %s, Room Type: %s",
                             reservationID, customerName, roomType);
    }
}
