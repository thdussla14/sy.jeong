-- 1. DB 생성
drop database if exists BoardDB;
create database BoardDB;
use BoardDB;

-- 2. 테이블생성
drop table if exists member;
create table member(
	mno 	int auto_increment primary key,
    mid 	varchar(10) not null unique,
    mpw 	varchar(10) not null,
    mname	varchar(30) not null,
    mphone  varchar(13) not null
);
drop table if exists category;
create table category(
	cno		int auto_increment primary key,
    cname	varchar(10) not null unique
);
drop table if exists board;
create table board(
	bno			int auto_increment primary key,
    btitle		varchar(1000) not null,
    bcontent    longtext not null,			-- 긴글 텍스트
    bdate       datetime default now(),		-- insert 시 자동 날짜/시간 대입
    bview		int default 0,				-- 조회수 기본값 0
    mno_fk      int ,
    cno_fk      int ,
    foreign key (mno_fk) references member  (mno) on delete set null, 	-- PK 삭제시 FK null --> 회원탈퇴시 작성자 공백으로 게시글 보존
    foreign key (cno_fk) references category(cno) on delete cascade		-- PK 삭제시 FK 삭제  --> 카테고리 삭제시 해당 카테고리 게시물 삭제
);
drop table if exists reply;
create table reply(
	rno 		int auto_increment primary key,
    rcontent	text not null,
	rdate		datetime default now(),	
    rindex		int ,						-- 상위 댓글 [ 0: 최상위 , 1~: 해당댓글하위댓글 ]
    mno_fk		int ,
    bno_fk 		int ,
    foreign key (mno_fk) references member  (mno) on delete set null,
    foreign key (bno_fk) references board   (bno) on delete cascade	
);