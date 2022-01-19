package com.lavanya.gudimella.PatientService.controller; 

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.lavanya.gudimella.PatientService.dto.PatientResponse;
import com.lavanya.gudimella.PatientService.service.PatientService;
import com.lavanya.gudimella.PatientService.vo.Patient;
 
@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService; 
	
	@Autowired
	private PatientResponse patientResponse;
	
	@RequestMapping(value="/sayHello", method=RequestMethod.GET)
	public String sayHello() {
		return "Hello!";
	}
	
	@RequestMapping(value="/addPatient", method=RequestMethod.POST)
	public PatientResponse addPatient(@RequestBody Patient patient) {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");
		patient.setConsultation_time((formatter.format(dateTime)));
		patientService.addPatient(patient);
		patientResponse.setResponse("Patient has been successfully added");
		patientResponse.setPatient(patient);
		return patientResponse;
	}
	
	@RequestMapping(value="getPatient/{patient_id}", method=RequestMethod.GET)
	public PatientResponse getPatientById(@PathVariable("patient_id") int patient_id) {
		Patient patient = patientService.getPatientById(patient_id);	
		patientResponse.setPatient(patient);
		patientResponse.setResponse("Patient Found : " +patient.getPatient_name());
		return patientResponse;
	}
	
	@RequestMapping(value="/patients", method=RequestMethod.GET)
	public List<Patient> getAllPatients() {
		return patientService.getPatientsList();
	}
}
