package evalutor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandRunner {

    public static Integer amountOfRecords = 0;
    public static Integer priceRange = 0;
    public static List<String> platformList = new ArrayList<>();
    public static List<String> tagList = new ArrayList<>();

    private static Scanner reader = new Scanner(System.in);

    public static void process() throws IOException {
        System.out.println("Podaj cene w zakresie ktorej poszukujemy gry: ");
        priceRange = reader.nextInt();
        reader.nextLine();

        System.out.println("Podaj platformy na ktore poszukujesz gry: ");
        String platforms = reader.nextLine().toLowerCase();
        platformList.addAll(Arrays.asList(platforms.split(" ")));

        System.out.println("Podaj tagi dla gier ktore poszukujesz: ");
        String tags = reader.nextLine().toLowerCase();
        tagList.addAll(Arrays.asList(tags.split(" ")));

        System.out.println("Podaj ile gier wyswietlic: ");
        amountOfRecords = reader.nextInt();
        reader.nextLine();
    }

}
