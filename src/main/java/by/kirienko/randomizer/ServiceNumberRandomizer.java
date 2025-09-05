package by.kirienko.randomizer;

public class ServiceNumberRandomizer {
    private static final int MIN_SERVICE = 3;
    private static final int MAX_SERVICE = 5;

    public static int getRandomServiceNumber() {
        int randomServiceNumber = Randomizer.RANDOM.nextInt(MAX_SERVICE - MIN_SERVICE);
        return randomServiceNumber + MIN_SERVICE;
    }
}
