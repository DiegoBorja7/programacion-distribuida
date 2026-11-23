package ec.edu.uce.programaciondistribuida.autors.db;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class BookAuthorID implements Serializable {
    @Column(name = "books_isbn")
    private String bookISBN;
    @Column(name = "authors_id")
    private Integer authorID;
}
