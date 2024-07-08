package net.bi4vmr.test.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class FileUtil {

    public static void main(String[] args) throws IOException {
        // FileType fileType = getFileType("/home/bi4vmr/Picture/测试图片/P01.jpg");
        // System.out.println(fileType);

        // 获得本机的所有网络接口
        Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
        while (nifs.hasMoreElements()) {
            NetworkInterface nif = nifs.nextElement();
            // 获得与该网络接口绑定的 IP 地址，一般只有一个
            Enumeration<InetAddress> addresses = nif.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                System.out.println("网卡接口名称 " + nif.getName());
                System.out.println("网卡接口地址 " + addr.getHostAddress());
                System.out.println("主机名2" + addr.getHostName());
                System.out.println();
                // if (addr instanceof Inet4Address) { // 只关心 IPv4 地址
                //     System.out.println("网卡接口名称：" + nif.getName());
                //     System.out.println("网卡接口地址：" + addr.getHostAddress());
                //     System.out.println();
                // }
            }
        }
        //
        // // 获得本机的所有网络接口
        // Enumeration<NetworkInterface> nifs = InterfaceAddress
        // while (nifs.hasMoreElements()) {
        //     NetworkInterface nif = nifs.nextElement();
        //     // 获得与该网络接口绑定的 IP 地址，一般只有一个
        //     Enumeration<InetAddress> addresses = nif.getInetAddresses();
        //     while (addresses.hasMoreElements()) {
        //         InetAddress addr = addresses.nextElement();
        //         System.out.println("网卡接口名称 " + nif.getName());
        //         System.out.println("网卡接口地址 " + addr.getHostAddress());
        //         System.out.println();
        //         // if (addr instanceof Inet4Address) { // 只关心 IPv4 地址
        //         //     System.out.println("网卡接口名称：" + nif.getName());
        //         //     System.out.println("网卡接口地址：" + addr.getHostAddress());
        //         //     System.out.println();
        //         // }
        //     }
        // }
    }

    // 获取文件类型
    public static FileType getFileType(String filePath) throws IOException {
        String header = getFileHeader(filePath);
        if (header == null || header.isEmpty()) {
            return null;
        }

        header = header.toUpperCase();
        FileType[] fileTypes = FileType.values();
        for (FileType type : fileTypes) {
            if (header.startsWith(type.getHeader())) {
                return type;
            }
        }

        return null;
    }

    // 获取文件头
    private static String getFileHeader(String filePath) throws IOException {
        InputStream inputStream = null;
        byte[] buffer = new byte[32];
        try {
            inputStream = new FileInputStream(filePath);
            int count = inputStream.read(buffer, 0, 20);
            if (count <= 0) {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return bytesToHexText(buffer);
    }

    // 将二进制数据转为16进制文本
    private static String bytesToHexText(byte[] src) {
        if (src == null || src.length == 0) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : src) {
            // 只保留低8位，然后将其转为16进制文本。
            String hex = Integer.toHexString(b & 0xFF);
            // 如果本字节对应的16进制文本只有一个字符，则在前面补"0"。
            if (hex.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hex);
        }

        return stringBuilder.toString();
    }
}
