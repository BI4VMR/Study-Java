package net.bi4vmr.test.file;

import net.bi4vmr.tool.java.io.base.IOUtil;
import net.bi4vmr.tool.java.math.base.NumberUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\bi4vmr\\Work\\#知识库插图");
        File[] arr = file.listFiles();
        for (File f : arr) {
            System.out.println(f.getName());
            FileType fileType = getFileType(f.getAbsolutePath());
            System.out.println(fileType);
        }

    }

    // 获取文件类型
    public static FileType getFileType(String filePath) throws IOException {
        String header = getFileHeader(filePath);
        if (header == null || header.isEmpty()) {
            return null;
        }

        header = header.toUpperCase();
        System.out.println("Header:[" + header + "]");
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
            IOUtil.closeSilently(inputStream);
        }

        return NumberUtil.toHexString(buffer);
    }
}
