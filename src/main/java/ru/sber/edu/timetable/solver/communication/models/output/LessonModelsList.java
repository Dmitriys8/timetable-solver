package ru.sber.edu.timetable.solver.communication.models.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize
@Getter
public class LessonModelsList {

    @JsonProperty("lessons")
    private List<LessonModel> lessons;

    public LessonModelsList(){
        this.lessons = new ArrayList<>();
    }
}
