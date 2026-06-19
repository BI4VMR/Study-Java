package net.bi4vmr.study;

import java.io.IOException;

public class HelloWorld {

    public static void main(String[] args) throws IOException, InterruptedException {
        Process p = new ProcessBuilder("/home/bi4vmr/Software/Bin/scrcpy").start();
        new Thread(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            p.destroy();
            // p.destroyForcibly();
            System.out.println("destroy");
        }).start();
        // int c = p.waitFor();
        // System.out.println("code " + c);
        // System.out.printf("Hello world! %2$s %1$s ", "AAA", "BBB");
    }
}
