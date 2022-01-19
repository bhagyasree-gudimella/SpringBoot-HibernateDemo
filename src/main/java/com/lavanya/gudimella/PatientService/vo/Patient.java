package com.lavanya.gudimella.PatientService.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id", nullable=false)
	private int patient_id;

	@Column(name = "patient_name", nullable=false)
	private String patient_name;

	@Column(name = "patient_email", nullable=false)
	private String patient_email;

	@Column(name = "insurance_number", nullable=false)
	private int insurance_number;

	@Column(name = "symptoms", nullable=false)
	private String symptoms;

	@Column(name = "consultation_time", nullable=false)
	private String consultation_time;

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getPatient_email() {
		return patient_email;
	}

	public void setPatient_email(String patient_email) {
		this.patient_email = patient_email;
	}

	public int getInsurance_number() {
		return insurance_number;
	}

	public void setInsurance_number(int insurance_number) {
		this.insurance_number = insurance_number;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getConsultation_time() {
		return consultation_time;
	}

	public void setConsultation_time(String consultation_time) {
		this.consultation_time = consultation_time;
	}

	@Override
	public String toString() {
		return "Patient [patient_id=" + patient_id + ", patient_name=" + patient_name + ", patient_email="
				+ patient_email + ", insurance_number=" + insurance_number + ", symptoms=" + symptoms
				+ ", consultation_time=" + consultation_time + "]";
	}
}
