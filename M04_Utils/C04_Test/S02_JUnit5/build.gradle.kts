plugins {
    id("java")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

dependencies {
    testImplementation(libJava.junit5.vintage)
}
