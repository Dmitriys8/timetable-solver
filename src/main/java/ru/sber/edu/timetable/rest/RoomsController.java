package ru.sber.edu.timetable.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.edu.timetable.communication.communicators.RoomsCommunicator;
import ru.sber.edu.timetable.communication.models.input.RoomInputModel;
import ru.sber.edu.timetable.communication.models.output.RoomModelsList;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

    @Autowired
    RoomsCommunicator roomsCommunicator;

    @GetMapping
    public RoomModelsList getRooms(){
        return roomsCommunicator.loadRooms();
    }

    @PutMapping
    public String createRoom(
            @RequestBody RoomInputModel roomInputModel
    ){
        return roomsCommunicator.createRoom(roomInputModel);
    }

}
