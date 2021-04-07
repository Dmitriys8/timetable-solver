package ru.sber.edu.timetable.communication.models.input;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LessonUpdateModel {

    @JsonIgnore
    private long lessonId;

    @JsonProperty("room_id")
    private long roomId;

    @JsonProperty("timeslot_id")
    private long timeslotId;
}
