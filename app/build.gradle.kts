plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //HILT PLUGIN
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {

    buildFeatures {
        compose = true
    }

    namespace = "com.example.brevisimo_news"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.brevisimo_news"
        minSdk = 27
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    //HILT
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.hilt)
    implementation(libs.androidx.compose.foundation)
    ksp(libs.hilt.compiler)
    //VIEWMODEL
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    //COIL3
    implementation(libs.coil3.network.okhttp)
    implementation(libs.coil3.compose)
    //GSON
    implementation(libs.converter.gson)
    implementation(libs.gson)
    //MATERIAL3
    implementation(libs.androidx.compose.material3.window.size)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.material.icons.extended)
    //NAVIGATION
    implementation(libs.androidx.navigation.compose)
    //RETROFIT
    implementation(libs.retrofit2)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}