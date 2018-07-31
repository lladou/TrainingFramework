package automation.force.api.json;

import java.util.List;

public class SearchResponse<T> {
    public List<T> searchRecords;

    public List<T> getSearchRecords() {
        return searchRecords;
    }

    public void setSearchRecords(List<T> searchRecords) {
        this.searchRecords = searchRecords;
    }

    @Override
    public String toString() {
        return String.format("SearchResponse [searchRecords=%s]", searchRecords);
    }
}
