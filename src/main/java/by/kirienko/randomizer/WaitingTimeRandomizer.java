package by.kirienko.randomizer;

public class WaitingTimeRandomizer {
    private static final int MIN_WAITING_TIME = 8;
    private static final int MAX_WAITING_TIME = 16;

    public static int getRandomWaitingTime() {
        int randomWaitingTime = Randomizer.RANDOM.nextInt(MAX_WAITING_TIME - MIN_WAITING_TIME);
        return randomWaitingTime + MIN_WAITING_TIME;
    }
}
