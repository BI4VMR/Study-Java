plugins {
    id("java")
    id("jacoco")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

dependencies {
    implementation(libJava.gson)

    testImplementation(libJava.junit4)
    testImplementation(libJava.mockito.core)
}

// Jacoco配置
jacoco {
    // 指定Jacoco版本
    toolVersion = "0.8.13"
    // 指定报告输出目录
    reportsDirectory = layout.buildDirectory.dir("jacocoReports")
}

// 在Gradle Test任务执行后自动执行Jacoco任务
tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)

    // 设置排除项
    classDirectories.setFrom(
        files(
            classDirectories.files.map {
                fileTree(it) {
                    exclude(
                        "net/**",
                    )
                }
            }
        )
    )
}

// tasks.jacocoTestReport {
//     reports {
//         xml.required = false
//         csv.required = false
//         // 指定HTML报告输出路径（覆盖jacoco -> reportsDirectory）
//         html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
//     }
// }
