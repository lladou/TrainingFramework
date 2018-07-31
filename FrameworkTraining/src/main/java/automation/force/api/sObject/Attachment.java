package automation.force.api.sObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Attachment extends SObject {
	@JsonProperty(value = "Name")
	private String name;
	@JsonProperty(value = "ParentId")
	private Object parentId;
	@JsonProperty(value = "Body")
	private String body;
	@JsonProperty(value = "BodyLength")
	private String bodyLength;
	@JsonProperty(value = "Description")
	private String description;
	
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public Object getParentId() {
    	return parentId;
    }
    
    public void setParentId(Object parentId) {
    	this.parentId = parentId;
    }
    
    public String getBody() {
    	return body;
    }
    
    public void setBody(String body) {
    	this.body = body;
    }
    
    public String getBodyLength() {
    	return bodyLength;
    }
    
    public void setBodyLength(String bodyLength) {
    	this.bodyLength = bodyLength;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
}