package ec.edu.uce.programaciondistribuida.autors.repo;

import ec.edu.uce.programaciondistribuida.autors.db.Author;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class AuthorRepository implements PanacheRepositoryBase<Author, Integer> {
    public List<Author> findByBook(String isbn) {
        return find("SELECT ba.author FROM BookAuthor ba WHERE ba.id.bookISBN = ?1", isbn).list();
    }
}
