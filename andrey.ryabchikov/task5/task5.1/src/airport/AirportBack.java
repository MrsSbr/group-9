package airport;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AirportBack {

    final List<Flight> flights;
    final List<Integer> numberFlights;

    public AirportBack(boolean isArray) {

        if (isArray) {

            numberFlights = new ArrayList<>();

        } else {

            numberFlights = new LinkedList<>();

        }
        flights = new ArrayList<>();

    }

    @Override
    public String toString() {

        String stringflights = flights.stream().map(flight -> "\nНомер рейса " + flight.numberFlight + " Количество пассажиров " + flight.getSumPeople()).collect(Collectors.joining("", "", ""));

        return "Все рейсы{"
                + stringflights +
                '}';
    }
}

