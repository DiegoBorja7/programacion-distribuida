package ec.edu.uce.programaciondistribuida.web02;

import jakarta.ws.rs.SeBootstrap;

import java.net.URI;

public class Web02Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hola");

        SeBootstrap.Configuration config = SeBootstrap.Configuration.builder()
                .host("localhost")
                .port(8080)
                .protocol("http")
                .build();

        SeBootstrap.start(MyApplicationRest.class, config)
                .thenAccept(instance ->  {
                    System.out.println(instance);
                    URI uri = instance.configuration().baseUri();
                    System.out.println("Servidor iniciado: "+uri);
                })
                .exceptionally(t -> {
                    t.printStackTrace();
                    return null;
                });
        Thread.currentThread().join();
    }

}
