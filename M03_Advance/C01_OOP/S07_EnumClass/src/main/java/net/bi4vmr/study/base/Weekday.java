package net.bi4vmr.study.base;

/**
 * 枚举类：星期。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public enum Weekday {

    MONDAY(1, "周一"),
    TUESDAY(2, "周二"),
    WEDNESDAY(3, "周三"),
    THURSDAY(4, "周四"),
    FRIDAY(5, "周五"),
    SATURDAY(6, "周六"),
    SUNDAY(7, "周日");

    // 定义属性：索引编号
    private final int index;
    // 定义属性：标准名称
    private final String standardName;

    /*
     * 构造方法
     *
     * 由于枚举常量都是预先确定的，该方法不能被外部调用，因此我们不能修改它的访问修饰符。
     */
    Weekday(int index, String standardName) {
        this.index = index;
        this.standardName = standardName;
    }

    // 获取索引编号
    public int getIndex() {
        return index;
    }

    // 获取标准名称
    public String getStandardName() {
        return standardName;
    }

    /**
     * 根据序号获取枚举常量。
     * <p>
     * 未匹配到对应的常量时，将返回空值。
     *
     * @param ordinal 枚举列表中的序号。
     * @return 枚举常量。
     */
    public static Weekday parseFromSerial(int ordinal) {
        Weekday[] items = values();
        // 遍历所有常量
        for (Weekday item : items) {
            // 如果某个常量的序号与传入参数相同，则返回该常量并终止循环。
            if (item.ordinal() == ordinal) {
                return item;
            }
        }

        // 如果传入参数未匹配到任何常量，则返回空值。
        return null;
    }

    /**
     * 获取上一项。
     *
     * @return 枚举常量。
     */
    public Weekday previous() {
        Weekday[] items = values();
        int maxOrdinal = items.length - 1;
        int itemOrdinal = ordinal();

        if (itemOrdinal == 0) {
            // 当前常量为第一项时，返回最后一项。
            return items[maxOrdinal];
        } else {
            // 当前常量不是第一项时，返回前一项。
            return items[itemOrdinal - 1];
        }
    }

    /**
     * 获取下一项。
     *
     * @return 枚举常量。
     */
    public Weekday next() {
        Weekday[] items = values();
        int maxOrdinal = items.length - 1;
        int itemOrdinal = ordinal();

        if (itemOrdinal < maxOrdinal) {
            // 当前常量的序号小于最后一项的序号时，返回后一项。
            return items[itemOrdinal + 1];
        } else {
            // 当前常量的序号等于最后一项的序号时，返回第一项。
            return items[0];
        }
    }
}
