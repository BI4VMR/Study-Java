package net.bi4vmr.study.base;

/**
 * 测试类：枚举类。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class TestEnumClass {

    public static void main(String[] args) {
        example05();
    }

    /**
     * 示例一：使用常量表示季节。
     * <p>
     * 在本示例中，我们使用数字代码表示四个季节。
     */
    static void example01() {
        printSeason(Const.SEASON_SPRING);
    }

    // 根据传入的季节代号，输出季节名称。
    static void printSeason(int code) {
        switch (code) {
            case Const.SEASON_SPRING:
                System.out.println("现在是春天");
                break;
            case Const.SEASON_SUMMER:
                System.out.println("现在是夏天");
                break;
            case Const.SEASON_AUTUMN:
                System.out.println("现在是秋天");
                break;
            case Const.SEASON_WINTER:
                System.out.println("现在是冬天");
                break;
            default:
                System.out.println("无效的参数！");
                break;
        }
    }

    /**
     * 示例二：使用枚举表示季节。
     * <p>
     * 在本示例中，我们使用数字代码表示四个季节。
     */
    static void example02() {
        // 传入枚举常量
        printSeason2(Season.SUMMER);
    }

    // 根据传入的枚举常量，输出季节名称。
    static void printSeason2(Season season) {
        switch (season) {
            case SPRING:
                System.out.println("现在是春天");
                break;
            case SUMMER:
                System.out.println("现在是夏天");
                break;
            case AUTUMN:
                System.out.println("现在是秋天");
                break;
            case WINTER:
                System.out.println("现在是冬天");
                break;
        }
    }

    /**
     * 示例三：访问枚举类的内置方法。
     * <p>
     * 在本示例中，我们访问Season中枚举的序号与名称属性，并将它们输出到控制台上。
     */
    static void example03() {
        // 获取常量的序号
        System.out.println("访问春天的序号：" + Season.SPRING.ordinal());
        // 获取常量的名称
        System.out.println("访问秋天的名称：" + Season.AUTUMN.name());
    }

    /**
     * 示例四：为枚举类新增自定义属性与方法。
     * <p>
     * 在本示例中，我们使用枚举表示一周中的七天，并添加一些自定义属性与方法。
     */
    static void example04() {
        // 调用自定义方法
        System.out.println(Weekday.SUNDAY.getStandardName() + "的序号是：" + Weekday.SUNDAY.getIndex());
    }

    /**
     * 示例五：常用方法模板。
     */
    static void example05() {
        // 根据序号获取对应的枚举常量
        System.out.println("根据序号获取对应的枚举常量：" + Weekday.parseFromSerial(0));

        // 获取上一项
        System.out.println();
        System.out.println("获取周一的上一项：" + Weekday.MONDAY.previous().getStandardName());
        System.out.println("获取周日的上一项：" + Weekday.SUNDAY.previous().getStandardName());

        // 获取下一项
        System.out.println();
        System.out.println("获取周一的下一项：" + Weekday.MONDAY.next().getStandardName());
        System.out.println("获取周日的下一项：" + Weekday.SUNDAY.next().getStandardName());
    }
}
