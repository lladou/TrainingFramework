package automation.force.api;

public class ForceApiException extends Exception {
    private static final long serialVersionUID = 1L;
    public String error;
    public String errorCode;
    public String[] errorFields;

    public ForceApiException(String error) {
        super(error);

        this.error = error;
    }

    public ForceApiException(String error, String errorCode) {
        this(error);

        this.errorCode = errorCode;
    }

    public ForceApiException(String error, String errorCode, String[] errorFields) {
        this(error, errorCode);

        this.errorFields = errorFields;
    }

    public String getError() {
        return error;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String[] getErrorFields() {
        return errorFields;
    }
}
