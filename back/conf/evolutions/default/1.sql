# --- !Ups

create table "category" (
  "id" integer not null primary key autoincrement,
  "name" varchar not null
);

create table "product" (
  "id" integer not null primary key autoincrement,
  "name" varchar not null,
  "description" text not null,
  "keyword" varchar not null,
  category int not null,
  "imageUrl" text not null,
  "price" integer not null,
  foreign key(category) references category(id)
);
CREATE TABLE "user" (
  "id" integer not null primary key autoincrement,
  "firstName" varchar not null,
  "lastName" varchar not null,
  "fullName" varchar not null,
  "email" varchar not null,
  "token" varchar not null
);
create table "koszyk" (
  "id" integer not null primary key autoincrement,
  "user" varchar not null,
  "product" integer not null,
  "productName" varchar not null,
  "quantity" integer not null,
  "price" integer not null
);
create table "opinia" (
  "id" integer not null primary key autoincrement,
  "product" integer not null,
  "opin" text not null,
  foreign key(product) references product(id)
);
create table "zamowienie" (
  "Za_id" integer not null primary key autoincrement,
  "koszyk" integer not null,
  "dataZam" varchar not null,
  "address" varchar not null,
  "wartosc" float not null,
  foreign key(koszyk) references Koszyk(id)
);

insert into "category" values(1, "food");
insert into "category" values(2, "electronics");
insert into "category" values(3, "home");
insert into "category" values(4, "fashion");
insert into "category" values(5, "sport");

insert into "product" values(1, "banana", "Yellow and yummy fruit.", "fit", 1, "https://images-na.ssl-images-amazon.com/images/I/71gI-IUNUkL._SY355_.jpg", 4.99);
insert into "product" values(2, "apple", "One apple a day keeps the doctor away!", "fit", 1, "https://bestapples.com/wp-content/uploads/2018/01/ambrosia-apple.jpg", 2.99);
insert into "product" values(3, "tomato", "Good for everything.", "fit", 1, "https://ripeme.com/wp-content/uploads/RV-10070-RIPE-ORGANIC-ORGANIC-TOMATO-BEEF.jpg", 6.99);

insert into "product" values(4, "Laptop Lenovo", "Fast computer.", "it", 2, "https://a.allegroimg.com/s512/031a0e/d891176b4707b3a33bd5fd932cea", 3550.99);
insert into "product" values(5, "Samsung TV", "Amazing quality!", "tv", 2, "https://www.mediaexpert.pl/temp/thumbs-new/2/products/016/telewizor-samsung-led-ue55mu6102_849016_3361834_1920x1920w50.jpg", 4999.99);

insert into "product" values(6, "Chair", "Comfortable chair.", "furniture", 3, "https://content.thebrick.com/ProductImages/0/569691.jpg?impolicy=product-320x320", 196.99);

insert into "product" values(7, "Dress", "Beautiful dress for every woman.", "dress", 4, "https://cdn.shopify.com/s/files/1/1619/8185/products/omgoth-my-gothic-shop-dress-layla-pentagram-dress-144710729741_400x.jpg?v=1513457815", 199.99);

insert into "product" values(8, "Bike", "Perfect for mountain trips.", "bike", 5, "http://www.kmart.com.au/wcsstore/Kmart/images/ncatalog/f/9/42476429-1-f.jpg", 599.99);

# --- !Downs

drop table if exists "product" ;
drop table if exists "category" ;
drop table if exists "user" ;
drop table if exists "koszyk" ;
drop table if exists "opinia" ;
drop table if exists "zamowienie" ;