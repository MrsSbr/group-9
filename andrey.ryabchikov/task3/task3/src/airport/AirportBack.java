package airport;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public int getSumPassangers() {

        int sum = 0;

        for (int i = 0; i < flights.size(); i++) {

            sum += flights.get(i).getSumPeople();

        }

        return sum;

    }

    @Override
    public String toString() {

        StringBuilder stringflights = new StringBuilder("");

        for (int i = 0; i < flights.size(); i++) {

            stringflights.append("\nНомер рейса ");
            stringflights.append(flights.get(i).numberFlight);
            stringflights.append(" Количество пассажиров ");
            stringflights.append(flights.get(i).getSumPeople());

        }

        return "Все рейсы{"
                + stringflights +
                '}';
    }
}

