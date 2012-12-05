package pl.comarch.interfaces;

import pl.comarch.datamodel.BloodPressureExamination;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Comarch
 * Date: 04.12.12
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */

@Local
public interface ExaminationFacadeLocal {

    public int create(BloodPressureExamination bloodPressureExamination);

    public List getBPExaminationList();
}
