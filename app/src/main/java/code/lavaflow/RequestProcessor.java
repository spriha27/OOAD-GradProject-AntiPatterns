package java.code.lavaflow;

public class RequestProcessor {
    public void processRequest(Request request) {
        if (request.getType() == RequestType.TYPE_A) {
            System.out.println("Handling TYPE_A request...");
        } else if (request.getType() == RequestType.TYPE_B) {
            System.out.println("Handling TYPE_B request...");
        }
    }

    public static void main(String[] args) {
        Request request = new Request(RequestType.TYPE_A);
        RequestProcessor processor = new RequestProcessor();
        processor.processRequest(request);
    }
}

// Request Type Enum
enum RequestType {
    TYPE_A,
    TYPE_B
}

// Request Class
class Request {
    private final RequestType type;

    public Request(RequestType type) {
        this.type = type;
    }

    public RequestType getType() {
        return type;
    }
}