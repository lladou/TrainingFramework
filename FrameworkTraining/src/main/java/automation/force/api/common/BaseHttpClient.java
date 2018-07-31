package automation.force.api.common;

import java.io.Closeable;
import java.io.IOException;

import javax.ws.rs.core.Response;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

/**
 * Basic HTTP Client that encapsulates CloseableHttpClient and also implements Closeable.
 */
public class BaseHttpClient implements Closeable {
    protected CloseableHttpClient httpClient;
    protected String contentType;

    protected BaseHttpClient(CloseableHttpClient httpClient, String contentType) {
        this.httpClient = httpClient;
        this.contentType = contentType;
    }
    
    /**
     * Sends a GET request to the specified URI.
     * @param uri The URI the request is sent to.
     * @return String The response message.
     * @throws ClientProtocolException
     * @throws IOException
     * @throws BaseHttpClientException
     */
    protected String HttpGet(String uri) throws ClientProtocolException, IOException, BaseHttpClientException {
        HttpGet get = new HttpGet(uri);

        try (CloseableHttpResponse response = httpClient.execute(get)) {
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == HttpStatus.SC_NO_CONTENT) {
                return "";
            }

            String responseMessage = EntityUtils.toString(response.getEntity());

            if (Response.Status.Family.familyOf(statusCode).equals(Response.Status.Family.SUCCESSFUL)) {
                return responseMessage;
            }

            throw new BaseHttpClientException(responseMessage, statusCode);
        }
    }
    
    /**
     * Sends a POST request to the specified URI.
     * @param uri The URI the request is sent to.
     * @return String The response message.
     * @throws ClientProtocolException
     * @throws IOException
     * @throws BaseHttpClientException
     */
    protected String HttpPost(String uri) throws ClientProtocolException, IOException, BaseHttpClientException {
        return HttpPost(uri, null);
    }
    
    /**
     * Sends a POST request to the specified URI.
     * @param uri The URI the request is sent to.
     * @param payload The payload that is sent.
     * @return String The response message.
     * @throws ClientProtocolException
     * @throws IOException
     * @throws BaseHttpClientException
     */
    protected String HttpPost(String uri, String payload)
            throws ClientProtocolException, IOException, BaseHttpClientException {
        HttpPost post = new HttpPost(uri);

        if (payload != null && !payload.isEmpty()) {
            post.setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, contentType));
            post.setEntity(new StringEntity(payload));
        }

        try (CloseableHttpResponse response = httpClient.execute(post)) {
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == HttpStatus.SC_NO_CONTENT) {
            	System.out.println("hi");
                return "";
            }

            String responseMessage = EntityUtils.toString(response.getEntity());

            if (Response.Status.Family.familyOf(statusCode).equals(Response.Status.Family.SUCCESSFUL)) {
                return responseMessage;
            }

            throw new BaseHttpClientException(responseMessage, statusCode);
        }
    }
    
    /**
     * Sends a DELETE request to the specified URI.
     * @param uri The URI the request is sent to.
     * @return String The response message.
     * @throws ClientProtocolException
     * @throws IOException
     * @throws BaseHttpClientException
     */
    protected String HttpDelete(String uri) throws ClientProtocolException, IOException, BaseHttpClientException {
        HttpDelete delete = new HttpDelete(uri);

        try (CloseableHttpResponse response = httpClient.execute(delete)) {
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == HttpStatus.SC_NO_CONTENT) {
                return "";
            }

            String responseMessage = EntityUtils.toString(response.getEntity());

            if (Response.Status.Family.familyOf(statusCode).equals(Response.Status.Family.SUCCESSFUL)) {
                return responseMessage;
            }

            throw new BaseHttpClientException(responseMessage, statusCode);
        }
    }
    
    /**
     * Sends a PUT request to the specified URI.
     * @param uri The URI the request is sent to.
     * @param payload The payload that is sent.
     * @return String The response message
     * @throws IOException 
     * @throws ClientProtocolException 
     * @throws BaseHttpClientException 
     */
    protected String HttpPut(String uri, String payload) throws ClientProtocolException, IOException, BaseHttpClientException {
		HttpPut put = new HttpPut(uri);
		
        if (payload != null && !payload.isEmpty()) {
            put.setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, contentType));
            put.setEntity(new StringEntity(payload));
        }

        try (CloseableHttpResponse response = httpClient.execute(put)) {
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == HttpStatus.SC_NO_CONTENT) {
                return "";
            }

            String responseMessage = EntityUtils.toString(response.getEntity());

            if (Response.Status.Family.familyOf(statusCode).equals(Response.Status.Family.SUCCESSFUL)) {
                return responseMessage;
            }

            throw new BaseHttpClientException(responseMessage, statusCode);
        }
		
    }
    
    /**
     * Sends a PATCH request to the specified URI.
     * @param uri The URI the request is sent to.
     * @param payload The payload that is sent.
     * @return String The response message
     * @throws IOException 
     * @throws ClientProtocolException 
     * @throws BaseHttpClientException 
     */
    protected String HttpPatch(String uri, String payload) throws ClientProtocolException, IOException, BaseHttpClientException {
		HttpPatch patch = new HttpPatch(uri);
		
        if (payload != null && !payload.isEmpty()) {
        	patch.setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, contentType));
            patch.setEntity(new StringEntity(payload));
        }

        
        CloseableHttpResponse response = httpClient.execute(patch);
		return response.toString();
    }
    
    /*
     *     protected String HttpPatch(String uri, String payload) throws ClientProtocolException, IOException, BaseHttpClientException {
		HttpPatch patch = new HttpPatch(uri);
		
        if (payload != null && !payload.isEmpty()) {
        	patch.setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, contentType));
            patch.setEntity(new StringEntity(payload));
        }
        CloseableHttpResponse response = httpClient.execute(patch);
        return response.toString();

        try (CloseableHttpResponse response = httpClient.execute(patch)) {
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == HttpStatus.SC_NO_CONTENT) {
                return "";
            }

            String responseMessage = EntityUtils.toString(response.getEntity());

            if (Response.Status.Family.familyOf(statusCode).equals(Response.Status.Family.SUCCESSFUL)) {
                return responseMessage;
            }

            throw new BaseHttpClientException(responseMessage, statusCode);
        }
		
    }
     */

    @Override
    public void close() throws IOException {
        httpClient.close();
    }
}
