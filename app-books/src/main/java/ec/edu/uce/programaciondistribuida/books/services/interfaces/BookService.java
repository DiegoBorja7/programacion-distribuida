package ec.edu.uce.programaciondistribuida.books.services.interfaces;

import ec.edu.uce.programaciondistribuida.books.dtos.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> findAll();
    BookDto findById(String isbn);
}
