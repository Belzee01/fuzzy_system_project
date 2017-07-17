package evalutor;

import dto.Game;
import fileproc.AdvancedFileReader;
import javafx.util.Pair;
import processes.Platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FuzzyEvaluator {

    private static List<Pair<Game, Double>> gameByValue = new ArrayList<>();

    public static void process() throws IOException {
        AdvancedFileReader reader = new AdvancedFileReader("./assests/base.dat");
        List<Game> games = reader.readAndMapToObject();

        CommandRunner.process();

        games.forEach(g -> {
            double value = 0.0;
            g.getPlatforms().forEach(p -> {

            });
        });
    }

}
