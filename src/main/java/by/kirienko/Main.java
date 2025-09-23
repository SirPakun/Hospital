package by.kirienko;

import by.kirienko.entities.Cabinet;
import by.kirienko.entities.Hospital;
import by.kirienko.entities.Patient;
import by.kirienko.generator.PatientGenerator;
import by.kirienko.utils.CabinetStatistic;
import by.kirienko.utils.PatientExecutor;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Hospital hospital = Hospital.getInstance();
        hospital.addCabinet(new Cabinet());
        //hospital.addCabinet(new Cabinet());

        List<Patient> patientList = PatientGenerator.generate(15);
        PatientExecutor.execute(patientList);

        CabinetStatistic.showStatistic();

    }
}