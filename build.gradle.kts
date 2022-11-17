import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
}

group = "com.leo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
var koin_version = "3.1.6"

dependencies {
    implementation("com.rabbitmq:amqp-client:5.16.0")
    implementation("io.insert-koin:koin-core:$koin_version")
    testImplementation ("io.insert-koin:koin-test:$koin_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}