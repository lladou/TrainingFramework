package automation.force.api.sObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact extends SObject {
    @JsonProperty(value = "FirstName")
    private String firstName;
    @JsonProperty(value = "LastName")
    private String lastName;
    @JsonProperty(value = "Email")
    private String email;
    @JsonProperty(value = "Phone")
    private String phone;
    @JsonProperty(value = "MobilePhone")
    private String mobilePhone;
    @JsonProperty(value = "MailingCountry")
    private String mailingCountry;
    @JsonProperty(value = "IsPersonAccount")
    private Boolean isPersonAccount;
    @JsonProperty(value = "Account")
    private Object account;
    @JsonProperty(value = "Owner")
    private User owner;
    @JsonProperty(value = "LeadSource")
    private String leadSource;
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }

    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
    }

    public Boolean getIsPersonAccount() {
        return isPersonAccount;
    }

    public void setIsPersonAccount(Boolean isPersonAccount) {
        this.isPersonAccount = isPersonAccount;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    
    public String getLeadSource() {
        return leadSource;
    }
    
    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }
}