package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.AppointmentDetailDto;
import com.mentbot.mainProject.dto.AvailableSlotsDto;
import com.mentbot.mainProject.dto.DoctorNameDto;
import com.mentbot.mainProject.models.*;
import com.mentbot.mainProject.repo.*;
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
	private UserRepo userRepo;

	public AppointmentServiceImpl(AppointmentRepo appointmentRepo, DoctorRepo doctorRepo, ScheduleRepo scheduleRepo,
			PatientRepo patientRepo, SpecializationRepo specializationRepo, UserRepo userRepo) {
		this.appointmentRepo = appointmentRepo;
		this.doctorRepo = doctorRepo;
		this.scheduleRepo = scheduleRepo;
		this.patientRepo = patientRepo;
		this.specializationRepo = specializationRepo;
		this.userRepo = userRepo;
	}

	@Override
	public void addAppointment(LocalDate appointmentDate, int specId, int doctorId, int patientId, LocalTime startTime,
			LocalTime endTime) {

		Appointment appointment = new Appointment();
		Doctor doctor = doctorRepo.getById((long) doctorId);
		Patient patient = patientRepo.getById((long) patientId);
		appointment.setAppointmentDate(appointmentDate);
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
		appointment.setStarttime(startTime);
		appointment.setEndtime(endTime);
		appointment.setSpecId((long) specId);
		appointmentRepo.save(appointment);

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

		List<Appointment> appointmentsForDoctorForDate = appointmentRepo.findAllByDoctorAndAppointmentDate(doctor.get(),
				date);
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

	@Override
	public List<DoctorNameDto> getDoctors(int specialityId) {
		Optional<Specialization> specializationOptional = specializationRepo.findById((long) specialityId);
		if (!specializationOptional.isPresent()) {
			return new ArrayList<>();
		}
		List<Doctor> doctorsBySpecialization = doctorRepo.findAllBySpecialization(specializationOptional.get());
		List<DoctorNameDto> doctorsForSpecialization = new ArrayList<>();
		for (Doctor doctor : doctorsBySpecialization) {
			DoctorNameDto doctorNameDto = new DoctorNameDto();
			User user = doctor.getUser();
			String doctorName = user.getFirstname() + " " + user.getLastname();
			doctorNameDto.setDoctorName(doctorName);
			doctorNameDto.setDoctorId(doctor.getDoctor_id());
			doctorsForSpecialization.add(doctorNameDto);
		}
		return doctorsForSpecialization;
	}

	@Override
	public List<AppointmentDetailDto> getAppointmentsForPatient(int patientId) {
		Optional<Patient> patientOptional = patientRepo.findById((long) patientId);
		if (!patientOptional.isPresent()) {
			return new ArrayList<>();
		}
		List<Appointment> appointments = appointmentRepo.findAllByPatient(patientOptional.get());
		List<AppointmentDetailDto> appointmentsForPatient = new ArrayList<>();
		for (Appointment appointment : appointments) {
			User user = appointment.getDoctor().getUser();
			String doctorName = user.getFirstname() + " " + user.getLastname();
			String specializationName = "";
			Optional<Specialization> specializationOptional = specializationRepo.findById(appointment.getSpecId());
			if (specializationOptional.isPresent()) {
				specializationName = specializationOptional.get().getSpec_name();
			}
			AppointmentDetailDto appointmentDetailDto = new AppointmentDetailDto(appointment.getAppointment_id(),
					appointment.getStarttime(), appointment.getEndtime(), appointment.getAppointmentDate(),
					specializationName, doctorName, appointment.getStatus());
			appointmentsForPatient.add(appointmentDetailDto);
		}
		return appointmentsForPatient;
	}
}
