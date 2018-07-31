package automation.force.api.common;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Basic JSON HTTP Client that extends BaseHttpClient.
 */
public class JsonHttpClient extends BaseHttpClient {
    private final static String contentType = "application/json";
    private static List<Header> defaultHeaders = Arrays.asList(new BasicHeader(HttpHeaders.ACCEPT, contentType));
    private ObjectMapper jsonMapper;

    protected JsonHttpClient(CloseableHttpClient httpClient) {
        super(httpClient, contentType);

        jsonMapper = new ObjectMapper();
        jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
    
    /**
     * Creates a new instance of the JsonHttpClient class object.
     * @return JsonHttpClient
     */
    public static JsonHttpClient createJsonHttpClient() {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultHeaders(defaultHeaders).build();

        JsonHttpClient jsonHttpClient = new JsonHttpClient(httpClient);

        return jsonHttpClient;
    }
    
    /**
     * Creates a new instance of the JsonHttpClient class object.
     * @param defaultHeaders Default request headers to be assigned.
     * @return JsonHttpClient
     */
    public static JsonHttpClient createJsonHttpClient(List<Header> defaultHeaders) {
        defaultHeaders.addAll(defaultHeaders);

        CloseableHttpClient httpClient = HttpClients.custom().setDefaultHeaders(defaultHeaders).build();

        JsonHttpClient jsonHttpClient = new JsonHttpClient(httpClient);

        return jsonHttpClient;
    }
    
    /**
     * Sends a GET request to the specified URI.
     * @param uri The URI the request is sent to.
     * @return String The JSON string.
     */
    public String HttpGet(String uri) throws ClientProtocolException, IOException, JsonHttpClientException {
        try {
            String json = super.HttpGet(uri);

            return json;
        } catch (BaseHttpClientException e) {
            throw new JsonHttpClientException(e.getMessage(), e.getStatusCode());
        }
    }
    
    /**
     * Sends a POST request to the specified URI.
     * @param uri The URI the request is sent to.
     * @return String The JSON string.
     */
    public String HttpPost(String uri) throws ClientProtocolException, IOException, JsonHttpClientException {
        try {
            String json = super.HttpPost(uri);

            return json;
        } catch (BaseHttpClientException e) {
            throw new JsonHttpClientException(e.getMessage(), e.getStatusCode());
        }
    }
    
    /**
     * Sends a POST request to the specified URI.
     * @param uri The URI the request is sent to.
     * @param object The JSON object that is sent.
     * @return String The JSON string.
     */
    public String HttpPost(String uri, Object object)
            throws ClientProtocolException, IOException, JsonHttpClientException {
        try {
            String payload = jsonMapper.writeValueAsString(object);

            String json = super.HttpPost(uri, payload);

            return json;
        } catch (BaseHttpClientException e) {
            throw new JsonHttpClientException(e.getMessage(), e.getStatusCode());
        }
    }
    
    /**
     * Sends a DELETE request to the specified URI.
     * @param uri The URI the request is sent to.
     * @return String The JSON string.
     */
    public String HttpDelete(String uri) throws ClientProtocolException, IOException, JsonHttpClientException {
        try {
            String json = super.HttpDelete(uri);

            return json;
        } catch (BaseHttpClientException e) {
            throw new JsonHttpClientException(e.getMessage(), e.getStatusCode());
        }
    }
    
    /**
     * Sends a PUT request to specified URI.
     * @param uri The URI the request is sent to.
     * @param json The body of the request
     * @return String The JSON String
     * @throws IOException 
     * @throws ClientProtocolException 
     * @throws JsonHttpClientException 
     */
    public String HttpPut(String uri, Object object) throws ClientProtocolException, IOException, JsonHttpClientException {
    	try {
    		String payload = jsonMapper.writeValueAsString(object);
    		
    		String json = super.HttpPut(uri, payload);
    		
    		return json;
    	} catch (BaseHttpClientException e) {
    		throw new JsonHttpClientException(e.getMessage(), e.getStatusCode());
    	}
    	
    }
    
    /**
     * Sends a PATCH request to specified URI.
     * @param uri The URI the request is sent to.
     * @param json The body of the request
     * @return String The JSON String
     * @throws IOException 
     * @throws ClientProtocolException 
     * @throws JsonHttpClientException 
     */
    public String HttpPatch(String uri, Object object) throws ClientProtocolException, IOException, JsonHttpClientException {
    	try {
    		String payload = jsonMapper.writeValueAsString(object);
    		
    		String json = super.HttpPatch(uri, payload);
    		
    		return json;
    	} catch (BaseHttpClientException e) {
    		throw new JsonHttpClientException(e.getMessage(), e.getStatusCode());
    	}
    }
}
