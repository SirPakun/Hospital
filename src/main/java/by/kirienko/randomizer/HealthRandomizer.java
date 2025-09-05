package by.kirienko.randomizer;

public class HealthRandomizer {
    private static final int MIN_HEALTH = 1;
    private static final int MAX_HEALTH = 4;

    public static int getRandomHealth() {
        int randomHealth = Randomizer.RANDOM.nextInt(MAX_HEALTH - MIN_HEALTH);
        return randomHealth + MIN_HEALTH;
    }
}
