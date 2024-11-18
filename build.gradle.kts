plugins {
    kotlin("jvm") version "2.0.21"
    id("org.springframework.boot") version "3.3.5" apply false
}

group = "org.thingsboard"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}