package processes;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Score {

    public static double process(Integer offer, Integer customer) {
        final String fileName = "assests/score.fcl";
        FIS fis = FIS.load(fileName, true);

        // Error while loading?
        if (fis == null)
            throw new IllegalArgumentException("Can't load file: '" + fileName + "'");

        JFuzzyChart.get().chart(fis);

        // Set inputs
        fis.setVariable("offer", offer);
        fis.setVariable("customer", customer);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable score = fis.getVariable("score");
        JFuzzyChart.get().chart(score, score.getDefuzzifier(), true);

        return score.getValue();
    }
}
