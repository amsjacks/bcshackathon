package parser_api_requests;

// Exception thrown if any kind of error occurs while parsing resources
public class ResourceParsingException extends Exception {
    public ResourceParsingException() {
        super();
    }

    public ResourceParsingException(String msg) {
        super(msg);
    }
}
