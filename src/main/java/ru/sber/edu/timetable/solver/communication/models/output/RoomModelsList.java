package ru.sber.edu.timetable.solver.communication.models.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonDeserialize
public class RoomModelsList {

    @JsonProperty("rooms")
    private List<RoomModel> rooms;

    public RoomModelsList(){
        rooms = new ArrayList<>();
    }
}
