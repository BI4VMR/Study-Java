package net.bi4vmr.study.base;

/**
 * Name        : USBManager
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2024-01-01 21:45
 * <p>
 * Description : 模拟系统的USB功能：USB管理。
 */
public class USBManager {

    // 模拟系统API：注册USB状态回调
    public static void addUSBStateCallback(USBStateCallback cb) {
        // Nothing to do.
    }

    // 模拟系统的USB功能：USB状态回调接口。
    public interface USBStateCallback {

        // USB设备插入时该类将被回调
        void onPlugged();

        // USB设备拔出时该类将被回调
        void onUnPlugged();
    }
}
