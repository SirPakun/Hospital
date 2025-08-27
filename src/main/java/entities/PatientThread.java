package entities;

import by.kirienko.utils.generator.HealthGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class PatientThread extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientThread.class);
    private Patient patient;
    private CabinetEnum cabinet;

    public PatientThread(Patient patient, CabinetEnum cabinet) {
        this.patient = patient;
        this.cabinet = cabinet;
    }

    @Override
    public void run() {
        try {
            if (!cabinet.isCabinetClosed()) {
                if (cabinet.getLock().tryLock(patient.getWaitingTime(), TimeUnit.SECONDS)) {
                    LOGGER.info("{} just came in {} for {} seconds", patient, cabinet.name(), patient.getTakingTime());

                    try {
                        Thread.sleep(patient.getTakingTime() * 1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    patient.setHealth(HealthGenerator.getRandomHealth());

                    LOGGER.info("{} finished", patient);
                    cabinet.enlargeServicedPatients();
                    LOGGER.debug("{} serviced patients : {}", cabinet.name(), cabinet.getServicedPatients());
                    cabinet.getLock().unlock();
                } else {
                    LOGGER.info("Patient {} is out", patient);
                    cabinet.enlargeLeavedPatients();
                    LOGGER.debug("{} leaved patients : {}", cabinet.name(), cabinet.getLeavedPatients());
                }
            } else {
                LOGGER.debug("{} is closed", cabinet.name());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public CabinetEnum getCabinet() {
        return cabinet;
    }

    public Patient getPatient() {
        return patient;
    }
}
