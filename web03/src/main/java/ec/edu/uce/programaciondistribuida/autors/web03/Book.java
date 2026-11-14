package ec.edu.uce.programaciondistribuida.autors.web03;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String title;
    private String isbn;
}
