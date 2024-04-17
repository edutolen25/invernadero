package com.example.invernadero.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.invernadero.models.Control;
import com.example.invernadero.service.ControlService;

@RestController
@RequestMapping("api/controlinvernadero/v1/control")
public class ControlController {

    @Autowired
    private ControlService controlService;

    @GetMapping
    public ResponseEntity<List<Control>> getAllControl() {
        List<Control> control = controlService.getAllControl();
        return new ResponseEntity<>(control, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Control> getControlById(@PathVariable Long id) {
        Optional<Control> control = controlService.getControlById(id);
        return control.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Control> saveControl(@RequestBody Control control) {
        Control saveControl = ControlService.saveControl(control);
        return new ResponseEntity<>(saveControl, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Control> updateControl(@PathVariable Long id, @RequestBody Control newControl) {
        Control updateControl = controlService.updateControl(id, newControl);
        return new ResponseEntity<>(updateControl, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteControl(@PathVariable Long id) {
        controlService.deleteControl(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
