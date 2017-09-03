package fileproc;

import dto.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvancedFileReader {

    private String filename = null;

    public AdvancedFileReader(String filename) {
        this.filename = filename;
    }

    public List<Game> readAndMapToObject() {
        List<Game> mappedObjects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                try {
                    String[] fields = sCurrentLine.split(";");
                    if (fields.length < 4)
                        throw new IllegalArgumentException("Missing fields in game definition!");

                    Game game = new Game(
                            fields[0],
                            Double.valueOf(fields[1]),
                            Arrays.asList(fields[2].toLowerCase().split(",")),
                            Arrays.asList(fields[3].toLowerCase().split(",")),
                            Integer.valueOf(fields[4]),
                            LocalDate.parse(fields[5])
                    );
                    mappedObjects.add(game);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mappedObjects;
    }

}
