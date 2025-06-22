plugins {
    id(libJava.plugins.java.application.get().pluginId)
    // 提供构建JAR/WAR包、调试应用等功能，版本号与SpringBoot同步。
    alias(libJava.plugins.spring.springboot)
    // 为SpringBoot等模块引入BOM文件，子模块声明依赖时无需指定版本，以SpringBoot插件版本为准。
    alias(libJava.plugins.spring.dependency)
}

dependencies {
    implementation(platform(libJava.springboot.bom))
    implementation(libJava.springboot.starter.core)
}
