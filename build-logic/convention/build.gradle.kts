import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl` /* kotlin("jvm") */
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(gradleApi())

    implementation(libs.apache.commons.compress)
    implementation(libs.tukaani.xz)
}

gradlePlugin {
    plugins {
        register("utils") {
            id = "org.monkeyking.build.utils"
            implementationClass = "org.monkeyking.build.UtilsPlugin"
            displayName = "MonkeyKing6 Build Utils Plugin"
            description = "Provides utilities for downloading, extracting archives, and version helpers."
        }
        register("versions") {
            id = "org.monkeyking.build.versions"
            implementationClass = "org.monkeyking.build.VersionsPlugin"
            displayName = "MonkeyKing6 Versions Plugin"
            description = "Provides version helpers."
        }
        register("signs") {
            id = "org.monkeyking.build.signs"
            implementationClass = "org.monkeyking.build.SignsPlugin"
            displayName = "MonkeyKing6 Signs Plugin"
            description = "Provides signing helpers."
        }
        register("properties") {
            id = "org.monkeyking.build.properties"
            implementationClass = "org.monkeyking.build.PropertiesPlugin"
            displayName = "MonkeyKing6 Properties Plugin"
            description = "Provides properties helpers."
        }
        register("jvmConvention") {
            id = "org.monkeyking.build.jvm-convention"
            implementationClass = "org.monkeyking.build.JvmConventionPlugin"
            displayName = "MonkeyKing6 JVM Convention Plugin"
            description = "Configures Java/Kotlin targets for Android modules using central Versions."
        }
        register("localAarRegisterConvention") {
            id = "org.monkeyking.build.local-arr-register-convention"
            implementationClass = "org.monkeyking.build.LocalAarRegisterConventionPlugin"
            displayName = "MonkeyKing6 Local AAR Register Convention Plugin"
            description = "Provides local AAR register helpers."
        }
    }
}

System.getProperty("gradle.java.version.select").toInt().let { jdk ->
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(jdk))
        }
    }
    kotlin {
        jvmToolchain(jdk)
    }
}

System.getProperty("gradle.jvm.target.effective").let { jvm ->
    java {
        sourceCompatibility = JavaVersion.toVersion(jvm)
        targetCompatibility = JavaVersion.toVersion(jvm)
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(jvm))
        }
    }
}
