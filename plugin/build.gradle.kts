plugins {
    id("com.android.library")
    id("com.vanniktech.maven.publish")
    kotlin("android")
    id("kotlin-parcelize")
}

setupCommon()

android {
    namespace = "com.github.shadowsocks.plugin"
    lint.informational += "GradleDependency"

    defaultConfig {
        consumerProguardFiles("proguard-rules.pro")

        externalNativeBuild.ndkBuild {
//            version("24.0.8215888")
            abiFilters("armeabi-v7a", "arm64-v8a", "x86")
            arguments("-j${Runtime.getRuntime().availableProcessors()}")
        }

    }
    externalNativeBuild.ndkBuild.path("src/main/jni/Android.mk")
}

dependencies {
    api(kotlin("stdlib-jdk8"))
    api("androidx.core:core-ktx:1.7.0")
    api("androidx.fragment:fragment-ktx:1.5.5")
    api("com.google.android.material:material:1.6.0")
}
