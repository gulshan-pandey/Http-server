package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        var serverSocket = new ServerSocket(8080);

        while(true) {
            Socket socket = serverSocket.accept(); // Accept incoming connections
            try( var os = socket.getOutputStream()) {
                var body = """
                        {
                            "id": "1"
                        }
                        """;
                var response = """
                        HTTP/1.1 200 OK
                        Content-Type:application/json
                        Content-Length: %d
                        
                        %s""".formatted(body.getBytes(StandardCharsets.UTF_8).length, body);
            os.write(response.getBytes(StandardCharsets.UTF_8));
            }

        }


    }
}