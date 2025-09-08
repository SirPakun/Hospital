package by.kirienko.randomizer;

import by.kirienko.entities.Cabinet;
import by.kirienko.entities.Hospital;
import by.kirienko.exceptions.NoSuchCabinetException;

public class CabinetRandomizer {

    public static Cabinet getRandomCabinet() {
        int amountOfCabinets = Hospital.getInstance().getCabinets().size();

        if (amountOfCabinets == 0) throw new NoSuchCabinetException("There is no cabinets in hospital");

        int randomIndex = Randomizer.RANDOM.nextInt(amountOfCabinets);

        Cabinet randomCabinet = Hospital.getInstance().getCabinets().get(randomIndex);

        return randomCabinet;
    }
}
