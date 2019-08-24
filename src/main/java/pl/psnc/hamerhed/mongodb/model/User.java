package pl.psnc.hamerhed.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "test")
public class User {

    @Id
    private String id;

    private Gender gender;
    
    private Organization organization;
    
    private User() {}
    
    public User(Gender gender, Organization org) {
    	this.gender = gender;
    	this.organization = org;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

	public Gender getGender() {
		return gender;
	}

	private void setGender(Gender gender) {
		this.gender = gender;
	}

	public Organization getOrganization() {
		return organization;
	}

	private void setOrganization(Organization organization) {
		this.organization = organization;
	}

   
    
}
