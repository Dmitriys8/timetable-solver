package ru.sber.edu.timetable.communication.models.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonDeserialize
public class TimeslotModelsList {

    @JsonProperty("timeslots")
    private List<TimeslotModel> timeslots;

    public TimeslotModelsList(){
        timeslots = new ArrayList<>();
    }
}
