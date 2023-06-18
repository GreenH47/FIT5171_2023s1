package FIT5171.Team8;

import java.util.ArrayList;

public class AirplaneCollection {

    public static ArrayList<Airplane> airplanes = new ArrayList<Airplane>();

    private AirplaneCollection(){}

    public static void addAirplane(Airplane airplane){
        for(Airplane temp: airplanes){
            if(airplane.getAirplaneID() == temp.getAirplaneID()){
                throw new RuntimeException(airplane.getAirplaneID() + " is already existing.");
            }
        }
        airplanes.add(airplane);
    }

    public static Airplane getAirPlaneInfo(int airplane_id) {

        for(Airplane airplane: airplanes){
            if(airplane_id == airplane.getAirplaneID()){
                return airplane;
            }
        }
        throw new RuntimeException("No such airplane exists.");
    }
}
