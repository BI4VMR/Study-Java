plugins {
    id(libJava.plugins.java.application.get().pluginId)
    // SpringBoot插件，为Gradle提供打包等能力，可选。
    alias(libJava.plugins.spring.springBoot)
    // Spring依赖管理插件，添加后可以不配置BOM，以SpringBoot插件版本为准，可选。
    alias(libJava.plugins.spring.dependency)
}

dependencies {
    implementation(platform(libJava.springBoot.bom))
    implementation(libJava.springBoot.starter.core)
}
