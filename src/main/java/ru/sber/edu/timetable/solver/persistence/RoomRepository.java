package ru.sber.edu.timetable.solver.persistence;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import ru.sber.edu.timetable.solver.models.Room;

public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {

    @Override
    List<Room> findAll();

}
