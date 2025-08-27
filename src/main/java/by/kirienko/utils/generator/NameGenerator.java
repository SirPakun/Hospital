package by.kirienko.utils.generator;

import by.kirienko.utils.Randomizer;
import by.kirienko.utils.enums.NameEnum;

public class NameGenerator {
    public static String getRandomName() {
        int bound = NameEnum.values().length;
        int randomIndex = Randomizer.RANDOM.nextInt(bound);

        return NameEnum.values()[randomIndex].getName();
    }
}
