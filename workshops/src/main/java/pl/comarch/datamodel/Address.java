/* =============================================================================
* Address.java
*
* Copyright (c) 2012-2012 iMed24 S.A.
* All Rights Reserved.
* Any usage, modification, duplication or redistribution of this software is allowed only
* according to separate agreement prepared in written between iMed24 S.A.
* and authorized party.
*
* Author:
* Modified:
*
* ==============================================================================
*/
package pl.comarch.datamodel;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Address implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String country;
	
	private String city;
	
	private String street;
	
	private String postalCode;	
	
	public Address() {}

    @Id
    @GeneratedValue
	public int getId(){
		return id;
	}
    
	public String getCountry(){
		return country;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getStreet(){
		return street;
	}
    
	public String getPostalCode(){
		return postalCode;
	}
	
	
	public void setId(int id){
		this.id = id;
	}
    
	public void setCountry( String country ){
		this.country = country;
	}
	
	public void setCity( String city ){
		this.city = city;
	}
	
	public void setStreet( String street ){
		this.street = street;
	}
	
	public void setPostalCode( String postalCode ){
		this.postalCode = postalCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id != other.id)
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
}
