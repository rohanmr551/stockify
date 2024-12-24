plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
    id("com.chaquo.python")
}

android {
    namespace = "com.example.ds"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.ds"
        minSdk = 34
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        signingConfig = signingConfigs.getByName("debug")
        ndk {
            abiFilters += listOf("arm64-v8a", "x86_64")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }

    flavorDimensions += "pyVersion"
    productFlavors {
        create("py312") { dimension = "pyVersion" }  // Python 3.12 support
    }

    buildToolsVersion = "34.0.0"
}

chaquopy {
    defaultConfig {
        pip {
            install("numpy")  // Install numpy
        }

        // Set Python version
        version = "3.12"
    }

    productFlavors {
        getByName("py312") { version = "3.12" }  // Python 3.12 support
    }

    sourceSets {
        getByName("main") {
            srcDir("src/main/python")  // Correct Python source directory
        }
    }
}

dependencies {
    // Android libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.auth)

    // Retrofit and OkHttp libraries
    implementation(libs.retrofit) // Retrofit
    implementation(libs.retrofit.gson) // Retrofit Gson converter
    implementation(libs.okhttp) // OkHttp

    // Volley library
    implementation("com.android.volley:volley:1.2.1")

    // Glide for image loading
    implementation("com.github.bumptech.glide:glide:4.15.1")
    // Uncomment the following if you're using annotationProcessor for Glide
    // annotationProcessor("com.github.bumptech.glide:compiler:4.15.1")

    // Retrofit dependencies for Gson conversion (do not repeat if already handled by libs)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation(libs.androidx.monitor)
    implementation(libs.androidx.junit.ktx)
    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.junit.junit)
}
