package CandP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Patient {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO) 	
   
   private int PatientID;
   private String Pfirstname;
   private String Plastname;
   private int Pnumber;
   
   public Patient(int PatientID, String Pfirstname, String Plastname,int Pnumber) {
      super( );
      this.PatientID = PatientID;
      this.Pfirstname = Pfirstname;
      this.Plastname = Plastname;
      this.Pnumber = Pnumber;
   }

   public Patient( ) {
      super();
   }

   public int getPatientID( ) {
      return PatientID;
   }
   
   public void setPatientID(int PatientID) {
      this.PatientID = PatientID;
   }
   
   public String getPlastname(){
	   return Plastname;
   }
   
   public String getPfirstname( ) {
      return Pfirstname;
   }
   public void setPlastname(String Plastname) {
	      this.Plastname = Plastname;
	   }
   public void setPfirstname(String Pfirstname) {
      this.Pfirstname = Pfirstname;
   }

   public int getPnumber( ) {
      return Pnumber;
   }
   
   public void setPnumber(int Pnumber) {
      this.Pnumber = Pnumber;
   }


   @Override
   public String toString() {
      return "\nPatient:\nPatient ID=" + PatientID + "\nPatient First Name=" + Pfirstname +"\nPatient Last Name="+ Plastname+"\nPatient Number=" + Pnumber+"\n";
   }
}