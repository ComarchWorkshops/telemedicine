package pl.comarch.datastore;

import pl.comarch.datamodel.BloodPressureExamination;
import pl.comarch.datamodel.Patient;
import pl.comarch.interfaces.PatientsInterfaceLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Comarch
 * Date: 04.12.12
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class PatientFacade implements PatientsInterfaceLocal {

    @PersistenceContext(unitName="workshopUnit")
    protected EntityManager entityManager;


    @Override
    public Patient addExamination(BloodPressureExamination examination) {
        Patient patient = entityManager.find(Patient.class, examination.getPatientID());

        if(patient != null)
        {
            patient.setBloodPressureExamination(true);
            patient.setDiastolicPressure(examination.getDiastolicPressure());
            patient.setSystolicPressure(examination.getSystolicPressure());
            patient.setPulse(examination.getPulse());

            entityManager.merge(patient);
            entityManager.flush();
        }
        return  null;
    }

    @Override
    public List<Patient> findAll() {
        return entityManager.createQuery("SELECT p FROM Patient AS p").getResultList();
    }

    @Override
    public Patient find(int patientId) {
        return entityManager.find(Patient.class, patientId);
    }

    @Override
    public Patient update(Patient patient) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int create(Patient patient) {
        int newId = -1;
        try {
            entityManager.persist(patient);
            entityManager.flush();

            newId = patient.getId();

            return newId;
        } catch(Exception e) {

            return -1;
        }
    }

    @Override
    public void remove(int patientId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Patient> findRange(int offset, int limit) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long count() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateLocation(int patientId, String Location) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
