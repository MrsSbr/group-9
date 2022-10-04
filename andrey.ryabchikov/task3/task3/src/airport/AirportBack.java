package airport;

import java.util.ArrayList;
import java.util.List;

public class AirportBack {

    final List<Flight> flights;

    public AirportBack() {

        flights = new ArrayList<Flight>();

    }

    public boolean conteinFlightNumber(int numberFlight) {

        boolean haveNumber = false;
        int i = 0;

        while (i < flights.size() && !haveNumber) {

            if (flights.get(i).numberFlight == numberFlight) {
                haveNumber = true;
            }
            i++;

        }

        return haveNumber;

    }


    @Override
    public String toString() {

        String stringflights = "";

        for (int i = 0; i < flights.size(); i++) {

            stringflights += "\nНомер рейса " + flights.get(i).numberFlight + " Количество пассажиров " +
                    flights.get(i).getSumPeople();

        }

        return "Все рейсы{"
                + stringflights +
                '}';
    }
}

