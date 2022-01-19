package com.lavanya.gudimella.PatientService.dao;

import java.util.List;  
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lavanya.gudimella.PatientService.vo.Patient;

@Repository
@Transactional
public class PatientDaoImpl implements PatientDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addPatient(Patient patient) {
		Session session = sessionFactory.openSession();
		session.save(patient);
		session.close();
	}

	@Override
	public Patient getPatientById(int patient_id) {
		Session session = sessionFactory.openSession();
		Patient patient = session.get(Patient.class, patient_id);
		session.close();
		return patient;
	}

	@Override
	public List<Patient> getPatientsList() {
		Session session = sessionFactory.openSession();
		List<Patient> patients = session.createQuery("from Patient", Patient.class).list();
		session.close();
		return patients;
	}

	@Override
	public boolean findPatient(String patient_email) {
		Session session = sessionFactory.openSession();
		List<Patient> patients = session.createQuery("from Patient", Patient.class).list();
		for(Patient patient : patients) {
			if(patient.getPatient_email().trim().equals(patient_email.trim())) {
				return true;
			}
		}	
		return false;
	}
}
