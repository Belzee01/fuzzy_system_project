package evalutor;

import dto.Game;
import fileproc.AdvancedFileReader;
import processes.Platform;
import processes.Price;
import processes.Tags;

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

            g.getPlatforms().getPlatform().forEach(p -> {
                CommandRunner.platformList.forEach(c -> {
                    multiplier[0] += Platform.process(p, c);
                });
            });


            multiplier[0] *= Price.process(g.getPrice(), CommandRunner.priceRange);

            g.getTags().getTags().forEach(t -> {
                CommandRunner.tagList.forEach(tl -> {
                    value[0] += Tags.process(t, tl);
                });
            });

            gameByValue.add(g.setValue(multiplier[0] * value[0]));
        });

        gameByValue.sort(Collections.reverseOrder());

        for (int i = 0; i < CommandRunner.amountOfRecords; i++) {
            System.out.println(gameByValue.get(i).toString());
        }
    }

}
