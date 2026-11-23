package ec.edu.uce.programaciondistribuida.books.config;

import ec.edu.uce.programaciondistribuida.books.clients.AuthorRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

@ApplicationScoped
public class RestClientConfig {
//    @Inject
//    @ConfigProperty(name = "app.authors.url")
//    String baseUrl;
//
//    @Produces
//    @ApplicationScoped
//    public AuthorRestClient authorRestClient() {
//        return RestClientBuilder.newBuilder()
//                .baseUri(java.net.URI.create(baseUrl))
//                .build(AuthorRestClient.class);
//    }
}
