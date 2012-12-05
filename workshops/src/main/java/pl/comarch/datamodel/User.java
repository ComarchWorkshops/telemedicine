/* =============================================================================
* User.java
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

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String firstName;
	
	private String secondaryNames;
	
	private String fullName;

	private String phone;
	
	private String email;
	
	private String photoUrl;
	
	private Address address;
	
	public User(int id) {
		this.id = id;
	}
	
	public User(){}

    @Id   @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondaryNames() {
		return secondaryNames;
	}

	public void setSecondaryNames(String secondaryNames) {
		this.secondaryNames = secondaryNames;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}




	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}	
}
