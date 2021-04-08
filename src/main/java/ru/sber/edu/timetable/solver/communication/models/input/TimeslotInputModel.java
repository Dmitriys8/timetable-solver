package ru.sber.edu.timetable.solver.communication.models.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@JsonDeserialize
@AllArgsConstructor
public class TimeslotInputModel {

    @JsonProperty("day_of_week")
    private String dayOfWeek;

    @JsonProperty("start_time")
    private LocalTime startTime;

    @JsonProperty("end_time")
    private LocalTime endTime;

}
