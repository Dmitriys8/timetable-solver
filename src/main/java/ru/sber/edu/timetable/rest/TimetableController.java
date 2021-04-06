package ru.sber.edu.timetable.rest;

import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.edu.timetable.communication.communicators.TimetableCommunicator;

@RestController
@RequestMapping("/timetable")
public class TimetableController {

    @Autowired
    SolverManager solverManager;
    @Autowired
    private TimetableCommunicator timetableCommunicator;

    @PostMapping("/solve")
    public void solve() {
        solverManager.solveAndListen(1L,
                timetableCommunicator::findById,
                timetableCommunicator::save);
    }
}
