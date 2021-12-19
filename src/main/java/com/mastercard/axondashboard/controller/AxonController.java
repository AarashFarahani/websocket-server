package com.mastercard.axondashboard.controller;

import com.mastercard.axondashboard.model.Event;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@CrossOrigin//(origins = "http://localhost:8080")
public class AxonController {
    @PostMapping("/push")
    public ResponseEntity push(@RequestBody Event event) {
        log.info(event);
        return ResponseEntity.ok(event);
    }
}
