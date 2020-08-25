include("gordon-plugin", "app")

pluginManagement {
    val androidGradlePluginVersion: String by settings
    val kotlinVersion: String by settings
    val kotlinterVersion: String by settings

    repositories {
        gradlePluginPortal()
        google()
        jcenter()
        mavenLocal()
        maven("https://www.jitpack.io")
    }

    plugins {
        kotlin("android") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        id("org.jmailen.kotlinter") version kotlinterVersion
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useModule("com.android.tools.build:gradle:$androidGradlePluginVersion")
            }
        }
    }
}
