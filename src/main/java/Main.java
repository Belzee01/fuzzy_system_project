import evalutor.FuzzyEvaluator;
import processes.Score;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

//        try {
//            FuzzyEvaluator.process("./assests/base2.dat");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Score.process(50, 95);
    }
}
