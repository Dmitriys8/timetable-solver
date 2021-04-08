package ru.sber.edu.timetable.solver;

import com.github.javaparser.utils.Log;
import lombok.SneakyThrows;
import org.optaplanner.core.api.solver.SolverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sber.edu.timetable.solver.communication.communicators.TimetableCommunicator;
import ru.sber.edu.timetable.solver.persistence.TimeTableRepository;
import ru.sber.edu.timetable.solver.rest.TimeTableController;

import java.io.Console;

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
        System.out.println("Solver have finished his work");
        System.out.println("Start export");
        timetableCommunicator.save(timeTableRepository.findById(1L));
        System.out.println("Export completed");
    }
}
