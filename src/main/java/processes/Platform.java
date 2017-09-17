package processes;

import dto.Platforms;
import dto.Platforms.PLATFORMS;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Platform {

    public static Double process(PLATFORMS offer, PLATFORMS customer) {
        final String fileName = "assests/platform.fcl";
        FIS fis = FIS.load(fileName, true);

        // Error while loading?
        if (fis == null)
            throw new IllegalArgumentException("Can't load file: '" + fileName + "'");


        // Set inputs
        fis.setVariable("offer", evaluatePlatform(offer));
        fis.setVariable("customer", evaluatePlatform(customer));

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable platform = fis.getVariable("platform");

        return platform.getValue();
    }

    private static Integer evaluatePlatform(PLATFORMS platform) {
        if (platform == PLATFORMS.PC)
            return 5;
        if (platform == PLATFORMS.PS)
            return 15;
        if (platform == PLATFORMS.XBOX)
            return 25;
        return 5;
    }
}
