create table users (
                       id                    bigserial,
                       username              varchar(30) not null,
                       password              varchar(80) not null,
                       email                 varchar(50) unique,
                       primary key (id)
);

create table roles (
                       id                    serial,
                       name                  varchar(50) not null,
                       primary key (id)
);

CREATE TABLE users_roles (
                             user_id               bigint not null,
                             role_id               int not null,
                             primary key (user_id, role_id),
                             foreign key (user_id) references users (id),
                             foreign key (role_id) references roles (id)
);

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN'), ('SOMETHING');

insert into users (username, password, email)
values
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com');

insert into users_roles (user_id, role_id) values (1, 1), (1, 2);

create table products (
                          id                      bigserial primary key,
                          title                   varchar(255),
                          price                   int
);

create table orders (
                        id                      bigserial primary key,
                        user_id                 bigint references users(id),
                        price                   int,
                        address                 varchar(1000)
);

create table order_items (
                             id                      bigserial primary key,
                             product_id              bigint references products(id),
                             order_id                bigint references orders(id),
                             price                   int,
                             price_per_product       int,
                             quantity                int
);

create table categories (
                            id bigserial primary key,
                            name varchar(100)
);

create table products_categories(
    product_id integer REFERENCES products(id),
    categories_id integer REFERENCES categories (id)
);


insert into categories(name) values
('Кексики'),
('Тортики'),
('Печеньки');


insert into products (title, price)
values
('Кекс1', 1),
('Кекс2', 2),
('Кекс3', 3),
('Кекс4', 32),
('Кекс5', 42),
('Тортик6', 52),
('Тортик7', 32),
('Тортик8', 42),
('Тортик9', 552),
('Тортик10', 32),
('Печенька11', 122),
('Печенька12', 312),
('Печенька13', 22),
('Печенька14', 432),
('Печенька15', 532),
('Bread16', 542),
('Bread17', 232),
('Bread18', 22),
('Bread19', 22),
('Bread20', 22),
('Bread21', 22),
('Bread22', 22),
('Bread23', 22),
('Bread24', 22),
('Bread25', 22);

insert into products_categories (product_id, categories_id) values
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 2),
(7, 2),
(8, 2),
(9, 2),
(10, 3),
(11, 3),
(12, 3),
(13, 3),
(14, 3),
(15, 3);