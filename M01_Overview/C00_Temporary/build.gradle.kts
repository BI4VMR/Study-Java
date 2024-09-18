plugins {
    id("java")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

dependencies {
    implementation(libJava.okhttps.core)
    implementation("com.larksuite.oapi:oapi-sdk:2.3.4")
}
