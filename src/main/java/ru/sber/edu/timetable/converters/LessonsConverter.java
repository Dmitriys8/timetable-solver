package ru.sber.edu.timetable.converters;

import ru.sber.edu.timetable.communication.entities.Lesson;
import ru.sber.edu.timetable.communication.models.input.LessonInputModel;
import ru.sber.edu.timetable.communication.models.input.LessonUpdateModel;
import ru.sber.edu.timetable.communication.models.output.LessonModel;

public class LessonsConverter {

    public static Lesson fromModelToEntity(LessonModel lessonModel){
        return new Lesson(
                lessonModel.getLessonId(),
                lessonModel.getSubject(),
                lessonModel.getTeacher(),
                lessonModel.getStudentGroup(),
                TimeslotConverter.fromModelToEntity(lessonModel.getTimeslot()),
                RoomConverter.fromModelToEntity(lessonModel.getRoom())
        );
    }

    public static LessonInputModel fromEntityToModel(Lesson lesson){
        return new LessonInputModel (
                lesson.getSubject(),
                lesson.getTeacher(),
                lesson.getStudentGroup(),
                lesson.getRoom().getId(),
                lesson.getTimeslot().getId()
        );
    }

    public static LessonUpdateModel fromEntityToUpdateModel(Lesson lesson){
        return new LessonUpdateModel(
                lesson.getId(),
                lesson.getRoom().getId(),
                lesson.getTimeslot().getId()
        );
    }

}
