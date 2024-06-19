package net.bi4vmr.study;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Name        : net.bi4vmr.study.TestFile
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-10-21 23:40
 * <p>
 * Description : 测试类：文件操作。
 */
public class TestFile {

    public static void main(String[] args) throws Exception {
        example08();
    }

    /*
     * 获取文件的属性
     */
    static void example01() throws IOException {
        String path = "dir" + File.separator + "test.txt";
        File file1 = new File(path);
        System.out.println("文件名称：" + file1.getName());
        System.out.println("路径：" + file1.getPath());
        System.out.println("绝对路径：" + file1.getAbsolutePath());
        System.out.println("绝对路径（标准）：" + file1.getCanonicalPath());
        System.out.println("文件大小：" + file1.length());
        System.out.println("最后修改时间：" + file1.lastModified());
        System.out.println("父级目录：" + file1.getParent());
        System.out.println("是否存在：" + file1.exists());
        System.out.println("是否为文件：" + file1.isFile());
        System.out.println("是否为目录：" + file1.isDirectory());
        System.out.println("是否隐藏：" + file1.isHidden());
        System.out.println("是否可读：" + file1.canRead());
        System.out.println("是否可写：" + file1.canWrite());
        System.out.println("是否可执行：" + file1.canExecute());
    }

    /*
     * 文件管理 - 创建文件
     */
    static void example02() throws IOException {
        File file = new File("1.txt");
        // 文件不存在时进行创建操作
        if (!file.exists()) {
            boolean result = file.createNewFile();
            System.out.println("文件创建结果：" + result);
        } else {
            System.out.println("文件已存在！");
        }
    }

    /*
     * 文件管理 - 创建目录
     */
    static void example03() {
        File file = new File("test");
        // 目录不存在时进行创建操作
        if (!file.exists()) {
            boolean result = file.mkdir();
            System.out.println("目录创建结果：" + result);
        } else {
            System.out.println("目录已存在！");
        }
    }

    /*
     * 文件管理 - 删除文件
     */
    static void example04() {
        File file = new File("1.txt");
        // 文件存在时进行删除操作
        if (file.exists()) {
            boolean result = file.delete();
            System.out.println("文件删除结果：" + result);
        } else {
            System.out.println("文件不存在，无需删除！");
        }
    }

    /*
     * 文件管理 - 移动文件或改名
     */
    static void example05() {
        File fileSrc = new File("1.txt");
        File fileDst = new File("1/2.txt");
        /*
         * 重命名文件时，需要源文件存在，目标文件不存在，且目标目录存在。
         *
         * 此处为同目录移动，因此无需检查目标目录是否存在。
         */
        if (fileSrc.exists() && !fileDst.exists()) {
            boolean result = fileSrc.renameTo(fileDst);
            System.out.println("文件移动结果：" + result);
        } else {
            System.out.println("源文件不存在或目标文件已存在！");
        }
    }

    /*
     * 文件管理 - 列出目录子项
     */
    static void example06() {
        File file = new File("./");
        // 路径存在且为目录时再进行遍历
        if (file.exists() && file.isDirectory()) {
            // 获取子项名称列表
            String[] subItems = file.list();
            // 显示结果
            if (subItems != null) {
                for (String item : subItems) {
                    System.out.println("子项名称：" + item);
                }
            }
        } else {
            System.out.println("目标不存在或不是一个目录！");
        }
    }

    /*
     * 文件管理 - 列出目录子项（指定过滤条件）
     */
    static void example07() {
        // 获取当前工程的根目录File对象
        File file = new File("./");
        // 获取子项名称列表，并指定过滤器。
        String[] subItems = file.list(new FilenameFilter() {

            /**
             * Name        : 是否接受该文件
             * <p>
             * Description : 当每个文件被遍历到时触发此回调，返回"true"表示接受文件，将会出现在结果数组中；返回"false"则会被过滤。
             *
             * @param dir 路径前缀
             * @param name 文件或目录名称
             */
            @Override
            public boolean accept(File dir, String name) {
                /* 筛选所有文件，忽略文件夹。 */
                File f = new File(dir, name);
                return f.isFile();
            }
        });

        // 显示结果
        if (subItems != null) {
            for (String item : subItems) {
                System.out.println("子项名称：" + item);
            }
        }
    }

    /*
     * 文件管理 - 遍历每层目录
     */
    static void example08() {
        File file = new File("./");
        if (file.exists() && file.isDirectory()) {
            listFiles(file);
        }
    }

    // 列出目录内部的文件
    static void listFiles(File file) {
        // 打印当前遍历到的目录或文件信息
        System.out.println("子项名称：" + file.getName());

        // 当前项为目录时继续操作
        if (file.isDirectory()) {
            // 获取子项
            File[] subItems = file.listFiles();
            if (subItems != null) {
                // 遍历子项
                for (File item : subItems) {
                    // 递归调用当前方法，直到最内层目录。
                    listFiles(item);
                }
            }
        }
    }

    /*
     * 文件系统信息 - 获取磁盘分区与容量信息
     */
    static void example09() {
        // 列出所有磁盘分区
        File[] disks = File.listRoots();
        // 遍历磁盘分区，获取容量信息。
        for (File disk : disks) {
            // 打印盘符
            System.out.print("盘符：" + disk.getPath() + "\t");
            // 获取总容量
            double totalSpace = disk.getTotalSpace() * 1.0 / 1024 / 1024 / 1024;
            // 获取剩余容量
            double usableSpace = disk.getUsableSpace() * 1.0 / 1024 / 1024 / 1024;
            // 计算已用容量
            double usedSpace = totalSpace - usableSpace;
            // 计算使用率
            double useRate = (usedSpace / totalSpace) * 100;

            System.out.printf("总量：%.2f GiB\t", totalSpace);
            System.out.printf("已用：%.2f GiB\t", usedSpace);
            System.out.printf("剩余：%.2f GiB\t", usableSpace);
            System.out.printf("使用率：%.2f%%", useRate);
            System.out.println();
        }
    }
}
