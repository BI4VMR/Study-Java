plugins {
    id("java")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
    // 添加JUnit5支持
    useJUnitPlatform()
}

dependencies {
    // 以下声明方式只能在IDE中运行测试代码，不适用于Gradle命令行。
    // Jupiter（将会自动引入Platform）
    // testImplementation(libJava.junit5.jupiter)
    // Vintage（JUnit4及更早版本的兼容模块，可选。）
    // testImplementation(libJava.junit5.vintage)

    // 以下声明方式适用于IDE和Gradle命令行
    // JUnit5 BOM版本配置文件
    testImplementation(platform(libJava.junit5.bom))
    // JUnit5 平台启动器
    testImplementation(libJava.junit5.launcher)
    // Jupiter
    testImplementation(libJava.junit5.jupiter)
    // Vintage（JUnit4及更早版本的兼容模块，可选。）
    testImplementation(libJava.junit5.vintage)
}
