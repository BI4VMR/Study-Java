@file:Suppress("UnstableApiUsage")

// 构建工具的依赖配置
pluginManagement {
    // 声明Gradle插件仓库
    repositories {
        // 阿里云仓库镜像：Gradle社区插件
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin/") }
        // 阿里云仓库镜像：Maven中心仓库+JCenter
        maven { setUrl("https://maven.aliyun.com/repository/public/") }
        // 阿里云仓库镜像：Google仓库
        maven { setUrl("https://maven.aliyun.com/repository/google/") }
        // 腾讯云仓库镜像：Maven中心仓库+Google+JCenter
        maven { setUrl("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }

        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

// 所有模块的依赖配置
dependencyResolutionManagement {
    // 版本管理配置
    versionCatalogs {
        // 公共组件(Java)
        create("libJava") {
            from(files("misc/version/dependency_public_java.toml"))
        }

        // 私有组件(Java)
        create("privateLibJava") {
            from(files("misc/version/dependency_private_java.toml"))
        }
    }
}

/* ----- 工程结构声明 ----- */
// 主工程名称
rootProject.name = "Study-Java"
// 加载自定义插件
includeBuild("plugin")

// ----- 基础知识 -----
include(":M01_Overview:C00_Temporary")
include(":M01_Overview:C01_HelloWorld")

// ----- 基本语法 -----
include(":M02_Syntax:C01_Struct")
include(":M02_Syntax:C02_Operator")
include(":M02_Syntax:C03_Control")
include(":M02_Syntax:C04_Method")
include(":M02_Syntax:C05_Array")
include(":M02_Syntax:C06_Exception")
include(":M02_Syntax:C07_Terminal")

// ----- 高级特性 -----
include(":M03_Advance:C01_OOP:S01_Base")
include(":M03_Advance:C01_OOP:S02_Encapsulation")
include(":M03_Advance:C01_OOP:S03_Inherit")
include(":M03_Advance:C01_OOP:S04_Polymorphism")
include(":M03_Advance:C01_OOP:S05_Interface")
include(":M03_Advance:C01_OOP:S06_WrapperClass")
include(":M03_Advance:C01_OOP:S07_EnumClass")
include(":M03_Advance:C02_Features:S01_Generics")
include(":M03_Advance:C02_Features:S02_Annotation")
include(":M03_Advance:C02_Features:S03_Reflection")
include(":M03_Advance:C03_Collection:S01_Base")
include(":M03_Advance:C04_Concurrent:S01_Thread")
include(":M03_Advance:C04_Concurrent:S02_Tool")
include(":M03_Advance:C05_IO:S01_Base")
include(":M03_Advance:C06_External:S01_Console")
include(":M03_Advance:C06_External:S02_JNI")

// ----- 实用工具 -----
include(":M04_Utils:C01_Text")
include(":M04_Utils:C02_DateTime")
include(":M04_Utils:C03_Math")
include(":M04_Utils:C04_Test:S01_Base")
include(":M04_Utils:C04_Test:S02_JUnit4")
include(":M04_Utils:C04_Test:S02_JUnit5")
include(":M04_Utils:C04_Test:S03_Mockito")

// ----- 数据存储 -----
include(":M05_Storage:C01_File:S01_Base")
include(":M05_Storage:C03_SQL:S02_MyBatis:E01_Base")

// ----- 网络通讯 -----
include(":M06_Network:C01_Base")

// ----- 企业框架 -----
include(":M07_JavaEE:C03_SpringBoot:S01_Base")
