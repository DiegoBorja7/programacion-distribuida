plugins {
    id("java")
    id("application")
    id("io.freefair.lombok") version "9.8.3"
    id("com.gradleup.shadow") version "9.6.1"

}

group = "ec.edu.uce.programaciondistribuida"
version = "unspecified"

repositories {
    mavenCentral()
}

val helidonVersion = "4.5.6"

dependencies {
    // Helidon
    // Source: https://mvnrepository.com/artifact/io.helidon.webserver/helidon-webserver
    // Core del Servidor Web
    implementation("io.helidon.webserver:helidon-webserver:$helidonVersion")

    //JSON
    implementation("io.helidon.http.media:helidon-http-media-jsonp:${helidonVersion}")
    implementation("io.helidon.http.media:helidon-http-media-jsonb:${helidonVersion}")

    //Gestión de Configuración
    implementation("io.helidon.config:helidon-config-yaml:${helidonVersion}")

    //Capa de Persistencia y Acceso a Datos
    // DBClient: Cliente de base de datos reactivo y no bloqueante de Helidon.
    implementation("io.helidon.dbclient:helidon-dbclient:${helidonVersion}")
    // JDBC: Soporte y mapeo para bases de datos relacionales tradicionales.
    implementation("io.helidon.dbclient:helidon-dbclient-jdbc:${helidonVersion}")
    // HikariCP: Pool de conexiones de alto rendimiento (gestión eficiente de hilos a la DB).
    implementation("io.helidon.dbclient:helidon-dbclient-hikari:${helidonVersion}")

    implementation("org.postgresql:postgresql:42.7.14")
}

application {
    mainClass.set("ec.edu.uce.programaciondistribuida.web03.Web03Main")
}
tasks.jar {
    manifest{
        attributes["Main-Class"] = "ec.edu.uce.programaciondistribuida.web03.Web03Main"
    }
}