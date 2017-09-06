package evalutor;

import dto.Game;
import fileproc.AdvancedFileReader;
import processes.*;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FuzzyEvaluator {

    private static List<Game> gameByValue = new ArrayList<>();

    public static void process(final String baseFilePath) throws IOException {
        AdvancedFileReader reader = new AdvancedFileReader(baseFilePath);
        List<Game> games = reader.readAndMapToObject();

        CommandRunner.process();

        games.forEach(g -> {
            final double[] value = {0.0};

            final double[] multiplier = {0.0};

            System.out.println(g.toString());

            g.getPlatforms().getPlatform().forEach(p -> {
                CommandRunner.platformList.forEach(c -> {
                    multiplier[0] += Platform.process(p, c) / 3.0;
                });
            });


            double price = Price.process(g.getPrice(), CommandRunner.priceRange);
            System.out.println(" 1 price val : " + price);
            multiplier[0] *= price;


            g.getTags().getTags().forEach(t -> {
                CommandRunner.tagList.forEach(tl -> {
                    value[0] += Tags.process(t, tl);
                });
            });

            double date = Date.process(g.getDate(), CommandRunner.date);
            System.out.println(" 2 date val : " + date);
            multiplier[0] *= date;


            double score = Score.process(g.getScore(), CommandRunner.score);
            System.out.println(" 3 score val : " + score);
            multiplier[0] *= score;


            gameByValue.add(g.setValue(multiplier[0] * value[0]));
            System.out.println("---------------------------------------------------");
        });

        gameByValue.sort(Collections.reverseOrder());

        for (int i = 0; i < CommandRunner.amountOfRecords && gameByValue.size()-1 < i; i++) {
            System.out.println(gameByValue.get(i).toString());
        }
    }
}
