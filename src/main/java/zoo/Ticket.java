package src.main.java.zoo;


import java.time.DayOfWeek;
import java.time.LocalDate;



public class Ticket {
    public enum TicketType {
        ADULT, CHILD, SENIOR
    }

    private static final double ADULT_PRICE  = 20.00;
    private static final double CHILD_PRICE  = 12.00;
    private static final double SENIOR_PRICE = 15.00;
    private static final double TUESDAY_DISCOUNT = 0.2;

    private Ticket() {}

    private static boolean isTuesday(LocalDate date){
        if (date == null) date = LocalDate.now();
        return date.getDayOfWeek() == DayOfWeek.TUESDAY; 
    }

    public static double unitPrice(TicketType type, LocalDate date){
        double price;
        switch (type) {
            case ADULT: price = ADULT_PRICE; break;
            case CHILD: price = CHILD_PRICE; break;
            case SENIOR: price = SENIOR_PRICE; break;
            default: throw new IllegalArgumentException("Unknown ticket type: " + type);
                
        }

        if (isTuesday(date)) {
            price = price * (1 - TUESDAY_DISCOUNT);
        }

        return price;
    }

    public static double total(int adults, int children, int seniors, LocalDate date){
        double total = 0.0;
        total += adults * unitPrice(TicketType.ADULT, date);
        total += children * unitPrice(TicketType.CHILD, date);
        total += seniors * unitPrice(TicketType.SENIOR, date);

        return Math.round(total * 100.0) / 100;
    }


}
