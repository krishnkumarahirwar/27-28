package com.capgemini.healthcaremanagementsystem.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.healthcaremanagementsystem.entity.Appointment;

public interface AppointmentDao extends JpaRepository<Appointment, Long> {

	//@Query("FROM Appointment WHERE centerId=:centerId AND status=false")
	
	//public List<Appointment> findUnApprovedAppointments(@Param("centerId") String centerId);

	//public List<Appointment findAppointmentByCustomerId(Long customerId);
}
