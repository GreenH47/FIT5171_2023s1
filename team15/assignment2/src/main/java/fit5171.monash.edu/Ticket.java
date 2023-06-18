package fit5171.monash.edu;
/*
* 1. Values for the ticket status must be ‘True’ or ‘False’ for
* the booked and available tickets respectively.
*
2. Discount is always applied based on the age category of the passenger.
*
3. Price is always applied to a ticket.
*
4. The price and service tax is a valid value (Integer or real numbers etc.)
*
5. The service tax is always applied when a ticket is sold. Note: Mock the behavior
* of the Flight and Passenger class, while creating objects of the Ticket class
* for unit testing.
*
6. Test that Ticker class received valid information of flight and passenger.
* */
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
        if (price < 0) {
            throw new IllegalArgumentException("Ticket price cannot be less than zero.");
        }
        this.price = price;
        int age = passenger.getAge();
        saleByAge(age); //changes price of the ticket according to the age category of passenger
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
        if (flight == null) {
            throw new IllegalArgumentException("Ticket flight cannot be null");
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
        this.price = (int)(price * 1.12);
    } //12% service tax

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Ticket passenger cannot be null");
        }
        this.passenger = passenger;
    }

    public String toString()
    {
        return"Ticket{" +'\n'+
                "Price=" + getPrice() + "KZT, " + '\n' +
                getFlight() +'\n'+ "Vip status=" + getClassVip() + '\n' +
                getPassenger()+'\n'+ "Ticket was purchased=" + ticketStatus() + "\n}";
    }
}
