package FIT5171.Team8;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class TicketSystem {
    Passenger passenger;
    Ticket ticketOne;
    Ticket ticketTwo;
    Flight flight;
    Scanner in = new Scanner(System.in);
    Scanner in_choose = new Scanner(System.in);


    public TicketSystem()
    {
        passenger = new Passenger();
        ticketOne = new Ticket();
        ticketTwo = new Ticket();
        flight = new Flight();
    }

    public TicketSystem(Passenger passenger, Flight flight, Ticket ticketOne, Ticket ticketTwo) {
        this.passenger = passenger;
        this.flight = flight;
    }

    public void chooseTicket(String city1, String city2) throws Exception
    {

        if(verifyCityName(city1) || verifyCityName(city2)) {


            int counter = 1;
            int idFirst = 0;
            int idSecond = 0;

            Flight myflight = getFlightByCity(city1, city2);


            if (myflight != null) {

                TicketCollection.getAllTickets();

                System.out.println("\nEnter ID of ticket you want to choose:");

                int ticketId = 0;
                boolean ticketStatus = false;

                while (!ticketStatus) {

                    ticketId = Integer.parseInt(in.nextLine());
                    ticketStatus = verifyTicketStatus(ticketId);
                }

                this.buyTicket(ticketId);

            } else {

                Flight departTo = FlightCollection.getFlightInfo(city2);


                String connectCity = departTo.getDepartFrom();


                Flight flightConnectingTwoCities = FlightCollection.getFlightInfo(city1, connectCity);

                if (flightConnectingTwoCities != null) {

                    System.out.println("There is special way to go there. And it is transfer way, like above. Way №" + counter);

                    idFirst = departTo.getFlightID();

                    idSecond = flightConnectingTwoCities.getFlightID();

                    counter++;

                }


                this.buyTicket(idFirst, idSecond);

                if (counter == 1) {
                    System.out.println("There is no possible variants.");
                }
            }
        }
    }

    public void showTicket()
    {
        try
        {
            if(!ticketTwo.ticketStatus()){
                System.out.println("You have bought a ticket for flight " + ticketOne.getFlight().getDepartFrom() + " - " + ticketOne.getFlight().getDepartTo() + "\n\nDetails:");
                System.out.println(ticketOne.toString());
            }
            else{
                System.out.println("You have bought a ticket for flight " + ticketOne.getFlight().getDepartFrom() + " - " + ticketTwo.getFlight().getDepartTo() + "\n\nDetails:");
                System.out.println(ticketOne.toString() + "\n" + ticketTwo.toString());
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("Null");
        }
    }

    public void buyTicket(int ticketId) throws Exception
    {
        int flightId = 0;


        Ticket validTicket = TicketCollection.getTicketInfo(ticketId);


        if(validTicket == null)
        {
            System.out.println("This ticket does not exist.");
        }
        else if(validTicket.ticketStatus()){
            System.out.println("This ticket has been sold.");
        }
        else{

            flightId = validTicket.getFlight().getFlightID();

            try
            {
                this.setPassengerInfo();

                System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                int purch = Integer.parseInt(in.nextLine());
                if (purch == 0)
                {
                    return;
                }
                else
                {
                    this.setTicketInfo(flightId, ticketId, passenger, ticketOne);
                }

                System.out.println("Your bill: " + ticketOne.getPrice() + "\n");

                this.payTicket();

                this.showTicket();

            } catch (PatternSyntaxException patternException)
            {
                throw new IllegalArgumentException("Failed to set passenger info: " + patternException.getMessage(), patternException);
            }
        }
    }

    @SuppressWarnings("null")
    public void buyTicket(int ticketIdFirst, int ticketIdSecond) throws Exception{

        int flightIdFirst = 0;

        int flightIdSecond = 0;

        System.out.println(ticketIdFirst + " " + ticketIdSecond);

        Ticket validTicketFirst = TicketCollection.getTicketInfo(ticketIdFirst);

        Ticket validTicketSecond = TicketCollection.getTicketInfo(ticketIdSecond);


        System.out.println("Processing...");


        if(validTicketFirst == null || validTicketSecond == null)
        {
            System.out.println("This ticket does not exist.");
        }

        else
        {
            flightIdFirst = validTicketFirst.getFlight().getFlightID();

            flightIdSecond = validTicketSecond.getFlight().getFlightID();


            try
            {
                this.setPassengerInfo();

                System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                int purch = Integer.parseInt(in.nextLine());
                if (purch == 0)
                {
                    return;
                }
                else
                {


                    this.setTicketInfo(flightIdFirst, ticketIdFirst, passenger, ticketOne);

                    System.out.println("--*-*-");

                    this.setTicketInfo(flightIdSecond, ticketIdSecond, passenger, ticketTwo);

                    System.out.println("--*-*-");

                    System.out.print("Your bill: " );
                    System.out.println(ticketOne.getPrice() + ticketTwo.getPrice());

                    this.payTicket();

                    this.showTicket();

                }
            } catch (PatternSyntaxException patternException)
            {
                throw new IllegalArgumentException("Failed to set ticket info: " + patternException.getMessage(), patternException);

            }
        }
    }

    public void setPassengerInfo(){

        System.out.println("Enter your First Name: ");
        String firstName = in.nextLine();
        passenger.setFirstName(firstName);


        System.out.println("Enter your Second name:");
        String secondName = in.nextLine();
        passenger.setSecondName(secondName);

        System.out.println("Enter your age:");
        int age = Integer.parseInt(in.nextLine());
        passenger.setAge(age);

        System.out.println("Enter your gender: ");
        String gender = in.nextLine();
        passenger.setGender(gender);

        System.out.println("Enter your e-mail address");
        String email = in.nextLine();
        passenger.setEmail(email);

        System.out.println("Enter your phone number (+7):");
        String phoneNumber = in.nextLine();
        passenger.setPhoneNumber(phoneNumber);

        System.out.println("Enter your passport number:");
        String passportNumber = in.nextLine();
        passenger.setPassport(passportNumber);
    }

    public void setTicketInfo(int flightId, int ticketId, Passenger passenger, Ticket ticket){
        Flight flight = FlightCollection.getFlightInfo(flightId);
        Airplane airplane = AirplaneCollection.getAirPlaneInfo(flight.getAirplane().getAirplaneID());
        Ticket ticketTemp = TicketCollection.getTicketInfo(ticketId);

        ticket.setPassenger(passenger);
        ticket.setTicket_id(ticketId);
        ticket.setFlight(flight);
        ticket.setPrice(ticketTemp.getPrice());
        ticket.setClassVip(ticketTemp.getClassVip());
        ticket.setTicketStatus(true);

        if (ticketTemp.getClassVip())
        {
            airplane.setBusinessSitsNumber(airplane.getBusinessSitsNumber() - 1);
        } else
        {
            airplane.setEconomySitsNumber(airplane.getEconomySitsNumber() - 1);
        }

    }

    public void payTicket(){
        System.out.println("Enter your card number:");
        String cardNumber = in.nextLine();
        passenger.setCardNumber(cardNumber);

        System.out.println("Enter your security code:");
        int securityCode = Integer.parseInt(in.nextLine());
        passenger.setSecurityCode(securityCode);
    }

    public static Boolean verifyCityName(String name){
        name = name.trim();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static Flight getFlightByCity(String city1, String city2) {
        Flight temp;
        try{
            temp = FlightCollection.getFlightInfo(city1, city2);
        }
        catch (Exception e)
        {
            temp = null;
        }
        return temp;
    }

    public static boolean verifyTicketStatus(int ticket) {
        Ticket choosedTicket = TicketCollection.getTicketInfo(ticket);
        if(choosedTicket.ticketStatus()){
            System.out.println("This ticket is booked, please choose another one.");
            throw new RuntimeException("This ticket is booked, please choose another one.");
        }
        else return true;
    }
}


