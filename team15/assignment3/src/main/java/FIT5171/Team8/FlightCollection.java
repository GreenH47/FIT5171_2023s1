package FIT5171.Team8;

import java.util.ArrayList;

public class FlightCollection {
	
	public static ArrayList<Flight> flights = new ArrayList<Flight>();

	public static ArrayList<Flight> getFlights() {
		return flights;
	}

	private static final String ERROR_MESSAGE = "No such flight exists.";

	private FlightCollection() {}

	public static void addFlight(Flight flight){
		for(Flight existFlight: getFlights())
			if(flight.getFlightID() == existFlight.getFlightID())
				throw new RuntimeException(flight.getFlightID() + " is already existing.");
		if(verifyCityName(flight.getDepartFrom()) && verifyCityName(flight.getDepartTo()))
			flights.add(flight);
		else throw new RuntimeException("The city name is invalid.");
	}

	public static void addFlights(ArrayList<Flight> flights) {
		for(Flight flight: flights){
			addFlight(flight);
		}
		//FlightCollection.flights.addAll(flights);
	}
	
	public static Flight getFlightInfo(String city1, String city2) {
    	//display the flights where there is a direct flight from city 1 to city2
		for(Flight flight: flights){
			if(flight.getDepartFrom().equals(city1) && flight.getDepartTo().equals(city2))
				return flight;
		}
    	throw new RuntimeException(ERROR_MESSAGE);
    }
    
    public static Flight getFlightInfo(String city) {
    	//SELECT a flight where depart_to = city
		for(Flight flight: flights){
			if(flight.getDepartTo().equals(city))
				return flight;
		}
		throw new RuntimeException(ERROR_MESSAGE);
    }

    public static Flight getFlightInfo(int flight_id) {
    	//SELECT a flight with a particular flight id
		for(Flight flight: flights){
			if(flight_id == flight.getFlightID()){
				return flight;
			}
		}
		throw new RuntimeException(ERROR_MESSAGE);
    }

	public static Boolean verifyCityName(String name){
		name = name.trim();
		for(int i = 0; i < name.length(); i++)
			if(name.charAt(i) < 'A' || name.charAt(i) > 'z')
				return false;
		return true;
	}
}
