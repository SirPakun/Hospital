package by.kirienko.randomizer;

public class TakingTimeRandomizer {
    private static final int MIN_TAKING_TIME = 4;
    private static final int MAX_TAKING_TIME = 8;

    public static int getRandomTakingTime() {
        int randomTakingTime = Randomizer.RANDOM.nextInt(MAX_TAKING_TIME - MIN_TAKING_TIME);
        return randomTakingTime + MIN_TAKING_TIME;
    }
}
