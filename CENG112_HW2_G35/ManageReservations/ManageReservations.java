package ManageReservations;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class ManageReservations {
    private Queue<Reservation> singleReservations = new LinkedList<>();
    private Queue<Reservation> doubleReservations = new LinkedList<>();
    private Queue<Reservation> suiteReservations = new LinkedList<>();
    private Queue<Reservation> deluxeReservations = new LinkedList<>();

    public void loadReservations(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                Reservation res = new Reservation(details[0], details[1], details[2]);
                switch (res.getRoomType()) {
                    case "Single": singleReservations.add(res); break;
                    case "Double": doubleReservations.add(res); break;
                    case "Suite": suiteReservations.add(res); break;
                    case "Deluxe": deluxeReservations.add(res); break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Queue<Reservation> getReservations(String roomType) {
        switch (roomType) {
            case "Single": return singleReservations;
            case "Double": return doubleReservations;
            case "Suite": return suiteReservations;
            case "Deluxe": return deluxeReservations;
            default: return null;
        }
    }
}

