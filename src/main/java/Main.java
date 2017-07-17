import evalutor.FuzzyEvaluator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            FuzzyEvaluator.process();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
