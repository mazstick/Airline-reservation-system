package src;

public class Tickets {
    public Ticket[] ticket = new Ticket[10];
    public int findNullTicket() {
        for (int i = 0; i < ticket.length; i++) {
            if (ticket[i] == null) {
                return i;
            }
        }
        return -1;
    }

}
