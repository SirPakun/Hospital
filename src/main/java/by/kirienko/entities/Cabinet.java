package by.kirienko.entities;

import by.kirienko.randomizer.HealthRandomizer;
import by.kirienko.randomizer.ServiceNumberRandomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cabinet {

    private static final Logger LOGGER = LoggerFactory.getLogger(Cabinet.class.getName());

    public final int MAX_SERVICE_NUMBER = ServiceNumberRandomizer.getRandomServiceNumber();

    private final Lock lock;
    private AtomicBoolean isClosed;
    private AtomicInteger servicedPatients;
    private AtomicInteger leavedPatients;

    public Cabinet() {
        this.lock = new ReentrantLock();
        this.isClosed = new AtomicBoolean(false);
        this.servicedPatients = new AtomicInteger(0);
        this.leavedPatients = new AtomicInteger(0);
    }

    public void patientTreating(Patient patient) throws InterruptedException {

        int takingTime = patient.getTakingTime();

        for (int i = 1; i < takingTime; i++) {
            Thread.sleep(1000);
            LOGGER.warn("{} is treating for {} seconds of {} seconds", this, i, takingTime);
        }
    }

    public void enterCabinet(Patient patient) {
        try {

            if (getLock().tryLock(patient.getWaitingTime(), TimeUnit.SECONDS)) {

                if (!isClosed.get()) {

                    LOGGER.info("{} just came in cabinet for {} seconds",
                            patient.getPatientName(),
                            patient.getTakingTime());

                    patientTreating(patient);

                    int newHealth = HealthRandomizer.getRandomHealth();
                    patient.setHealth(newHealth);

                    enlargeServicedPatients();

                    LOGGER.info("{} just left the cabinet with {} HP",
                            patient.getPatientName(),
                            patient.getHealth());

                    if (getServicedPatients().get() == MAX_SERVICE_NUMBER) {
                        close();
                    }

                } else {
                    enlargeLeavedPatients();
                    LOGGER.info("{} is closed", this);
                }
            } else {
                enlargeLeavedPatients();
                LOGGER.info("{} is done to wait", patient.getPatientName());
            }
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            LOGGER.error("Thread was interrupted while waiting for patient thread");
        } finally {
            lock.unlock();
        }
    }

    public Lock getLock() {
        return lock;
    }

    public AtomicBoolean isClosed() {
        return isClosed;
    }

    public void close() {
        this.isClosed.set(true);
    }

    public AtomicInteger getServicedPatients() {
        return servicedPatients;
    }

    public void enlargeServicedPatients() {
        this.servicedPatients.incrementAndGet();
    }

    public AtomicInteger getLeavedPatients() {
        return leavedPatients;
    }

    public void enlargeLeavedPatients() {
        this.leavedPatients.incrementAndGet();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cabinet cabinet = (Cabinet) o;
        return MAX_SERVICE_NUMBER == cabinet.MAX_SERVICE_NUMBER
                && Objects.equals(lock, cabinet.lock)
                && Objects.equals(isClosed, cabinet.isClosed)
                && Objects.equals(servicedPatients, cabinet.servicedPatients)
                && Objects.equals(leavedPatients, cabinet.leavedPatients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MAX_SERVICE_NUMBER, lock, isClosed, servicedPatients, leavedPatients);
    }

    @Override
    public String toString() {
        return "Cabinet{" +
                "MAX_SERVICE_NUMBER=" + MAX_SERVICE_NUMBER +
                ", isClosed=" + isClosed +
                ", servicedPatients=" + servicedPatients +
                ", leavedPatients=" + leavedPatients +
                '}';
    }
}
