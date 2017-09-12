package hospitalManagement.services;

import hospitalManagement.models.Doctor;

public class DoctorService {

	public void showAllDoctors() {
		for (int i = 0; i < MenagerData.listOfDoctors.size(); i++) {
			System.out.print(i + ". " + MenagerData.listOfDoctors.get(i).getName());
			System.out.println(" " + MenagerData.listOfDoctors.get(i).getSurname());
		}
	}

	public void createDoctor(Doctor doctor) {
		MenagerData.createDoctor(doctor);
	}

	public void updateDoctor(Doctor doctor, int id) {
		MenagerData.updateDoctor(doctor, id);
	}

	public void deleteDoctor(int id) {
		MenagerData.deleteDoctor(id);
	}
}
