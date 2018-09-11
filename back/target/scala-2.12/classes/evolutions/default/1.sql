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

insert into "category" values(1, "friuts");
insert into "product" values(1, "banana", "yellow fruit", "fit", 1, "url", 4.99);

# --- !Downs

drop table if exists "product" ;
drop table if exists "category" ;
drop table if exists "user" ;
drop table if exists "koszyk" ;
drop table if exists "opinia" ;
drop table if exists "zamowienie" ;