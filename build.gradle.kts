import net.bi4vmr.gradle.data.Plugins

// Gradle插件声明
plugins {
    alias(libJava.plugins.spring.springboot).apply(false)
    alias(libJava.plugins.spring.dependency).apply(false)

    alias(privateLibJava.plugins.repo.private).apply(false)
    alias(privateLibJava.plugins.repo.public).apply(false)
}

// 为子工程应用自定义插件
allprojects {
    project.apply(plugin = Plugins.PRIVATE_REPO)
    project.apply(plugin = Plugins.PUBLIC_REPO)
}
