package by.kirienko.utils;

import by.kirienko.entities.PatientThread;

import java.util.List;

public class PatientThreadExecutor {
    public static void execute(List<PatientThread> patientThreadList) {
        for (PatientThread patientThread : patientThreadList) {
            patientThread.start();
        }

        for (PatientThread patientThread : patientThreadList) {
            try {
                patientThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
