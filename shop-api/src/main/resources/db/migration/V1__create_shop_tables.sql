create schema if not exists shopping;

create table shopping.shop (
    id bigserial primary key,
    userIdentifier varchar(100) not null,
    created_at varchar(100) not null,
    total float not null
);

create table shopping.item (
    shop_id bigserial REFERENCES shopping.shop(id),
    product_identifier varchar(100) not null,
    price float not null
);