package training360.springrestnavdemo.service;

import org.springframework.stereotype.Service;
import training360.springrestnavdemo.appointment.dtos.AppointmentDto;
import training360.springrestnavdemo.appointment.dtos.CaseTypeDto;
import training360.springrestnavdemo.appointment.dtos.CreateAppointmentCommand;
import training360.springrestnavdemo.appointment.mappers.AppointmentMapper;
import training360.springrestnavdemo.appointment.mappers.CaseTypeMapper;
import training360.springrestnavdemo.appointment.model.Appointment;
import training360.springrestnavdemo.appointment.model.CaseType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AppointmentService {

    private CaseTypeMapper caseTypeMapper;
    private AppointmentMapper appointmentMapper;
    private AtomicLong idGenerator = new AtomicLong(0);
    private final List<CaseType> caseTypes = List.of(new CaseType("001","Administration"), new CaseType("002", "Payment"));
    private List<Appointment> appointments = new ArrayList<>();

    public AppointmentService(CaseTypeMapper caseTypeMapper, AppointmentMapper appointmentMapper) {
        this.caseTypeMapper = caseTypeMapper;
        this.appointmentMapper = appointmentMapper;
    }

    public List<CaseTypeDto> getAllTypes() {
        return caseTypeMapper.toDto(caseTypes);
    }

    public AppointmentDto createAppointment(CreateAppointmentCommand command) {
        Appointment appointment = Appointment.builder()
                .id(idGenerator.incrementAndGet())
                .Cdv(command.getCdv())
                .startDate(command.getStartDate())
                .endDate(command.getEndDate())
                .typeOfAdministration(command.getTypeOfAdministration())
                .build();

        appointments.add(appointment);

        return appointmentMapper.toDto(appointment);
    }

}
