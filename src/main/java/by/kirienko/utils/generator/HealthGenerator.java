package by.kirienko.utils.generator;

import by.kirienko.utils.Randomizer;

public class HealthGenerator {
    private static int MIN_HEALTH = 1;
    private static int MAX_HEALTH = 4;

    public static int getRandomHealth() {
        int randomHealth = Randomizer.RANDOM.nextInt(MAX_HEALTH - MIN_HEALTH);
        return randomHealth + MIN_HEALTH;
    }
}
