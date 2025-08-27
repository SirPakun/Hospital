package by.kirienko.utils.generator;

import by.kirienko.utils.Randomizer;

public class TakingTimeGenerator {
    private static int MIN_TAKING_TIME = 4;
    private static int MAX_TAKING_TIME = 8;

    public static int getRandomTakingTime() {
        int randomTakingTime = Randomizer.RANDOM.nextInt(MAX_TAKING_TIME - MIN_TAKING_TIME);
        return randomTakingTime + MIN_TAKING_TIME;
    }
}
