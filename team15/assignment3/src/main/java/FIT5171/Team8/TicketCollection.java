package FIT5171.Team8;

import java.util.ArrayList;
//huang's allocation
public class TicketCollection {

	public static ArrayList<Ticket> tickets = new ArrayList<Ticket>();

	private TicketCollection(){}

	public static ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public static void addTicket(Ticket ticket) {
		if(!ticket.ticketStatus())
			tickets.add(ticket);
		else throw new RuntimeException(ticket.getTicket_id() + " has been booked.");
	}

	public static void addTickets(ArrayList<Ticket> tickets) {
		for(Ticket ticket: tickets){
			addTicket(ticket);
		}
	}

	public static void getAllTickets() {
		//display all available tickets from the Ticket collection
			for (Ticket ticket : tickets) {
			  System.out.print(ticket);
    	}
	}
	public static Ticket getTicketInfo(int ticket_id) {
//		//SELECT a ticket where ticket id = ticket_id
    	for (Ticket ticket : tickets) {
		   if (ticket.getTicket_id() == ticket_id) {
			  return ticket;
       		}
    	}
		throw new RuntimeException(ticket_id + " doesn't exit.");
	}


}