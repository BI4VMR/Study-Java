plugins {
    id("java")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

dependencies {
    // Jupiter（将会自动引入Platform）
    testImplementation(libJava.junit5.jupiter)
    // JUnit4及更早版本的兼容模块
    testImplementation(libJava.junit5.vintage)
}
