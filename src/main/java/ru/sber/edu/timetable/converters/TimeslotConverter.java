package ru.sber.edu.timetable.converters;

import ru.sber.edu.timetable.communication.entities.Timeslot;
import ru.sber.edu.timetable.communication.models.input.TimeslotInputModel;
import ru.sber.edu.timetable.communication.models.output.TimeslotModel;
import ru.sber.edu.timetable.enums.Days;

import java.time.LocalTime;

public class TimeslotConverter {

    public static Timeslot fromModelToEntity(TimeslotModel timeslotModel){
        if (timeslotModel == null){
            return new Timeslot();
        }
        return new Timeslot(
                timeslotModel.timeslotId,
                Days.getByName(timeslotModel.dayOfWeek),
                LocalTime.parse(timeslotModel.startTime.replace("+",".")),
                LocalTime.parse(timeslotModel.endTime.replace("+","."))
        );
    }

    public static TimeslotInputModel fromEntityToModel(Timeslot timeslot){
        return new TimeslotInputModel(
                Days.getNameByDay(timeslot.getDayOfWeek()),
                timeslot.getStartTime(),
                timeslot.getEndTime()
        );
    }
}
