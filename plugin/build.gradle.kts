plugins {
    id("java-gradle-plugin")
    alias(libs.plugins.kotlin)
    id("maven-publish")
    id("com.gradle.plugin-publish") version "1.2.1"
}

group = "zbs.resourceplaceholders"
version = "1.0.0"

// Use java-gradle-plugin to generate plugin descriptors and specify plugin ids
gradlePlugin {
    website = "https://github.com/timfreiheit/ResourcePlaceholdersPlugin"
    vcsUrl = "https://github.com/timfreiheit/ResourcePlaceholdersPlugin.git"

    plugins {
        plugins.register("resource-placeholders") {
            id = "zbs.resourceplaceholders"
            implementationClass =
                "de.timfreiheit.plugin.resourceplaceholders.ResourcePlaceholdersPlugin"
            displayName = "ResourcePlaceholdersPlugin"
            description =
                "Gradle plugin which adds support for \${placeholder} manifestPlaceholders in Android resource files"
            tags.set(listOf("android", "resource", "placeholders"))
        }
    }
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())
    implementation("com.android.tools.build:gradle:8.2.2")
}
