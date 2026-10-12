package net.bi4vmr.study;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TestS {

    public static void main(String[] args) throws Exception {
        int port = 10000;
        // 创建服务端 Socket 实例，绑定指定的 TCP 端口并持续监听。
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Start to listening TCP [" + port + "] ...");
            // 阻塞当前线程，直到有客户端连接时返回 Socket 实例。
            Socket socket = serverSocket.accept();
            System.out.println("Client [" + socket.getRemoteSocketAddress() + "] connected.");

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
            }
            System.out.println("get message from client: " + sb);
            inputStream.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("Server error! Reason:[" + e.getMessage() + "]");
            e.printStackTrace();
        }
    }
}
