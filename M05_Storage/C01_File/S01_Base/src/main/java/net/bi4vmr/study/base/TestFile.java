package net.bi4vmr.study.base;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * 测试代码 - 文件管理。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestFile {

    public static void main(String[] args) throws Exception {
        example04();
    }


    /**
     * 示例一：获取文件的属性。
     * <p>
     * 在本示例中，我们通过File实例获取文件的属性。
     */
    static void example01() throws IOException {
        String prefix = "M05_Storage/C01_File/S01_Base/src/main/resources/";
        File file = new File(prefix + "test.txt");

        System.out.println("文件名称：" + file.getName());
        System.out.println("路径：" + file.getPath());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("绝对路径（标准）：" + file.getCanonicalPath());
        System.out.println("文件大小：" + file.length());
        System.out.println("最后修改时间：" + file.lastModified());
        System.out.println("父级目录：" + file.getParent());
        System.out.println("是否存在：" + file.exists());
        System.out.println("是否为文件：" + file.isFile());
        System.out.println("是否为目录：" + file.isDirectory());
        System.out.println("是否隐藏：" + file.isHidden());
        System.out.println("是否可读：" + file.canRead());
        System.out.println("是否可写：" + file.canWrite());
        System.out.println("是否可执行：" + file.canExecute());
    }


    /**
     * 示例二：创建目录与文件。
     * <p>
     * 在本示例中，我们在当前模块的资源目录中创建名为 `test` 的目录，并在其中创建一个内容为空的文件。
     */
    static void example02() throws IOException {
        String prefix = "M05_Storage/C01_File/S01_Base/src/main/resources/";

        // 目录路径
        File dirPath = new File(prefix, "test");
        // 目录已存在或无写入权限等情况将返回 `false` 。
        boolean result = dirPath.mkdir();
        System.out.println("目录创建结果：" + result);

        // 文件路径
        File filePath = new File(dirPath.getPath(), "1.txt");
        // 文件已存在或无写入权限等情况将返回 `false` 。
        boolean result2 = filePath.createNewFile();
        System.out.println("文件创建结果：" + result2);
    }


    /**
     * 示例三：修改文件名称。
     * <p>
     * 在本示例中，我们将“示例二”中生成的测试文件 `1.txt` 改名为 `2.txt` 。
     */
    static void example03() {
        String prefix = "M05_Storage/C01_File/S01_Base/src/main/resources/test";

        // 原文件
        File fileSrc = new File(prefix, "1.txt");
        // 新文件
        File fileDst = new File(prefix, "2.txt");

        if (fileSrc.exists() && !fileDst.exists()) {
            boolean result = fileSrc.renameTo(fileDst);
            System.out.println("文件移动结果：" + result);
        } else {
            System.out.println("源文件不存在或目标文件已存在！");
        }
    }


    /**
     * 示例四：删除文件。
     * <p>
     * 在本示例中，我们将前文“示例三”中生成的测试文件 `2.txt` 删除。
     */
    static void example04() {
        String prefix = "M05_Storage/C01_File/S01_Base/src/main/resources/test";

        File file = new File(prefix, "2.txt");
        // 文件存在时进行删除操作
        if (file.exists()) {
            boolean result = file.delete();
            System.out.println("文件删除结果：" + result);
        } else {
            System.out.println("文件不存在，无需删除！");
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


    /**
     * 示例十：获取常用路径。
     * <p>
     * 在本示例中，我们通过系统属性获取常用目录的路径。
     */
    static void example10() {
        // 终端工作目录
        String workDir = System.getProperty("user.dir");
        System.out.println("终端工作目录：" + workDir);

        // 当前用户目录
        String userDir = System.getProperty("user.home");
        System.out.println("当前用户目录：" + userDir);

        // 临时目录
        String tempDir = System.getProperty("java.io.tmpdir");
        System.out.println("临时目录：" + tempDir);
    }
}
