package by.kirienko.entities;

import by.kirienko.randomizer.ServiceNumberRandomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cabinet {

    private static final Logger LOGGER = LoggerFactory.getLogger(Cabinet.class.getName());

    public final int MAX_SERVICE_NUMBER = ServiceNumberRandomizer.getRandomServiceNumber();

    private final Lock lock = new ReentrantLock();
    private AtomicBoolean isClosed = new AtomicBoolean(false);
    private AtomicInteger servicedPatients = new AtomicInteger(0);
    private AtomicInteger leavedPatients = new AtomicInteger(0);

    public Cabinet() {
    }

    public void patientTreating(Patient patient) throws InterruptedException {

        int takingTime = patient.getTakingTime();

        for (int i = 1; i < takingTime; i++) {
            Thread.sleep(1000);
            LOGGER.warn("{} is treating for {} seconds of {} seconds", this, i, takingTime);
        }
    }

    public Lock getLock(){
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
