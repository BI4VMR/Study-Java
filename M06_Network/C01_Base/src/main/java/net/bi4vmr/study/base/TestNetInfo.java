package net.bi4vmr.study.base;

import java.net.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 * 测试代码：基本网络信息。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestNetInfo {

    public static void main(String[] args) throws Exception {
        example05();
    }

    /**
     * 示例一：获取接口信息。
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
     * 示例二：获取接口的网络层地址。
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
     * 示例三：获取接口的广播地址与前缀长度。
     * <p>
     * 在本示例中，我们解析接口的广播地址与前缀长度。
     */
    static void example03() throws Exception {
        // 获取本机的所有网络接口
        Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
        while (nifs.hasMoreElements()) {
            NetworkInterface nif = nifs.nextElement();

            List<InterfaceAddress> addresses = nif.getInterfaceAddresses();
            for (InterfaceAddress address : addresses) {
                System.out.println("接口名称：" + nif.getName());
                System.out.println("网络地址：" + address.getAddress().getHostAddress());
                System.out.println("前缀长度：" + address.getNetworkPrefixLength());
                if (address.getBroadcast() != null) {
                    System.out.println("广播地址：" + address.getBroadcast().getHostAddress());
                }
                System.out.println();
            }
        }
    }

    /**
     * 示例四：InetAddress类的静态方法。
     * <p>
     * 在本示例中，我们演示InetAddress类静态方法的功能。
     */
    static void example04() throws Exception {
        /*
         * 获取本地主机的地址信息
         *
         * 该方法不可用于获取本机IP地址，因为设备可能具有多个地址，此时该方法的行为是不确定的。
         *
         * 我们在设计程序时应当考虑到对于多个接口的支持，使用户选择需要使用的接口，而不是调用本方法获取接口。
         */
        System.out.println("本机信息：" + InetAddress.getLocalHost());

        // 获取本地主机的环回接口
        System.out.println("环回接口：" + InetAddress.getLoopbackAddress());

        // 获取地址或域名对应的InetAddress对象
        System.out.println("通过地址或域名获取InetAddress对象：" + InetAddress.getByName("www.bing.com"));

        // 获取域名对应的地址列表
        System.out.println("解析域名对应的地址：");
        for (InetAddress addr : InetAddress.getAllByName("www.bing.com")) {
            System.out.println(addr);
        }
    }

    /**
     * 示例五：InetAddress对象的常用方法。
     * <p>
     * 在本示例中，我们演示InetAddress对象的常用方法。
     */
    static void example05() throws Exception {
        InetAddress address = InetAddress.getByName("www.bing.com");

        // 获取主机名
        System.out.println("主机名：" + address.getHostName());
        // 获取IP地址
        System.out.println("主机地址：" + address.getHostAddress());
        // 是否为环回地址
        System.out.println("是否为环回地址：" + address.isLoopbackAddress());
        // 是否为组播地址
        System.out.println("是否为组播地址：" + address.isMulticastAddress());
        // 是否为链路本地地址
        System.out.println("是否为链路本地地址：" + address.isLinkLocalAddress());
        // 检测本设备与目标主机之间的可达性
        System.out.println("是否可达：" + address.isReachable(1000));
    }
}
