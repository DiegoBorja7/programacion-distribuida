package ec.edu.uce.programaciondistribuida.books.services.implementation;

import ec.edu.uce.programaciondistribuida.books.clients.AuthorRestClient;
import ec.edu.uce.programaciondistribuida.books.db.Book;
import ec.edu.uce.programaciondistribuida.books.dtos.AuthorDto;
import ec.edu.uce.programaciondistribuida.books.dtos.BookDto;
import ec.edu.uce.programaciondistribuida.books.repo.BookRepository;
import ec.edu.uce.programaciondistribuida.books.services.interfaces.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
@Transactional
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;
    final AuthorRestClient authorRestClient;

    @Inject
    public BookServiceImplementation(BookRepository bookRepository, @RestClient AuthorRestClient authorRestClient) {
        this.bookRepository = bookRepository;
        this.authorRestClient = authorRestClient;
    }

    private BookDto mapToDto(Book book) {
        return BookDto.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .price(book.getPrice())
                .inventorySold(book.getInventory() != null ? book.getInventory().getSold() : 0)
                .inventorySupplied(book.getInventory() != null ? book.getInventory().getSupplied() : 0)
                .inventoryVersion(book.getInventory() != null ? book.getInventory().getVersion() : 0)
                .build();
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.streamAll()
                .map(this::mapToDto)
                .peek(bookDto -> {
                    var authors = authorRestClient.getAuthorsByBook(bookDto.getIsbn());
                    bookDto.setAuthors(authors);
                })
                .toList();
    }

    @Override
    public BookDto findById(String isbn) {
        List<AuthorDto> authors = authorRestClient.getAuthorsByBook(isbn);

        return bookRepository.findByIdOptional(isbn)
                .map(this::mapToDto)
                .map(bookDto -> {
                    bookDto.setAuthors(authors);
                    return bookDto;
                })
                .orElse(null);
    }
}