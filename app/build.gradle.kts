plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.indiannaveymr"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.indiannaveymr"
        minSdk = 21
        targetSdk = 34
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

    buildFeatures{
        viewBinding = true;
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)



   // implementation("com.github.barteksc:android-pdf-viewer:2.8.2")

    implementation ("com.github.Foysalofficial:pdf-viewer-android:6.1")

    implementation("com.google.android.gms:play-services-ads:23.6.0")

}