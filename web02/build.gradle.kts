plugins {
    id("java")
    id("application")
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    // RESTEasy Core
    // Source: https://mvnrepository.com/artifact/org.jboss.resteasy/resteasy-core
    implementation("org.jboss.resteasy:resteasy-core:7.0.5.Final")

    // RESTEasy Undertow Integration
    // Source: https://mvnrepository.com/artifact/org.jboss.resteasy/resteasy-undertow
    implementation("org.jboss.resteasy:resteasy-undertow:7.0.5.Final")
}
