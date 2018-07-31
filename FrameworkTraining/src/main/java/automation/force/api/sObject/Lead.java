package automation.force.api.sObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lead extends SObject {
	@JsonProperty(value = "Name")
	private String name;
	@JsonProperty(value = "Phone")
	private String phone;
	@JsonProperty(value = "Company")
	private String company;
    @JsonProperty(value = "FirstName")
    private String firstName;
    @JsonProperty(value = "LastName")
    private String lastName;
    @JsonProperty(value = "Status")
    private String status;
	
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getPhone() {
    	return phone;
    }
    
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    
    public String getCompany() {
    	return company;
    }
    
    public void setCompany(String company) {
    	this.company = company;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getStatus() {
    	return status;
    }
    
    public void setStatus(String status) {
    	this.status = status;
    }

}