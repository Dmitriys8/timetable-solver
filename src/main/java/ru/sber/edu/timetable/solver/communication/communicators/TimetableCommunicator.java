package ru.sber.edu.timetable.solver.communication.communicators;


import ru.sber.edu.timetable.solver.converters.LessonsConverter;
import ru.sber.edu.timetable.solver.converters.RoomConverter;
import ru.sber.edu.timetable.solver.converters.TimeslotConverter;
import ru.sber.edu.timetable.solver.entities.Lesson;
import ru.sber.edu.timetable.solver.entities.Room;
import ru.sber.edu.timetable.solver.entities.TimeTable;
import ru.sber.edu.timetable.solver.entities.Timeslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TimetableCommunicator {

    @Autowired
    LessonsCommunicator lessonsCommunicator;

    @Autowired
    RoomsCommunicator roomsCommunicator;

    @Autowired
    TimeslotsCommunicator timeslotsCommunicator;

    public TimeTable findById(Object id) {
        System.out.println(id);
        final List<Timeslot> timeslots = timeslotsCommunicator.loadTimeslots().getTimeslots()
                                                              .stream()
                                                              .map(TimeslotConverter::fromModelToEntity)
                                                              .collect(Collectors.toList());
        final List<Room> rooms = roomsCommunicator.loadRooms().getRooms()
                                                  .stream()
                                                  .map(RoomConverter::fromModelToEntity)
                                                  .collect(Collectors.toList());
        final List<Lesson> lessons = lessonsCommunicator.loadLessons().getLessons()
                                                        .stream()
                                                        .map(LessonsConverter::fromModelToEntity)
                                                        .collect(Collectors.toList());
        return new TimeTable(
                timeslots,
                rooms,
                lessons
        );
    }

    public void save(TimeTable timeTable) {
        try {
            for (Lesson lesson : timeTable.getLessonList()) {
                // TODO this is awfully naive: optimistic locking causes issues if called by the SolverManager
                lessonsCommunicator.updateLesson(LessonsConverter.fromEntityToUpdateModel(lesson));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
