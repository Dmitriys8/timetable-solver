package ru.sber.edu.timetable.solver.rest;

import ru.sber.edu.timetable.solver.communication.communicators.LessonsCommunicator;
import ru.sber.edu.timetable.solver.communication.communicators.RoomsCommunicator;
import ru.sber.edu.timetable.solver.communication.communicators.TimeslotsCommunicator;
import ru.sber.edu.timetable.solver.converters.LessonsConverter;
import ru.sber.edu.timetable.solver.converters.RoomConverter;
import ru.sber.edu.timetable.solver.converters.TimeslotConverter;
import ru.sber.edu.timetable.solver.entities.Lesson;
import ru.sber.edu.timetable.solver.entities.Room;
import ru.sber.edu.timetable.solver.entities.Timeslot;
import ru.sber.edu.timetable.solver.persistence.LessonRepository;
import ru.sber.edu.timetable.solver.persistence.RoomRepository;
import ru.sber.edu.timetable.solver.persistence.TimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/import")
public class ImportController {

    @Autowired
    RoomsCommunicator roomsCommunicator;

    @Autowired
    TimeslotsCommunicator timeslotsCommunicator;

    @Autowired
    LessonsCommunicator lessonsCommunicator;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    TimeslotRepository timeslotRepository;

    @Autowired
    LessonRepository lessonRepository;

    @PostMapping("/rooms")
    public String importRooms(){
        List<Room> rooms = roomsCommunicator.loadRooms().getRooms()
                                            .stream()
                                            .map(RoomConverter::fromModelToEntity)
                                            .collect(Collectors.toList());
        roomRepository.saveAll(rooms);
        return "success";
    }


    @PostMapping("/timeslots")
    public String importTimeslots(){
        List<Timeslot> timeslots = timeslotsCommunicator.loadTimeslots().getTimeslots()
                                                .stream()
                                                .map(TimeslotConverter::fromModelToEntity)
                                                .collect(Collectors.toList());
        timeslotRepository.saveAll(timeslots);
        return "success";
    }

    @PostMapping("/lessons")
    public String importLessons(){
        List<Lesson> lessons = lessonsCommunicator.loadLessons().getLessons()
                                                      .stream()
                                                      .map(LessonsConverter::fromModelToEntity)
                                                      .collect(Collectors.toList());
        lessons.forEach(lessonRepository::save);
        return "success";
    }

}
