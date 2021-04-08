package ru.sber.edu.timetable.solver.communication.models.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@JsonDeserialize
@NoArgsConstructor
public class RoomInputModel {

    @JsonProperty("roomName")
    private String roomName;
}
