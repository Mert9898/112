package HotelReservationSystem;

import java.util.ArrayList;
import java.util.List;

public class HotelReservationSystem {
    private RoomManager roomManager = new RoomManager();
    private ReservationManager reservationManager = new ReservationManager();
    private List<Room> bookedRooms = new ArrayList<>();

    public void processReservations(String fileName) {
        reservationManager.loadReservations(fileName);

        for (String roomType : new String[]{"Single", "Double", "Suite", "Deluxe"}) {
            Stack<Room> rooms = roomManager.getRooms(roomType);
            Queue<Reservation> reservations = reservationManager.getReservations(roomType);

            while (!reservations.isEmpty() && !rooms.isEmpty()) {
                Room room = rooms.pop();
                room.setAvailability(false);
                bookedRooms.add(room);
                reservations.poll();
            }
        }
    }

    public void makeOddRoomsAvailable() {
        for (Room room : bookedRooms) {
            if (room.getRoomNumber() % 2 != 0) {
                room.setAvailability(true);
                roomManager.getRooms(room.getRoomType()).push(room);
            }
        }
    }

    public void processWaitingReservations() {
        for (String roomType : new String[]{"Single", "Double", "Suite", "Deluxe"}) {
            Stack<Room> rooms = roomManager.getRooms(roomType);
            Queue<Reservation> reservations = reservationManager.getReservations(roomType);

            while (!reservations.isEmpty() && !rooms.isEmpty()) {
                Room room = rooms.pop();
                room.setAvailability(false);
                bookedRooms.add(room);
                reservations.poll();
            }
        }
    }

    public void printStatus() {
        System.out.println("Final Room Status:");
        for (Room room : bookedRooms) {
            if (!room.isAvailable()) {
                System.out.println("Room " + room.getRoomNumber() + " (" + room.getRoomType() + ") is booked.");
            } else {
                System.out.println("Room " + room.getRoomNumber() + " (" + room.getRoomType() + ") is available.");
            }
        }
    }

    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();
        system.processReservations("reservations.txt");
        system.makeOddRoomsAvailable();
        system.processWaitingReservations();
        system.printStatus();
    }
}
