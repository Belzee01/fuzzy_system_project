package processes;

import dto.Tags.TAGS;
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

    private static Integer evaluateTag(TAGS tag) {
        switch (tag) {
            case FPS:
                return 5;
            case RACING:
                return 15;
            case RTS:
                return 25;
            case RPG:
                return 35;
            case SPORT:
                return 45;
            case TACTICAL:
                return 55;
            case ADVENTURE:
                return 65;
            case ARCADE:
                return 75;
            default:
                return 5;
        }
    }

    public static Double process(TAGS offer, TAGS customer) {
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
