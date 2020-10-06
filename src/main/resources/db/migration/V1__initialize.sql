create table customers (
  id bigserial,
  name varchar(255) not null,
  primary key (id)
);

create table products (
    id bigserial primary key ,
    title varchar(255),
    price int
);

create table orders (
    id bigserial primary key,
    customer_id bigint references customers(id),
    product_id bigint references products(id),
    price int
);

insert into  customers (name) values
('Bib'),
('Vasya'),
('Petya');

insert into products (title, price)
values
('Bread', 100),
('milk', 84),
('Bulba', 91),
('mouse', 33),
('Buhanka', 11),
('mozambika', 53),
('Olegus', 2),
('Cocowatch', 66),
('Stick', 49),
('Penis', 39),
('Cellphone', 45),
('Overlord', 26);

insert into orders (customer_id, product_id, price)
values
(1, 1, 24);