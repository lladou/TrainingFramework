package automation.force.api;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicHeader;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import automation.force.api.common.JsonHttpClient;
import automation.force.api.common.JsonHttpClientException;
import automation.force.api.json.ErrorResponse;
import automation.force.api.json.QueryResponse;
import automation.force.api.json.SObjectTreeRequest;
import automation.force.api.json.SObjectTreeResponse;
import automation.force.api.json.SearchResponse;
import automation.force.api.json.SuccessResponse;
import automation.force.api.sObject.SObject;
import automation.properties.Settings;

/**
 * REST API for interacting with Force.com.
 */
public class ForceApi {
    private static ForceApi instance = null;
    private ForceApiSession session;
    private JsonHttpClient jsonHttpClient;
    private ObjectMapper jsonMapper;
    
    protected ForceApi(ForceApiSession session) {
        this.session = session;

        List<Header> defaultHeaders = new ArrayList<Header>();
        defaultHeaders.add(new BasicHeader(HttpHeaders.AUTHORIZATION, "Bearer " + session.getAccessToken()));

        jsonHttpClient = JsonHttpClient.createJsonHttpClient(defaultHeaders);

        jsonMapper = new ObjectMapper();
        jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
    
    /**
     * Gets the ForceApiSession object.
     * @return ForceApiSession
     */
    public ForceApiSession getSession() {
        return session;
    }
    
    /**
     * Gets the instance of the ForceApi class object.
     * @return ForceApi
     * @throws ForceApiException
     */
    public static ForceApi getInstance() throws ForceApiException {
        try {
            if (instance == null) {
                ForceApiAuthentication auth = ForceApiAuthentication.getInstance();

                ForceApiSession session = auth.usernamePasswordOAuthFlow();

                instance = new ForceApi(session);
            }

            return instance;
        } catch (Exception e) {
            throw new ForceApiException(e.getMessage());
        }
    }

    private ForceApiException ParseForceApiException(String json)
            throws JsonParseException, JsonMappingException, IOException {
        List<ErrorResponse> errorResponses = jsonMapper.readValue(json, new TypeReference<List<ErrorResponse>>() {
        });

        ErrorResponse errorResponse = errorResponses.get(0);

        return new ForceApiException(errorResponse.getMessage(), errorResponse.getErrorCode(),
                errorResponse.getFields());
    }
    
    /**
     * Creates a new record for a specified SObject.
     * @param sObjectName The name of the SObject.
     * @param sObject The SObject class object.
     * @return SuccessResponse
     * @throws ClientProtocolException
     * @throws IOException
     * @throws ForceApiException
     */
    public SuccessResponse create(String sObjectName, SObject sObject)
            throws ClientProtocolException, IOException, ForceApiException {
        try {
            String uri = uriBase() + "/sobjects/" + sObjectName;

            String json = jsonHttpClient.HttpPost(uri, sObject);

            SuccessResponse successResponse = jsonMapper.readValue(json, SuccessResponse.class);

            return successResponse;
        } catch (JsonHttpClientException e) {
            throw ParseForceApiException(e.getMessage());
        }
    }
    
    /**
     * Deletes a record for a specified record Id.
     * @param sObjectName The name of the SObject.
     * @param id The record Id of the SObject.
     * @return SuccessResponse
     * @throws ClientProtocolException
     * @throws IOException
     * @throws ForceApiException
     */
   /* public SuccessResponse delete(String sObjectName, String id)
            throws ClientProtocolException, IOException, ForceApiException {
        try {
            String uri = uriBase() + "/sobjects/" + sObjectName + "/" + id;

            String json = jsonHttpClient.HttpDelete(uri);

            SuccessResponse successResponse = jsonMapper.readValue(json, SuccessResponse.class);

            return successResponse;
        } catch (JsonHttpClientException e) {
            throw ParseForceApiException(e.getMessage());
        }
    }*/
    public void delete(String sObjectName, String id)
            throws ClientProtocolException, IOException, ForceApiException {
        try {
            String uri = uriBase() + "/sobjects/" + sObjectName + "/" + id;

            String json = jsonHttpClient.HttpDelete(uri);
        } catch (JsonHttpClientException e) {
            throw ParseForceApiException(e.getMessage());
        }
    }
    
    /**
     * <h1>update</h1>
     * Updates a record for a specified record Id.
     * @param sObjectName The name of the SObject
     * @param id the record Id of the SObject
     * @param json Json 
     * @throws IOException 
     * @throws ForceApiException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    public void update(String sObjectName, SObject sObject, String id) 
    		throws ClientProtocolException, ForceApiException, IOException {
    	
    	try {
    		String uri = uriBase() + "/sobjects/" + sObjectName + "/" + id;
    		
    		String json = jsonHttpClient.HttpPatch(uri, sObject);
    		
    		//SuccessResponse response = jsonMapper.readValue(json, SuccessResponse.class);
    		
    		//return response;
    	} catch (JsonHttpClientException e) {
    		throw ParseForceApiException(e.getMessage());
    	}
    }
    
    /*
     *     public SuccessResponse update(String sObjectName, SObject sObject, String id) 
    		throws ClientProtocolException, ForceApiException, IOException {
    	
    	try {
    		String uri = uriBase() + "/sobjects/" + sObjectName + "/" + id;
    		
    		String json = jsonHttpClient.HttpPatch(uri, sObject);
    		
    		//SuccessResponse response = jsonMapper.readValue(json, SuccessResponse.class);
    		
    		//return response;
    	} catch (JsonHttpClientException e) {
    		throw ParseForceApiException(e.getMessage());
    	}
    }
     */
    
    /**
     * Executes the specified SOQL query.
     * @param query The SOQL query.
     * @param clazz Class type that extends the SObject class type.
     * @return QueryResponse<T> where T extends the SObject class type.
     * @throws ClientProtocolException
     * @throws IOException
     * @throws ForceApiException
     */
    public <T extends SObject> QueryResponse<T> query(String query, Class<T> clazz)
            throws ClientProtocolException, IOException, ForceApiException {
        try {
            String uri = uriBase() + "/query/?q=" + URLEncoder.encode(query, "UTF-8");

            String json = jsonHttpClient.HttpGet(uri);

            QueryResponse<T> queryResponse = jsonMapper.readValue(json,
                    jsonMapper.getTypeFactory().constructParametricType(QueryResponse.class, clazz));
            
            return queryResponse;
        } catch (JsonHttpClientException e) {
            throw ParseForceApiException(e.getMessage());
        }
    }
    
    /**
     * Executes the specified SOSL query.
     * @param query The SOSL query.
     * @param clazz Class type that extends the SObject class type.
     * @return SearchResponse<T> where T extends the SObject class type.
     * @throws ClientProtocolException
     * @throws IOException
     * @throws ForceApiException
     */
    public <T extends SObject> SearchResponse<T> search(String query, Class<T> clazz)
            throws ClientProtocolException, IOException, ForceApiException {
        try {
            String uri = uriBase() + "/search/?q=" + URLEncoder.encode(query, "UTF-8");

            String json = jsonHttpClient.HttpGet(uri);

            SearchResponse<T> searchResponse = jsonMapper.readValue(json,
                    jsonMapper.getTypeFactory().constructParametricType(SearchResponse.class, clazz));

            return searchResponse;
        } catch (JsonHttpClientException e) {
            throw ParseForceApiException(e.getMessage());
        }
    }
    
    /**
     * Creates one or more sObject trees with root records of the specified type. An sObject tree is a collection of nested, parent-child records with a single root record.
     * @param sObjectName The name of the SObject.
     * @param records List of SObject records.
     * @return SObjectTreeResponse
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws ForceApiException
     * @throws IOException
     */
    public SObjectTreeResponse sObjectTree(String sObjectName, List<SObject> records)
            throws JsonParseException, JsonMappingException, ForceApiException, IOException {
        try {
            String uri = uriBase() + "/composite/tree/" + sObjectName;

            SObjectTreeRequest sObjectTreeRequest = new SObjectTreeRequest();
            sObjectTreeRequest.setRecords(records);

            String json = jsonHttpClient.HttpPost(uri, sObjectTreeRequest);

            SObjectTreeResponse sObjectTreeResponse = jsonMapper.readValue(json, SObjectTreeResponse.class);

            return sObjectTreeResponse;
        } catch (JsonHttpClientException e) {
            throw ParseForceApiException(e.getMessage());
        }
    }

    private final String uriBase() {
        return (session.getInstanceUrl() + "/services/data/" + Settings.getForceApiVersion());
    }
}
