@file:Suppress("UnstableApiUsage")

// 构建工具的依赖配置
pluginManagement {
    // 声明Gradle插件仓库
    repositories {
        // 添加本地私有仓库与代理镜像，无法直连时应当禁用该配置。
        val hostName: String = java.net.InetAddress.getLocalHost().hostName
        println("Current host name is [$hostName]")
        var isInPrivateLAN = false
        run {
            java.net.NetworkInterface.getNetworkInterfaces().toList().forEach {
                it.inetAddresses.toList().forEach { addr ->
                    if ((addr is java.net.Inet4Address) && (addr.hostAddress.startsWith("172.18."))) {
                        isInPrivateLAN = true
                        return@run
                    }
                }
            }
        }
        println("Current host in private LAN? [$isInPrivateLAN]")

        if (hostName.startsWith("BI4VMR") && isInPrivateLAN) {
            println("Current host is in private network, add LAN repositorys.")
            maven {
                isAllowInsecureProtocol = true
                setUrl("http://172.18.5.1:8081/repository/maven-union/")
            }
        } else {
            if (java.net.InetAddress.getByName("192.168.128.1").isReachable(2000)) {
                println("Current host is not in private network, add VPN repositorys.")
                maven {
                    isAllowInsecureProtocol = true
                    setUrl("http://192.168.128.1:8081/repository/maven-union/")
                }
            } else {
                println("Current host is not in private network, add LOCAL repositorys.")
                mavenLocal()
            }
        }

        // 腾讯云仓库镜像：Maven中心仓库+Google+JCenter
        maven { setUrl("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
        // 阿里云仓库镜像：Maven中心仓库+JCenter
        maven { setUrl("https://maven.aliyun.com/repository/public/") }
        // 阿里云仓库镜像：Google
        maven { setUrl("https://maven.aliyun.com/repository/google/") }
        // 阿里云仓库镜像：Gradle社区插件
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin/") }

        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

// 所有模块的依赖配置
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    // 声明Maven组件仓库
    repositories {
        // 添加本地私有仓库与代理镜像，无法直连时应当禁用该配置。
        val hostName: String = java.net.InetAddress.getLocalHost().hostName
        var isInPrivateLAN = false
        run {
            java.net.NetworkInterface.getNetworkInterfaces().toList().forEach {
                it.inetAddresses.toList().forEach { addr ->
                    if ((addr is java.net.Inet4Address) && (addr.hostAddress.startsWith("172.18."))) {
                        isInPrivateLAN = true
                        return@run
                    }
                }
            }
        }

        if (hostName.startsWith("BI4VMR") && isInPrivateLAN) {
            maven {
                isAllowInsecureProtocol = true
                setUrl("http://172.18.5.1:8081/repository/maven-union/")
            }
        } else {
            if (java.net.InetAddress.getByName("192.168.128.1").isReachable(2000)) {
                maven {
                    isAllowInsecureProtocol = true
                    setUrl("http://192.168.128.1:8081/repository/maven-union/")
                }
            } else {
                mavenLocal()
            }
        }

        // 腾讯云仓库镜像：Maven中心仓库+Google+JCenter
        maven { setUrl("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
        // 阿里云仓库镜像：Maven中心仓库+JCenter
        maven { setUrl("https://maven.aliyun.com/repository/public/") }
        // 阿里云仓库镜像：Google
        maven { setUrl("https://maven.aliyun.com/repository/google/") }

        mavenCentral()
        google()
        maven { setUrl("https://jitpack.io/") }
    }

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


// ----- 基础知识 -----
include(":M01_Overview:C00_Temporary")
include(":M01_Overview:C01_HelloWorld")

// ----- 基本语法 -----
include(":M02_Syntax:C01_Struct")
include(":M02_Syntax:C02_Terminal")
include(":M02_Syntax:C03_Operator")
include(":M02_Syntax:C04_Control")
include(":M02_Syntax:C05_Method")
include(":M02_Syntax:C06_Array")
include(":M02_Syntax:C07_Exception")

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

// ----- 数据存储 -----
include(":M05_Storage:C01_File:S01_Base")
include(":M05_Storage:C03_SQL:S02_MyBatis:E01_Base")

// ----- 网络通讯 -----
include(":M06_Network:C01_Base")
