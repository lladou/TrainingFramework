package automation.force.api.sObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Opportunity extends SObject {
	@JsonProperty(value = "Name")
    private String name;
	@JsonProperty(value = "CloseDate")
    private String closeDate;
	@JsonProperty(value = "StageName")
    private String stageName;
	@JsonProperty(value = "Account")
    private Object account;
	
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getCloseDate() {
    	return closeDate;
    }
    
    public void setCloseDate(String closeDate) {
    	this.closeDate = closeDate;
    }
    
    public String getStageName() {
    	return stageName;
    }
    
    public void setStageName(String stageName) {
    	this.stageName = stageName;
    }
    
    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }
}