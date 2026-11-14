package ec.edu.uce.programaciondistribuida.books.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@Path("/config")
public class TestConfigRest {
    private static final Logger LOG = Logger.getLogger(TestConfigRest.class);

    @ConfigProperty(name = "app.name")
    String appName;

    @ConfigProperty(name = "app.version")
    String appVersion;

    @ConfigProperty(name = "quarkus.http.port")
    String quarkusHttpPort;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        LOG.debugf("Fuentes de configuración disponibles:");
        ConfigProvider.getConfig().getConfigSources().forEach(configSource -> {
            LOG.debugf("Fuente de configuración: %s - [%d]",
                    configSource.getName(), configSource.getOrdinal());
        });

        LOG.debugf("Nombre de la aplicación: %s", appName);
        LOG.debugf("Versión de la aplicación: %s", appVersion);
        LOG.debugf("Puerto de la aplicación: %s", quarkusHttpPort);

        return "Sí corre: " + appName
                + " - Versión: " + appVersion
                + " - Puerto: " + quarkusHttpPort;
    }
}
