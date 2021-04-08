package ru.sber.edu.timetable.solver.converters;

import ru.sber.edu.timetable.solver.communication.models.input.RoomInputModel;
import ru.sber.edu.timetable.solver.communication.models.output.RoomModel;
import ru.sber.edu.timetable.solver.entities.Room;

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
