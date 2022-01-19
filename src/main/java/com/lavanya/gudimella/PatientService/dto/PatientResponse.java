package com.lavanya.gudimella.PatientService.dto;

import org.springframework.stereotype.Component;

import com.lavanya.gudimella.PatientService.vo.Patient;

@Component
public class PatientResponse {
	private Patient patient;
	private String response;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "PatientResponse [patient=" + patient + ", response=" + response + "]";
	}
}
