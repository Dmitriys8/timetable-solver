package ru.sber.edu.timetable.solver.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
@Entity
public class Lesson {

    @PlanningId
    @Id @GeneratedValue
    private Long id;

    private Long foreignId;

    private String subject;
    private String teacher;
    private String studentGroup;

    @PlanningVariable(valueRangeProviderRefs = "timeslotRange")
    @ManyToOne(cascade = CascadeType.ALL)
    private Timeslot timeslot;

    @PlanningVariable(valueRangeProviderRefs = "roomRange")
    @ManyToOne(cascade = CascadeType.ALL)
    private Room room;

    // No-arg constructor required for Hibernate and OptaPlanner
    public Lesson() {
    }

    public Lesson(long foreignId, String subject, String teacher, String studentGroup) {
        this.foreignId = foreignId;
        this.subject = subject.trim();
        this.teacher = teacher.trim();
        this.studentGroup = studentGroup.trim();
    }

    public Lesson(long id, long foreignId, String subject, String teacher, String studentGroup, Timeslot timeslot, Room room) {
        this(foreignId, subject, teacher, studentGroup);
        this.id = id;
        this.timeslot = timeslot;
        this.room = room;
    }

    @Override
    public String toString() {
        return subject + "(" + id + ")";
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

    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
