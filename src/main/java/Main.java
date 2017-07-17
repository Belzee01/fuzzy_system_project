import dto.Game;
import fileproc.AdvancedFileReader;
import processes.Price;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AdvancedFileReader reader = new AdvancedFileReader("./assests/base.dat");
        List<Game> games = reader.readAndMapToObject();

        System.out.println(games.toString());

        Price.process(200, 100);
    }
}
