package org.example.c1;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientSocketDemo {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost",8080));

        PrintStream out = new PrintStream(socket.getOutputStream());
        out.println("hello");
        out.println("Done");

    }
}
