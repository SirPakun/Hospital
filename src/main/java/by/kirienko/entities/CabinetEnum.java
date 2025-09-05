package by.kirienko.entities;

import by.kirienko.randomizer.ServiceNumberRandomizer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public enum CabinetEnum {
    FIRST_CABINET(new ReentrantLock()),
    SECOND_CABINET(new ReentrantLock()),
    THIRD_CABINET(new ReentrantLock());

    private final Lock lock;
    private final int maxServiceNumber = ServiceNumberRandomizer.getRandomServiceNumber();
    private int servicedPatients = 0;
    private int leavedPatients = 0;

    CabinetEnum(Lock lock) {
        this.lock = lock;
    }

    public Lock getLock() {
        return lock;
    }

    public int getMaxServiceNumber() {
        return maxServiceNumber;
    }

    public int getServicedPatients() {
        return servicedPatients;
    }

    public void enlargeServicedPatients() {
        this.servicedPatients++;
    }

    public int getLeavedPatients() {
        return leavedPatients;
    }

    public void enlargeLeavedPatients() {
        this.leavedPatients++;
    }

    public boolean isCabinetClosed() {
        return servicedPatients==maxServiceNumber;
    }
}
