plugins {
    id("org.monkeyking.build.versions")
    id("org.monkeyking.build.jvm-convention")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "monkeyking6.plugin.paddleocr.v5.runtime"
    compileSdk = versions.sdkVersionCompile

    defaultConfig {
        minSdk = 26
        consumerProguardFiles("proguard-rules.pro")
    }

    lint {
        targetSdk = versions.sdkVersionTarget
        abortOnError = false
        checkReleaseBuilds = false
    }

    buildFeatures {
        buildConfig = false
    }

    sourceSets.named("main") {
        kotlin.directories += "src/main/java"
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.21")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

    compileOnly(files("$rootDir/libs/paddle-ocr-api.aar"))
    implementation(project(":libs:ppocr-android-sdk"))
}
