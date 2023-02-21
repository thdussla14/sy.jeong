-- 1. DB 생성
create database day15;
-- 2. DB 선택
use day15;
-- 3. 테이블 생성
create table member(
	mno int auto_increment primary key,	-- 회원번호 [ 자동생성, 식별자 ]
    mid varchar(20),                    -- 회원 id [20자 이내]
    mpw varchar(20)                     -- 회원 pw [20자 이내]
);