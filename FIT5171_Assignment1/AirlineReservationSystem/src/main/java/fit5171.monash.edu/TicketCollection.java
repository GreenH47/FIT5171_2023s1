package fit5171.monash.edu;

import java.util.ArrayList;

public class TicketCollection {
	
	public static ArrayList<Ticket> tickets;

	public static ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public static void addTickets(ArrayList<Ticket> tickets_db) {
		TicketCollection.tickets.addAll(tickets_db);
	}
	
	public static void getAllTickets() {
    	//display all available tickets from the Ticket collection
    }
	public static Ticket getTicketInfo(int ticket_id) {
    	//SELECT a ticket where ticket id = ticket_id
    	return null;

    }
	

}
