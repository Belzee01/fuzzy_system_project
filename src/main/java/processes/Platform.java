package processes;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Platform {

    public static Double process(String offer, String customer) {
        final String fileName = "assests/platform.fcl";
        FIS fis = FIS.load(fileName, true);

        // Error while loading?
        if (fis == null)
            throw new IllegalArgumentException("Can't load file: '" + fileName + "'");

        // Show
//        JFuzzyChart.get().chart(fis);

        // Set inputs
        fis.setVariable("offer", evaluatePlatform(offer));
        fis.setVariable("customer", evaluatePlatform(customer));

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable platform = fis.getVariable("platform");
//        JFuzzyChart.get().chart(platform, platform.getDefuzzifier(), true);

        return platform.getValue();
    }

    private static Integer evaluatePlatform(String platform) {
        if (platform.equals("pc"))
            return 5;
        if (platform.equals("ps"))
            return 15;
        if (platform.equals("xbox"))
            return 25;
        return 5;
    }
}
