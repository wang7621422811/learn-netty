package org.example.c1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);

            // 阻塞，直到一个连接的建立,返回的Socket用于客户端和服务器之间的通信
            Socket clientSocket = serverSocket.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            String request,response;
            System.out.println("客户端已连接：" + clientSocket);
            // readLine会一直阻塞，直到读取回车或者换行符结束 服务器使用readLine，客户端必须一行一行写入out.println("hello");
            while ((request = br.readLine()) != null) {
                if ("Done".equals(request)) {
                    break;
                }
                response = processRequest(request);
//                out.println(response);
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }

    private static String processRequest(String request) {
        System.out.println("服务端收到数据, " + request);
        return request;
    }
}
