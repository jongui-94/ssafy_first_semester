DROP DATABASE IF EXISTS PM;

CREATE DATABASE PM;

USE PM;

DROP TABLE IF EXISTS product;

CREATE TABLE product (
	code varchar(10) not null primary key,
    name varchar(20) not null,
    price int not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into product values("1111", "삼성티비", 300);
insert into product values("2222", "엘지티비", 100);
insert into product values("3333", "어쩔티비", 5000);
insert into product values("4444", "삼성냉장고", 1200);
insert into product values("5555", "엘지냉장고", 800);
insert into product values("6666", "어쩔냉장고", 8400);
insert into product values("7777", "삼성노트북", 250);
insert into product values("8888", "엘지노트북", 80);

select *, price*0.85 as "할인된 가격"
from product;

update product
set price = price *0.8
where name like '%티비';

select *
from product;

select sum(price) as "총금액"
from product;
