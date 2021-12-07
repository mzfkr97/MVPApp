buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(
            url = "https://maven.google.com/"
        )
        maven(
            url = "https://www.jitpack.io"
        )
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.0.3")
        classpath ("com.google.gms:google-services:4.3.10")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
