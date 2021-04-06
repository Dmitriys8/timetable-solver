package ru.sber.edu.timetable.communication.models.output;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonDeserialize
@Getter
public class LessonModel {

    @JsonProperty("lesson_id")
    private Long lessonId;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("teacher")
    private String teacher;

    @JsonProperty("student_group")
    private String studentGroup;

    @JsonProperty("room")
    private RoomModel room;

    @JsonProperty("timeslot")
    private TimeslotModel timeslot;

}
