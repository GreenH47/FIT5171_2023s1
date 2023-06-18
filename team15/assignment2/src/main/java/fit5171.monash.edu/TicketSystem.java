package fit5171.monash.edu;
import java.util.*;
import java.util.regex.PatternSyntaxException;

/*
* 1. When choosing a ticket, a valid city is used.
*
2. If a passenger chooses an already booked ticket it should display an error message.
*
3. Appropriate checks have been implemented to validate passenger information
*
4. Appropriate checks have been implemented to validate flight information
*
5. Appropriate checks have been implemented to validate ticket information
*
6. A correct value is displayed to the passenger when buying a ticket
* */
public class TicketSystem <T>
{
    Passenger passenger;
    Ticket ticket;
    Flight flight;
    Scanner in = new Scanner(System.in);

    public TicketSystem()
    {

//        passenger = new Passenger("Jane", "Doe", 22, "Female", "abc@admain.com", "0488256354", "AB8976754", "123456789", "908");
//        ticket = new Ticket();
//        flight = new Flight();
        passenger = new Passenger();
        ticket = new Ticket();
        flight = new Flight();
    }

    public TicketSystem(Passenger passenger, Flight flight, Ticket ticket) {
        this.passenger = passenger;
        this.ticket = ticket;
        this.flight = flight;
    }


    public boolean showTicket()
    {
        try
        {
            System.out.println("You have bought a ticket for flight " + ticket.getFlight().getDepartFrom() + " - " + ticket.getFlight().getDepartTo() + "\n\nDetails:");
            System.out.println(this.ticket.toString());
            return true;
        }
        catch (NullPointerException e)
        {
            return false;
        }
    }

    public int sumOfNumbersFromSystemIn() {
        int firstSummand = in.nextInt();
        in.nextLine();
        int secondSummand = in.nextInt();
        return firstSummand + secondSummand;
    }

    /**
     *
     * @param ticket_id
     * @throws Exception
     */
    public void buyTicket(int ticket_id) throws Exception
    //method for buying one ticket with direct flight
    {
        int flight_id;

        //select ticket where ticket_id="+ticket_id"
        Ticket validTicket = TicketCollection.getTicketInfo(ticket_id);

        //if there is a valid ticket id was input then we buy it, otherwise show message
        if(validTicket == null)
        {
            System.out.println("This ticket does not exist.");
            return;
        }
        else if (validTicket.ticketStatus()) {
            System.out.println("Sorry, ticket has been booked.");
            return;
        }

        else{
            //select flight_id from ticket where ticket_id=" + ticket_id

            flight_id = validTicket.getFlight().getFlightID();

            try
            {
                System.out.println("Enter your First Name: ");
                //String firstName = "";
                String firstName = in.nextLine();
                passenger.setFirstName(firstName);


                System.out.println("Enter your Second name:");
                //String secondName = "";
                String secondName = in.nextLine();
                passenger.setSecondName(secondName); //setting passengers info

                System.out.println("Enter your age:");
                //Integer age = 0;
                //in.nextLine();
                Integer age = in.nextInt();
                in.nextLine();
                passenger.setAge(age);

                System.out.println("Enter your gender: ");
                //String gender = "";
                String gender = in.nextLine();
                passenger.setGender(gender);

                System.out.println("Enter your e-mail address");
                //String email = "";
                String email = in.nextLine();
                passenger.setEmail(email);

                System.out.println("Enter your phone number (+7):");
                String phoneNumber = in.nextLine();
                passenger.setPhoneNumber(phoneNumber);

                System.out.println("Enter your passport number:");
                String passportNumber = in.nextLine();
                passenger.setPassport(passportNumber);

                System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                int purch;
                while (true) {
                    System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                    purch = in.nextInt();
                    in.nextLine();
                    if (purch == 1 || purch == 0)
                        break;
                }
                if (purch == 0)
                {
                    return;
                } else
                {

                    flight = FlightCollection.getFlightInfo(flight_id);

                    int airplane_id = flight.getAirplane().getAirplaneID();

                    Airplane airplane = Airplane.getAirPlaneInfo(airplane_id);

                    ticket = TicketCollection.getTicketInfo(ticket_id);

                    ticket.setPassenger(passenger);
                    ticket.setTicket_id(ticket_id);
                    ticket.setFlight(flight);
                    ticket.setPrice(ticket.getPrice());
                    ticket.setClassVip(ticket.getClassVip());
                    ticket.setTicketStatus(true);
                    if (ticket.getClassVip() == true)
                    {
                        airplane.setBusinessSitsNumber(airplane.getBusinessSitsNumber() - 1);
                    } else
                    {
                        airplane.setEconomySitsNumber(airplane.getEconomySitsNumber() - 1);
                    }

                }
                System.out.println("Your bill: " + ticket.getPrice() + "\n");

                System.out.println("Enter your card number:");
                String cardNumber = in.nextLine();
                passenger.setCardNumber(cardNumber);

                System.out.println("Enter your security code:");
                Integer securityCode = in.nextInt();
                passenger.setSecurityCode(securityCode);


            } catch (PatternSyntaxException patternException)
            {
                patternException.printStackTrace();
            }
        }
    }

