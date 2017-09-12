package hospitalManagement.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import hospitalManagement.models.Appeal;
import hospitalManagement.models.Doctor;
import hospitalManagement.models.Patient;

public class AppealService {

	Scanner scanner = new Scanner(System.in);
	DoctorService doctorService = new DoctorService();
	PatientService patientService = new PatientService();

	public void showAppealsByPatientId(int id) {
		for (int i = 0; i < MenagerData.listOfAppeals.size(); i++) {
			Appeal appeal = MenagerData.listOfAppeals.get(i);
			Doctor doctor = MenagerData.listOfDoctors.get(appeal.getIdDoctor());
			if (appeal.getIdPatient() == id) {
				System.out.print(" date : " + formateDate(appeal.getDate()));
				System.out.print(" name : " + appeal.getName());
				System.out.println(" doctor : " + doctor.getName() + " " + doctor.getSurname());
				System.out.println(" --------------------------------- ");
			}
		}
	}

	public void showAllAppealsByDoctorId(int id) {
		for (int i = 0; i < MenagerData.listOfAppeals.size(); i++) {
			if (MenagerData.listOfAppeals.get(i).getIdDoctor() == id) {
				Appeal appeal = MenagerData.listOfAppeals.get(i);
				System.out.print(i + ". date : " + formateDate(appeal.getDate()));
				System.out.print(" name : " + appeal.getName());
				Patient patient = MenagerData.listOfPatient.get(appeal.getIdPatient());
				System.out.print(" patient : " + patient.getName() + " " + patient.getSurname());
				Doctor doctor = MenagerData.listOfDoctors.get(id);
				System.out.println(" Doctor : " + doctor.getName() + " " + doctor.getSurname());
				System.out.println(" --------------------------------- ");
			}
		}
	}

	public Appeal shooseFieldsForApdateAppeal(Appeal appeal) {
		int shooseField;

		System.out.println("update name    -- press 1 -- ");
		System.out.println("update date    -- press 2 -- ");
		shooseField = scanner.nextInt();

		System.out.println(" -- enter data -- ");
		if (shooseField == 1) {
			String name = scanner.next();
			appeal.setName(name);
		} else if (shooseField == 2) {
			appeal.setDate(MenagerData.getDateFormat(scanner.next()));
		}
		System.out.println("end method");
		return appeal;
	}

	public Appeal createCustomAppeal() {
		Appeal appeal = new Appeal();
		String enterData;
		int idOfData;
		System.out.println(" -- create appeal -- ");
		System.out.println(" -- enter data of name -- ");
		enterData = scanner.next();
		appeal.setName(enterData);
		System.out.println(" -- enter date -- ");
		appeal.setDate(MenagerData.getDateFormat(scanner.next()));
		System.out.println(" -- enter id of doctor -- ");
		doctorService.showAllDoctors();
		idOfData = scanner.nextInt();
		appeal.setIdDoctor(idOfData);
		System.out.println(" -- enter id of patient -- ");
		patientService.showAllPatient();
		idOfData = scanner.nextInt();
		appeal.setIdPatient(idOfData);
		return appeal;
	}

	public void createAppeal(Appeal appeal) {
		MenagerData.creatApeal(appeal);
	}

	public void deleteAppeal(int id) {
		MenagerData.deleteApeal(id);
	}

	public void updateAppeal(Appeal appeal, int id) {
		MenagerData.updateApeal(appeal, id);
	}

	private String formateDate(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
	}

}
