package net.bi4vmr.study;

import com.android.ddmlib.AndroidDebugBridge;
import net.bi4vmr.tool.java.common.base.SystemUtil;

import java.io.File;
import java.util.Arrays;

/**
 * ADB工具类。
 * 优先使用用户设置的ADB路径；若未设置则尝试从PATH中查找。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class ADBUtil {

    private static AndroidDebugBridge bridge;
    private static volatile boolean initialized;

    public static void main(String[] args) {
        try {
            if (!init()) {
                return;
            }

            if (!waitForInitialDeviceList(10_000L)) {
                System.err.println("ADB bridge not ready within timeout.");
                return;
            }

            Arrays.stream(bridge.getDevices())
                    .forEach(device -> System.out.println("Connected device: " + device));
        } finally {
            close();
        }
    }

    /**
     * 初始化ADB连接。
     *
     * @return 是否初始化成功。
     */
    public static synchronized boolean init() {
        if (initialized) {
            return true;
        }

        File adbFile = findADBInPath();
        if (adbFile == null) {
            System.err.println("ADB executable not found in PATH.");
            return false;
        }

        // 初始化DDM库，client表示是否连接应用JVM进行Debug，仅有一个实例可以支持。
        AndroidDebugBridge.init(false);
        bridge = AndroidDebugBridge.createBridge(adbFile.getAbsolutePath(), false);
        if (bridge == null) {
            System.err.println("Failed to create AndroidDebugBridge.");
            return false;
        }

        Runtime.getRuntime().addShutdownHook(new Thread(ADBUtil::close, "adbutil-shutdown"));
        initialized = true;
        return true;
    }

    /**
     * 等待桥接器连接成功并完成初始设备列表加载。
     *
     * @param timeoutMillis 超时时间。
     * @return 是否在超时前准备完成。
     */
    public static boolean waitForInitialDeviceList(long timeoutMillis) {
        if (bridge == null) {
            return false;
        }

        long deadline = System.currentTimeMillis() + timeoutMillis;
        while (System.currentTimeMillis() < deadline) {
            if (bridge.isConnected() && bridge.hasInitialDeviceList()) {
                return true;
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }

        return false;
    }

    /**
     * 关闭ADB连接并终止DDM内部线程。
     */
    public static synchronized void close() {
        if (!initialized) {
            return;
        }

        try {
            AndroidDebugBridge.disconnectBridge();
        } catch (Exception e) {
            System.err.println("Failed to disconnect bridge: " + e.getMessage());
        }

        try {
            AndroidDebugBridge.terminate();
        } catch (Exception e) {
            System.err.println("Failed to terminate ddmlib: " + e.getMessage());
        }

        bridge = null;
        initialized = false;
    }

    /**
     * 获取ADB可执行文件名称。
     *
     * @return 可执行文件名称。
     */
    private static String getADBFileName() {
        return SystemUtil.isWindows() ? "adb.exe" : "adb";
    }

    /**
     * 在环境变量PATH中寻找ADB可执行文件。
     *
     * @return ADB可执行文件。如果未找到则为空值。
     */
    private static File findADBInPath() {
        String adbName = getADBFileName();
        File adbFile = null;
        String[] dirs = SystemUtil.getPathDirectories();
        // 遍历PATH的目录，寻找ADB可执行文件路径。
        for (String dir : dirs) {
            File temp = new File(dir, adbName);
            if (temp.exists()) {
                adbFile = temp;
                break;
            }
        }

        return adbFile;
    }
}
