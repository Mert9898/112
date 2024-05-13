package Main;

import hotel.Hotel;
import hotel.Reservation;
import utils.FileIO;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing the Hotel Reservation System...\n");

        // Initialize the hotel
        Hotel hotel = new Hotel();
        System.out.println("Initial room stacks:");
        hotel.displayRoomStacks();  // Display initial state of room stacks

        // Load reservations
        Queue<Reservation> reservations = FileIO.readReservations();
        System.out.println("Loaded reservations:");
        for (Reservation res : reservations) {
            System.out.println(res);
        }

        // Process reservations
        processReservations(hotel, reservations);

        // Update and display the final state of the hotel
        System.out.println("\nFinal room stacks after processing reservations:");
        hotel.displayRoomStacks();

        // Optionally, display lists of available and unavailable rooms
        hotel.displayRoomAvailability();
    }

    // Method to process reservations
    private static void processReservations(Hotel hotel, Queue<Reservation> reservations) {
        while (!reservations.isEmpty()) {
            Reservation reservation = reservations.poll();
            if (!hotel.assignRoomToReservation(reservation)) {
                hotel.addToWaitingList(reservation);  // Add to waiting list if room is not available
            }
        }

        // Process any waiting list items that can now be assigned
        hotel.processWaitingList();
    }
}
