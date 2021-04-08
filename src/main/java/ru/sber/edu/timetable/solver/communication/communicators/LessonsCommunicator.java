package ru.sber.edu.timetable.solver.communication.communicators;

import ru.sber.edu.timetable.solver.Constants;
import ru.sber.edu.timetable.solver.communication.models.input.LessonInputModel;
import ru.sber.edu.timetable.solver.communication.models.input.LessonUpdateModel;
import ru.sber.edu.timetable.solver.communication.models.output.LessonModelsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
public class LessonsCommunicator {

    @Autowired
    HttpServletRequest request;

    private static final String REQUEST_URI = Constants.HASURA_API_PATH + Constants.LESSONS_PATH;

    private HttpHeaders httpHeaders;
    private RestTemplate restTemplate;

    public LessonsCommunicator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public LessonModelsList loadLessons() {
        HttpEntity entity;
        try {
            entity = new HttpEntity(getCurrentHeaders());
        } catch (Exception e) {
            entity = new HttpEntity(configureHeaders());
        }
        LessonModelsList response = restTemplate.exchange(
                REQUEST_URI,
                HttpMethod.GET,
                entity,
                LessonModelsList.class
        ).getBody();
        return response;
    }

    public String createLesson(LessonInputModel lessonInputModel){
        HttpEntity entity;
        try {
            entity = new HttpEntity(
                    lessonInputModel,
                    getCurrentHeaders()
            );
        } catch (Exception e){
            entity = new HttpEntity(
                    lessonInputModel,
                    configureHeaders()
            );
        }
        String response = restTemplate.exchange(
                REQUEST_URI,
                HttpMethod.PUT,
                entity,
                String.class
        ).getBody();
        return response;
    }

    public String updateLesson(LessonUpdateModel lessonUpdateModel){
        HttpEntity entity;
        try {
            entity = new HttpEntity(
                    lessonUpdateModel,
                    getCurrentHeaders()
            );
        } catch (Exception e){
            entity = new HttpEntity(
                    lessonUpdateModel,
                    configureHeaders()
            );
        }
        String response = restTemplate.exchange(
                REQUEST_URI + "/" + lessonUpdateModel.getLessonId(),
                HttpMethod.POST,
                entity,
                String.class
        ).getBody();
        return response;
    }

    private HttpHeaders getCurrentHeaders() {
        httpHeaders = new HttpHeaders();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            httpHeaders.add(key, value);
        }
        return httpHeaders;
    }

    private HttpHeaders configureHeaders(){
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setConnection("keep-alive");
        httpHeaders.add("X-Hasura-admin-secret", "L5ZalprIfFwo7CzSVyRiv9nTO40lD3KGm6q46iqJxnpVkeoeW4HIo03RJk1uwDRH");
        return httpHeaders;
    }
}
