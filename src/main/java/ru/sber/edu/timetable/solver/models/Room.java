package ru.sber.edu.timetable.solver.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.optaplanner.core.api.domain.lookup.PlanningId;

@Entity
public class Room {

    @PlanningId
    @Id @GeneratedValue
    private Long id;

    private Long foreignId;

    private String name;

    // No-arg constructor required for Hibernate
    public Room() {
    }

    public Room(Long foreignId, String name) {
        this.foreignId = foreignId;
        this.name = name.trim();
    }

    public Room(long id, long foreignId, String name) {
        this(foreignId, name);
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

    // ************************************************************************
    // Getters and setters
    // ************************************************************************

    public Long getId() {
        return id;
    }

    public Long getForeignId() {
        return foreignId;
    }

    public String getName() {
        return name;
    }

}
