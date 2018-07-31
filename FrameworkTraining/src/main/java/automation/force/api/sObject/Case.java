package automation.force.api.sObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Case extends SObject{
    @JsonProperty(value = "Status")
    private String status;
	@JsonProperty(value = "AccountId")
	private Object accountId;
	@JsonProperty(value = "Account")
	private Object account;
	@JsonProperty(value = "Contact")
	private Object contact;
	@JsonProperty(value = "Source")
	private String source;
	@JsonProperty(value = "ContactId")
	private Object contactId;
	@JsonProperty(value = "Origin")
	private String origin;
	@JsonProperty(value = "Subject")
	private String subject;
	@JsonProperty(value = "CaseNumber")
	private String caseNumber;
	
    public String getStatus() {
    	return status;
    }
    
    public void setStatus(String status) {
    	this.status = status;
    }
    
    public Object getAccountId() {
    	return accountId;
    }
    
    public void setAccountId(Object accountId) {
    	this.accountId = accountId;
    }
    
    public Object getAccount() {
    	return account;
    }
    
    public void setAccount(Object account) {
    	this.account = account;
    }
    
    public Object getContact() {
      	return contact;
    }
      	
    public void setContact(Object contact) {
      	this.contact = contact;
    }
    
    public Object getContactId() {
    	return contactId;
    }
    
    public String getSource() {
    	return source;
    }
    
    public void setSource(String source) {
    	this.source = source;
    }
    
    public void setContactId(Object contactId) {
    	this.contactId = contactId;
    }
    
    public String getOrigin() {
    	return origin;
    }
    
    public void setOrigin(String origin) {
    	this.origin = origin;
    }
    
    public String getSubject() {
    	return subject;
    }
    
    public void setSubject(String subject) {
    	this.subject = subject;
    }
    
    public String getCaseNumber() {
    	return caseNumber;
    }
    
    public void setCaseNumber(String caseNumber) {
    	this.caseNumber = caseNumber;
    } 
}