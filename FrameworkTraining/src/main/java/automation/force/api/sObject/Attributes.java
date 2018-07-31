package automation.force.api.sObject;

public class Attributes {
    private String referenceId;
    private String type;
    private String url;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return String.format("Attributes [referenceId=%s, type=%s, url=%s]", referenceId, type, url);
    }
}
