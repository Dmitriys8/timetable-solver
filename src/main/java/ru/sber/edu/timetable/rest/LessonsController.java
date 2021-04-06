package ru.sber.edu.timetable.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.edu.timetable.communication.communicators.LessonsCommunicator;
import ru.sber.edu.timetable.communication.models.input.LessonInputModel;
import ru.sber.edu.timetable.communication.models.output.LessonModelsList;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    @Autowired
    LessonsCommunicator lessonsCommunicator;

    @GetMapping
    public LessonModelsList getLessons(){
        return lessonsCommunicator.loadLessons();
    }

    @PutMapping
    public String createLesson(
            @RequestBody LessonInputModel lessonInputModel
    ){
        return lessonsCommunicator.createLesson(lessonInputModel);
    }
}
