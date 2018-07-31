package automation.force.api.json;

import java.util.List;

public class SuccessResponse {
    public String id;
    public List<ErrorResponse> errors;
    public boolean success;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ErrorResponse> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorResponse> errors) {
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return String.format("SuccessResponse [id=%s, errors=%s, success=%s]", id, errors, success);
    }
}
