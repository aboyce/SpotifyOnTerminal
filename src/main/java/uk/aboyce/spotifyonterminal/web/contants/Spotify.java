package uk.aboyce.spotifyonterminal.web.contants;

public class Spotify {

    private static final String PROTOCOL = "https";

    private static final String URI = "api.spotify.com";

    private static final String VERSION = "v1";

    public static String getApiUri () {
        return String.format("%s://%s/%S/", PROTOCOL, URI, VERSION);
    }

    public enum ResponseStatusCode {

        OK (200, "The client can read the result of the request in the body and the headers of the response."),
        CREATED (201, "The request has been fulfilled and resulted in a new resource being created."),
        ACCEPTED (202, "The request has been accepted for processing, but the processing has not been completed."),
        NO_CONTENT (204, "The request has succeeded but returns no message body."),
        NOT_MODIFIED (304, ""),
        BAD_REQUEST (400, "The request could not be understood by the server due to malformed syntax."),
        UNAUTHORISED (401, "The request requires user authentication or, if the request included authorization credentials, authorization has been refused for those credentials."),
        FORBIDDEN (403, "The server understood the request, but is refusing to fulfill it."),
        NOT_FOUND (404, "The requested resource could not be found. This error can be due to a temporary or permanent condition."),
        TOO_MANY_REQUESTS (429, "Rate limiting has been applied."),
        INTERNAL_SERVER_ERROR (500, "Should not ever happen, logic issue from Spotify."),
        BAD_GATEWAY (502, "The server was acting as a gateway or proxy and received an invalid response from the upstream server."),
        SERVICE_UNAVAILABLE (503, "The server is currently unable to handle the request due to a temporary condition which will be alleviated after some delay. You can choose to resend the request again.");

        private Integer statusCode;
        private String message;

        ResponseStatusCode(int statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }
    }
}
