plugins {
    id("java")
}

dependencies {
    // JDBC驱动-SQLite
    implementation(libJava.jdbc.sqlite)

    // MyBatis
    implementation(libJava.mybatis)

    // 日志工具
    implementation(libJava.slf4j.simple)
}
