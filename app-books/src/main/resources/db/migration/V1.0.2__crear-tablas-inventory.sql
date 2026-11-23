CREATE TABLE public.inventory
(
    book_isbn varchar(255) NOT NULL PRIMARY KEY,
    sold      integer      NOT NULL,
    supplied  integer      NOT NULL,
    version   integer      NOT NULL,
    CONSTRAINT fk_inventory_book
        FOREIGN KEY (book_isbn)
        REFERENCES public.books (isbn)
);

INSERT INTO public.inventory (book_isbn, sold, supplied, version)
VALUES ('978-0134686097', 10, 50, 1);