plugins {
    id("java")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

dependencies {
    testImplementation(libJava.junit4)
    testImplementation("org.mockito:mockito-core:5.16.1")
}
