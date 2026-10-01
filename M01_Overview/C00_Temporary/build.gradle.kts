plugins {
    id(libJava.plugins.java.application.get().pluginId)
}

dependencies {
    implementation("com.google.android.tools:ddmlib:r13")
    implementation("org.slf4j:slf4j-simple:2.0.18")
}
