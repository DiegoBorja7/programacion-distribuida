package ec.edu.uce.programaciondistribuida.books.rest;

import ec.edu.uce.programaciondistribuida.books.dtos.BookDto;
import ec.edu.uce.programaciondistribuida.books.services.interfaces.BookService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/libros")
@Produces(MediaType.APPLICATION_JSON)
public class BookRest {
    private final BookService bookService;

    @Inject
    public BookRest(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    public List<BookDto> getAllBooks() {
        return bookService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") String id) {
        return Optional.ofNullable(bookService.findById(id))
                .map(book -> Response.ok(book).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }
}
