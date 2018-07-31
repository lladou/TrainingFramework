package automation.force.api;

public class ForceApiAuthenticationException extends Exception {
    private static final long serialVersionUID = 1L;
    public String error;
    public String errorCode;

    public ForceApiAuthenticationException(String error) {
        super(error);

        this.error = error;
    }

    public ForceApiAuthenticationException(String error, String errorCode) {
        this(error);

        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
