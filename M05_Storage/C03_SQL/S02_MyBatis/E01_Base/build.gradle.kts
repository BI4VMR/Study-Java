plugins {
    id("java")
}

dependencies {
    // MyBatis
    implementation("org.mybatis:mybatis:3.5.13")
    // JDBC实现-MariaDB
    implementation("org.mariadb.jdbc:mariadb-java-client:3.2.0")
    // 日志工具
    implementation("org.slf4j:slf4j-simple:2.0.9")
}
