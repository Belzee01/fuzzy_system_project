package processes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Date {

    public static double process(LocalDate offer, LocalDate customer) {
        long absoluteDiff = ChronoUnit.MONTHS.between(offer, customer);

        if (offer.isAfter(customer))
            return 1.0;

        if (absoluteDiff > 36) {
            return 0.0;
        } else if (absoluteDiff <= 36 && absoluteDiff >= 1) {
            return ((36.0 - absoluteDiff) / (35.0));
        } else {
            return 1.0;
        }
    }

}
