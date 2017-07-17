package processes;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Tags {

    private static Double value = 0.0;

    /**
     * rpg - 5
     * action - 15
     * horror - 25
     * adventure - 35
     * scifi - 45
     * fantasy - 55
     * fps - 65
     */
    public static void process() {
        final String fileName = "assests/tags.fcl";
        FIS fis = FIS.load(fileName, true);

        // Error while loading?
        if (fis == null)
            throw new IllegalArgumentException("Can't load file: '" + fileName + "'");

        // Show
        JFuzzyChart.get().chart(fis);

        // Set inputs
        fis.setVariable("offer", 65);
        fis.setVariable("customer", 45);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable platform = fis.getVariable("tags");
        JFuzzyChart.get().chart(platform, platform.getDefuzzifier(), true);

        value = platform.getValue();

        // Print ruleSet
        System.out.println(fis);
    }

    public static Double getValue() {
        return value;
    }

}
