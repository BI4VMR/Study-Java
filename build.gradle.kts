// Groovy写法
// tasks.withType(JavaCompile) {
//     options.encoding = "UTF-8"
// }

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
