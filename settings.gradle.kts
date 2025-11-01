// This file is essential. It configures where Gradle finds plugins and dependencies.
pluginManagement {
    repositories {
        // These repositories are non-negotiable for Android development.
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

// This block configures where your project's libraries (dependencies) are found.
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // The creditCardNfcReader library is on JitPack. This is essential.
        maven { url = uri("https://mvnrepository.com/artifact/com.github.pro100svitlo/creditCardNfcReader") }
    }
}

rootProject.name = "NFCAndroid"
include(":app")
include(":readnfcmessage")
include(":nfcemvread")
