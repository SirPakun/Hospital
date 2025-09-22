package by.kirienko.entities;

import java.util.*;

public class Hospital {
    private static final Hospital HOSPITAL = new Hospital();
    private final List<Cabinet> cabinets;

    private Hospital() {
        this.cabinets = new ArrayList<>();
    }

    public static Hospital getInstance() {
        return HOSPITAL;
    }

    public List<Cabinet> getCabinets() {
        return cabinets;
    }

    public void addCabinet(Cabinet cabinet) {
        cabinets.add(cabinet);
    }

    public void addCabinets(Cabinet... cabinets) {
        List<Cabinet> cabinetsList = Arrays.stream(cabinets).toList();
        this.cabinets.addAll(cabinetsList);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(cabinets, hospital.cabinets);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cabinets);
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "cabinets=" + cabinets +
                '}';
    }
}
