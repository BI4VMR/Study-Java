plugins {
    id(libJava.plugins.java.application.get().pluginId)
}

dependencies {
    implementation("com.google.android.tools:ddmlib:r13")
    implementation(privateLibJava.io.base)
}
