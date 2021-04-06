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
public class RoomModel {

    @JsonProperty("room_id")
    private long roomId;

    @JsonProperty("name")
    private String name;
}
