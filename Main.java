import Hospital_Service.service_datahospital;
import Hospital_Service.service_datahospital;
import dao.HospitalServiceImpl;
import dao.IHospitalService;

public class Main {


public static void main(String[] args) {
	
   
    
	service_datahospital detail = new service_datahospital();
	
    detail.getAppointmentById();
    detail.getAppointmentForPatient();
    detail.getAppointmentsForDoctor();
    detail.updateAppointment();
    detail.cancelAppointment();
}
}
