package by.kirienko.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Patient {
    private static final Logger LOGGER = LoggerFactory.getLogger(Patient.class.getName());
    private final String name;
    private final int waitingTime;
    private final int takingTime;

    private int health;

    public Patient(String name, int waitingTime, int takingTime, int health) {
        this.name = name;
        this.waitingTime = waitingTime;
        this.takingTime = takingTime;
        this.health = health;

        LOGGER.debug("{} created", this);
    }

    public String getName() {
        return name;
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
                Objects.equals(name, patient.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, waitingTime, takingTime, health);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", waitingTime=" + waitingTime +
                ", takingTime=" + takingTime +
                ", health=" + health +
                '}';
    }
}

