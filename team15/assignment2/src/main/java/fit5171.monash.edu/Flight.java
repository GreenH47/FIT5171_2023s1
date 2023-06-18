package fit5171.monash.edu;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
* When a flight is being added to the system, following conditions must be met.
1. All fields are required. Note: Mock the behaviour of the Airplane
* class while creating objects of the Flight class for unit testing.
*
2. Date must be in DD/MM/YY format.
*
3. Time must be in HH:MM:SS format.
*
4. Ensure the same flight is not already in the system
* */
public class Flight {
    private int flightID;
    private String departTo;
    private String departFrom;
    private String code;
    private String company;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    Airplane airplane;
    //public static ArrayList<Flight> flights = new ArrayList<>();

    public Flight(){}

    public Flight(int flight_id, String departTo, String departFrom, String code, String company, String dateFrom,String dateTo, Airplane airplane) throws ParseException {
        this.setFlightID(flight_id);
        this.setDateFrom(dateFrom);
        this.setDateTo(dateTo);
        this.setDepartFrom(departFrom);
        this.setDepartTo(departTo);
        this.setCode(code);
        this.setCompany(company);
        this.airplane = airplane;
    }

//    public static boolean isFlightValid(int flightID){
//        for (Flight a : flights) {
//            if (a.getFlightID() == flightID) {
//                return false;
//            }
//        }
//        return true;
//    }

    public String getDateFromString(){
        Timestamp timestamp = this.getDateFrom();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedTime = dateFormat.format(timestamp);
        return formattedTime;
    }

    public String getDateToString(){
        Timestamp timestamp = this.getDateTo();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedTime = dateFormat.format(timestamp);
        return formattedTime;
    }

    public static boolean isAllFieldsRequired(Flight flight){
        if(flight.getFlightID() == 0){
            return false;
        }

        if(flight.getCode() == null){
            return false;
        }

        if(flight.getDepartTo() == null){
            return false;
        }

        if(flight.getDepartFrom() == null){
            return false;
        }

        if(flight.getCompany() == null){
            return false;
        }

        if(flight.getDateFrom() == null){
            return false;
        }

        if(flight.getDateTo() == null){
            return false;
        }

        if(flight.getAirplane() == null){
            return false;
        }

        return true;
    }

//    public static void addFlight(Flight flight){
//        boolean idValid = isFlightValid(flight.getFlightID());
//        boolean fieldsValid = isAllFieldsRequired(flight);
//        if(idValid && fieldsValid){
//            flights.add(flight);
//        }
//    }

    public static Timestamp getTimestamp(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = dateFormat.parse(dateStr);
        Timestamp timestamp;
        timestamp = new Timestamp(date.getTime());
        return timestamp;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightid) {
        if(flightid <= 0){
            throw new IllegalArgumentException("flight id cannot less or equal to 0");
        }else {
            this.flightID = flightid;
        }
    }

    public String getDepartTo() {
        return departTo;
    }

    public void setDepartTo(String departTo) {
        //departTo and departFrom should not same
        if (departTo.equals(departFrom)) {
            throw new IllegalArgumentException("Departure and Destination cities cannot be the same.");
        }else {
            this.departTo = departTo;
        }
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        //departTo and departFrom should not same
        if (departFrom.equals(departTo)) {
            throw new IllegalArgumentException("Departure and Destination cities cannot be the same.");
        }else {
            this.departFrom = departFrom;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null || code.trim().length() == 0) {
            throw new IllegalArgumentException("Flight code cannot be null.");
        }else {
            this.code = code;
        }
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if (company == null || company.trim().length() == 0) {
            throw new IllegalArgumentException("Company name cannot be null.");
        }else {
            this.company = company;
        }
    }

    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) throws ParseException {
  /*      //dateTo should later than dateFrom
        if (dateTo != null && dateFrom.after(dateTo)) {
            throw new IllegalArgumentException("Departure date cannot be after Arrival date.");
        }
        this.dateFrom = dateFrom;*/
        Timestamp dateFromTimestamp = Flight.getTimestamp(dateFrom);
        Timestamp dateToTimestamp = this.getDateTo();
        if(dateTo != null && dateFromTimestamp.after(dateToTimestamp)){
            throw new IllegalArgumentException("Departure date cannot be after Arrival date.");
        }else {
            this.dateFrom = Flight.getTimestamp(dateFrom);
        }
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) throws ParseException {
     /*   //dateTo should later than dateFrom
        if (dateFrom != null && dateTo.before(dateFrom)) {
            throw new IllegalArgumentException("Arrival date cannot be before Departure date.");
        }
        this.dateTo = dateTo;*/
        Timestamp dateToTimestamp = Flight.getTimestamp(dateTo);
        Timestamp dateFromTimestamp = this.getDateFrom();
        if(dateFrom != null && dateToTimestamp.before(dateFromTimestamp)){
            throw new IllegalArgumentException("Departure date cannot be after Arrival date.");
        }else {
            this.dateTo = Flight.getTimestamp(dateTo);
        }
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public String toString()
    {
        return "Flight{" + airplane.toString() +
                ", date to=" +  getDateToString() + ", " + '\'' +
                ", date from='" + getDateFromString() + '\'' +
                ", depart from='" + getDepartFrom() + '\'' +
                ", depart to='" + getDepartTo() + '\'' +
                ", code=" + getCode() + '\'' +
                ", company=" + getCompany() + '\'' +
                ", code=" + getCode() + '\'' +
                '}';
    }
}
