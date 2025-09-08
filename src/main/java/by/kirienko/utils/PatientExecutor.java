package by.kirienko.utils;

import by.kirienko.entities.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PatientExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientExecutor.class.getName());

    public static void execute(List<Patient> patientList) {
        for (Patient patient : patientList) {
            patient.start();
        }

        for (Patient patient : patientList) {
            try {
                patient.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.error("Thread was interrupted while waiting for patient thread");
            }
        }
    }
}
