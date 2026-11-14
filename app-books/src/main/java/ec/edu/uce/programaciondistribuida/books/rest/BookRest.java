package ec.edu.uce.programaciondistribuida.books.rest;

import ec.edu.uce.programaciondistribuida.books.db.Book;
import ec.edu.uce.programaciondistribuida.books.repo.BookRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/libros")
@Produces(MediaType.APPLICATION_JSON)
public class BookRest {
    private final BookRepository bookRepository;

    @Inject
    public BookRest(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GET
    public List<Book> getAllBooks() {
        return bookRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") String id) {
        return bookRepository.findByIdOptional(id)
                .map(book -> Response.ok(book).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }
}
