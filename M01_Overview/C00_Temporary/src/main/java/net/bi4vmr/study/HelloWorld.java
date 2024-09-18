package net.bi4vmr.study;

import cn.zhxu.okhttps.HTTP;

public class HelloWorld {

    public static void main(String[] args) {
        HTTP client = HTTP.builder().build();
        client.sync("http://172.18.5.1:8082/job/BookKeeper/job/BookKeeper-Client_Android/lastSuccessfulBuild/artifact/bookkeeper_app/build/outputs/apk/release/bookkeeper_app-release.apk")
                .basicAuth("admin", "Emczyg300498.")
                .get()
                .getBody()
                .stepRate(0.2)
                .setOnProcess(p -> System.out.println("下载中... " + p.getRate() * 100))
                .toFile("D:/test.apk")
                .setOnSuccess(file -> System.out.println("下载完成！ " + file.getAbsolutePath()))
                .start();
    }
}
