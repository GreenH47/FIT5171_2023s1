package fit5171.monash.edu;

import java.util.ArrayList;

/*
* 1. Whenever a ticket is being added to the TicketCollection, it must be validated.
*
2. When trying to get a ticket, the correct ticket is returned
* */
public class TicketCollection {
	
	public static ArrayList<Ticket> tickets;

	public static ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public static void validateTicketList(ArrayList<Ticket> newTickets, ArrayList<Ticket> existingTickets) {
		if (newTickets == null || newTickets.isEmpty())
			throw new IllegalArgumentException("Ticket list cannot be empty");
		ArrayList<Integer> newTicketIDs = new ArrayList<Integer>();
		for (Ticket newTicket :
				newTickets
		) {
			if (newTicket == null)
				throw new IllegalArgumentException("Ticket list cannot contain null");
			else {
				if (newTicketIDs.contains(newTicket.getTicket_id()))
					throw new IllegalArgumentException("Ticket with ID:" + newTicket.getTicket_id() + " already exists");
				newTicketIDs.add(newTicket.getTicket_id());

				for (Ticket existingTicket : existingTickets
				) {
					if (newTicket.getTicket_id() == existingTicket.getTicket_id())
						throw new IllegalArgumentException("Ticket with ID:" + newTicket.getTicket_id() + " already exists");
				}

			}
		}
	}

	public static void addTickets(ArrayList<Ticket> tickets_db) {
		validateTicketList(tickets_db, tickets);
		TicketCollection.tickets.addAll(tickets_db);
	}
	
	public static void getAllTickets() {
    	//display all available tickets from the Ticket collection
		if (tickets.size() == 0) {
			System.out.println("No tickets available in the ticket collection.");
		}
		else {
			System.out.println("Available tickets:");
			for (Ticket ticket : tickets) {
				System.out.println(ticket);
			}
		}
    }
	public static Ticket getTicketInfo(int ticket_id) {
    	//SELECT a ticket where ticket id = ticket_id
		for (Ticket ticket : tickets) {
			if (ticket.getTicket_id() == ticket_id) {
				return ticket;
			}
		}
		return null; // Ticket with given ticket_id does not exist

    }
	

}
