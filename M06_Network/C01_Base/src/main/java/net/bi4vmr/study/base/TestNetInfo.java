package net.bi4vmr.study.base;

import java.net.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 * TODO 添加简述。
 * <p>
 * TODO 添加描述。
 */
public class TestNetInfo {

    public static void main(String[] args) throws Exception {
        example03();
    }

    /**
     * 示例：获取接口信息。
     * <p>
     * 在本示例中，我们使用NetworkInterface获取设备上的接口信息。
     */
    static void example01() throws Exception {
        // 获取本机的所有网络接口
        Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
        while (nifs.hasMoreElements()) {
            // 获取单个接口，并访问属性。
            NetworkInterface nif = nifs.nextElement();
            System.out.println("接口名称：" + nif.getName());
            System.out.println("友好名称：" + nif.getDisplayName());
            System.out.println("是否启动：" + nif.isUp());

            // 获取链路层地址
            byte[] hwAddr = nif.getHardwareAddress();
            System.out.println("硬件地址：" + Arrays.toString(hwAddr));
        }
    }

    /**
     * 示例：获取接口的网络层地址。
     * <p>
     * 在本示例中，我们解析接口的网络层地址信息。
     */
    static void example02() throws Exception {
        // 获取本机的所有网络接口
        Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
        while (nifs.hasMoreElements()) {
            NetworkInterface nif = nifs.nextElement();
            Enumeration<InetAddress> addresses = nif.getInetAddresses();
            // 跳过没有配置地址的接口
            if (!addresses.hasMoreElements()) {
                continue;
            } else {
                System.out.println("接口名称：" + nif.getName());
            }

            while (addresses.hasMoreElements()) {
                InetAddress address = addresses.nextElement();
                System.out.println("网络地址：" + address.getHostAddress());
                // 判断地址类型
                if (address instanceof Inet4Address) {
                    System.out.println("这是一个IPv4地址。");
                } else if (address instanceof Inet6Address) {
                    System.out.println("这是一个IPv6地址。");
                } else {
                    System.out.println("这是一个未知类型的地址。");
                }
            }
            System.out.println();
        }
    }

    /**
     * 示例：获取接口的网络层地址与前缀长度。
     * <p>
     * 在本示例中，我们解析接口的网络层地址与前缀长度。
     */
    static void example03() throws Exception {
        // 获取本机的所有网络接口
        Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
        while (nifs.hasMoreElements()) {
            NetworkInterface nif = nifs.nextElement();

            List<InterfaceAddress> addresses = nif.getInterfaceAddresses();
            for (InterfaceAddress address : addresses) {
                System.out.println("接口名称：" + nif.getName());
                System.out.println("网络地址：" + address.getAddress());
                System.out.println("前缀长度：" + address.getNetworkPrefixLength());
                System.out.println("广播地址：" + address.getBroadcast());
                System.out.println();
            }
        }
    }
}
