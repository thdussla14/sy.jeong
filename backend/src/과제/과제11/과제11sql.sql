-- DB 생성
create database 과제11;
-- DB 선택
use 과제11;
-- table 생성
create table Icecream (
	pno int auto_increment primary key,
    pname varchar(20),
    price int,
    storage int
);
select * from Icecream;
-- 등록
String sql = "insert into Icecream (pname,price,storage) values (?,?,?)";
-- 출력
String sql = "select * from Icecream";
-- 수정
String sql = "update Icecream set pname = ? , price = ? where pno = ? ";
-- 재고 수정
String sql = "update Icecream set storage = ? where pno = ? ";
-- 삭제
String sql = "delete from Icecream where pno = ? ";
-- 판매
String sql1 = "select storage from Icecream where pno = ?";
String sql2 = "update Icecream set storage = ? where pno = ?";