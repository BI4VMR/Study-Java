package net.bi4vmr.study;

/**
 * 扫描器启动类
 */
public class ScanApp {

    public static void main(String[] args) {
        // 待扫描的ip地址或ip地址组
        String ips = null;
        ips = "172.16.0.1,172.16.5.1";
        // 待扫描的port范围
        String ports = "21-22";
        Scanner.start(ips, ports);
    }
}
