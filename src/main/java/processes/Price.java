package processes;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Price {

    private static Double value = 0.0;

    /**
     * Price needs to be done in refrence to http://home.agh.edu.pl/~golunska/wp-content/uploads/2017/06/W3.pdf
     * page 36
     * @param offer
     * @param customer
     */

    public static void process(Integer offer, Integer customer) {
        final String fileName = "assests/price.fcl";
        FIS fis = FIS.load(fileName, true);

        // Error while loading?
        if (fis == null)
            throw new IllegalArgumentException("Can't load file: '" + fileName + "'");

        // Show
        JFuzzyChart.get().chart(fis);

        // Set inputs
        fis.setVariable("offer", offer);
        fis.setVariable("customer", customer);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable platform = fis.getVariable("price_tag");
        JFuzzyChart.get().chart(platform, platform.getDefuzzifier(), true);

        value = platform.getValue();

        // Print ruleSet
        System.out.println(fis);
    }

    public static Double getValue() {
        return value;
    }

}
