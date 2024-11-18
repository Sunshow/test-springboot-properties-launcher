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
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

// 禁用默认的jar任务
//val jar by tasks.getting(Jar::class) {
//    enabled = false
//}

// 禁用bootJar任务
tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = false
}

tasks.register<Zip>("packageDependencies") {
    dependsOn("jar")

    archiveFileName.set("dependencies.zip")
    destinationDirectory.set(layout.buildDirectory.dir("distributions"))

    // 添加项目自身的 JAR 文件
    from(tasks.jar) {
        into("lib")
    }

    // 添加所有依赖项
    from(configurations.runtimeClasspath) {
        into("lib")
    }
}
