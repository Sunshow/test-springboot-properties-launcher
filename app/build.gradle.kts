plugins {
    kotlin("jvm")
}

apply(plugin = "org.springframework.boot")

group = "org.thingsboard"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(platform("org.springframework.boot:spring-boot-dependencies:3.3.5"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-loader")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

//val jar by tasks.getting(Jar::class) {
//    manifest {
//        // kotlin 会自动编译成两个文件 需要指定带 Kt 后缀的类名
//        attributes["Main-Class"] = "sample.app.SampleApplicationKt"
//    }
//}

tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    launchScript()
    manifest {
        attributes["Main-Class"] = "org.springframework.boot.loader.launch.PropertiesLauncher"
    }
}
