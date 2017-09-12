package hospitalManagement.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hospitalManagement.models.Appeal;
import hospitalManagement.models.Doctor;
import hospitalManagement.models.Patient;

public class MenagerData {

	public static List<Doctor> listOfDoctors = new ArrayList<Doctor>();
	public static List<Appeal> listOfAppeals = new ArrayList<Appeal>();
	public static List<Patient> listOfPatient = new ArrayList<Patient>();

	public static void fillAllData() {
		fillDoctors();
		fillAppeals();
		fillPatient();
	}

	private static void fillDoctors() {
		Doctor doctor1 = new Doctor();
		doctor1.setName("Andriy");
		doctor1.setSurname("Petrenko");

		Doctor doctor2 = new Doctor();
		doctor2.setName("Ivan");
		doctor2.setSurname("Ivanenko");

		Doctor doctor3 = new Doctor();
		doctor3.setName("Roman");
		doctor3.setSurname("Romenko");

		Doctor doctor4 = new Doctor();
		doctor4.setName("Vasyl");
		doctor4.setSurname("Vasylenko");

		listOfDoctors.add(doctor1);
		listOfDoctors.add(doctor2);
		listOfDoctors.add(doctor3);
		listOfDoctors.add(doctor4);
	}

	private static void fillAppeals() {

		Appeal appeal1 = new Appeal();
		appeal1.setDate(new Date());
		appeal1.setName("headache");
		appeal1.setIdDoctor(0);
		appeal1.setIdPatient(0);

		Appeal appeal2 = new Appeal();
		appeal2.setDate(getDateFormat("10-02-2017 12:00:00"));
		appeal2.setName("headache");
		appeal2.setIdDoctor(1);
		appeal2.setIdPatient(0);

		Appeal appeal3 = new Appeal();
		appeal3.setDate(getDateFormat("12-09-2017 14:20:00"));
		appeal3.setName("break of the hand");
		appeal3.setIdDoctor(1);
		appeal3.setIdPatient(0);

		Appeal appeal4 = new Appeal();
		appeal4.setDate(getDateFormat("10-09-2017 14:19:00"));
		appeal4.setName("break of the leg");
		appeal4.setDiagnosis("break");
		appeal4.setDoctorNotes("good patient");
		appeal4.setTreatment("gypsum");
		appeal4.setIdDoctor(2);
		appeal4.setIdPatient(0);

		Appeal appeal5 = new Appeal();
		appeal5.setDate(getDateFormat("12-09-2017 14:30:00"));
		appeal5.setName("toothache");
		appeal5.setIdDoctor(2);
		appeal5.setIdPatient(1);

		Appeal appeal6 = new Appeal();
		appeal6.setDate(getDateFormat("12-09-2017 18:30:00"));
		appeal6.setName("cold");
		appeal6.setIdDoctor(3);
		appeal6.setIdPatient(2);

		Appeal appeal7 = new Appeal();
		appeal7.setDate(getDateFormat("11-09-2017 10:30:00"));
		appeal7.setName("cold");
		appeal7.setIdDoctor(3);
		appeal7.setIdPatient(1);

		Appeal appeal8 = new Appeal();
		appeal8.setDate(getDateFormat("09-08-2017 08:30:00"));
		appeal8.setName("fever");
		appeal8.setDiagnosis("some fever 38");
		appeal8.setDoctorNotes("good patient");
		appeal8.setTreatment("aspiryn");
		appeal8.setIdDoctor(3);
		appeal8.setIdPatient(2);

		listOfAppeals.add(appeal1);
		listOfAppeals.add(appeal2);
		listOfAppeals.add(appeal3);
		listOfAppeals.add(appeal4);
		listOfAppeals.add(appeal5);
		listOfAppeals.add(appeal6);
		listOfAppeals.add(appeal7);
		listOfAppeals.add(appeal8);

	}

	private static void fillPatient() {

		Patient patient1 = new Patient();
		patient1.setName("Dima");
		patient1.setSurname("Andrusiv");
		patient1.setPhone("0987231671");
		patient1.setAddress("Molodizhna 69");

		Patient patient2 = new Patient();
		patient2.setName("Vasyl");
		patient2.setSurname("Andrusiv");
		patient2.setPhone("0987231671");
		patient2.setAddress("Molodizhna 69");

		Patient patient3 = new Patient();
		patient3.setName("Andriy");
		patient3.setSurname("Andrusiv");
		patient3.setPhone("0987231671");
		patient3.setAddress("Molodizhna 69");

		listOfPatient.add(patient1);
		listOfPatient.add(patient2);
		listOfPatient.add(patient3);

	}

	public static Date getDateFormat(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = date;
		Date formatDate = null;
		try {
			formatDate = sdf.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatDate;
	}

	public static List<Patient> getListOfPatient() {
		return listOfPatient;
	}

	public static List<Doctor> getListOfDoctor() {
		return listOfDoctors;
	}

	public static List<Appeal> getListOfAppels() {
		return listOfAppeals;
	}

	public static void createPatient(Patient patient) {
		listOfPatient.add(patient);
	}

	public static void creatApeal(Appeal appeal) {
		listOfAppeals.add(appeal);
	}

	public static void createDoctor(Doctor doctor) {
		listOfDoctors.add(doctor);
	}

	public static void updatePatient(Patient patient, int id) {
		listOfPatient.set(id, patient);
	}

	public static void updateApeal(Appeal appeal, int id) {
		listOfAppeals.set(id, appeal);
	}

	public static void updateDoctor(Doctor doctor, int id) {
		listOfDoctors.set(id, doctor);
	}

	public static void deletePatient(int id) {
		listOfPatient.remove(id);
	}

	public static void deleteApeal(int id) {
		listOfAppeals.remove(id);
	}

	public static void deleteDoctor(int id) {
		listOfDoctors.remove(id);
	}

}
