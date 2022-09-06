import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        List<Terminal> terminals = Airport.getInstance().getTerminals();
        airport.getTerminals().clear();
        airport.getTerminals().addAll(terminals);

        List<Flight> flights = findPlanesLeavingInTheNextTwoHours(airport);
        System.out.println(stringify(flights));

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        LocalDateTime now = LocalDateTime.now();
        List<Flight> flightList = airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE)
                .filter(flight -> toLocalDate(flight.getDate()).isAfter(now)
                        && toLocalDate(flight.getDate()).isBefore(now.plusHours(2)))
                .collect(Collectors.toList());
        return flightList;
    }

    private static LocalDateTime toLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private static String stringify(List<Flight> flights) {
        return "[" + String.join("\n",
                flights.stream()
                        .map(f -> String.format("<%s %s %s %s>", f.getType(), f.getCode(), f.getDate(), f.getAircraft()))
                        .toArray(String[]::new)) + "]";
    }
}