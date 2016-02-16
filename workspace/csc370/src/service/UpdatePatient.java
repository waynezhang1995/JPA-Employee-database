package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import CandP.Patient;

public class UpdatePatient {
   public static void main( String[ ] args ) {
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("csc370");
      
      EntityManager entitymanager = emfactory.createEntityManager( );
      entitymanager.getTransaction( ).begin( );
      Patient patient = entitymanager.find( Patient.class, 1201 );
      
      //before update
      System.out.println( patient );
      patient.setPnumber( 46000 );
      entitymanager.getTransaction( ).commit( );
      
      //after update
      System.out.println( patient );
      entitymanager.close();
      emfactory.close();
   }
}
