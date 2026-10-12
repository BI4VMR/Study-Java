package net.bi4vmr.study;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TestC {

    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 10000;
        // 创建客户端 Socket 实例，与指定主机的端口建立连接。
        try (Socket socket = new Socket(host, port)) {
            // 获取输出流，向服务端发送数据。
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("Hello, Server!".getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
