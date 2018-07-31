package automation.force.api;

import automation.properties.Settings;

/**
 * Holds the configuration parameters for interacting with Force.com.
 */
public class ForceApiConfiguration {
    private static ForceApiConfiguration instance = null;
    private String loginUrl;
    private String username;
    private String password;
    private String clientId;
    private String clientSecret;

    protected ForceApiConfiguration(String loginUrl, String username, String password, String clientId, String clientSecret) {
        this.loginUrl = loginUrl;
        this.username = username;
        this.password = password;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }
    
    /**
     * Gets the Login URL.
     * @return String
     */
    public String getLoginUrl() {
        return loginUrl;
    }
    
    /**
     * Gets the Username.
     * @return String
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Gets the Password.
     * @return String
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Gets the Client Id.
     * @return String
     */
    public String getClientId() {
        return clientId;
    }
    
    /**
     * Gets the Client Secret.
     * @return String
     */
    public String getClientSecret() {
        return clientSecret;
    }
    
    /**
     * Gets the instance of the ForceApiConfiguration class object.
     * @return ForceApiConfig
     */
    public static ForceApiConfiguration getInstance() {
        if (instance == null) {
            instance = new ForceApiConfiguration(Settings.getForceLoginUrl(), Settings.getForceUsername(),
                    Settings.getForcePassword(), Settings.getForceClientId(), Settings.getForceClientSecret());
        }

        return instance;
    }

    @Override
    public String toString() {
        return String.format(
                "ForceApiConfiguration [apiVersion=%s, loginUrl=%s, username=%s, password=%s, clientId=%s, clientSecret=%s]",
                loginUrl, username, password, clientId, clientSecret);
    }
}