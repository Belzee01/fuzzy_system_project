package processes;

public class Score {

    public static double process(Integer offer, Integer customer) {
        double absoluteDiff = Math.abs(
                ((customer - offer) / customer) * 100.0
        );

        if (customer > offer)
            return 100.0;



        return 0.0;
    }
}