    /**
     *
     * @param ticket_id_first
     * @param ticket_id_second
     * @throws Exception
     */
    @SuppressWarnings("null")
    public void buyTicket(int ticket_id_first, int ticket_id_second) throws Exception{
        //method for buying two tickets with transfer flight
        int flight_id_first;

        int flight_id_second;


        System.out.println(ticket_id_first + " " + ticket_id_second);

        Ticket validTicketfirst = TicketCollection.getTicketInfo(ticket_id_first);

        Ticket validTicketSecond = TicketCollection.getTicketInfo(ticket_id_first);


        System.out.println("Processing...");

        //if there is a valid ticket id was input then we buy it, otherwise show message

        if(validTicketfirst!=null || validTicketSecond!=null)
        {
            System.out.println("This ticket does not exist.");
            return;
        }
        else if (validTicketfirst.ticketStatus()) {
            System.out.println("Sorry,ticket 1 has been booked.");
            return;
        }
        else if (validTicketSecond.ticketStatus()) {
            System.out.println("Sorry, ticket 2 has been booked.");
            return;
        }

        else
        {
            flight_id_first = validTicketfirst.getFlight().getFlightID();

            flight_id_second = validTicketfirst.getFlight().getFlightID();


            try
            {
//                System.out.println("Enter your First Name: ");
//                String firstName = "";
//                passenger.setFirstName(firstName);
//
//
//                System.out.println("Enter your Second name:");
//                String secondName = "";
//                passenger.setSecondName(secondName); //setting passengers info
//
//                System.out.println("Enter your age:");
//                Integer age = 0;
//                in.nextLine();
//                passenger.setAge(age);
//
//                System.out.println("Enter your gender: ");
//                String gender = "";
//                //passenger.setGender(gender));
//
//                System.out.println("Enter your e-mail address");
//                String email = "";
//                passenger.setEmail(email);
//
//                System.out.println("Enter your phone number (+7):");
//                String phoneNumber = "";
//                passenger.setPhoneNumber(phoneNumber);
//
//                System.out.println("Enter your passport number:");
//                String passportNumber = "";
//                passenger.setPassport(passportNumber);

                //FirstName
                while (true) {
                    try {
                        System.out.println("Enter your First Name: ");
                        String firstName = in.nextLine();
                        //PersonValidator.validateName(firstName);
                        passenger.setFirstName(firstName);
                        break;
                    } catch (IllegalArgumentException e) {
                    }
                }

                //SecondName
                while (true) {
                    try {
                        System.out.println("Enter your Second name:");
                        String secondName = in.nextLine();
                        //PersonValidator.validateName(secondName);
                        passenger.setSecondName(secondName); //setting passengers info
                        break;
                    } catch (IllegalArgumentException e) {
                    }
                }

                //Age
                while (true) {
                    try {
                        System.out.println("Enter your age:");
                        Integer age = in.nextInt();
                        in.nextLine();
                        //PersonValidator.validateAge(age);
                        passenger.setAge(age);
                        break;
                    } catch (IllegalArgumentException e) {
                    }
                }

                //Gender
                while (true) {
                    try {
                        System.out.println("Enter your gender: ");
                        String gender = in.nextLine();
                        //PersonValidator.validateGender(gender);
                        passenger.setGender(gender);
                        break;
                    } catch (IllegalArgumentException e) {
                    }
                }

                //Email
                while (true) {
                    try {
                        System.out.println("Enter your e-mail address");
                        String email = in.nextLine();
                        //PassengerValidator.validateEmail(email);
                        passenger.setEmail(email);
                        break;
                    } catch (IllegalArgumentException e) {
                    }
                }

                //Phone Number
                while (true) {
                    try {
                        System.out.println("Enter your phone number (start with 04/05/61):");
                        String phoneNumber = in.nextLine();
                        //PassengerValidator.validatePhoneNumber(phoneNumber);
                        passenger.setPhoneNumber(phoneNumber);
                        break;
                    } catch (IllegalArgumentException e) {
                    }
                }

                //Passport
                while (true) {
                    try {
                        System.out.println("Enter your passport number:");
                        String passportNumber = in.nextLine();
                        //PassengerValidator.validatePassportNumber(passportNumber);
                        passenger.setPassport(passportNumber);
                        break;
                    } catch (IllegalArgumentException e) {
                    }
                }


                System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                int purch;
                while (true) {
                    System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                    purch = in.nextInt();
                    in.nextLine();
                    if (purch == 1 || purch == 0)
                        break;
                }
                if (purch == 0)
                {
                    return;
                }
                else
                {

                    //  "select * from flight, airplane where flight_id=" + flight_id_first + " and flight.airplane_id=airplane.airplane_id");
                    Flight flight_first = FlightCollection.getFlightInfo(flight_id_first);

                    int airplane_id_first = flight_first.getAirplane().getAirplaneID();

                    Airplane airplane_first = Airplane.getAirPlaneInfo(airplane_id_first);

                    Flight flight_second = FlightCollection.getFlightInfo(flight_id_second);

                    int airplane_id_second = flight_second.getAirplane().getAirplaneID();

                    Airplane airpairplane_second  = Airplane.getAirPlaneInfo(airplane_id_second);

                    Ticket ticket_first = TicketCollection.getTicketInfo(ticket_id_first);

                    Ticket ticket_second = TicketCollection.getTicketInfo(ticket_id_second);

                    ticket_first.setPassenger(passenger);
                    ticket_first.setTicket_id(ticket_id_first);
                    ticket_first.setFlight(flight_first);
                    ticket_first.setPrice(ticket_first.getPrice());
                    ticket_first.setClassVip(ticket_first.getClassVip());
                    ticket_first.setTicketStatus(true);

                    if (ticket_first.getClassVip() == true)
                    {
                        airplane_first.setBusinessSitsNumber(airplane_first.getBusinessSitsNumber() - 1);
                    } else
                    {
                        airplane_first.setEconomySitsNumber(airplane_first.getEconomySitsNumber() - 1);
                    }

                    System.out.println("--*-*-");

                    ticket_second.setPassenger(passenger);
                    ticket_second.setTicket_id(ticket_id_second);
                    ticket_second.setFlight(flight_first);
                    ticket_second.setPrice(ticket_second.getPrice());
                    ticket_second.setClassVip(ticket_second.getClassVip());
                    ticket_second.setTicketStatus(true);
                    if (ticket_second.getClassVip() == true)
                    {
                        airpairplane_second.setBusinessSitsNumber(airpairplane_second.getBusinessSitsNumber() - 1);
                    } else
                    {
                        airpairplane_second.setEconomySitsNumber(airpairplane_second.getEconomySitsNumber() - 1);
                    }

                    System.out.println("--*-*-");

                    ticket.setPrice(ticket_first.getPrice() + ticket_second.getPrice());

                    System.out.println("Your bill: " + ticket.getPrice() + "\n");

//                    System.out.println("Enter your card number:");
//
//                    String cardNumber = "";
//                    passenger.setCardNumber(cardNumber);
//
//                    System.out.println("Enter your security code:");
//                    Integer securityCode = 0;
//                    passenger.setSecurityCode(securityCode);
                    while (true) {
                        try {
                            System.out.println("Enter your card number:");
                            String cardNumber = in.nextLine();
                            passenger.setCardNumber(cardNumber);
                            break;
                        } catch (IllegalArgumentException e) {
                        }
                    }

                    //Cvc code
                    while (true) {
                        try {
                            System.out.println("Enter your security code:");
                            Integer securityCode = in.nextInt();
                            passenger.setSecurityCode(securityCode);
                            break;
                        } catch (IllegalArgumentException e) {
                        }
                    }

                }
            } catch (PatternSyntaxException patternException)
            {
                patternException.printStackTrace();
            }
        }

    }

