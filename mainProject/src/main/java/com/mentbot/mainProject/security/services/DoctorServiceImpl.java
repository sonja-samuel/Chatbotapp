package com.mentbot.mainProject.security.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentbot.mainProject.dto.AppointmentDto;
import com.mentbot.mainProject.dto.DocSpecialitiesDto;
import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.dto.ScheduleDto;
import com.mentbot.mainProject.models.Appointment;
import com.mentbot.mainProject.models.DocSpecialities;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Patient;
import com.mentbot.mainProject.models.Specialization;
import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.repo.AppointmentRepo;
import com.mentbot.mainProject.repo.DocSpecialitiesRepo;
import com.mentbot.mainProject.repo.DoctorRepo;
import com.mentbot.mainProject.repo.PatientRepo;
import com.mentbot.mainProject.repo.SpecializationRepo;
import com.mentbot.mainProject.repo.UserRepo;

@Service
public class DoctorServiceImpl implements DoctorService {
	

	 private DoctorRepo doctorrepo;
	
	
	private SpecializationRepo specrepo;
	

	private DocSpecialitiesRepo docspecrepo;
	
	
	private AppointmentRepo appointmentrepo;
	
	private PatientRepo patientrepo;
	
	private UserRepo userrepo;
	
	

	public DoctorServiceImpl(DoctorRepo doctorrepo, SpecializationRepo specrepo, DocSpecialitiesRepo docspecrepo, AppointmentRepo appointmentrepo,PatientRepo patientrepo,UserRepo userrepo) {
		
		this.doctorrepo = doctorrepo;
		this.specrepo = specrepo;
		this.docspecrepo = docspecrepo;
		this.appointmentrepo=appointmentrepo;
		this.patientrepo=patientrepo;
		this.userrepo=userrepo;
	}


	@Override
	public void addDetails(DoctorDto doctordto) {
		Doctor doctor=new Doctor();
		doctor.setProf_statement(doctordto.getProf_statement());
		doctor.setPracticing_date(doctordto.getPracticing_date());
		
		doctorrepo.save(doctor);
		
	}


	@Override
	public void addSpecialities(DocSpecialitiesDto docspecdto) {
		
		DocSpecialities docspec=new DocSpecialities();
		Doctor doctor = doctorrepo.getById(docspecdto.getDoctorId());
		Specialization spec= specrepo.getById(docspecdto.getSpecId());
		docspec.setDoctor(doctor);
		docspec.setSpecialization(spec);
		docspecrepo.save(docspec);
		
	}


//	@Override
//	public List<AppointmentDto>  getAppointmentsByDoctorId(int doctorId) {
//
//        Optional<Doctor> doctor = doctorrepo.findById((long) doctorId);
//		
//		List<Appointment> appointments= appointmentrepo.getAppointmentsByDoctorId(doctor.get());
//		
//		List<AppointmentDto> appointmentdto=new ArrayList<>();
//		for (Appointment appointment : appointments) {
//			
//			Patient patient=patientrepo.getById(appointment.getPatient().getPatient_id());
//			User user=userrepo.getById(patient.getUser().getId());
//			
//			AppointmentDto appointdto=new AppointmentDto(appointment);
//			appointdto.setPatientName(user.getFirstname() + user.getLastname());
//			appointmentdto.add(appointdto);	
//		}
//		
//		return appointmentdto;
//	}


	

	
}
