import dto.Game;
import evalutor.FuzzyEvaluator;
import fileproc.AdvancedFileReader;
import fileproc.AdvancedFileWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        try {
            FuzzyEvaluator.process("./assests/base2.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
