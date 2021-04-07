package ru.sber.edu.timetable.converters;

import ru.sber.edu.timetable.communication.entities.Room;
import ru.sber.edu.timetable.communication.entities.Timeslot;
import ru.sber.edu.timetable.communication.models.input.RoomInputModel;
import ru.sber.edu.timetable.communication.models.output.RoomModel;
import ru.sber.edu.timetable.communication.models.output.TimeslotModel;
import ru.sber.edu.timetable.enums.Days;

import java.time.LocalTime;

public class RoomConverter {

    public static Room fromModelToEntity(RoomModel roomModel){
        if (roomModel == null){
            return new Room();
        }
        return new Room(
                roomModel.getRoomId(),
                roomModel.getName()
        );
    }

    public static RoomInputModel fromEntityToModel(Room room){
        return new RoomInputModel(
                room.getName()
        );
    }
}
