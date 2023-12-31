package net.bi4vmr.study;

import java.io.*;
import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * Name        : TestStream
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-10-22 23:49
 * <p>
 * Description : 测试类：文件流。
 */
public class TestFileStream {

    public static void main(String[] args) {
        example06();
    }

    /*
     * 获取JVM编码信息
     */
    static void example01() {
        // 获取JVM默认字符集
        Charset charset = Charset.defaultCharset();
        System.out.println("JVM默认字符集：" + charset);

        // 通过名称获取字符集对象
        Charset charset2 = Charset.forName("GBK");
        System.out.println("通过名称获取字符集对象：" + charset2);

        // 判断JVM是否支持特定的字符集
        boolean supportedBIG5 = Charset.isSupported("BIG5");
        System.out.println("当前JVM是否支持BIG5编码：" + supportedBIG5);

        // 获取JVM支持的所有字符集
        System.out.println("当前JVM支持的字符集列表：");
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }

    /*
     * 读取文本文件（按字符）
     */
    static void example02() {
        // 构造输入输出端点
        File file = new File("test.txt");
        if (!file.exists() || !file.isFile()) {
            System.out.println("目标不存在或不是一个文件！");
            return;
        }

        StringBuffer text = new StringBuffer();
        FileReader reader = null;
        try {
            // 以File对象为目标，创建Reader对象。
            reader = new FileReader(file);
            // 循环读取文件内容
            while (true) {
                // 读取一个字符
                int c = reader.read();
                // "read()"方法返回"-1"时表示读取完毕，此时退出循环。
                if (c == -1) {
                    break;
                }
                // 将当前字符保存至StringBuffer
                text.append(Character.toString(c));
            }
        } catch (Exception e) {
            /* 异常处理 */
            e.printStackTrace();
        } finally {
            /* 操作结束后关闭输入流 */
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // 显示最终结果
        System.out.print(text);
    }

    /*
     * 读取文本文件（缓冲读取）
     */
    static void example03() {
        // 构造输入输出端点
        File file = new File("test.txt");
        if (!file.exists() || !file.isFile()) {
            System.out.println("目标不存在或不是一个文件！");
            return;
        }

        StringBuffer text = new StringBuffer();
        FileReader reader = null;
        char[] buffer = new char[8];
        try {
            // 以File对象为目标，创建Reader对象。
            reader = new FileReader(file);
            // 循环读取文件内容
            while (true) {
                // 每次根据缓冲区容量读取字符
                int count = reader.read(buffer);
                // "read()"方法返回"-1"时表示读取完毕，此时退出循环。
                if (count == -1) {
                    break;
                }
                // 将缓冲区内容保存至StringBuffer
                text.append(new String(buffer, 0, count));
            }
        } catch (Exception e) {
            /* 异常处理 */
            e.printStackTrace();
        } finally {
            /* 操作结束后关闭输入流 */
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // 显示最终结果
        System.out.print(text);
    }

    /*
     * 写入文本文件
     */
    static void example04() {
        // 构造输入输出端点
        File file = new File("output.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            // 将字符串内容写入文件
            writer.write("我能吞下玻璃而不伤身体。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    // 使用"flush()"方法将缓冲区内容写入磁盘，并关闭流。
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * 读取UTF-8编码的文本文件，并以GBK编码保存一份副本。
     */
    static void example05() {
        // 输入文件
        File fileIn = new File("test.txt");
        // 判断文件是否存在或为目录
        if (!fileIn.exists() || !fileIn.isFile()) {
            System.out.println("目标不存在或不是一个文件！");
            return;
        }

        FileReader reader = null;
        // 输出文件
        File fileOut = new File("output.txt");
        FileWriter writer = null;
        try {
            // 构建FileReader，字符集为JVM默认值，输入文件需要与其一致。
            reader = new FileReader(fileIn);
            // 构建FileWriter，指定字符集为GBK。
            writer = new FileWriter(fileOut, Charset.forName("GBK"));
            char[] buffer = new char[8];
            while (true) {
                int count = reader.read(buffer);
                if (count == -1) {
                    break;
                }
                // 将本轮读取到的字符，写入目标文件，写出长度与读入数量一致。
                writer.write(buffer, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * 读写二进制数据（复制音频文件）
     */
    static void example06() {
        // 构造输入端点
        File file = new File("Lullaby - Enzalla.mp3");
        if (!file.exists() || !file.isFile()) {
            System.out.println("目标不存在或不是一个文件！");
            return;
        }

        FileInputStream inStream = null;
        FileOutputStream outStream = null;
        try {
            inStream = new FileInputStream(file);
            // 构造输出流，指定文件名为"copy.mp3"。
            outStream = new FileOutputStream("copy.mp3");
            byte[] buffer = new byte[1024 * 1024];
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
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
