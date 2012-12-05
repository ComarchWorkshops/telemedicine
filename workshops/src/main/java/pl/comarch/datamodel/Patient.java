/* =============================================================================
* Patient.java
*
* Copyright (c) 2012-2012 iMed24 S.A.
* All Rights Reserved.
* Any usage, modification, duplication or redistribution of this software is allowed only
* according to separate agreement prepared in written between iMed24 S.A.
* and authorized party.
*
* Author: Tomasz Nedza, tomasz.nedza@imed24.pl
* Modified:   12/08/16 Created
*
* ==============================================================================
*/
package pl.comarch.datamodel;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@Entity
public class Patient extends User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String pesel;
	
	private Date birthDate;

	public enum Sex {
		Male, Female;
	}

    private Boolean isBloodPressureExamination;
    private Integer systolicPressure;
    private Integer diastolicPressure;
    private Integer pulse;

    public Boolean getBloodPressureExamination() {
        return isBloodPressureExamination;
    }

    public void setBloodPressureExamination(Boolean bloodPressureExamination) {
        isBloodPressureExamination = bloodPressureExamination;
    }

    public Integer getSystolicPressure() {
        return systolicPressure;
    }

    public void setSystolicPressure(Integer systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public Integer getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setDiastolicPressure(Integer diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }



    private Sex sex;
	
	private String knownLocation;
	//private Location knownLocation;

	public Patient() {}
	
	public Patient(int patientId) {
		setId(patientId);
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getKnownLocation() {
		return knownLocation;
	}

	public void setKnownLocation(String knownLocation) {
		this.knownLocation = knownLocation;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (birthDate != null ? !birthDate.equals(patient.birthDate) : patient.birthDate != null) return false;
        if (diastolicPressure != null ? !diastolicPressure.equals(patient.diastolicPressure) : patient.diastolicPressure != null)
            return false;
        if (isBloodPressureExamination != null ? !isBloodPressureExamination.equals(patient.isBloodPressureExamination) : patient.isBloodPressureExamination != null)
            return false;
        if (knownLocation != null ? !knownLocation.equals(patient.knownLocation) : patient.knownLocation != null)
            return false;
        if (pesel != null ? !pesel.equals(patient.pesel) : patient.pesel != null) return false;
        if (pulse != null ? !pulse.equals(patient.pulse) : patient.pulse != null) return false;
        if (sex != patient.sex) return false;
        if (systolicPressure != null ? !systolicPressure.equals(patient.systolicPressure) : patient.systolicPressure != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pesel != null ? pesel.hashCode() : 0;
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (isBloodPressureExamination != null ? isBloodPressureExamination.hashCode() : 0);
        result = 31 * result + (systolicPressure != null ? systolicPressure.hashCode() : 0);
        result = 31 * result + (diastolicPressure != null ? diastolicPressure.hashCode() : 0);
        result = 31 * result + (pulse != null ? pulse.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (knownLocation != null ? knownLocation.hashCode() : 0);
        return result;
    }
}
