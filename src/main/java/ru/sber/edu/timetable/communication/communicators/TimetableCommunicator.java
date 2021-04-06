package ru.sber.edu.timetable.communication.communicators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sber.edu.timetable.communication.entities.Lesson;
import ru.sber.edu.timetable.communication.entities.Room;
import ru.sber.edu.timetable.communication.entities.TimeTable;
import ru.sber.edu.timetable.communication.entities.Timeslot;
import ru.sber.edu.timetable.converters.LessonsConverter;
import ru.sber.edu.timetable.converters.RoomConverter;
import ru.sber.edu.timetable.converters.TimeslotConverter;

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

    public void save(Object timeTable) {
        for (Lesson lesson : ((TimeTable) timeTable).getLessonList()) {
            // TODO this is awfully naive: optimistic locking causes issues if called by the SolverManager
            lessonsCommunicator.createLesson(LessonsConverter.fromEntityToModel(lesson));
        }
    }

}
