package by.kirienko.utils;

import by.kirienko.entities.CabinetEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CabinetStatistic {
    private static final Logger LOGGER = LoggerFactory.getLogger(CabinetStatistic.class);

    public static void showStatistic() {
        for (CabinetEnum cabinetEnum : CabinetEnum.values()) {
            LOGGER.info("Cabinet {}, max patient : {}; serviced patients : {}; leaved patients : {}",
                    cabinetEnum.name(), cabinetEnum.getMaxServiceNumber(),
                    cabinetEnum.getServicedPatients(), cabinetEnum.getLeavedPatients());
        }
    }
}
