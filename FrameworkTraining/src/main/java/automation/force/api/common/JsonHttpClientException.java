package automation.force.api.common;

public class JsonHttpClientException extends BaseHttpClientException {
    private static final long serialVersionUID = 1L;

    public JsonHttpClientException(String responseMessage, int statusCode) {
        super(responseMessage, statusCode);
    }
}