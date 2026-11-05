package ec.edu.uce.programaciondistribuida.web01;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/hola")
public class HelloRest {
    @GET
    @Path("/{name}")
    @Produces("text/plain")
    public  String hola(@PathParam("name")String name){
        return "hola";
    }
}
