package net.bi4vmr.test.file;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * TODO 添加简述。
 * <p>
 * TODO 添加描述。
 */
public class TestNetwork {

    public static void main(String[] args) throws IOException {
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
}
