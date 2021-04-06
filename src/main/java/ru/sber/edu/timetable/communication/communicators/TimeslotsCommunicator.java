package ru.sber.edu.timetable.communication.communicators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.sber.edu.timetable.Constants;
import ru.sber.edu.timetable.communication.models.input.TimeslotInputModel;
import ru.sber.edu.timetable.communication.models.output.TimeslotModelsList;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
public class TimeslotsCommunicator {

    @Autowired
    HttpServletRequest request;

    private static final String REQUEST_URI = Constants.HASURA_API_PATH + Constants.TIMESLOTS_PATH;

    RestTemplate restTemplate;

    public TimeslotsCommunicator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public TimeslotModelsList loadTimeslots(){
        HttpEntity entity;
        try {
            entity = new HttpEntity(getCurrentHeaders());
        } catch (Exception e) {
            System.out.println("Current request is undefined. Using headers by hardcode");
            entity = new HttpEntity(configureHeaders());
        }
        TimeslotModelsList response = restTemplate.exchange(
                REQUEST_URI,
                HttpMethod.GET,
                entity,
                TimeslotModelsList.class
        ).getBody();
        return response;
    }

    public String createTimeslot(
            TimeslotInputModel timeslotInputModel
    ){
        HttpEntity entity;
        try {
            entity = new HttpEntity(
                    timeslotInputModel,
                    getCurrentHeaders()
            );
        } catch (Exception e){
            System.out.println("Current request is undefined. Using headers by hardcode");
            entity = new HttpEntity(
                    timeslotInputModel,
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