    /**
     *
     * @param city1
     * @param city2
     * @throws Exception
     */
    public void chooseTicket(String city1, String city2) throws Exception
    {
        int counter = 1;
        int idFirst = 0;
        int idSecond = 0;

        Flight flight = new Flight();

        //search for direct flight from city1 to city2

        flight = FlightCollection.getFlightInfo(city1, city2);


        if(flight != null) {

            TicketCollection.getAllTickets();

            System.out.println("\nEnter ID of ticket you want to choose:");

            int ticket_id = in.nextInt();

            //validate ticker here

            //buy ticket here
            buyTicket(ticket_id);
        }
        else
        //in case there is no direct ticket from city1 to city2
        {
            //SELECT a flight where depart_to = city2

            Flight depart_to = FlightCollection.getFlightInfo(city2);

            //and search for city with depart_from as connector city

            String connectCity = depart_to.getDepartFrom();

            //SELECT * from flight where depart_to = '" + connectCity + "' and depart_from = '" + city1+"'"

            Flight flightConnectingTwoCities = FlightCollection.getFlightInfo(city1, connectCity);

            if(flightConnectingTwoCities != null){

                System.out.println("There is special way to go there. And it is transfer way, like above. Way №" + counter);

                idFirst = depart_to.getFlightID();

                idSecond = flightConnectingTwoCities.getFlightID();


            }

            counter++;

            buyTicket(idFirst, idSecond); //pass two tickets and buy them

            if(counter == 1)
            {
                System.out.println("There is no possible variants.");
            }
            return;
        }

    }
}
