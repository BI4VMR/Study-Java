package net.bi4vmr.test.file;

/**
 * TODO 添加简述。
 * <p>
 * TODO 添加详情。
 *
 * @author BI4VMR
 */
//文件的字节码头

public enum FileType {
    /**
     * JEPG.
     */
    JPEG("FFD8FF"),

    /**
     * PNG.
     */
    PNG("89504E47"),

    /**
     * Windows Bitmap.
     */
    BMP("424D"),

    /**
     * GIF.
     */
    GIF("47494638"),

    /**
     * TIFF.
     */
    TIFF("49492A00"),

    /**
     * CAD.
     */
    DWG("41433130"),

    /**
     * Adobe Photoshop.
     */
    PSD("38425053"),

    /**
     * Rich Text Format.
     */
    RTF("7B5C727466"),

    /**
     * XML.
     */
    XML("3C3F786D6C"),

    /**
     * HTML.
     */
    HTML("68746D6C3E"),

    /**
     * Email [thorough only].
     */
    EML("44656C69766572792D646174653A"),

    /**
     * Outlook Express.
     */
    DBX("CFAD12FEC5FD746F"),

    /**
     * Outlook (pst).
     */
    PST("2142444E"),

    /**
     * MS Word/Excel.
     */
    XLS_DOC("D0CF11E0"),

    /**
     * MS Access.
     */
    MDB("5374616E64617264204A"),

    /**
     * WordPerfect.
     */
    WPD("FF575043"),

    /**
     * Adobe Acrobat.
     */
    PDF("255044462D312E"),

    /**
     * Quicken.
     */
    QDF("AC9EBD8F"),

    /**
     * Windows Password.
     */
    PWL("E3828596"),

    /**
     * ZIP Archive.
     */
    ZIP("504B0304"),

    /**
     * RAR Archive.
     */
    RAR("52617221"),

    /**
     * Wave.
     */
    WAV("57415645"),

    /**
     * AVI.
     */
    AVI("41564920"),

    /**
     * Real Audio.
     */
    RAM("2E7261FD"),

    /**
     * Real Media.
     */
    RM("2E524D46"),

    /**
     * MPEG (mpg).
     */
    MPG("000001BA"),

    /**
     * Quicktime.
     */
    MOV("6D6F6F76"),

    /**
     * Windows Media.
     */
    ASF("3026B2758E66CF11"),

    GZ("1F8B08"),

    /**
     * MIDI.
     */
    MID("4D546864");

    private final String header;

    FileType(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    // 静态方法：根据序号获取枚举常量

    /**
     * 根据文件头获取文件类型。
     *
     * @param header 文件头。
     * @return 文件类型。
     */
    public static FileType parseHeader(String header) {
        FileType[] items = values();
        // 遍历所有常量
        for (FileType item : items) {
            // 如果某个常量的序号与传入参数相同，则返回该常量并终止循环。
            if (item.header.equals(header)) {
                return item;
            }
        }

        // 如果传入参数未匹配到任何常量，则返回空值。
        return null;
    }
}
