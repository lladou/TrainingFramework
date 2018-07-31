package automation.force.api.json;

import java.util.List;

public class SObjectTreeResult {
    private String id;
    private String referenceId;
    private List<ErrorResponse> errors;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public List<ErrorResponse> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorResponse> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return String.format("SObjectTreeResult [id=%s, referenceId=%s, errors=%s]", id, referenceId, errors);
    }
}
