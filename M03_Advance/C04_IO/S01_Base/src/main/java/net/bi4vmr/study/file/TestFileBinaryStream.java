package net.bi4vmr.study.file;

import net.bi4vmr.study.util.IOUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 测试代码 - 文件字节流。
 *
 * @author BI4VMR@outlook.com
 */
public class TestFileBinaryStream {

    public static void main(String[] args) {
        example02();
    }

    /**
     * 示例：读写二进制数据（复制音频文件）。
     */
    static void example01() {
        final String inPath = "./M03_Advance/C04_IO/S01_Base/src/main/resources/Lullaby_Enzalla.mp3";
        final String outPath = "./M03_Advance/C04_IO/S01_Base/src/main/resources/copy.mp3";

        File file = new File(inPath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("目标不存在或不是一个文件！");
            return;
        }

        FileInputStream inStream = null;
        FileOutputStream outStream = null;
        try {
            inStream = new FileInputStream(file);
            // 构造输出流，指定文件名为"copy.mp3"。
            outStream = new FileOutputStream(outPath);
            byte[] buffer = new byte[1024];
            while (true) {
                int count = inStream.read(buffer);
                if (count == -1) {
                    break;
                }
                // 将本轮读入的数据写出到目标文件
                outStream.write(buffer, 0, count);
            }
        } catch (Exception e) {
            /* 异常处理 */
            e.printStackTrace();
        } finally {
            /* 操作结束后关闭输入与输出流 */
            IOUtil.closeSilently(inStream);
            IOUtil.closeSilently(outStream);
        }
    }

    /**
     * 示例：读取二进制文件头部内容，并转为十六进制文本。
     */
    static void example02() {
        final String path = "./M03_Advance/C04_IO/S01_Base/src/main/resources/Lullaby_Enzalla.mp3";
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.out.println("目标不存在或不是一个文件！");
            return;
        }

        FileInputStream inStream = null;
        try {
            inStream = new FileInputStream(file);
            // 读取20字节数据
            byte[] buffer = new byte[20];
            int count = inStream.read(buffer);

            // 遍历数组，将"byte"值转为无符号的原始数据值。
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < count; i++) {
                // 丢弃符号位，转为原始值。
                int unsignedValue = buffer[i] & 0xFF;
                // 转为十六进制字符
                String hex = Integer.toHexString(unsignedValue);
                // 如果为单个字符，则填充至2位。
                if (hex.length() == 1) {
                    hex = hex + "0";
                }
                stringBuffer.append(hex).append(" ");
            }
            System.out.println(stringBuffer);
        } catch (Exception e) {
            /* 异常处理 */
            e.printStackTrace();
        } finally {
            /* 操作结束后关闭输入与输出流 */
            IOUtil.closeSilently(inStream);
        }
    }
}
