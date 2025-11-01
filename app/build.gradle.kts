plugins {
    // Apply the plugins defined in the root build file.
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    // Namespace is mandatory in modern AGP.
    namespace = "com.qifan.nfcbank"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.qifan.nfcbank"
        minSdk = 24 // A more realistic minimum SDK for modern apps.
        targetSdk = 36 // Should match compileSdk.
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

    // Java 17 is the standard for modern Android development.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // UPDATED to modern, stable versions to avoid compatibility issues.
    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("com.google.android.material:material:1.13.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    // THE FIX: Add dependencies on your local library modules.
    implementation(project(":nfcemvread"))
    implementation(project(":readnfcmessage"))
    // https://mvnrepository.com/artifact/com.github.pro100svitlo/creditCardNfcReader
    // implementation("com.github.pro100svitlo:creditCardNfcReader:1.0.3")
    // implementation("com.github.devnied.emvnfccard:library:3.0.1")
    // Test dependencies UPDATED.
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
}
