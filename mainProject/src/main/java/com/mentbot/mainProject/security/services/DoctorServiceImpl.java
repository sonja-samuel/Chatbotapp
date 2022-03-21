package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.AppointmentDto;
import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.models.*;
import com.mentbot.mainProject.repo.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {


    private DoctorRepo doctorrepo;


    private SpecializationRepo specrepo;


//	private DocSpecialitiesRepo docspecrepo;


    private AppointmentRepo appointmentrepo;

    private PatientRepo patientrepo;

    private UserRepo userrepo;


    public DoctorServiceImpl(DoctorRepo doctorrepo, SpecializationRepo specrepo, AppointmentRepo appointmentrepo, PatientRepo patientrepo, UserRepo userrepo) {

        this.doctorrepo = doctorrepo;
        this.specrepo = specrepo;
//		this.docspecrepo = docspecrepo;
        this.appointmentrepo = appointmentrepo;
        this.patientrepo = patientrepo;
        this.userrepo = userrepo;
    }


    @Override
    public void addDetails(DoctorDto doctordto, int userId) {

//		LocalDate practicingDate = LocalDate.parse(doctordto.getPracticing_date(), DateTimeFormatter.ofPattern("dd-mm-yyyy"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate practicingDate = LocalDate.parse(doctordto.getPracticing_date(), formatter);

        Set<Long> specializationIds = doctordto.getSpecializationIds().stream()
                .mapToLong(Integer::longValue)
                .boxed().collect(Collectors.toSet());

        Doctor doctor = new Doctor();
        User user = userrepo.getById(Long.valueOf(userId));
        doctor.setUser(user);
        doctor.setProf_statement(doctordto.getProf_statement());
        doctor.setPracticing_date(practicingDate);
        List<Specialization> specializations = specrepo.findAllById(specializationIds);
//		Set<Specialization> specializations = (Set<Specialization>) specrepo.findAllById(specializationIds);
        Set<Specialization> docSpecializations = new HashSet<Specialization>(specializations);
        doctor.setSpecialization(docSpecializations);
        doctorrepo.save(doctor);
    }


//	@Override
//	public void addSpecialities(DocSpecialitiesDto docspecdto) {
//		
//		DocSpecialities docspec=new DocSpecialities();
//        Doctor doctor = doctorrepo.getById(docspecdto.getDoctorId());
//		Doctor doctor=doctorrepo.getById(Long.valueOf(doctorId));
//		Specialization spec= specrepo.getById(docspecdto.getSpecId());
//		docspec.setDoctor(doctor);
//		docspec.setSpecialization(spec);
//		docspecrepo.save(docspec);
//		
//	}


    @Override
    public List<AppointmentDto> getAppointmentsByDoctorId(int doctorId) {

        Optional<Doctor> doctor = doctorrepo.findById((long) doctorId);
        if (!doctor.isPresent()) {
            return new ArrayList<>();
        }
        List<Appointment> appointments = appointmentrepo.findAllByDoctor(doctor.get());

        List<AppointmentDto> appointmentdto = new ArrayList<>();
        for (Appointment appointment : appointments) {
            Patient patient = patientrepo.getById(appointment.getPatient().getPatient_id());
            User user = userrepo.getById(patient.getUser().getId());
            AppointmentDto appointdto = new AppointmentDto(appointment);
            appointdto.setPatientName(user.getFirstname() + user.getLastname());
            appointmentdto.add(appointdto);
        }

        return appointmentdto;
    }

    @Override
    public void confirmAppointment(int appointmentId, String status) {
        Optional<Appointment> appointmentOptional = appointmentrepo.findById((long) appointmentId);
        if (!appointmentOptional.isPresent()) {
            return;
        }
        Appointment appointment = appointmentOptional.get();
        appointment.setStatus(AppointmentStatus.valueOf(status));
        appointmentrepo.save(appointment);
    }
}
