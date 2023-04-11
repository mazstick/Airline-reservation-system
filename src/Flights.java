package src;

public class Flights {
    public Flight[] flight = new Flight[20];

    public void flightLib(){
        flight[0] = new Flight("YT-30","yazd", "tehran", "1402-01-20", "13:15", "500000", "300" );
        flight[1] = new Flight("MG-43","mashhad", "ghazvin", "1402-01-22", "12:30", "2000000","123");
        flight[2]= new Flight("SA-90","sari", "ardabil", "1402-01-23", "2:45", "400000", "200" );
        flight[3] = new Flight("GB-37","ghom", "bandarabbas", "1402-01-30", "14:35", "320000", "110" );
        flight[4] = new Flight("RT-78","rasht", "tabriz", "1402-02-03", "14:15", "450000", "420" );
    }
    public void flightSchedules(){
        System.out.print(".........................................................................................................................\n");
        System.out.printf("|%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |\n", "FlightId" , "Origin" , "Destination" , "Date", "Time" , "Price" , "Seat");
        for (int i = 0; flight[i] != null; i++) {
            System.out.print(".........................................................................................................................\n");
            System.out.printf("|%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |\n", flight[i].getFlightId() , flight[i].getOrigin() , flight[i].getDestination() , flight[i].getDate(), flight[i].getTime() , flight[i].getPrice() , flight[i].getSeat());
        }
        System.out.print(".........................................................................................................................\n");
    }
}
