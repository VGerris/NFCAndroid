// This file defines the versions of plugins used across all modules.
plugins {
    // AGP 8.4.1 is a stable, modern version.
    id("com.android.application") version "8.13.0" apply false
    id("com.android.library") version "8.13.0" apply false // Add this for your library modules
    id("org.jetbrains.kotlin.android") version "2.2.21" apply false
}
