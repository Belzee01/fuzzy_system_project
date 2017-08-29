package fileproc;

import dto.Game;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvancedFileWriter {

    private String filename = null;

    public AdvancedFileWriter(String filename) {
        this.filename = filename;
    }

    public void mapObjectAndWriteToFile(List<Game> games) {
        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.filename)))) {
          games.forEach(g-> {
              try {
                  br.write(g.toString());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
