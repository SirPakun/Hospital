package by.kirienko.generator;

import by.kirienko.randomizer.CabinetRandomizer;
import by.kirienko.entities.PatientThread;

import java.util.ArrayList;
import java.util.List;

public class PatientThreadGenerator {
    public static PatientThread generate(){
        return new PatientThread(PatientGenerator.generate(), CabinetRandomizer.getRandomCabinet());
    }

    public static List<PatientThread> generate(int amount){
        List<PatientThread> patientThreads = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            patientThreads.add(generate());
        }

        return patientThreads;
    }
}
