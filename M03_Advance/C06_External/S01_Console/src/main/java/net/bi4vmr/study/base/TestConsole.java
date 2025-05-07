package net.bi4vmr.study.base;

public class TestConsole {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("参数序号：[" + i + "] 参数值：[" + args[i] + "]");
        }
    }
}
