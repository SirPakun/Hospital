package by.kirienko.generator;

import by.kirienko.randomizer.HealthRandomizer;
import by.kirienko.randomizer.NameRandomizer;
import by.kirienko.randomizer.TakingTimeRandomizer;
import by.kirienko.randomizer.WaitingTimeRandomizer;
import by.kirienko.entities.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PatientGenerator {
    public static Patient generate() {
        String name = NameRandomizer.getRandomName();
        int waitingTime = WaitingTimeRandomizer.getRandomWaitingTime();
        int takingTime = TakingTimeRandomizer.getRandomTakingTime();
        int health = HealthRandomizer.getRandomHealth();

        return new Patient(name, waitingTime, takingTime, health);
    }

    public static List<Patient> generate(int amount) {
        List<Patient> patients = Stream
                .generate(PatientGenerator::generate)
                .limit(amount)
                .collect(Collectors.toList());

        return patients;
    }
}
