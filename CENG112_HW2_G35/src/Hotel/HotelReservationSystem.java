package Hotel;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class HotelReservationSystem {
    private RoomManager roomManager = new RoomManager();
    private ManageReservations reservationManager = new ManageReservations();
    private List<Room> bookedRooms = new ArrayList<>();
    private List<Room> availableRooms = new ArrayList<>();

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

            while (!rooms.isEmpty()) {
                availableRooms.add(rooms.pop());
            }
        }
    }

    public void makeOddRoomsAvailable() {
        List<Room> tempBookedRooms = new ArrayList<>(bookedRooms);
        for (Room room : tempBookedRooms) {
            if (room.getRoomNumber() % 2 != 0) {
                room.setAvailability(true);
                roomManager.getRooms(room.getRoomType()).push(room);
                bookedRooms.remove(room);
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
        System.out.println("*********************************************** Unavailable Rooms");
        for (Room room : bookedRooms) {
            System.out.println("Room " + room.getRoomNumber() + " (" + room.getRoomType() + ")");
        }

        System.out.println("*********************************************** Available Rooms");
        for (Room room : availableRooms) {
            System.out.println("Room " + room.getRoomNumber() + " (" + room.getRoomType() + ")");
        }

        // Additionally print rooms that became available after making odd rooms available
        for (String roomType : new String[]{"Single", "Double", "Suite", "Deluxe"}) {
            Stack<Room> rooms = roomManager.getRooms(roomType);
            for (Room room : rooms) {
                if (room.isAvailable()) {
                    System.out.println("Room " + room.getRoomNumber() + " (" + room.getRoomType() + ")");
                }
            }
        }
    }

    public void printPiles() {
        System.out.println("Single Pile of Rooms: " + printStack(roomManager.getRooms("Single")));
        System.out.println("Double Pile of Rooms: " + printStack(roomManager.getRooms("Double")));
        System.out.println("Suite Pile of Rooms: " + printStack(roomManager.getRooms("Suite")));
        System.out.println("Deluxe Pile of Rooms: " + printStack(roomManager.getRooms("Deluxe")));
    }

    private String printStack(Stack<Room> stack) {
        StringBuilder sb = new StringBuilder();
        for (Room room : stack) {
            sb.append("Room ").append(room.getRoomNumber()).append(" (").append(room.getRoomType()).append(") -> ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 4); // Remove the last " -> "
        }
        return sb.toString();
    }

    public void printWaitingLines() {
        System.out.println("Single Waiting Line of Reservations: " + printQueue(reservationManager.getReservations("Single")));
        System.out.println("Double Waiting Line of Reservations: " + printQueue(reservationManager.getReservations("Double")));
        System.out.println("Suite Waiting Line of Reservations: " + printQueue(reservationManager.getReservations("Suite")));
        System.out.println("Deluxe Waiting Line of Reservations: " + printQueue(reservationManager.getReservations("Deluxe")));
    }

    private String printQueue(Queue<Reservation> queue) {
        StringBuilder sb = new StringBuilder();
        for (Reservation res : queue) {
            sb.append(res.getReservationID()).append(",").append(res.getCustomerName()).append(",").append(res.getRoomType()).append(" -> ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 4); // Remove the last " -> "
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();

        // Print initial room piles
        System.out.println("Initial Room Piles:");
        system.printPiles();

        // Process reservations from the file
        system.processReservations("src/Hotel/reservations.txt");

        // Print waiting lines after reading reservations
        System.out.println("Waiting Lines After Reading Reservations:");
        system.printWaitingLines();

        // Make odd-numbered rooms available
        system.makeOddRoomsAvailable();

        // Print room piles and waiting lines after making odd rooms available
        System.out.println("Room Piles After Making Odd Rooms Available:");
        system.printPiles();
        System.out.println("Waiting Lines After Making Odd Rooms Available:");
        system.printWaitingLines();

        // Process waiting reservations
        system.processWaitingReservations();

        // Print final room piles and waiting lines
        System.out.println("Final Room Piles After Processing Waiting Lines:");
        system.printPiles();
        System.out.println("Final Waiting Lines After Processing Waiting Lines:");
        system.printWaitingLines();

        // Print final status of rooms
        system.printStatus();
    }
}
