package com.weatherapp.weather_details.ControllerAdvice;


import com.weatherapp.weather_details.Exceptions.LocationNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity<String> getLocationNotFoundException(LocationNotFoundException loc_error) {
        return new ResponseEntity<String>(loc_error.getMessage(), HttpStatusCode.valueOf(400));
    }
}
