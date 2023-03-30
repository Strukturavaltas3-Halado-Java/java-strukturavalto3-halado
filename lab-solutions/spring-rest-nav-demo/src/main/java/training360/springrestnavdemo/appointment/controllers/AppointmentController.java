package training360.springrestnavdemo.appointment.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import training360.springrestnavdemo.appointment.dtos.AppointmentDto;
import training360.springrestnavdemo.appointment.dtos.CaseTypeDto;
import training360.springrestnavdemo.appointment.dtos.CreateAppointmentCommand;
import training360.springrestnavdemo.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService service;

    @GetMapping("/types")
    public List<CaseTypeDto> getAllTypes(){
        return service.getAllTypes();
    }

    @PostMapping("/appointments")
    public AppointmentDto createAppointment(@Valid @RequestBody CreateAppointmentCommand command){
        return service.createAppointment(command);
    }
}
