package ec.edu.uce.programaciondistribuida.autors.db;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class BookAuthorID {
    @Column(name = "books_isbn")
    private String bookISBN;
    @Column(name = "authors_id")
    private Integer authorID;
}
