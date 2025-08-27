package by.kirienko.utils.generator;

import by.kirienko.utils.Randomizer;

public class WaitingTimeGenerator {
    private static int MIN_WAITING_TIME = 8;
    private static int MAX_WAITING_TIME = 16;

    public static int getRandomWaitingTime() {
        int randomWaitingTime = Randomizer.RANDOM.nextInt(MAX_WAITING_TIME - MIN_WAITING_TIME);
        return randomWaitingTime + MIN_WAITING_TIME;
    }
}
