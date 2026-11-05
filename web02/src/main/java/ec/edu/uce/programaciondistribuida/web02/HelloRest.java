package ec.edu.uce.programaciondistribuida.web02;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Path("/hola")
public class HelloRest {
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON) // Cambiado a JSON
    public Response hola(@PathParam("name") String name) {

        // Obtener la fecha y hora actual
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String horaFormateada = ahora.format(formato);

        // Crear un mensaje estructurado en JSON de forma manual
        // En proyectos más grandes, se usan librerías como Jackson o JSON-B
        String jsonRespuesta = String.format(
                "{\n" +
                        "  \"mensaje\": \"¡Hola %s, bienvenido a la API!\",\n" +
                        "  \"servidor\": \"Apache TomEE 10.2.0\",\n" +
                        "  \"timestamp\": \"%s\"\n" +
                        "}", name, horaFormateada
        );

        // Retornar la respuesta con código 200 (OK)
        return Response.ok(jsonRespuesta).build();
    }
}
