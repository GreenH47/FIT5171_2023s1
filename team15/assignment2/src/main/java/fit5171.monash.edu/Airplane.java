package fit5171.monash.edu;

import java.util.ArrayList;
import java.util.List;

/*
* When some attribute of the airplane is being set, the following unit testing conditions need to be satisfied.
1. Ensure all fields/details for an airplane like Airplane ID,
* Airplane businessSitsNumber, crewSitsNumber, etc. are tested
*
2. Seat number must be in the range [1, 300].
* */
public class Airplane
{
    private int airplaneID;
    private String airplaneModel;
    private int businessSitsNumber;
    private int economySitsNumber;
    private int crewSitsNumber;
    //private static final int ALL_SEAT_NUMBER = 300;
    public static final List<Airplane> airplanes = new ArrayList<>();
    //public static ArrayList<Airplane> airplanes;

//    public Airplane(int airplaneID, String airplaneModel, int businessSitsNumber, int economySitsNumber, int crewSitsNumber) throws SeatLimitExceededException {
////        if(businessSitsNumber + economySitsNumber + crewSitsNumber > 300) {
////            throw new SeatLimitExceededException("The number of seats exceeded the limit");
////        }else {
////            this.airplaneID=airplaneID;
////            this.airplaneModel = airplaneModel;
////            this.businessSitsNumber = businessSitsNumber;
////            this.economySitsNumber = economySitsNumber;
////            this.crewSitsNumber = crewSitsNumber;
////            airplanes.add(this);
////        }
//        setAirplaneID(airplaneID);
//        setAirplaneModel(airplaneModel);
//        setBusinessSitsNumber(businessSitsNumber);
//        setEconomySitsNumber(economySitsNumber);
//        setCrewSitsNumber(crewSitsNumber);
//    }
    public Airplane(int airplaneID, String airplaneModel, int businessSitsNumber, int economySitsNumber, int crewSitsNumber)
    {

        this.setAirplaneID(airplaneID);
        this.setAirplaneModel(airplaneModel);
        this.setBusinessSitsNumber(businessSitsNumber);
        this.setEconomySitsNumber(economySitsNumber);
        this.setCrewSitsNumber(crewSitsNumber);
        validateTotalSitsNumber(businessSitsNumber,economySitsNumber,crewSitsNumber);
//        this.airplaneID=airplaneID;
//        this.airplaneModel = airplaneModel;
//        this.businessSitsNumber = businessSitsNumber;
//        this.economySitsNumber = economySitsNumber;
//        this.crewSitsNumber = crewSitsNumber;
        airplanes.add(this);
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        if (airplaneModel==null){
            throw new IllegalArgumentException("Airplane Model cannot be empty");
        }
        this.airplaneModel = airplaneModel;
    }

    public int getBusinessSitsNumber() {
        return businessSitsNumber;
    }
    public void setBusinessSitsNumber(int businessSitsNumber){
//        int availableSeats = ALL_SEAT_NUMBER - this.getCrewSitsNumber() - this.getEconomySitsNumber();
//        if (businessSitsNumber > availableSeats) {
//            throw new SeatLimitExceededException("The number of seats exceeded the limit");
//        } else {
//            this.businessSitsNumber = businessSitsNumber;
//        }
        if (businessSitsNumber<0 || businessSitsNumber>300){
            throw new IllegalArgumentException("businessSitsNumber should be within 1-300");
        }
        validateTotalSitsNumber(businessSitsNumber,this.economySitsNumber,this.crewSitsNumber);
        this.businessSitsNumber = businessSitsNumber;

    }

//    public void setBusinessSitsNumber(int businessSitsNumber) throws SeatLimitExceededException{
////        int availableSeats = ALL_SEAT_NUMBER - this.getCrewSitsNumber() - this.getEconomySitsNumber();
////        if (businessSitsNumber > availableSeats) {
////            throw new SeatLimitExceededException("The number of seats exceeded the limit");
////        } else {
////            this.businessSitsNumber = businessSitsNumber;
////        }
//        if (businessSitsNumber<0 || businessSitsNumber>300){
//            throw new IllegalArgumentException("businessSitsNumber should be within 1-300");
//        }
//        this.businessSitsNumber = businessSitsNumber;
//
//    }

