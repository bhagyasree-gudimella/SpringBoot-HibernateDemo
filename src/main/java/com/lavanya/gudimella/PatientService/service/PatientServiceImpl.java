package com.lavanya.gudimella.PatientService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavanya.gudimella.PatientService.dao.PatientDao;
import com.lavanya.gudimella.PatientService.vo.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientDao patientDao;

	@Override
	public void addPatient(Patient patient) {
		patientDao.addPatient(patient);
	}

	@Override
	public Patient getPatientById(int patient_id) {
		return patientDao.getPatientById(patient_id);
	}

	@Override
	public List<Patient> getPatientsList() {
		return patientDao.getPatientsList();
	}

	@Override
	public boolean findPatient(String patient_email) {
		return patientDao.findPatient(patient_email);
	}
}
