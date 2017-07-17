package processes;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Price {

    private static Double value = 0.0;

    /**
     * Price needs to be done in refrence to http://home.agh.edu.pl/~golunska/wp-content/uploads/2017/06/W3.pdf
     * page 36
     *
     * @param offer
     * @param customer
     */

    public static double process(Integer offer, Integer customer) {

        double absoluteDiff = Math.abs(
                ((double)(customer - offer) / customer) * 100.0
        );

        if (customer > offer)
            return 1.0;

        if (absoluteDiff > 30) {
            return 0.0;
        } else if (absoluteDiff <= 30 && absoluteDiff >= 3) {
            return ((30 - absoluteDiff)/(27));
        } else {
            return 1.0;
        }
    }

    public static Double getValue() {
        return value;
    }

}