    public int getEconomySitsNumber() {
        return economySitsNumber;
    }

//    public void setEconomySitsNumber(int economSitsNumber) throws SeatLimitExceededException{
////        int availableSeats = ALL_SEAT_NUMBER - this.getCrewSitsNumber() - this.getBusinessSitsNumber();
////        if (economSitsNumber > availableSeats) {
////            throw new SeatLimitExceededException("The number of seats exceeded the limit");
////        } else {
////            this.economySitsNumber = economSitsNumber;
////        }
//        if (economySitsNumber<0 || economySitsNumber>300){
//            throw new IllegalArgumentException("economySitsNumber should be within 1-300");
//        }
//        this.economySitsNumber = economSitsNumber;
//
//    }
    public void setEconomySitsNumber(int economySitsNumber){
        if (economySitsNumber<0 || economySitsNumber>300){
            throw new IllegalArgumentException("economySitsNumber should be within 1-300");
        }
        validateTotalSitsNumber(this.businessSitsNumber,economySitsNumber,this.crewSitsNumber);
        this.economySitsNumber = economySitsNumber;
//        int availableSeats = ALL_SEAT_NUMBER - this.getCrewSitsNumber() - this.getBusinessSitsNumber();
//        if (economSitsNumber > availableSeats) {
//            throw new SeatLimitExceededException("The number of seats exceeded the limit");
//        } else {
//            this.economySitsNumber = economSitsNumber;
//        }


}

    public int getCrewSitsNumber() {
        return crewSitsNumber;
    }

//    public void setCrewSitsNumber(int crewSitsNumber) throws SeatLimitExceededException{
//        int availableSeats = ALL_SEAT_NUMBER - this.getEconomySitsNumber() - this.getBusinessSitsNumber();
//        if (crewSitsNumber > availableSeats) {
//            throw new SeatLimitExceededException("The number of seats exceeded the limit");
//        } else {
//            this.crewSitsNumber = crewSitsNumber;
//        }
//
//    }
    public void setCrewSitsNumber(int crewSitsNumber) {
        if (crewSitsNumber<1 || crewSitsNumber>300){
            throw new IllegalArgumentException("crewSitsNumber should be within 1-300");
        }
        validateTotalSitsNumber(this.businessSitsNumber,this.economySitsNumber,crewSitsNumber);
        this.crewSitsNumber = crewSitsNumber;

    }

    public void validateTotalSitsNumber(int businessSitsNumber, int economySitsNumber,int crewSitsNumber){
        int totalSitsNumber = businessSitsNumber+economySitsNumber+crewSitsNumber;
        if(totalSitsNumber>300 || totalSitsNumber<1)
        {
            throw new IllegalArgumentException("Total sits number must in range 1-300");
        }
    }

    public String toString()
    {
        return "Airplane{" +
                "model=" + getAirplaneModel() + '\'' +
                ", business sits=" + getBusinessSitsNumber() + '\'' +
                ", economy sits=" + getEconomySitsNumber() + '\'' +
                ", crew sits=" + getCrewSitsNumber() + '\'' +
                '}';
    }

//    public static Airplane getAirPlaneInfo(int airplane_id) {
//        // TODO Auto-generated method stub
//        Airplane ap = null;
//
//        for (Airplane a : airplanes) {
//            if (a.getAirplaneID() == airplane_id) {
//                ap = a;
//                break;
//            }
//        }
//        return ap;
//    }

    public static Airplane getAirPlaneInfo(int airplane_id) {
//        // TODO Auto-generated method stub
        Airplane ap = null;

        for (Airplane a : airplanes) {
            if (a.getAirplaneID() == airplane_id) {
                ap = a;
                break;
            }
        }
        if (ap == null){
            System.out.println("no airplane has this airplane_id");
        }
        return ap;
    }
}