package ru.sber.edu.timetable.solver.persistence;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import ru.sber.edu.timetable.solver.entities.Lesson;

public interface LessonRepository extends PagingAndSortingRepository<Lesson, Long> {

    @Override
    List<Lesson> findAll();

}
