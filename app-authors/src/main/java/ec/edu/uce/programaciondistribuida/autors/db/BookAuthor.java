package ec.edu.uce.programaciondistribuida.autors.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "books_authors")
@Getter
@Setter
@ToString
public class BookAuthor {
    @EmbeddedId
    private BookAuthorID id;
    @ManyToOne
    @JoinColumn(name = "authors_id", insertable = false, updatable = false)
    private Author author;

}
