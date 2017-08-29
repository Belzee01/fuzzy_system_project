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

    public static void injectDataIntoGamesBase() {
        AdvancedFileReader reader = new AdvancedFileReader("./assests/base2.dat");
        List<Game> games = reader.readAndMapToObject();

        games.forEach(g -> {
            g.setScore(new Random().nextInt(100));
            g.setDate(LocalDate.now().minusYears(new Random().nextInt(20)).minusMonths(new Random().nextInt(12)).minusDays(new Random().nextInt(30)));
        });

        AdvancedFileWriter writer = new AdvancedFileWriter("./assests/base2.dat");

        writer.mapObjectAndWriteToFile(games);
    }
}
