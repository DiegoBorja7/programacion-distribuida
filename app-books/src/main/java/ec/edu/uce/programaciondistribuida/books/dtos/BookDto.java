package ec.edu.uce.programaciondistribuida.books.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * DTO for {@link ec.edu.uce.programaciondistribuida.books.db.Book}
 */
@Getter
@Setter
@ToString
@Builder
public class BookDto implements Serializable {
    private String isbn;
    private String title;
    private BigDecimal price;

    private Integer inventorySold;
    private Integer inventorySupplied;
    private Integer inventoryVersion;

    private List<AuthorDto> authors;
}