package by.kirienko.utils.generator;

import by.kirienko.utils.Randomizer;
import entities.CabinetEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CabinetGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CabinetGenerator.class.getName());

    public static CabinetEnum getRandomCabinet() {
        int bound = CabinetEnum.values().length;
        int randomIndex = Randomizer.RANDOM.nextInt(bound);

        return CabinetEnum.values()[randomIndex];
    }
}
