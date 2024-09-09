package com.weatherapp.weather_details.Controllers;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/test_controller")
    public String test() {
        return "This is a test controller";
    }
}
