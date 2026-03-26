package serverHTTP;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class MainHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();

        if (path.equals("/")) {
            path = "/index.html";
        }

        Path filePath = Paths.get("web", path);

        if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
            byte[] fileContent = Files.readAllBytes(filePath);

            String contentType = determineContentType(path);

            exchange.getResponseHeaders().set("Content-type", contentType);
            exchange.sendResponseHeaders(200, fileContent.length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(fileContent);
            }
        } else {
            byte[] errorMessage = "Error 404: File not found!".getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders().set("Content-type", "text/plain; charset=UTF-8");
            exchange.sendResponseHeaders(404, errorMessage.length);
            
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(errorMessage);
            }
        }
    }

    private String determineContentType(String path) {
        if (path.endsWith(".html")) return "text/html; charset=UTF-8";
        if (path.endsWith(".css")) return "text/css; charset=UTF-8";
        if (path.endsWith(".js")) return "text/javascript; charset=UTF-8";
        if (path.endsWith(".jpg")) return "image/jpeg";
        return "application/octet-stream";
    }
}