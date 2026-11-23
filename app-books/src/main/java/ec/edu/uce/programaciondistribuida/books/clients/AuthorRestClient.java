package ec.edu.uce.programaciondistribuida.books.clients;

import ec.edu.uce.programaciondistribuida.books.dtos.AuthorDto;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/autores")
@Produces("application/json")
@Consumes("application/json")
@RegisterRestClient(configKey = "AuthorRestClient")
public interface AuthorRestClient {
//    @GET
//    List<Author> getAllAuthors();

    @GET
    @Path("/buscar/{isbn}")
    List<AuthorDto> getAuthorsByBook(@PathParam("isbn") String isbn);
}
