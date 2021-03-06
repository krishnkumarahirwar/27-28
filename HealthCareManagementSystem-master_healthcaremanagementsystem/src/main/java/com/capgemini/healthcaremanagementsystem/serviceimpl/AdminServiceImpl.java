package com.capgemini.healthcaremanagementsystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaremanagementsystem.dao.AdminDao;
import com.capgemini.healthcaremanagementsystem.dao.AppointmentDao;
import com.capgemini.healthcaremanagementsystem.dao.DiagnosticCenterDao;
import com.capgemini.healthcaremanagementsystem.dao.TestDao;
import com.capgemini.healthcaremanagementsystem.entity.Admin;
import com.capgemini.healthcaremanagementsystem.entity.Appointment;
import com.capgemini.healthcaremanagementsystem.entity.DiagnosticCenter;
import com.capgemini.healthcaremanagementsystem.entity.Test;
import com.capgemini.healthcaremanagementsystem.exception.AdminNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.CenterAlreadyExistException;
import com.capgemini.healthcaremanagementsystem.exception.CenterNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.DiagnosticCenterNotExistsException;
import com.capgemini.healthcaremanagementsystem.exception.TestIdDoesNotExistException;
import com.capgemini.healthcaremanagementsystem.exception.TestNotFoundException;
import com.capgemini.healthcaremanagementsystem.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private TestDao testDao;

	@Autowired
	private AppointmentDao appointmentDao;

	@Autowired
	private DiagnosticCenterDao diagnosticCenterDao;

	@Override
	public Admin adminLogin(String adminName, String adminPassword) {
		Admin admin = adminDao.findAdminByAdminName(adminName);
		if ((admin != null && admin.getAdminPassword().equals(adminPassword) && admin.getAdminName().equals(adminName)))
			return admin;
		throw new AdminNotFoundException(
				"Admin with AdminName [" + adminName + "] and password [" + adminPassword + "] not found");
	}

	@Override
	public Test addTest(Test test) {
		Optional<DiagnosticCenter> option = diagnosticCenterDao.findById(test.getCenterId());
		
		if (option.isPresent()) {
			DiagnosticCenter center=option.get();
			List<Test> list= center.getListOfTest();
			list.add(test);
			center.setListOfTest(list);
			Test addtest = testDao.save(test);
			return addtest;
		}
		throw new DiagnosticCenterNotExistsException("Center does not exists");

	}

	@Override
	public boolean deleteTestById(Long testId) {
		boolean isExist = testDao.existsById(testId);
		if (isExist) {
			testDao.deleteById(testId);
			return true;
		}
		throw new TestNotFoundException("Test not found...");
	}

	@Override
	public Test updateTest(Test test) {
		Optional<DiagnosticCenter> option = diagnosticCenterDao.findById(test.getCenterId());
		Optional<Test> option1 = testDao.findById(test.getTestId());
		if (option.isPresent() && option1.isPresent()) {
			testDao.save(test);
			return test;
		}
		throw new TestNotFoundException("Test Id or Centerid does not exists");
	}

	@Override
	public Test findTestById(Long testId) {
		if (!testDao.existsById(testId)) {
			throw new TestIdDoesNotExistException("TestId does Not Exists");
		}
		return testDao.findById(testId).get();
	}

	@Override
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter center) {
		Optional<DiagnosticCenter> optional = diagnosticCenterDao.findById(center.getCenterId());
		if (optional.isPresent()) {
			throw new CenterAlreadyExistException("center is already exist with given details");
		} else
			return diagnosticCenterDao.save(center);
	}

	@Override
	public boolean removeDiagnosticCenter(long centerId) {
		Optional<DiagnosticCenter> optional = diagnosticCenterDao.findById(centerId);
		if (optional.isPresent()) {
			DiagnosticCenter center = optional.get();
			diagnosticCenterDao.delete(center);
			return true;
		}

		throw new CenterNotFoundException("No center with given details" + centerId);
	}

	@Override
	public DiagnosticCenter findDiagnosticCenterById(long centerId) {
		Optional<DiagnosticCenter> optional = diagnosticCenterDao.findById(centerId);
		if (optional.isPresent()) {
			DiagnosticCenter center = optional.get();
			return center;
		} else
			throw new CenterNotFoundException("No center with given id" + centerId);
	}

	@Override
	public List<DiagnosticCenter> viewAllDiagnosticCenter() {
		return diagnosticCenterDao.findAll();
	}

	@Override
	public Appointment approveAppointment(Appointment appointment, String status) {
		appointment.setAppointmentStatus(status);
		return appointmentDao.save(appointment);
	}

}
