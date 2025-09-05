package by.kirienko.randomizer;

import by.kirienko.entities.CabinetEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CabinetRandomizer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CabinetRandomizer.class.getName());

    public static CabinetEnum getRandomCabinet() {
        int bound = CabinetEnum.values().length;
        int randomIndex = Randomizer.RANDOM.nextInt(bound);

        return CabinetEnum.values()[randomIndex];
    }
}
