package automation.force.api.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationErrorResponse {
    @JsonProperty(value = "error_description")
    public String errorDescription;
    @JsonProperty(value = "error")
    public String error;

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return String.format("AuthenticationErrorResponse [errorDescription=%s, error=%s]", errorDescription, error);
    }
}
