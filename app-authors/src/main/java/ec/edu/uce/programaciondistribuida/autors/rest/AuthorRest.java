package ec.edu.uce.programaciondistribuida.autors.rest;

import ec.edu.uce.programaciondistribuida.autors.db.Author;
import ec.edu.uce.programaciondistribuida.autors.repo.AuthorRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/autores")
@Produces("application/json")
@Consumes("application/json")
public class AuthorRest {
    final AuthorRepository authorRepository;

    @Inject
    public AuthorRest(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GET
    public List<Author> getAllAuthors() {
        return authorRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") Integer id) {
        return authorRepository.findByIdOptional(id)
                .map(author -> Response.ok(author).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("/buscar/{isbn}")
    public List<Author> getAuthorsByBook(@PathParam("isbn") String isbn) {
        return authorRepository.findByBook(isbn);
    }
}
