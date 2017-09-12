package hospitalManagement.services;

import hospitalManagement.models.Patient;

public class PatientService {

	public void showAllPatient() {
		for (int i = 0; i < MenagerData.listOfPatient.size(); i++) {
			Patient patient = MenagerData.listOfPatient.get(i);
			System.out.println(i + ". name: " + patient.getName() + " " + patient.getSurname());
		}
	}

	public void createPatient(Patient patient) {
		MenagerData.createPatient(patient);
	}

	public void updatePatient(Patient patient, int id) {
		MenagerData.updatePatient(patient, id);
	}

	public void deletePatient(int id) {
		MenagerData.deletePatient(id);
	}

}
