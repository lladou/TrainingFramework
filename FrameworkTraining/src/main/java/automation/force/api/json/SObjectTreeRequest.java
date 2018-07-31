package automation.force.api.json;

import java.util.List;

import automation.force.api.sObject.SObject;

public class SObjectTreeRequest {
    public List<SObject> records;

    public List<SObject> getRecords() {
        return records;
    }

    public void setRecords(List<SObject> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return String.format("SObjectTreeRequest [records=%s]", records);
    }
}
