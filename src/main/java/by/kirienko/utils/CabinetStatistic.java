package by.kirienko.utils;

import by.kirienko.entities.Cabinet;
import by.kirienko.entities.Hospital;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CabinetStatistic {

    private static final Logger LOGGER = LoggerFactory.getLogger(CabinetStatistic.class);

    public static void showStatistic() {
        for (Cabinet cabinet : Hospital.getInstance().getCabinets()) {
            LOGGER.info(cabinet.toString());
        }
    }
}
