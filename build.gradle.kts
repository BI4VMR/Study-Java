// Gradle插件声明
plugins {
    alias(libJava.plugins.spring.springBoot).apply(false)
    alias(libJava.plugins.spring.dependency).apply(false)
}
