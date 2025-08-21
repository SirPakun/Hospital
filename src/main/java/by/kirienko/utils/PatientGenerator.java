package by.kirienko.utils;

import by.kirienko.utils.generator.HealthGenerator;
import by.kirienko.utils.generator.NameGenerator;
import by.kirienko.utils.generator.TakingTimeGenerator;
import by.kirienko.utils.generator.WaitingTimeGenerator;
import entities.Patient;

import java.util.Scanner;

public class PatientGenerator {
    public static Patient generate(){
        String name = NameGenerator.getRandomName();
        int waitingTime = WaitingTimeGenerator.getRandomWaitingTime();
        int takingTime = TakingTimeGenerator.getRandomTakingTime();
        int health = HealthGenerator.getRandomHealth();

        return new Patient(name,waitingTime,takingTime,health);
    }
}
