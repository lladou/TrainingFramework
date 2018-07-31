package automation.force.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Holds the session details for interacting with Force.com.
 */
public class ForceApiSession {
    @JsonProperty(value = "access_token")
    private String accessToken;
    @JsonProperty(value = "instance_url")
    private String instanceUrl;
    @JsonProperty(value = "id")
    private String id;
    @JsonProperty(value = "token_type")
    private String tokenType;
    @JsonProperty(value = "issued_at")
    private String issuedAt;
    @JsonProperty(value = "signature")
    private String signature;

    /**
     * Gets the Access Token.
     * @return String
     */
    public String getAccessToken() {
        return accessToken;
    }
    
    /**
     * Sets the Access Token.
     * @param accessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    
    /**
     * Gets the Instance URL.
     * @return String
     */
    public String getInstanceUrl() {
        return instanceUrl;
    }
    
    /**
     * Sets the Instance URL.
     * @param instanceUrl
     */
    public void setInstanceUrl(String instanceUrl) {
        this.instanceUrl = instanceUrl;
    }
    
    /**
     * Gets the ID.
     * @return String
     */
    public String getId() {
        return id;
    }
    
    /**
     * Sets the ID.
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Gets the Token Type.
     * @return String
     */
    public String getTokenType() {
        return tokenType;
    }
    
    /**
     * Sets the Token Type.
     * @param tokenType
     */
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
    
    /**
     * Gets the Issued At.
     * @return String
     */
    public String getIssuedAt() {
        return issuedAt;
    }
    
    /**
     * Sets the Issued At.
     * @param issuedAt
     */
    public void setIssuedAt(String issuedAt) {
        this.issuedAt = issuedAt;
    }
    
    /**
     * Gets the Signature.
     * @return String
     */
    public String getSignature() {
        return signature;
    }
    
    /**
     * Sets the Signature.
     * @param signature
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return String.format(
                "ForceApiSession [accessToken=%s, instanceUrl=%s, id=%s, tokenType=%s, issuedAt=%s, signature=%s]",
                accessToken, instanceUrl, id, tokenType, issuedAt, signature);
    }
}
