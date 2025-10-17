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
