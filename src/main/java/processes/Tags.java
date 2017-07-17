package processes;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Tags {

    /**
     * rpg - 5
     * action - 15
     * horror - 25
     * adventure - 35
     * scifi - 45
     * fantasy - 55
     * fps - 65
     */

    private static Integer evaluateTag(String tag) {
        switch (tag) {
            case "rpg":
                return 5;
            case "action":
                return 15;
            case "horror":
                return 25;
            case "adventure":
                return 35;
            case "scifi":
                return 45;
            case "fantasy":
                return 55;
            case "fps":
                return 65;
            default:
                return 5;
        }
    }

    public static Double process(String offer, String customer) {
        final String fileName = "assests/tags.fcl";
        FIS fis = FIS.load(fileName, true);

        // Error while loading?
        if (fis == null)
            throw new IllegalArgumentException("Can't load file: '" + fileName + "'");

        // Set inputs
        fis.setVariable("offer", evaluateTag(offer));
        fis.setVariable("customer", evaluateTag(customer));

        // Evaluate
        fis.evaluate();

        Variable platform = fis.getVariable("tags");

        return platform.getValue();
    }
}
