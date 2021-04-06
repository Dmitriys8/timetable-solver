package ru.sber.edu.timetable.communication.models.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LessonInputModel {

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("teacher")
    private String teacher;

    @JsonProperty("student_group")
    private String studentGroup;

    @JsonProperty("room_id")
    private long roomId;

    @JsonProperty("timeslot_id")
    private long timeslotId;
}
