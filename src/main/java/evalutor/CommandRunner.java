package evalutor;

import dto.Platforms;
import dto.Tags;
import processes.Platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandRunner {

    public static Integer amountOfRecords = 0;
    public static Double priceRange = 0.0;
    public static List<Platforms.PLATFORMS> platformList = new ArrayList<>();
    public static List<Tags.TAGS> tagList = new ArrayList<>();

    private static Tags tag = new Tags();
    private static Platforms platform = new Platforms();

    private static Scanner reader = new Scanner(System.in);

    public static void process() throws IOException {
        System.out.println("Podaj cene w zakresie ktorej poszukujemy gry: ");
        priceRange = reader.nextDouble();
        reader.nextLine();

        System.out.println("Podaj platformy na ktore poszukujesz gry: ");
        String platforms = reader.nextLine().toLowerCase();
        platform.assign(Arrays.asList(platforms.split(" ")));
        platformList.addAll(platform.getPlatform());

        System.out.println("Tagi : [fps, racing, rts, rpg, sport, tactical, adventure, arcade]");
        System.out.println("Podaj tagi dla gier ktore poszukujesz: ");
        String tags = reader.nextLine().toLowerCase();
        tag.assign(Arrays.asList(tags.split(" ")));
        tagList.addAll(tag.getTags());

        System.out.println("Podaj ile gier wyswietlic: ");
        amountOfRecords = reader.nextInt();
        reader.nextLine();
    }

}
