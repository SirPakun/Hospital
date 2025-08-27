package by.kirienko.utils.generator;

import by.kirienko.utils.Randomizer;

public class ServiceNumberGenerator {
    private static int MIN_SERVICE = 3;
    private static int MAX_SERVICE = 5;

    public static int getRandomServiceNumber() {
        int randomServiceNumber = Randomizer.RANDOM.nextInt(MAX_SERVICE - MIN_SERVICE);
        return randomServiceNumber + MIN_SERVICE;
    }
}
