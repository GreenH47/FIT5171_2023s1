package FIT5171.Team8;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.lang.*;

public class Flight {
    private int flightID;
    private String departTo;
    private String departFrom;
    private String code;
    private String company;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    Airplane airplane;
    
    public Flight(){}

    public Flight(int flight_id, String departTo, String departFrom, String code, String company, Timestamp dateFrom,Timestamp dateTo, Airplane airplane)
    {
            this.flightID=flight_id;
            this.departTo = departTo;
            this.departFrom = departFrom;
            this.code = code;
            this.company = company;
            this.airplane = airplane;
            this.dateTo = dateTo;
            this.dateFrom = dateFrom;
    }

    public int getFlightID() {
        return this.flightID;
    }

    public void setFlightID(int flightid) {
        this.flightID = flightid;
    }

    public String getDepartTo() {
        return departTo;
    }

    public void setDepartTo(String departTo) {
        if(verifyCityName(departTo))
        {
            if (departTo.equals(departFrom)) {
                throw new IllegalArgumentException("Departure and Destination cities cannot be the same.");
            }else {
                this.departTo = departTo;
            }
            //this.departTo = departTo;
        }
        else throw new IllegalArgumentException("This city name is invalid!");
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        if(verifyCityName(departFrom))
            this.departFrom = departFrom;
        else throw new IllegalArgumentException("This city name is invalid!");


    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDateFrom() {
        return TimestampConverter(dateFrom);
    }

    public void setDateFrom(Timestamp dateFrom) {
        if(this.dateTo == null || this.dateTo.compareTo(dateFrom) > 0)
            this.dateFrom = dateFrom;
        else
            throw new RuntimeException("The time of dateFrom must Before time of dateTo!!!");
    }

    public String getDateTo() {
        return TimestampConverter(dateTo);
    }

    public void setDateTo(Timestamp dateTo) {
        if(this.dateFrom == null || dateTo.compareTo(this.dateFrom) > 0)
            this.dateTo = dateTo;
        else
            throw new RuntimeException("The time of dateTo must AFTER time of dateFrom!!!");
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
                    ", date to=" +  getDateTo() + ", " + '\'' +
                    ", date from='" + getDateFrom() + '\'' +
                    ", depart from='" + getDepartFrom() + '\'' +
                    ", depart to='" + getDepartTo() + '\'' +
                    ", code=" + getCode() + '\'' +
                    ", company=" + getCompany() + '\'' +
                    ", code=" + getCode() + '\'' +
                    '}';
    }

    public String TimestampConverter(Timestamp timestamp){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(timestamp);
    }

    public static Boolean verifyCityName(String name){
        name = name.trim();
        for(int i = 0; i < name.length(); i++)
            if(name.charAt(i) < 'A' || name.charAt(i) > 'z')
                return false;
        return true;
    }

}
