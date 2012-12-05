package pl.comarch.interfaces;

import pl.comarch.datamodel.BloodPressureExamination;
import pl.comarch.datamodel.Patient;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PatientsInterfaceLocal {


    public Patient addExamination(BloodPressureExamination examination);
	public List<Patient> findAll();
	public Patient find(int patientId);
	public Patient update(Patient patient);
	public int create(Patient patient);
	public void remove(int patientId);
	public List<Patient> findRange(int offset, int limit);
	public long count();
	public void updateLocation(int patientId, String Location);
}

