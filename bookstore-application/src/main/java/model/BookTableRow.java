package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookTableRow {
    private String title;
    private String author;
    private String publisher;
}
