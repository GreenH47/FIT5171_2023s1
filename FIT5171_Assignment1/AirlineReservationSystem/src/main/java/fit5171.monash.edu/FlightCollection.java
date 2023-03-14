package fit5171.monash.edu;

import java.util.ArrayList;

public class FlightCollection {
	
	public static ArrayList<Flight> flights;

	public static ArrayList<Flight> getFlights() {
		return flights;
	}

	public static void addFlights(ArrayList<Flight> flights) {
		FlightCollection.flights.addAll(flights);
	}
	
	public static Flight getFlightInfo(String city1, String city2) {
    	//display the flights where there is a direct flight from city 1 to city2
    	return null;
    }
    
    public static Flight getFlightInfo(String city) {
    	//SELECT a flight where depart_to = city
    	return null;

    }
    public static Flight getFlightInfo(int flight_id) {
    	//SELECT a flight with a particular flight id
    	return null;

    }
    

}
