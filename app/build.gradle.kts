plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

apply(from = "$rootDir/ktlint.gradle.kts")

android {

    compileSdk = 31

    defaultConfig {

        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        kotlinOptions.jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        debug {
            buildConfigField ("String", "CURRENCY_URL", "\"https://www.nbrb.by/\"")
        }
        release {
            buildConfigField ("String", "CURRENCY_URL", "\"https://www.nbrb.by/\"")
        }
    }
}


dependencies {

    // Common
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.fragment:fragment-ktx:1.4.0")

    // Moxy MVP
    kapt ("com.github.moxy-community:moxy-compiler:2.2.2")
    implementation ("com.github.moxy-community:moxy:2.2.2")
    implementation ("com.github.moxy-community:moxy-androidx:2.2.2")
    implementation ("com.github.moxy-community:moxy-ktx:2.2.2")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.4.0")
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.work:work-runtime:2.7.1")

    // Cicerone
    implementation("com.github.terrakok:cicerone:7.1")

    // ViewBinding
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.0-beta01")

    // Network
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    // Dependency injection
    implementation("com.google.dagger:dagger:2.38.1")
    kapt("com.google.dagger:dagger-compiler:2.38.1")
}

object Config {
    const val applicationId = "com.roman.mvpapp"
    const val minSdk = 26
    const val targetSdk = 31
    const val versionCode = 1
    const val versionName = "1"
}