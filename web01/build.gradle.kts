plugins {
    id("java")
    id("war")
}

group = "ec.edu.uce.programacion.distruibuida"
version = "1.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //
    // Source: https://mvnrepository.com/artifact/jakarta.ws.rs/jakarta.ws.rs-api
    compileOnly("jakarta.ws.rs:jakarta.ws.rs-api:4.0.0")
}
