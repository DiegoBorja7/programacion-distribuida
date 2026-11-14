plugins {
    id("java")
    id("io.quarkus")  version "3.40.1.1"
    id("io.freefair.lombok") version "9.8.3"
}

group = "ec.edu.uce.programaciondistribuida"
version = "unspecified"

repositories {
    mavenCentral()
}

val quarkusVersion = "3.40.1.1"

dependencies {
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:$quarkusVersion"))
    // Quarkus CDI/CD
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-hibernate-orm:3.40.1.2")
    implementation("io.quarkus:quarkus-jdbc-postgresql:${quarkusVersion}")
    implementation("io.quarkus:quarkus-hibernate-orm-panache:${quarkusVersion}")

    //  Quarkus REST
    implementation("io.quarkus:quarkus-rest")
    implementation("io.quarkus:quarkus-rest-jsonb")}

java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}