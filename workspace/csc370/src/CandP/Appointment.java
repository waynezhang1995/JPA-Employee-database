package CandP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PatientID;
	private String date;
	private String time;
	

	public Appointment(String date, String time) {
		super();
		this.date = date;
		this.time = time;
	}

	public Appointment() {
		super();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getPatientID() {
		return PatientID;
	}

	public void setPatientID(int PatientID) {
		this.PatientID = PatientID;
	}

	@Override
	public String toString() {
		return "\nAppointment:\nPatient ID=" + PatientID + "\nDate=" + date +"\ntime="+ time+"\n";
	}
}
