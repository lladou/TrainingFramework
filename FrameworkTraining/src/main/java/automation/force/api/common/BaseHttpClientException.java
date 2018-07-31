package automation.force.api.common;

public class BaseHttpClientException extends Exception {
    private static final long serialVersionUID = 1L;
    private int statusCode;

    public BaseHttpClientException(String responseMessage, int statusCode) {
        super(responseMessage);

        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
