package automation.force.api;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.client.ClientProtocolException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import automation.force.api.common.JsonHttpClient;
import automation.force.api.common.JsonHttpClientException;
import automation.force.api.json.AuthenticationErrorResponse;

/**
 * Provides OAuth Authentication for interacting with Force.com.
 */
public class ForceApiAuthentication {
    private static ForceApiAuthentication instance = null;
    private ForceApiConfiguration config;
    private JsonHttpClient jsonHttpClient;
    private ObjectMapper jsonMapper;
    
    protected ForceApiAuthentication(ForceApiConfiguration config) {
        this.config = config;

        jsonHttpClient = JsonHttpClient.createJsonHttpClient();

        jsonMapper = new ObjectMapper();
        jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
    
    /**
     * Gets the ForceApiAuthentication object.
     * @return ForceApiAuthentication
     */
    public static ForceApiAuthentication getInstance() {
        if (instance == null) {
            ForceApiConfiguration config = ForceApiConfiguration.getInstance();

            instance = new ForceApiAuthentication(config);
        }

        return instance;
    }

    private ForceApiAuthenticationException parseForceApiAuthenticationException(String json)
            throws JsonParseException, JsonMappingException, IOException {
        AuthenticationErrorResponse errorResponse = jsonMapper.readValue(json, AuthenticationErrorResponse.class);

        return new ForceApiAuthenticationException(errorResponse.getErrorDescription(), errorResponse.getError());
    }
    
    /**
     * Authenticates using the user's username and password to request an access token.
     * @return ForceApiSession
     * @throws ClientProtocolException
     * @throws IOException
     * @throws ForceApiAuthenticationException
     */
    public ForceApiSession usernamePasswordOAuthFlow()
            throws ClientProtocolException, IOException, ForceApiAuthenticationException {
        try {
            String uri = config.getLoginUrl() + "?grant_type=password" + "&client_id="
                    + URLEncoder.encode(config.getClientId(), "UTF-8") + "&client_secret="
                    + URLEncoder.encode(config.getClientSecret(), "UTF-8") + "&username="
                    + URLEncoder.encode(config.getUsername(), "UTF-8") + "&password="
                    + URLEncoder.encode(config.getPassword(), "UTF-8");

            String json = jsonHttpClient.HttpPost(uri);

            ForceApiSession session = jsonMapper.readValue(json, ForceApiSession.class);

            return session;
        } catch (JsonHttpClientException e) {
            throw parseForceApiAuthenticationException(e.getMessage());
        }
    }
}
