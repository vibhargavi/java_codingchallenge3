package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.appointment;
import util.DBConnUtil;

public class ConcreteHospitalServiceImpl extends HospitalServiceImpl {
	 private Connection conn;

	    public ConcreteHospitalServiceImpl() {
	    	this.conn = DBConnUtil.getConnect();
	    }
	
	@Override
    public appointment getAppointmentById(int appointmentId) {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from appointment where appointmentId = ?");
            ps.setInt(1, appointmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new appointment(
                        rs.getInt("appointmentId"),
                        rs.getInt("patientId"),
                        rs.getInt("doctorId"),
                        rs.getString("appointmentDate"),
                        rs.getString("description")
                );
            } else {
            	throw new Exception("Appointment ID not found: " + appointmentId);
            }
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<appointment> getAppointmentsForPatient(int patientId) {
        ArrayList<appointment> appointments = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from appointments where patientId = ?");
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                appointments.add(new appointment(
                        rs.getInt("appointmentId"),
                        rs.getInt("patientId"),
                        rs.getInt("doctorId"),
                        rs.getString("appointmentDate"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return appointments;
    }

    @Override
    public ArrayList<appointment> getAppointmentsForDoctor(int doctorId) {
        ArrayList<appointment> appointments = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select * FROM appointments where doctorId = ?");
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                appointments.add(new appointment(
                        rs.getInt("appointmentId"),
                        rs.getInt("patientId"),
                        rs.getInt("doctorId"),
                        rs.getString("appointmentDate"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return appointments;
    }

    @Override
    public boolean scheduleAppointment(appointment appointment) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO appointments (patientid, doctorId, appointmentDate, description) VALUES (?, ?, ?, ?)");
            ps.setInt(1, appointment.getPatientID());
            ps.setInt(2, appointment.getDoctorID());
            ps.setString(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getDescription());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateAppointment(appointment appointment) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE appointments SET patientId = ?, doctorId = ?, appointmentDate = ?, description = ? WHERE appointmentId = ?");
            ps.setInt(1, appointment.getPatientID());
            ps.setInt(2, appointment.getDoctorID());
            ps.setString(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getDescription());
            ps.setInt(5, appointment.getAppointmentID());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean cancelAppointment(int appointmentId) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM appointments WHERE appointmentId = ?");
            ps.setInt(1, appointmentId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}