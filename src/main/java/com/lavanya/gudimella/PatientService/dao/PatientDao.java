package com.lavanya.gudimella.PatientService.dao;

import java.util.List; 
import com.lavanya.gudimella.PatientService.vo.Patient;

public interface PatientDao {
	
	public void addPatient(Patient patient);
	
	public Patient getPatientById(int patient_id);
	
	public List<Patient> getPatientsList();
	
	public boolean findPatient(String patient_email);
}
