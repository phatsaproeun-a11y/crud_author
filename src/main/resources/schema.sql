CREATE TABLE authors(
    author_id serial PRIMARY KEY,
    author_name VARCHAR(20),
    gender VARCHAR(10)
);

CREATE TABLE books(
    book_id serial PRIMARY KEY,
    tittle VARCHAR(20),
    published_date TIMESTAMP,
    author_id INT not NULL

);

create table categories(
                           category_id serial PRIMARY KEY,
                           category_name VARCHAR(100) not null
);


CREATE TABLE bookcategories(
    book_id INT not NULL,
    category_id INT not NULL,
    PRIMARY KEY (book_id, category_id),
    constraint fk_book foreign key(book_id) references books(book_id) on update cascade on delete cascade,
    constraint fk_category foreign key(category_id) references categories(category_id) on update cascade on delete cascade
);


insert into authors(author_name, gender) values ('Phatsa', 'Female');
INSERT INTO authors(author_name, gender) VALUES('John Doe', 'Male');
INSERT INTO authors(author_name, gender) VALUES('Jane Doe', 'Female');

INSERT INTO books(tittle, published_date, author_id) VALUES('The Hobbit', '2012-01-01', 1);

insert into categories(category_name) values ('Fiction');
insert into bookcategories(book_id, category_id) values (1, 1);
