package automation.force.api.sObject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User extends SObject {
    @JsonProperty(value = "FirstName")
    private String firstName;
    @JsonProperty(value = "LastName")
    private String lastName;
    @JsonProperty(value = "Locale")
    private String locale;
    @JsonProperty(value = "Alias")
    private String alias;
    @JsonProperty(value = "Email")
    private String email;
    @JsonProperty(value = "Username")
    private String username;
    @JsonProperty(value = "CommunityNickname")
    private String communityNickname;
    @JsonProperty(value = "UserRoleId")
    private Object userRoleId;
    @JsonProperty(value = "ProfileId")
    private Object profileId;
    @JsonProperty(value = "EmailEncodingKey")
    private String emailEncodingKey;
    @JsonProperty(value = "TimeZoneSidKey")
    private String timeZoneSidKey;
    @JsonProperty(value = "LocaleSidKey")
    private String localeSidKey;
    @JsonProperty(value = "LanguageLocaleKey")
    private String languageLocaleKey;
    @JsonProperty(value = "IsActive")
    private Boolean isActive;

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
    
    public String getLocale() {
    	return locale;
    }
    
    public void setLocale(String locale) {
    	this.locale = locale;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getCommunityNickname() {
        return communityNickname;
    }

    public void setCommunityNickname(String communityNickname) {
        this.communityNickname = communityNickname;
    }
    
    public Object getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Object userRoleId) {
        this.userRoleId = userRoleId;
    }
    
    public Object getProfileId() {
        return profileId;
    }

    public void setProfileId(Object profileId) {
        this.profileId = profileId;
    }
    
    public String getEmailEncodingKey() {
        return emailEncodingKey;
    }

    public void setEmailEncodingKey(String emailEncodingKey) {
        this.emailEncodingKey = emailEncodingKey;
    }
    
    public String getTimeZoneSidKey() {
        return timeZoneSidKey;
    }

    public void setTimeZoneSidKey(String timeZoneSidKey) {
        this.timeZoneSidKey = timeZoneSidKey;
    }
    
    public String getLocaleSidKey() {
        return localeSidKey;
    }

    public void setLocaleSidKey(String localeSidKey) {
        this.localeSidKey = localeSidKey;
    }
    
    public String getLanguageLocaleKey() {
        return languageLocaleKey;
    }

    public void setLanguageLocaleKey(String languageLocaleKey) {
        this.languageLocaleKey = languageLocaleKey;
    }
    
    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
