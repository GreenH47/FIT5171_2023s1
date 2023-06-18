package FIT5171.Team8;

public class Airplane
{
    private int airplaneID;
    private String airplaneModel;
    private int businessSitsNumber;
    private int economySitsNumber;
    private int crewSitsNumber;
    private static final String ERROR_MESSAGE = "Seat number must be in the range [1, 300].";
    private static final int TOTAL_SEAT_NUMBER = 300;

    public Airplane(){}

    public Airplane(int airplaneID, String airplaneModel, int businessSitsNumber, int economySitsNumber, int crewSitsNumber)
    {
        this.airplaneID=airplaneID;
        this.airplaneModel = airplaneModel;
        setBusinessSitsNumber(businessSitsNumber);
        setEconomySitsNumber(economySitsNumber);
        setCrewSitsNumber(crewSitsNumber);
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
        this.airplaneModel = airplaneModel;
    }

    public int getBusinessSitsNumber() {
        return businessSitsNumber;
    }

    public void setBusinessSitsNumber(int businessSitsNumber) {
        int available_sit_number = TOTAL_SEAT_NUMBER - this.getEconomySitsNumber() - this.getCrewSitsNumber();
        if(businessSitsNumber > 0 && businessSitsNumber <= available_sit_number)
            this.businessSitsNumber = businessSitsNumber;
        else throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public int getEconomySitsNumber() {
        return economySitsNumber;
    }

    public void setEconomySitsNumber(int economSitsNumber) {
        int available_sit_number = TOTAL_SEAT_NUMBER - this.getBusinessSitsNumber() - this.getCrewSitsNumber();
        if(economSitsNumber > 0 && economSitsNumber <= available_sit_number)
            this.economySitsNumber = economSitsNumber;
        else throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public int getCrewSitsNumber() {
        return crewSitsNumber;
    }

    public void setCrewSitsNumber(int crewSitsNumber) {
        int available_sit_number = TOTAL_SEAT_NUMBER - this.getEconomySitsNumber() - this.getBusinessSitsNumber();
        if(crewSitsNumber > 0 && crewSitsNumber <= available_sit_number)
            this.crewSitsNumber = crewSitsNumber;
        else throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public String toString()
    {
        return "Airplane{" +
                "airplaneID=" + getAirplaneID() + '\'' +
                ", model=" + getAirplaneModel() + '\'' +
                ", business sits=" + getBusinessSitsNumber() + '\'' +
                ", economy sits=" + getEconomySitsNumber() + '\'' +
                ", crew sits=" + getCrewSitsNumber() + '\'' +
                '}';
    }
}