package hospitalManagement;

import java.util.Scanner;

import hospitalManagement.models.Appeal;
import hospitalManagement.services.AppealService;
import hospitalManagement.services.DoctorService;
import hospitalManagement.services.MenagerData;
import hospitalManagement.services.PatientService;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MenagerData.fillAllData();

		DoctorService doctorService = new DoctorService();
		PatientService patientService = new PatientService();
		AppealService appealService = new AppealService();

		System.out.println(" ----------------------------------- ");
		System.out.println(" ------------- Welcom -------------- ");
		System.out.println(" ----------------------------------- ");

		System.out.println(" - if you want to show doctor`s appeals -- push 1");
		System.out.println(" - if you want to update appeal -- push 2");
		System.out.println(" - if you want to remove appeal -- push 3");
		System.out.println(" - if you want to create appeal -- push 4");

		int param = scanner.nextInt();

		int idOfDoctor;
		int idOfAppeal;
		int idOfPatient;
		if (param == 1) {
			doctorService.showAllDoctors();
			System.out.println("--- shoose id of doctor -----");
			idOfDoctor = scanner.nextInt();
			appealService.showAllAppealsByDoctorId(idOfDoctor);
		} else if (param == 2) {
			doctorService.showAllDoctors();
			System.out.println("--- shoose id of doctor -----");
			idOfDoctor = scanner.nextInt();
			appealService.showAllAppealsByDoctorId(idOfDoctor);
			System.out.println("--- shoose id of appeals -----");
			idOfAppeal = scanner.nextInt();
			Appeal appeal = MenagerData.listOfAppeals.get(idOfAppeal);
			MenagerData.updateApeal(appealService.shooseFieldsForApdateAppeal(appeal), idOfAppeal);
			System.out.println("-- update successfully -- ");
			appealService.showAllAppealsByDoctorId(idOfDoctor);
		} else if (param == 3) {
			System.out.println("--- shoose id of patient -----");
			patientService.showAllPatient();
			idOfPatient = scanner.nextInt();
			appealService.showAppealsByPatientId(idOfPatient);
			System.out.println("--- shoose id of appeals -----");
			idOfAppeal = scanner.nextInt();
			appealService.deleteAppeal(idOfAppeal);
			System.out.println("-- remove successfully -- ");
			appealService.showAppealsByPatientId(idOfPatient);
		} else if (param == 4) {
			Appeal appeal = appealService.createCustomAppeal();
			appealService.createAppeal(appeal);
		}
	}

}
