package fit5171.monash.edu;

import java.util.ArrayList;

/*
* 1. When adding a flight into the system, test if
* it conforms with the requirement as a flight and Flight Collection.
*
2. Valid city names must be used.
*
3. When trying to get flight information, a valid flight is returned
* */
public class FlightCollection {

	//public static ArrayList<Flight> flights = Flight.flights;
	public static ArrayList<Flight> flights  = new ArrayList<>();

	public static ArrayList<Flight> getFlights() {
		return flights;
	}
	public static void validateFlightList(ArrayList<Flight> newFlights, ArrayList<Flight> existingFlights) {
		if (newFlights == null || newFlights.isEmpty())
			throw new IllegalArgumentException("Flight list cannot be empty");
		ArrayList<Integer> newFlightIDs = new ArrayList<Integer>();
		for (Flight newFlight :
				newFlights
		) {
			if (newFlight == null)
				throw new IllegalArgumentException("Flight list cannot contain null");
			else {
				if (newFlightIDs.contains(newFlight.getFlightID()))
					throw new IllegalArgumentException("Flight with ID:" + newFlight.getFlightID() + " already exists");
				newFlightIDs.add(newFlight.getFlightID());

				if(existingFlights != null){
					for (Flight existingFlight : existingFlights
					) {
						if (newFlight.getFlightID() == existingFlight.getFlightID())
							throw new IllegalArgumentException("Flight with ID:" + newFlight.getFlightID() + " already exists");
					}
				}

			}
		}
	}

	public static void addFlights(ArrayList<Flight> flights_db) {

//		if (flights == null || flights.contains(null)) {
//			throw new IllegalArgumentException("Flight collection cannot be null or contain null value");
//		}

		//	Appends all the elements in the specified collection to the end of this list,
		//	in the order that they are returned by the specified collection's Iterator.
		//FlightCollection.flights.addAll(flights);

//		for (Flight flight : flights) {
//			Flight.addFlight(flight);
//		}
		validateFlightList(flights_db,flights);
		FlightCollection.flights.addAll(flights_db);
	}

	public static void validateCity(String cityName) {
		try {
			if (cityName == null || !cityName.matches("^[a-zA-Z\\s]+$"))
				throw new IllegalArgumentException("Invalid city name:City name can only contain letter and space");
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("City cannot be empty");
		}
	}

	public static Flight getFlightInfo(String city1, String city2) {
		validateCity(city1);
		validateCity(city2);
		//display the flights where there is a direct flight from city 1 to city2
		for (Flight flight : flights) {
			if(flight.getDepartFrom().equalsIgnoreCase(city1) && flight.getDepartTo().equalsIgnoreCase(city2)){
				return flight;
			}
		}
		return null;
		//throw new IllegalArgumentException("Invalid city name");
	}

	public static Flight getFlightInfo(String city) {
		validateCity(city);
		//SELECT a flight where depart_to = city
		for (Flight flight : flights) {
			if(flight.getDepartTo().equalsIgnoreCase(city)){
				return flight;
			}
		}
		return null;

		//throw new IllegalArgumentException("Invalid city name");
	}
	public static Flight getFlightInfo(int flight_id) {
		//SELECT a flight with a particular flight id

		for (Flight flight : flights) {
			if(flight.getFlightID() == flight_id){
				return flight;
			}
		}
		return null;

		//throw new IllegalArgumentException("Invalid flight ID");

	}

}
