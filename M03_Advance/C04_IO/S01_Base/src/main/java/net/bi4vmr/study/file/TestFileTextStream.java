package net.bi4vmr.study.file;

import net.bi4vmr.study.util.IOUtil;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 测试代码 - 文件字符流。
 *
 * @author BI4VMR@outlook.com
 */
public class TestFileTextStream {

    public static void main(String[] args) {
        example04();
    }

    /**
     * 示例：读取文本文件（逐个字符）。
     */
    static void example01() {
        final String path = "./M03_Advance/C04_IO/S01_Base/src/main/resources/test.txt";
        // 构造输入输出端点
        File file = new File(path);
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

    /**
     * 示例：读取文本文件（缓冲读取）。
     */
    static void example02() {
        final String path = "./M03_Advance/C04_IO/S01_Base/src/main/resources/test.txt";
        // 构造输入输出端点
        File file = new File(path);
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
            IOUtil.closeSilently(reader);
        }

        // 显示最终结果
        System.out.print(text);
    }

    /**
     * 示例：写入文本文件。
     */
    static void example03() {
        final String path = "./M03_Advance/C04_IO/S01_Base/src/main/resources/output.txt";
        // 构造输入输出端点
        File file = new File(path);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            // 将字符串内容写入文件
            writer.write("我能吞下玻璃而不伤身体。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtil.closeSilently(writer);
        }
    }

    /**
     * 示例：读取UTF-8编码的文本文件，并以GBK编码保存一份副本。
     */
    static void example04() {
        final String inPath = "./M03_Advance/C04_IO/S01_Base/src/main/resources/test.txt";
        final String outPath = "./M03_Advance/C04_IO/S01_Base/src/main/resources/test_GBK.txt";

        File fileIn = new File(inPath);
        // 判断文件是否存在或为目录
        if (!fileIn.exists() || !fileIn.isFile()) {
            System.out.println("目标不存在或不是一个文件！");
            return;
        }

        FileReader reader = null;
        // 输出文件
        File fileOut = new File(outPath);
        FileWriter writer = null;
        try {
            // 构建FileReader，指定字符集为UTF-8。
            reader = new FileReader(fileIn, StandardCharsets.UTF_8);
            // 构建FileWriter，指定字符集为GBK。
            writer = new FileWriter(fileOut, Charset.forName("GBK"));
            char[] buffer = new char[8];
            while (true) {
                int count = reader.read(buffer);
                if (count == -1) {
                    break;
                }
                // 将本轮读取到的字符，写入目标文件，写入字符数量与读取数量一致。
                writer.write(buffer, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtil.closeSilently(reader);
            IOUtil.closeSilently(writer);
        }
    }
}
