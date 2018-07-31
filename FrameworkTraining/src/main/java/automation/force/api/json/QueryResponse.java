package automation.force.api.json;

import java.util.List;

public class QueryResponse<T> {
    public int totalSize;
    public boolean done = false;
    public List<T> records;
    public String nextRecordsUrl;

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public String getNextRecordsUrl() {
        return nextRecordsUrl;
    }

    public void setNextRecordsUrl(String nextRecordsUrl) {
        this.nextRecordsUrl = nextRecordsUrl;
    }

    @Override
    public String toString() {
        return String.format("QueryResponse [totalSize=%s, done=%s, records=%s, nextRecordsUrl=%s]", totalSize, done,
                records, nextRecordsUrl);
    }
}
