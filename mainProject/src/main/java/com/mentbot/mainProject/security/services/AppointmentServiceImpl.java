package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.AppointmentDto;
import com.mentbot.mainProject.dto.AvailableSlotsDto;
import com.mentbot.mainProject.models.Appointment;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Patient;
import com.mentbot.mainProject.models.Schedule;
import com.mentbot.mainProject.models.Specialization;
import com.mentbot.mainProject.repo.AppointmentRepo;
import com.mentbot.mainProject.repo.DoctorRepo;
import com.mentbot.mainProject.repo.PatientRepo;
import com.mentbot.mainProject.repo.ScheduleRepo;
import com.mentbot.mainProject.repo.SpecializationRepo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepo appointmentRepo;

    private DoctorRepo doctorRepo;

    private ScheduleRepo scheduleRepo;
    
    private PatientRepo patientRepo;
    
    private SpecializationRepo specializationRepo;
    

    public AppointmentServiceImpl(AppointmentRepo appointmentRepo,
                                  DoctorRepo doctorRepo,
                                  ScheduleRepo scheduleRepo,
                                  PatientRepo patientRepo,
                                  SpecializationRepo specializationRepo) {
        this.appointmentRepo = appointmentRepo;
        this.doctorRepo = doctorRepo;
        this.scheduleRepo = scheduleRepo;
        this.patientRepo=patientRepo;
        this.specializationRepo=specializationRepo;
    }


    @Override
    public void addAppointment(LocalDate appointmentDate,int specId,int doctorId, int patientId,LocalTime startTime,LocalTime endTime) {

       Appointment appointment=new Appointment();
    
       Doctor doctor=doctorRepo.getById(Long.valueOf(doctorId));
       Patient patient= patientRepo.getById(Long.valueOf(patientId));
      
       
       appointment.setAppointmentDate(appointmentDate);
       appointment.setDoctor(doctor);
       appointment.setPatient(patient);
       appointment.setStarttime(startTime);
       appointment.setEndtime(endTime);
       appointment.setSpecId(Long.valueOf(specId));
       
    }

    @Override
    public List<AvailableSlotsDto> getAvailableSlots(int doctorId, LocalDate date) {

        Optional<Doctor> doctor = doctorRepo.findById((long) doctorId);
        if (!doctor.isPresent()) {
            return new ArrayList<>();
        }
        Optional<Schedule> schedule = scheduleRepo.findByDoctor(doctor.get());
        if (!schedule.isPresent()) {
            return new ArrayList<>();
        }
        int day = date.getDayOfWeek().getValue();
        List<String> availableDays = Arrays.asList(schedule.get().getAvailableDays().split(","));
        if (!availableDays.contains(String.valueOf(day))) {
            return new ArrayList<>();
        }
        LocalTime startTime = schedule.get().getStartTime();
        LocalTime endTime = schedule.get().getEndTime();
        List<List<LocalTime>> availableSlots = new ArrayList<>();
        while (!startTime.equals(endTime)) {
            List<LocalTime> availableSlot = new ArrayList<>();
            availableSlot.add(startTime);
            availableSlot.add(startTime.plusHours(1));
            availableSlots.add(availableSlot);
            startTime = startTime.plusHours(1);
        }

        List<Appointment> appointmentsForDoctorForDate = appointmentRepo.findAllByDoctorAndAppointmentDate(doctor.get(), date);
        List<List<LocalTime>> availableSlotsForAppointment = new ArrayList<>();
        for (List<LocalTime> availableSlot : availableSlots) {
            boolean slotBooked = false;
            for (Appointment appointment : appointmentsForDoctorForDate) {
                if (appointment.getStarttime().equals(availableSlot.get(0))) {
                    slotBooked = true;
                    break;
                }
            }
            if (!slotBooked) {
                availableSlotsForAppointment.add(availableSlot);
            }
        }
        List<AvailableSlotsDto> availableSlotsDtos = new ArrayList<>();
        for (List<LocalTime> availableSlot : availableSlotsForAppointment) {
            AvailableSlotsDto availableSlotsDto = new AvailableSlotsDto();
            availableSlotsDto.setStartTime(availableSlot.get(0));
            availableSlotsDto.setEndTime(availableSlot.get(1));
            availableSlotsDtos.add(availableSlotsDto);
        }
        return availableSlotsDtos;
    }
}
