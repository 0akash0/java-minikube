import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

class HelloWorld {
    public static void main(String[] args) throws IOException {
        // Create an HTTP server that listens on port 8001
        HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);

        // Create a context for the root path ("/") and handle requests with the HelloHandler
        server.createContext("/", new HelloHandler());

        // Start the server
        server.start();

        System.out.println("Server is running on port 8001. Press Ctrl+C to exit.");
    }

    // Define the HelloHandler class to handle incoming HTTP requests
    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Prepare the response message
            String response = "Hello, DevOps World!";

            // Set the response headers
            exchange.getResponseHeaders().set("Content-Type", "text/plain");
            exchange.sendResponseHeaders(200, response.length());

            // Get the output stream and write the response
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}

