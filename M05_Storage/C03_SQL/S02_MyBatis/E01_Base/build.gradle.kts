plugins {
    id("java")
}

dependencies {
    // JDBC驱动-SQLite
    implementation(libs.java.jdbc.sqlite)

    // MyBatis
    implementation(libs.java.mybatis)

    // 日志工具
    implementation(libs.java.slf4j)
}
