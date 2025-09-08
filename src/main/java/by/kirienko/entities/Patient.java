package by.kirienko.entities;

import by.kirienko.exceptions.NoSuchCabinetException;
import by.kirienko.randomizer.CabinetRandomizer;
import by.kirienko.randomizer.HealthRandomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Patient extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(Patient.class.getName());

    private final String patientName;
    private final int waitingTime;
    private final int takingTime;

    private int health;

    public Patient(String name, int waitingTime, int takingTime, int health) {
        this.patientName = name;
        this.waitingTime = waitingTime;
        this.takingTime = takingTime;
        this.health = health;

        LOGGER.debug("{} created", this);
    }

    @Override
    public void run() {

        boolean lockAcquired = false;
        Cabinet cabinet = null;

        try {
            cabinet = CabinetRandomizer.getRandomCabinet();
            lockAcquired = cabinet.getLock().tryLock(waitingTime, TimeUnit.SECONDS);

            if (lockAcquired) {

                if (!cabinet.isClosed().get()) {

                    LOGGER.info("{} just came in cabinet for {} seconds", this, this.takingTime);

                    cabinet.patientTreating(this);

                    int newHealth = HealthRandomizer.getRandomHealth();
                    this.setHealth(newHealth);

                    cabinet.enlargeServicedPatients();

                    LOGGER.info("{} just left the cabinet with {} HP", this, this.health);

                    if (cabinet.getServicedPatients().get() == cabinet.MAX_SERVICE_NUMBER) {
                        cabinet.close();
                    }

                } else {
                    cabinet.enlargeLeavedPatients();
                    LOGGER.info("{} is closed", cabinet);
                }
            } else {
                cabinet.enlargeLeavedPatients();
                LOGGER.info("{} is done to wait", this);
            }

        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            LOGGER.error("Thread was interrupted while waiting for patient thread");
        } catch (NoSuchCabinetException exception) {
            LOGGER.error(exception.getMessage());
        } finally {
            if (lockAcquired) {
                cabinet.getLock().unlock();
            }

        }

    }

    public String getPatientName() {
        return patientName;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public int getTakingTime() {
        return takingTime;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return waitingTime == patient.waitingTime &&
                takingTime == patient.takingTime &&
                health == patient.health &&
                Objects.equals(patientName, patient.patientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientName, waitingTime, takingTime, health);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientName='" + patientName + '\'' +
                ", waitingTime=" + waitingTime +
                ", takingTime=" + takingTime +
                ", health=" + health +
                '}';
    }
}

