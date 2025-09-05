package by.kirienko;

import by.kirienko.utils.CabinetStatistic;
import by.kirienko.generator.PatientGenerator;
import by.kirienko.utils.PatientThreadExecutor;
import by.kirienko.generator.PatientThreadGenerator;
import by.kirienko.entities.CabinetEnum;
import by.kirienko.entities.PatientThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class Main {

    public static void main(String[] args){
        List<PatientThread> patientThreadList = PatientThreadGenerator.generate(100);
        PatientThreadExecutor.execute(patientThreadList);

        CabinetStatistic.showStatistic();

    }

    private static void testMain(){
        PatientThread thread1 = new PatientThread(PatientGenerator.generate(), CabinetEnum.FIRST_CABINET);
        PatientThread thread2 = new PatientThread(PatientGenerator.generate(), CabinetEnum.FIRST_CABINET);
        PatientThread thread3 = new PatientThread(PatientGenerator.generate(), CabinetEnum.FIRST_CABINET);

        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.warn("asdasdsadasd");

        System.out.println("thread1 : " + thread1.getPatient());
        System.out.println("thread2 : " + thread2.getPatient());
        System.out.println("thread3 : " + thread3.getPatient());

        System.out.println("thread1 cabinet : " + thread1.getCabinet());
        System.out.println("thread2 cabinet : " + thread2.getCabinet());
        System.out.println("thread3 cabinet : " + thread3.getCabinet());

        thread1.start();
        thread2.start();
        thread3.start();

    }

}