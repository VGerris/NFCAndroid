plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "com.qifan.readnfcmessage" // Namespace is mandatory
    compileSdk = 36

    defaultConfig {
        minSdk = 21
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

    // All dependencies use double quotes ("...") as required by Kotlin.
    implementation("androidx.work:work-runtime-ktx:2.11.0")
    // implementation("com.github.pro100svitlo:creditCardNfcReader:1.0.3")
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    implementation("com.google.android.material:material:1.13.0")

    // CRITICAL FIX: The firebase-crashlytics-buildtools is a build plugin, NOT a library.
    // Including it here is incorrect and will cause issues. It has been removed.
    // If you use Crashlytics, its plugin should be applied at the top of the file
    // and its classpath added to the root build.gradle.kts.

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
}
