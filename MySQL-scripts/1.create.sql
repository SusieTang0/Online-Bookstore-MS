CREATE DATABASE bookstore;

USE bookstore;

drop table book;
CREATE TABLE book (
  isbn varchar(15) NOT NULL,
  title varchar(255) NOT NULL,
  author varchar(255) NOT NULL,
  price double NOT NULL,
  stock int NOT NULL,
  PRIMARY KEY (isbn)
);

drop table purchase;
CREATE TABLE purchase (
  purchaseId int auto_increment,
  isbn varchar(15) NOT NULL,
  quantity int NOT NULL,
  customerName varchar(50) NOT NULL,
  customerEmail varchar(50) NOT NULL,
  PRIMARY KEY (purchaseId)
);

INSERT INTO book (isbn, title, author,price,stock)
VALUES
("978-1662513453", "The Promise of Tomorrow","Mary Ellen Taylor",13.10,5),
("978-0765386694", "The Dark Forest","CIxin Liu",19.99,3),
("978-0545162074", "Harry Potter Paperback Box Set (Books 1-7)","J. K. Rowling",45.44,2)
;

select *  from book;
select *  from purchase;