plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "com.qifan.nfcemvread" // Namespace is mandatory
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        // targetSdk = 34
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // Set Java version compatibility. Java 17 is standard for modern AGP.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            // To use ProGuard, the syntax is:
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

}

dependencies {
    // Correctly includes all JAR files from the 'libs' directory.
    implementation(fileTree("libs") { include("*.jar") })

    // THE FIX: All dependencies now use double quotes ("...").
    implementation("androidx.work:work-runtime-ktx:2.11.0")
    // implementation("com.github.pro100svitlo:creditCardNfcReader:1.0.3")
    // implementation("com.github.devnied.emvnfccard:library:3.0.1")
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    implementation("com.google.android.material:material:1.13.0")

    // THE FIX: Add the RxJava dependencies REQUIRED by the devnied library
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")

    // THE FIX: Add the logging library that the AAR file is missing.
    implementation("org.slf4j:slf4j-api:2.0.17")
    implementation("org.slf4j:slf4j-simple:1.7.32")
    // ========================================================================


    // IMPORTANT: This Crashlytics dependency is likely in the wrong place.
    // It is a build tool, not an implementation library.
    // For now, I am leaving it but it may cause other errors.
    // If it does, it should be moved to your root build.gradle.kts's classpath.
    implementation("com.google.firebase:firebase-crashlytics-buildtools:3.0.6")
    implementation(files("libs/creditCardNfcReader-1.0.3.aar"))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
}