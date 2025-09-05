package by.kirienko.randomizer;

import by.kirienko.utils.enums.NameEnum;

public class NameRandomizer {
    public static String getRandomName() {
        int bound = NameEnum.values().length;
        int randomIndex = Randomizer.RANDOM.nextInt(bound);

        return NameEnum.values()[randomIndex].getName();
    }
}
