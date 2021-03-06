package ru.sber.edu.timetable.communication.models.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@JsonDeserialize
public class TimeslotModel {

    @JsonProperty("timeslot_id")
    public long timeslotId;

    @JsonProperty("day_of_week")
    public String dayOfWeek;

    @JsonProperty("start_time")
    public String startTime;

    @JsonProperty("end_time")
    public String endTime;

}
