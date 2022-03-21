package com.mentbot.mainProject.models;


import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Doctor_table")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctor_id;

    private String prof_statement;
    private LocalDate practicing_date;

    @OneToOne
    private User user;

//	@OneToMany
//	private Set<DocSpecialities> docspecialities;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "doctor_specialities",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "spec_id"))
    Set<Specialization> specialization = new HashSet<>();


    @OneToMany
    private List<Appointment> appointments;


    public Set<Specialization> getSpecialization() {
        return specialization;
    }


    public void setSpecialization(Set<Specialization> specialization) {
        this.specialization = specialization;
    }


    public List<Appointment> getAppointments() {
        return appointments;
    }


    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }


    public Long getDoctor_id() {
        return doctor_id;
    }


    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public String getProf_statement() {
        return prof_statement;
    }


    public void setProf_statement(String prof_statement) {
        this.prof_statement = prof_statement;
    }


    public LocalDate getPracticing_date() {
        return practicing_date;
    }


    public void setPracticing_date(LocalDate practicing_date) {
        this.practicing_date = practicing_date;
    }


}
