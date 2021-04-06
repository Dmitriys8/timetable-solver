package ru.sber.edu.timetable.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.edu.timetable.communication.communicators.TimeslotsCommunicator;
import ru.sber.edu.timetable.communication.models.input.TimeslotInputModel;
import ru.sber.edu.timetable.communication.models.output.TimeslotModelsList;

@RestController
@RequestMapping("/timeslots")
public class TimeslotsController {

    @Autowired
    TimeslotsCommunicator timeslotsCommunicator;

    @GetMapping
    public TimeslotModelsList getTimeslots(){
        return timeslotsCommunicator.loadTimeslots();
    }

    @PutMapping
    public String createTimeslot(
            @RequestBody TimeslotInputModel timeslotInputModel
    ){
        return timeslotsCommunicator.createTimeslot(
                timeslotInputModel
        );
    }
}
