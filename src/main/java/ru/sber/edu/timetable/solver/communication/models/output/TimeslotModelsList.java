package ru.sber.edu.timetable.solver.communication.models.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonDeserialize
public class TimeslotModelsList {

    @JsonProperty("timeslots")
    private List<TimeslotModel> timeslots;

    public TimeslotModelsList(){
        timeslots = new ArrayList<>();
    }
}
