package ru.sber.edu.timetable.solver;

import lombok.SneakyThrows;
import org.optaplanner.core.api.solver.SolverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sber.edu.timetable.solver.communication.communicators.TimetableCommunicator;
import ru.sber.edu.timetable.solver.persistence.TimeTableRepository;
import ru.sber.edu.timetable.solver.rest.TimeTableController;

@Component
public class Exporter implements Runnable {

    @Autowired
    TimeTableController timeTableController;

    @Autowired
    TimetableCommunicator timetableCommunicator;

    @Autowired
    TimeTableRepository timeTableRepository;

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(1000);
        while (timeTableController.getSolverStatus() == SolverStatus.SOLVING_ACTIVE){
            System.out.println("Solver is still solving");
            Thread.sleep(1000);
        }
        System.out.println("Solver have finished its work");
        System.out.println("Export is starting");
        timetableCommunicator.save(timeTableRepository.findById(1L));
        System.out.println("Export complete");
    }
}
