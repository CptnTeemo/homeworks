import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.*;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    RouteCalculator calculate;
    List<Station> connectionAB;
    List<Station> connectionBC;
    StationIndex stationIndex;

    Line line1;
    Line line2;
    Line line3;

    Station a1;
    Station a2;
    Station b1;
    Station b2;
    Station c1;
    Station c2;
    Station c3;

    @Override
    protected void setUp() throws Exception {

        stationIndex = new StationIndex();
        route = new ArrayList<>();
        calculate = new RouteCalculator(stationIndex);
        connectionAB = new ArrayList<>();
        connectionBC = new ArrayList<>();
        line1 = new Line(1, "A");
        line2 = new Line(2, "B");
        line3 = new Line(3, "C");
        a1 = new Station("A1", line1);
        a2 = new Station("A2", line1);
        b1 = new Station("B1", line2);
        b2 = new Station("B2", line2);
        c1 = new Station("C1", line3);
        c2 = new Station("C2", line3);
        c3 = new Station("C3", line3);

        line1.addStation(a1);
        line1.addStation(a2);
        line2.addStation(b1);
        line2.addStation(b2);
        line3.addStation(c1);
        line3.addStation(c2);
        line3.addStation(c3);

        connectionAB.add(a2);
        connectionAB.add(b1);
        connectionBC.add(b2);
        connectionBC.add(c2);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.addStation(a1);
        stationIndex.addStation(a2);
        stationIndex.addStation(b1);
        stationIndex.addStation(b2);
        stationIndex.addStation(c1);
        stationIndex.addStation(c2);
        stationIndex.addStation(c3);
        stationIndex.addConnection(connectionAB);
        stationIndex.addConnection(connectionBC);

        route.add(a1);
        route.add(a2);
        route.add(b1);
        route.add(b2);
        route.add(c1);
        route.add(c2);
        route.add(c3);


    }

    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 17;
        assertEquals(expected, actual);
    }

//    public void testGetShortestRoute(){
//        List<Station> route = new ArrayList<>();
//        List<Station> stations = this.route;
//        int direction = 0;
//        for (Station station : stations) {
//            if (direction == 0) {
//                if (station.equals(from)) {
//                    direction = 1;
//                } else if (station.equals(to)) {
//                    direction = -1;
//                }
//            }
//
//            if (direction != 0) {
//                route.add(station);
//            }
//
//            if ((direction == 1 && station.equals(to)) ||
//                    (direction == -1 && station.equals(from))) {
//                break;
//            }
//        }
//        if (direction == -1) {
//            Collections.reverse(route);
//        }
////        return route;
//    }

    public void testGetRouteOnTheLine(){
        List<Station> oneLineRoute = new ArrayList<>();
//        calculate = new RouteCalculator(stationIndex);

        oneLineRoute.add(c1);
        oneLineRoute.add(c2);
        oneLineRoute.add(c3);

        List<Station> actual = calculate.getShortestRoute(c1, c3);
        assertEquals(oneLineRoute, actual);
    }

    public void testGetRouteWithOneConnection(){
        List<Station> wayWithOneConnection = new ArrayList<>();
        wayWithOneConnection.add(a1);
        wayWithOneConnection.add(a2);
        wayWithOneConnection.add(b1);
        wayWithOneConnection.add(b2);

        List<Station> actual = calculate.getShortestRoute(a1, b2);
        assertEquals(wayWithOneConnection, actual);
    }

    public void testGetRouteWithTwoConnection(){
        List<Station> wayWithTwoConnection = new ArrayList<>();
        wayWithTwoConnection.add(a1);
        wayWithTwoConnection.add(a2);
        wayWithTwoConnection.add(b1);
        wayWithTwoConnection.add(b2);
        wayWithTwoConnection.add(c2);
        wayWithTwoConnection.add(c3);

        List<Station> actual = calculate.getShortestRoute(a1, c3);
        assertEquals(wayWithTwoConnection, actual);
    }

    @Override
    protected void tearDown() throws Exception {

    }
}
