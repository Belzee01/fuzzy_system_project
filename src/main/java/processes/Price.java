package processes;

public class Price {

    public static double process(Double offer, Double customer) {

        double absoluteDiff = Math.abs(
                ((customer - offer) / customer) * 100.0
        );

        if (customer > offer)
            return 100.0;

        if (absoluteDiff > 30) {
            return 0.0;
        } else if (absoluteDiff <= 30 && absoluteDiff >= 3) {
            return ((30 - absoluteDiff)/(27)) * 100.0;
        } else {
            return 100.0;
        }
    }
}
