package Controlpanel;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import CandP.Patient;
import CandP.Appointment;

public class UserInterface {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence		//create new ManagerFactory
				.createEntityManagerFactory("csc370");
		EntityManager entitymanager = emfactory.createEntityManager();	//create new entitymanager
		String userinput = "";
		Scanner input = new Scanner(System.in);		//scanner user input from keyboard
		while (true) {	//loop forever until user enter 'exit'
			System.out.printf("\n\n\n\n\n\n**********Welcome to Client and Patient Database**********\n*                                                        *\n*                                                        *\n*                                                        *\n*                                                        *\n");
			System.out.printf("**********************************************************\n\n\n\n");
			System.out.printf("Please choose 'Appointment' mode or 'Patient' mode(Enter 'Exit' to quit)\n");
			System.out.printf("=======> ");
			userinput = input.next();
			if (userinput.equalsIgnoreCase("Patient")) {  //enter patient mode
				while (true) {  //break until enter 'exit' or 'back'.
					Patient patient = new Patient();  //create new entity
					System.out.printf("\nPlease choose one of the following options:\n\n");
					System.out.printf("'Enter': Insert a new patient\n");
					System.out.printf("'Search': Search a new patient by Last Name\n");
					System.out.printf("'Delete': Delete a patient by PatientID\n");
					System.out.printf("'Back': Go back\n");
					System.out.printf("'Exit': Quit Program\n");
					System.out.printf("=======> ");
					userinput = input.next();
					//Choose options
					if (userinput.equalsIgnoreCase("Enter")) {
						createPatient(patient, entitymanager);
					} else if (userinput.equalsIgnoreCase("Search")) {
						searchPatient(patient, entitymanager);
					} else if (userinput.equalsIgnoreCase("Delete")) {
						deletePatient(patient, entitymanager);
					} else if (userinput.equalsIgnoreCase("Exit")) {
						//close 
						input.close();
						entitymanager.close();
						emfactory.close();
						System.exit(0);
					} else if (userinput.equalsIgnoreCase("Back")) {  //back to last page
						break;
					}
				}
			}
			if (userinput.equalsIgnoreCase("Appointment")) {  //appointment mode
				while (true) {
					Appointment appoinment = new Appointment();  //create new entity
					System.out.printf("\nPlease choose one of the following options:\n\n");
					System.out.printf("'Create': Create a new Appointment\n");
					System.out.printf("'View': View Appointment in a particular date range\n");
					System.out.printf("'Delete': Delete an appointment by PatientID\n");
					System.out.printf("'Back': Go back\n");
					System.out.printf("'Exit': Quit Program\n");
					System.out.printf("=======> ");
					userinput = input.next();
					//Operation options
					if (userinput.equalsIgnoreCase("Create")) {
						createAppo(appoinment, entitymanager);
					} else if (userinput.equalsIgnoreCase("View")) {
						viewAppo(appoinment, entitymanager);
					} else if (userinput.equalsIgnoreCase("Delete")) {
						deleteAppo(appoinment, entitymanager);
					} else if (userinput.equalsIgnoreCase("Exit")) {
						input.close();
						entitymanager.close();
						emfactory.close();
						System.exit(0);
					} else if (userinput.equalsIgnoreCase("Back")) {
						break;
					}
				}
			}
			if (userinput.equalsIgnoreCase("Exit")) { //exit
				input.close();
				entitymanager.close();
				emfactory.close();
				System.exit(0);
			}
		}

	}
	//insert new patient
	public static void createPatient(Patient patient,
			EntityManager entitymanager) {
		entitymanager.getTransaction().begin();   //begin synchronizing with database
		Scanner createP = new Scanner(System.in);  //get userinput
		System.out.printf("\nPlease provide Patient ID =====> ");
		int NewPID = createP.nextInt();
		System.out.printf("Please provide Patient First Name =====> ");
		String NewPfirstName = createP.next();
		System.out.printf("Please provide Patient Last Name =====> ");
		String NewPlastName = createP.next();
		System.out.printf("Please provide Patient Number =====> ");
		int NewPNumber = createP.nextInt();

		patient.setPatientID(NewPID);       //patient ID
		patient.setPfirstname(NewPfirstName); //first name
		patient.setPlastname(NewPlastName);  //last name
		patient.setPnumber(NewPNumber); //phone number

		entitymanager.persist(patient);	//persist with database
		entitymanager.getTransaction().commit();  //commit changes 
		// createP.close();
	}
	
	//select patient based on their last name
	public static void searchPatient(Patient patient,
			EntityManager entitymanager) {
		Scanner findP = new Scanner(System.in);
		System.out.printf("\nPlease provide patient's lastname =====> ");
		String findlastname = findP.next();   //get the last name
		Query q = entitymanager		//create a new select query 
				.createQuery("SELECT x FROM Patient x WHERE x.Plastname = "
						+ "'" + findlastname + "'");
		List<Patient> results = q.getResultList();   //get the matching result
		// patient = entitymanager.find(Patient.class, findPID );
		System.out.println(results);   //print the result
		// System.out.println("Patient First NAME = " + patient.getPfirstname(
		// ));
		// System.out.println("Patient Number = " + patient.getPnumber( ));
		// findP.close();
	}

	//delete patient
	public static void deletePatient(Patient patient,
			EntityManager entitymanager) {
		entitymanager.getTransaction().begin();		//begin 
		Scanner findP = new Scanner(System.in);
		System.out.printf("\nPlease provide patient's ID =====> ");
		int findPID = findP.nextInt();
		patient = entitymanager.find(Patient.class, findPID);	//find the patient based on ID
		entitymanager.remove(patient);	//remove that patient
		entitymanager.getTransaction().commit();	//commit change
	}

	//create new appointment 
	public static void createAppo(Appointment appointment,
			EntityManager entitymanager) {
		entitymanager.getTransaction().begin(); //begin synchronizing 
		Scanner createP = new Scanner(System.in);
		System.out.printf("\nPlease provide patient's ID =====> ");
		int NewPID = createP.nextInt();
		System.out.printf("Please provide Appointment Date 'yyyy-mm-dd' =====>  "); //format required
		String NewAppodate = createP.next();
		System.out.printf("Please provide Appointment Time 'hh:mm' =====>  ");	//format required
		String NewAppotime = createP.next();

		appointment.setPatientID(NewPID);	//set up patient ID
		appointment.setDate(NewAppodate);	//set up appointment date
		appointment.setTime(NewAppotime);	//set up appointment time

		entitymanager.persist(appointment);		//persist with database
		entitymanager.getTransaction().commit();	//commit changes
		// createP.close();
	}

	public static void viewAppo(Appointment appointment,
			EntityManager entitymanager) {

		Scanner findP = new Scanner(System.in);
		System.out.printf("\nPlease provide Appointment Start Date 'yyyy-mm-dd' =====>  ");
		String start = findP.next();
		System.out.printf("Please provide Appointment End Date 'yyyy-mm-dd' =====>  ");
		String end = findP.next();

		Query q = entitymanager
				.createQuery("SELECT x FROM Appointment x WHERE x.date >= "
						+ "'" + start + "'" + " AND " + "x.date <= " + "'"
						+ end + "'");
		List<Patient> results = q.getResultList();
		// patient = entitymanager.find(Patient.class, findPID );
		System.out.println(results);

	}

	public static void deleteAppo(Appointment appointment,
			EntityManager entitymanager) {
		entitymanager.getTransaction().begin();
		Scanner findP = new Scanner(System.in);
		System.out.printf("\nPlease provide Patient's ID =====>  ");
		int findPID = findP.nextInt();
		appointment = entitymanager.find(Appointment.class, findPID);
		entitymanager.remove(appointment);
		entitymanager.getTransaction().commit();
	}
}
