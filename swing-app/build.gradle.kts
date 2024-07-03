plugins {
    id("java")
    id("com.teamdev.jxbrowser") version "1.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(jxbrowser.crossPlatform)
    implementation(jxbrowser.swing)
}

jxbrowser {
    version = "7.39.2"
}

tasks.test {
    useJUnitPlatform()
}