package ru.sber.edu.timetable.solver.converters;


import ru.sber.edu.timetable.solver.communication.models.input.LessonInputModel;
import ru.sber.edu.timetable.solver.communication.models.input.LessonUpdateModel;
import ru.sber.edu.timetable.solver.communication.models.output.LessonModel;
import ru.sber.edu.timetable.solver.entities.Lesson;

public class LessonsConverter {

    public static Lesson fromModelToEntity(LessonModel lessonModel){
        return new Lesson(
                lessonModel.getLessonId(),
                lessonModel.getSubject(),
                lessonModel.getTeacher(),
                lessonModel.getStudentGroup()
                //TimeslotConverter.fromModelToEntity(lessonModel.getTimeslot()),
                //RoomConverter.fromModelToEntity(lessonModel.getRoom())
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
                lesson.getForeignId(),
                lesson.getRoom().getForeignId(),
                lesson.getTimeslot().getForeignId()
        );
    }

}
