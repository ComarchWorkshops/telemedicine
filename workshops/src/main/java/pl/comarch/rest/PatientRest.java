package pl.comarch.rest;

import pl.comarch.datamodel.Patient;
import pl.comarch.interfaces.PatientsInterfaceLocal;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: Marcin
 * Date: 30.11.12
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 */

@Path("/rest")
public class PatientRest {

    @EJB
    private PatientsInterfaceLocal patientsInterfaceLocal;


    @GET
    @Path("patient/datamodel/{patientID}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getPatientData(@PathParam("patientID") int patientID)
    {
        Patient result = patientsInterfaceLocal.find(patientID);
        if(result != null)
        {
            return Response.ok(result).build();
        }

        return  Response.ok(null).build();
    }

    @GET
    @Path("patient/add")
    @Produces({MediaType.APPLICATION_JSON})
    public Response addPatient()
    {
        Patient patient = new Patient();
        patient.setFirstName("Jan");
        patient.setFullName("Kowalski");
        patient.setPesel("78071485643");
        patient.setEmail("jan.kowalski@o2.pl");
        patient.setPhone("12 47 324 11");
        patient.setSex(Patient.Sex.Male);
        patientsInterfaceLocal.create(patient);

        return Response.ok(patient).build();
    }

    @GET
    @Path("patient/list")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getPatientsList()
    {
        return Response.ok(patientsInterfaceLocal.findAll()).build();
    }
}
