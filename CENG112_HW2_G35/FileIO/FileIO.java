package FileIO;

package utils;

import hotel.Reservation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import hotel.Hotel;


public class FileIO {
    private static final String RESERVATION_FILE = "reservations.txt"; // Path to the reservations file

    // Method to read reservations from the file
    public static Queue<Reservation> readReservations() {
        Queue<Reservation> reservations = new LinkedList<>(); // Using LinkedList as a Queue
        try (BufferedReader reader = new BufferedReader(new FileReader(RESERVATION_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Assuming CSV format: reservationID,customerName,roomType
                if (parts.length == 3) {
                    try {
                        int reservationID = Integer.parseInt(parts[0].trim());
                        String customerName = parts[1].trim();
                        String roomType = parts[2].trim();
                        reservations.add(new Reservation(reservationID, customerName, roomType));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid format for reservation ID in line: " + line);
                    }
                } else {
                    System.out.println("Skipping invalid reservation line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read the reservations file: " + e.getMessage());
        }
        return reservations;
    }

}

