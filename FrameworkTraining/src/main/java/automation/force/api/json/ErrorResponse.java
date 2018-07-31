package automation.force.api.json;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {
    public String[] fields;
    public String message;
    public String errorCode;

    public String[] getFields() {
        return fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("errorCode")
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @JsonProperty("statusCode")
    public String getStatusCode() {
        return errorCode;
    }

    public void setStatusCode(String statusCode) {
        this.errorCode = statusCode;
    }

    @Override
    public String toString() {
        return String.format("Error [fields=%s, message=%s, errorCode=%s]", Arrays.toString(fields), message,
                errorCode);
    }
}
