package Hospital_Service;
import java.util.List;
import java.util.Scanner;
import dao.HospitalServiceImpl;
import dao.ConcreteHospitalServiceImpl;
import dao.IHospitalService;
import entity.appointment;


public class service_datahospital extends HospitalServiceImpl{
	private HospitalServiceImpl adao;
	
	private Scanner sc;
	
	
	public service_datahospital() {
		
		sc=new Scanner(System.in);
		adao =  new ConcreteHospitalServiceImpl();
		
		
		
	}
		
	
	
	/*public void getAppointmentById() {
		
		appointment appID=new appointment();
		System.out.println("enter the appointment id");
		appID.setAppointmentID(sc.nextInt());
		adao.getAppointmentById();*/
	
	public void getAppointmentById() {
        System.out.println("Enter the appointment ID:");
        int appointmentId = sc.nextInt();
        sc.nextLine();
        
       appointment appointment = adao.getAppointmentById(appointmentId);
        if (appointment != null) {
            System.out.println("Appointment Details: " + appointment);
        } else {
            System.out.println("Appointment not found.");
        }
    }
		
		
		
	
	/*public void getAppointmentForPatient() {
		
		patient pID=new patient();
		System.out.println("enter patient id");
		pID.setPatientID(sc.nextInt());
		pdao.getAppointmentForPatient();
	}*/


public void getAppointmentForPatient() {
    System.out.println("Enter patient ID:");
    int patientId = sc.nextInt();
    List<appointment> appointments = adao.getAppointmentsForPatient(patientId);
    if (!appointments.isEmpty()) {
        for (appointment appointment : appointments) {
            System.out.println(appointment);
        }
    } else {
        System.out.println("No appointments found for the patient.");
    }
}
	
	
	/*public void getAppointmentsForDoctor() {
		
		doctor  dID=new doctor();
		System.out.println("enter doctor id");
		dID.setDoctorID(sc.nextInt());
		ddao.getAppointmentsForDoctor();
	}*/
public void getAppointmentsForDoctor() {
    System.out.println("Enter doctor ID:");
    int doctorId = sc.nextInt();
    List<appointment> appointments = adao.getAppointmentsForDoctor(doctorId);
    if (!appointments.isEmpty()) {
        for (appointment appointment : appointments) {
            System.out.println(appointment);
        }
    } else {
        System.out.println("No appointments found for the doctor.");
    }
}







		
	/*public void updateAppointment() {
		
		appointment appID=new appointment();
		System.out.println("enter appointment id to be added");
		appID.setAppointmentID(sc.nextInt());
		adao.updateAppointment();*/
		
		
		
		public void updateAppointment() {
	        appointment appointment = new appointment();
	        System.out.println("Enter appointment ID to be updated:");
	        appointment.setAppointmentID(sc.nextInt());
	        
	        boolean updated = adao.updateAppointment(appointment);
	        if (updated) {
	            System.out.println("Appointment updated successfully.");
	        } else {
	            System.out.println("Failed to update appointment.");
	        }
	    }
		
	
	
	/*public void cancelAppointment() {
		appointment appID=new appointment();
		System.out.println("enter the appointment id to be removed");
		appID.setAppointmentID(sc.nextInt());
		adao.remove(appID);
		
	}*/
		public void cancelAppointment() {
	        System.out.println("Enter the appointment ID to be removed:");
	        int appointmentId = sc.nextInt();
	        boolean removed = adao.cancelAppointment(appointmentId);
	        if (removed) {
	            System.out.println("Appointment removed successfully.");
	        } else {
	            System.out.println("Failed to remove appointment.");
	        }
	    }
		}



