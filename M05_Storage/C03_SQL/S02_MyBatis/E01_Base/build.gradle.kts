plugins {
    id("java")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

dependencies {
    // JDBC驱动-SQLite
    implementation(libJava.jdbc.sqlite)

    // MyBatis
    implementation(libJava.mybatis.core)

    // 日志工具
    implementation(libJava.slf4j.simple)
}
