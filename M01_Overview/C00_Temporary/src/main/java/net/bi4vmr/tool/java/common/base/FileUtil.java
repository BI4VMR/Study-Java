package net.bi4vmr.tool.java.common.base;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 文件相关工具。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class FileUtil {

    /**
     * 获取最后修改时间戳。
     *
     * @param file 目标文件。
     * @return 时间戳。
     */
    public static long getModifyTimestamp(File file) {
        try {
            return Files.getLastModifiedTime(file.toPath()).toMillis();
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 更新最后修改时间戳。
     *
     * @param file      目标文件。
     * @param timestamp 时间戳。
     * @return 修改成功时返回 {@code true} ；修改失败时返回 {@code false} 。
     */
    public static boolean setModifyTime(File file, long timestamp) {
        try {
            Files.setLastModifiedTime(file.toPath(), FileTime.fromMillis(timestamp));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取最后修改时间。
     *
     * @param file 目标文件。
     * @return 当前时区的 {@code ZonedDateTime} 实例。
     */
    public static ZonedDateTime getModifyTime(File file) {
        try {
            Instant instant = Files.getLastModifiedTime(file.toPath()).toInstant();
            return ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 更新最后修改时间。
     *
     * @param file 目标文件。
     * @param time 目标时间。
     * @return 修改成功时返回 {@code true} ；修改失败时返回 {@code false} 。
     */
    public static boolean setModifyTime(File file, ZonedDateTime time) {
        try {
            return setModifyTime(file, time.toInstant().toEpochMilli());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 更新文件创建时间。
     * <p>
     * 该方法只能在拥有PowerShell环境的Windows系统中使用，类Unix系统不提供此类功能。
     *
     * @param file 目标文件。
     * @param time 目标时间。
     * @return 修改成功时返回 {@code true} ；修改失败时返回 {@code false} 。
     */
    public static boolean setCreateTime(File file, ZonedDateTime time) {
        String timeText = time.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        List<String> command = List.of(
                "powershell", "-Command",
                "\"Set-ItemProperty",
                "-Path '" + file.getAbsolutePath() + "'",
                "-Name CreationTime",
                "-Value '" + timeText + "'\"");
        int status = CLIUtil.runForStatus(command.toArray(new String[0]));
        return CLIUtil.isSuccess(status);
    }

    /**
     * 更新文件创建时间。
     * <p>
     * 该方法只能在拥有PowerShell环境的Windows系统中使用，类Unix系统不提供此类功能。
     *
     * @param file      目标文件。
     * @param timestamp 目标时间（时间戳）。
     * @return 修改成功时返回 {@code true} ；修改失败时返回 {@code false} 。
     */
    public static boolean setCreateTime(File file, long timestamp) {
        ZonedDateTime utcTime = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.UTC);
        return setCreateTime(file, utcTime);
    }
}
