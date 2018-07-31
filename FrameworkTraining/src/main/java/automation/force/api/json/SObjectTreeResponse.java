package automation.force.api.json;

import java.util.List;

public class SObjectTreeResponse {
    private Boolean hasErrors;
    public List<SObjectTreeResult> results;

    public Boolean getHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(Boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public List<SObjectTreeResult> getResults() {
        return results;
    }

    public void setResults(List<SObjectTreeResult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return String.format("SObjectTreeResponse [hasErrors=%s, results=%s]", hasErrors, results);
    }
}
