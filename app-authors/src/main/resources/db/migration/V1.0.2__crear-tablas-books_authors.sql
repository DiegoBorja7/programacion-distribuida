CREATE TABLE public.books_authors
(
    authors_id integer      NOT NULL,
    books_isbn varchar(255) NOT NULL,
    PRIMARY KEY (authors_id, books_isbn),
    CONSTRAINT fk_books_authors_author
        FOREIGN KEY (authors_id)
        REFERENCES public.authors (id)
);

INSERT INTO public.books_authors (authors_id, books_isbn)
VALUES
    (1, '978-0134686097'),
    (2, '978-1260440232'),
    (3, '978-0596009205'),
    (4, '978-0321349606'),
    (5, '978-0136083238'),
    (5, '978-0134686097'),
    (1, '978-1260440232'),
    (2, '978-0596009205'),
    (3, '978-0321349606'),
    (4, '978-0136083238'),
    (1, '978-0136083238'),
    (2, '978-0136083238');
