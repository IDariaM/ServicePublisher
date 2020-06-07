package idariam.Publisher.controller;

import idariam.Publisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController //Marks class as controller and shows that custom xml/json object can be returned in this class
public class PublisherController {
    private final PublisherService publisherService;

    @Autowired //shows the necessity to inject the dependence here
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping //marks method to return the response for get request
    public Map<String, String> getResponse() {

        return publisherService.createResponse();
    }

}

