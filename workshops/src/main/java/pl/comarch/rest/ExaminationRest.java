package pl.comarch.rest;

import pl.comarch.datamodel.BloodPressureExamination;
import pl.comarch.interfaces.ExaminationFacadeLocal;
import pl.comarch.interfaces.PatientsInterfaceLocal;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marcin
 * Date: 30.11.12
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
 */
@Path("/rest/examination")
public class ExaminationRest {

    @EJB
    ExaminationFacadeLocal examinationFacade;

    @EJB
    PatientsInterfaceLocal patientsInterfaceLocal;

    @GET
    @Path("/bp")
    @Produces({MediaType.APPLICATION_JSON})
    public Response saveExaminationBloodPressure(@QueryParam("patientID") Integer patientId,
                                                 @QueryParam("systolic") @DefaultValue("0") Integer systolic,
                                                 @QueryParam("diastolic")@DefaultValue("0") Integer diastolic,
                                                 @QueryParam("puls")@DefaultValue("0") Integer pulse)
    {
        BloodPressureExamination bloodPressureExamination =  new BloodPressureExamination();
        bloodPressureExamination.setPatientID(patientId);
        bloodPressureExamination.setSystolicPressure(systolic);
        bloodPressureExamination.setDiastolicPressure(diastolic);
        bloodPressureExamination.setPulse(pulse);

        examinationFacade.create(bloodPressureExamination);
        patientsInterfaceLocal.addExamination(bloodPressureExamination);

        return  Response.ok(bloodPressureExamination).build();
    }


   /*
    @POST
    @Path("/bp")
    @Produces({MediaType.APPLICATION_JSON})
    public Response saveExaminationBloodPressure(@QueryParam("patientID") Integer patientId,
                                                 @QueryParam("systolic") @DefaultValue("0") Integer systolic,
                                                 @QueryParam("diastolic")@DefaultValue("0") Integer diastolic)
    {
        BloodPressureExamination bloodPressureExamination =  new BloodPressureExamination();
        bloodPressureExamination.setPatientID(patientId);
        bloodPressureExamination.setSystolicPressure(systolic);
        bloodPressureExamination.setDiastolicPressure(diastolic);

        examinationFacade.create(bloodPressureExamination);

        return  Response.ok(bloodPressureExamination).build();
    }

     */

    @GET()
    @Path("/bp/list")
    @Produces
    public List getExaminationsBPList()
    {
        return examinationFacade.getBPExaminationList();
    }


}
