create table book
(
    id_ bigint identity
        constraint book_pk
        primary key nonclustered,
    name_ varchar(255),
    image_ varchar(max),
    price_ numeric(14,2)
)


create table cart_detail
(
    id_ bigint identity
        constraint shopping_cart_pk
        primary key nonclustered,
    book_id_ bigint,
    user_id_ bigint,
    count_ int,
    price_ numeric(14,2)
)


create table sys_user
(
    id_ bigint identity
        constraint user_pk
        primary key nonclustered,
    name_ varchar(255),
    login_name_ varchar(255),
    password_ varchar(255)
)


INSERT INTO BOOK(name_, price_) values ('高等数学',25.5);

INSERT INTO BOOK(name_, price_) values ('大学英语',30.5);

INSERT INTO BOOK(name_, price_) values ('马克思主义哲学',15.5);