package ru.sber.edu.timetable.solver.communication.communicators;

import ru.sber.edu.timetable.solver.Constants;
import ru.sber.edu.timetable.solver.communication.models.input.RoomInputModel;
import ru.sber.edu.timetable.solver.communication.models.output.RoomModelsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
public class RoomsCommunicator {

    @Autowired
    HttpServletRequest request;

    private static final String REQUEST_URI = Constants.HASURA_API_PATH + Constants.ROOMS_PATH;

    RestTemplate restTemplate;

    public RoomsCommunicator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public RoomModelsList loadRooms(){
        HttpEntity entity;
        try {
            entity = new HttpEntity(getCurrentHeaders());
            if (entity.getHeaders().getFirst("X-Hasura-admin-secret") == null){
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Current request is undefined. Using headers by hardcode");
            entity = new HttpEntity(configureHeaders());
        }
        RoomModelsList response = restTemplate.exchange(
                REQUEST_URI,
                HttpMethod.GET,
                entity,
                RoomModelsList.class
        ).getBody();
        return response;
    }

    public String createRoom(
            RoomInputModel roomInputModel
    ){
        HttpEntity entity;
        try {
            entity = new HttpEntity(
                    roomInputModel,
                    getCurrentHeaders());
        } catch (Exception e) {
            entity = new HttpEntity(
                    roomInputModel,
                    configureHeaders()
            );
        }
        ResponseEntity response = restTemplate.exchange(
                REQUEST_URI,
                HttpMethod.PUT,
                entity,
                String.class
        );
        return response.getBody().toString();
    }

    private HttpHeaders getCurrentHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            httpHeaders.add(key, value);
        }
        return httpHeaders;
    }

    private HttpHeaders configureHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setConnection("keep-alive");
        httpHeaders.add("X-Hasura-admin-secret", "L5ZalprIfFwo7CzSVyRiv9nTO40lD3KGm6q46iqJxnpVkeoeW4HIo03RJk1uwDRH");
        return httpHeaders;
    }
}
