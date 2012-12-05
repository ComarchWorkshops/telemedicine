package pl.comarch.datastore;

import pl.comarch.datamodel.BloodPressureExamination;
import pl.comarch.interfaces.ExaminationFacadeLocal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Comarch
 * Date: 04.12.12
 * Time: 16:25
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class ExaminationFacade implements ExaminationFacadeLocal {

    @PersistenceContext(unitName="workshopUnit")
    protected EntityManager entityManager;



    public int create(BloodPressureExamination examinationBP) {
        int newId = -1;
        try {
            entityManager.persist(examinationBP);
            entityManager.flush();

            newId = examinationBP.getId();

            return newId;
        } catch(Exception e) {

            return -1;
        }
    }

    @Override
    public List getBPExaminationList() {
        return entityManager.createQuery("SELECT bp FROM BloodPressureExamination AS bp").getResultList();
    }

}