/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.sber.edu.timetable.solver.models;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.optaplanner.core.api.domain.lookup.PlanningId;

@Entity
public class Timeslot {

    @PlanningId
    @Id @GeneratedValue
    private Long id;

    private Long foreignId;

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    // No-arg constructor required for Hibernate
    public Timeslot() {
    }

    public Timeslot(Long foreignId, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.foreignId = foreignId;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Timeslot(long id, long foreignId, DayOfWeek dayOfWeek, LocalTime startTime) {
        this(foreignId, dayOfWeek, startTime, startTime.plusMinutes(50));
        this.id = id;
    }

    public Timeslot(long id, Long foreignId, DayOfWeek dayOfWeek, LocalTime startTime,  LocalTime endTime) {
        this(foreignId, dayOfWeek, startTime, endTime);
        this.id = id;
    }

    @Override
    public String toString() {
        return dayOfWeek + " " + startTime;
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

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

}