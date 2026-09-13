// Top-level build file where you can add configuration options common to all sub-projects/modules.

allprojects {
    repositories {
        maven("https://maven.aliyun.com/repository/public")
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/gradle-plugin")
        maven("https://maven.aliyun.com/repository/central")
        mavenCentral()
        google()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}

tasks {
    register<Delete>("clean").configure {
        // @Legacy delete(rootProject.buildDir)
        delete(rootProject.layout.buildDirectory)
    }
}
