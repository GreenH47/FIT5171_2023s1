package FIT5171.Team8;
//huang's allocation
public class Ticket
{
    private int ticket_id;
    private int price;
    Flight flight;
    private boolean classVip; //indicates if this is bussiness class ticket or not
    private boolean status; //indicates status of ticket: if it is bought by someone or not
    Passenger passenger;

    public Ticket(int ticket_id,int price, Flight flight, boolean classVip, Passenger passenger)
    {
        this.ticket_id=ticket_id;
        this.price = price;
        this.flight = flight;
        this.classVip = classVip;
        this.status = false;
        this.passenger=passenger;
    }

    public Ticket() {
        this.ticket_id = 0;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getPrice() { return price; }

    public void setPrice(int price)
    {
        this.price = price;
        saleByAge(passenger.getAge()); //changes price of the ticket according to the age category of passenger
        serviceTax( ); //changes price by adding service tax to the ticket
    }

    public void saleByAge(int age)
    {
        int price = getPrice();
        if(age < 15)
        {
            price-=(int)price*0.5;//50% sale for children under 15
            this.price=price;

        } else if(age>=60){
            this.price=0; //100% sale for elder people
        }
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
//        try{
//            FlightCollection.getFlightInfo(flight.getDepartFrom(), flight.getDepartTo());
//        }
//        catch (Exception e){
//            throw new RuntimeException("No such flight exists.");
//        }
//
        Flight temp = new Flight();
        try {
            temp.setDepartFrom(flight.getDepartFrom());
            temp.setDepartTo(flight.getDepartTo());
        }
        catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
        this.flight = flight;
    }

    public boolean getClassVip() {
        return classVip;
    }

    public void setClassVip(boolean classVip) {
        this.classVip = classVip;
    }

    public boolean ticketStatus()
    {
        return status;
    }

    public void setTicketStatus(boolean status)
    {
        this.status = status;
    }

    public void serviceTax(){
        this.price *= 1.12;
    } //12% service tax

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        Passenger temp = new Passenger();
        try{
            temp.setEmail(passenger.getEmail());
            temp.setPhoneNumber(passenger.getPhoneNumber());
            temp.setPassport(passenger.getPassport());
        }
        catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }

        this.passenger = passenger;

    }

    public String toString()
    {
        return"Ticket{" +'\n' + "Ticket Id: " + getTicket_id() +
                "\nPrice = " + getPrice() + "KZT, " + '\n' +
                getFlight() +'\n'+ "Vip status = " + getClassVip() + '\n' +
                getPassenger()+'\n'+ "Ticket was purchased = " + ticketStatus() + "\n}";
    }
}
