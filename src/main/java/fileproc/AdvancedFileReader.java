package fileproc;

import dto.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
                String[] fields = sCurrentLine.split(";");
                mappedObjects.add(
                        new Game(
                                fields[0],
                                Double.valueOf(fields[1]),
                                Arrays.asList(fields[2].split(",")),
                                Arrays.asList(fields[3].split(","))
                        )

                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mappedObjects;
    }

}