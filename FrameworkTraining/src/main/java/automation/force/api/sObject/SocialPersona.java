package automation.force.api.sObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SocialPersona extends SObject {
	@JsonProperty(value = "ParentId")
	private Object parentId;
	@JsonProperty(value = "Provider")
	private String provider;
	@JsonProperty(value = "Name")
	private String name;
	@JsonProperty(value = "ExternalId")
	private String externalId;
	@JsonProperty(value = "ProfileType")
	private String profileType;
	@JsonProperty(value = "SourceApp")
	private String sourceApp;
	@JsonProperty(value = "RealName")
	private String realName;
	
	public Object getParentId() {
		return parentId;
	}
	
	public void setParentId(Object parentId) {
		this.parentId = parentId;
	}
	
	public String getProvider() {
		return provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public String getSourceApp() {
		return sourceApp;
	}
	
	public void setSourceApp(String sourceApp) {
		this.sourceApp = sourceApp;
	}
	
	public String getRealName() {
		return realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getProfileType() {
		return profileType;
	}
	
	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}
	
	public String getExternalId() {
		return externalId;
	}
	
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}