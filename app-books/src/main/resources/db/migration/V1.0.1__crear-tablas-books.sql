CREATE TABLE public.books
(
    isbn  varchar(255) NOT NULL PRIMARY KEY,
    title varchar(255),
    price numeric(8, 2) NOT NULL
);

INSERT INTO public.books (isbn, title, price)
VALUES
    ('978-0596009205', 'Head First Java', 40.00),
    ('978-0321349606', 'Java Concurrency in Practice', 55.00),
    ('978-0136083238', 'Clean Code: A Handbook of Agile Software Craftsmanship', 50.00),
    ('978-0134686097', 'Effective Java', 45.00),
    ('978-1260440232', 'Java: The Complete Reference', 50.00);