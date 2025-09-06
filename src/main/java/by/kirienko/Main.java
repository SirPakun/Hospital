package by.kirienko;

import by.kirienko.utils.CabinetStatistic;
import by.kirienko.utils.PatientThreadExecutor;
import by.kirienko.generator.PatientThreadGenerator;
import by.kirienko.entities.PatientThread;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<PatientThread> patientThreadList = PatientThreadGenerator.generate(100);
        PatientThreadExecutor.execute(patientThreadList);

        CabinetStatistic.showStatistic();

    }
}