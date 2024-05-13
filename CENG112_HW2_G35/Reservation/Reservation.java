package Reservation;

public class Reservation {
    private int reservationID;
    private String customerName;
    private String roomType;

    // Constructor to initialize reservation properties
    public Reservation(int reservationID, String customerName, String roomType) {
        this.reservationID = reservationID;
        this.customerName = customerName;
        this.roomType = roomType;
    }

    // Getter for reservation ID
    public int getReservationID() {
        return reservationID;
    }

    // Getter for customer name
    public String getCustomerName() {
        return customerName;
    }

    // Getter for room type
    public String getRoomType() {
        return roomType;
    }

    // Setter for reservation ID
    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    // Setter for customer name
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Setter for room type
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    // Method to display reservation information
    @Override
    public String toString() {
        return "Reservation ID: " + reservationID +
               ", Customer: " + customerName +
               ", Room Type: " + roomType;
    }
}
