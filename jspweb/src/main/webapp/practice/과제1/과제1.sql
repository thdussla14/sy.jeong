use jspweb;

drop table if exists staff;
drop table if exists field;

create table field(
   fnum      int auto_increment primary key,
   fname      varchar(5) not null
);

create table staff(
   sno         int auto_increment primary key,
   sname       varchar(10)  not null,
   sclass      varchar(5)  not null,
   stype      varchar(5)  not null,
   fnum      int  not null,
   edate       date  not null,
   simg      varchar(20)  not null,
   ddate      date default null,
   dcontent   varchar(100) default null,
    foreign key (fnum) references field (fnum) on delete cascade
);

insert into field (fname) values ('인사팀');
insert into field (fname) values ('영업팀');
insert into field (fname) values ('개발팀');
insert into staff ( sname,	sclass,	stype,	fnum,	edate,	simg )  values ('홍길동','대표','정규직',1,'2017-08-25','알리.png');
insert into staff ( sname,	sclass,	stype,	fnum,	edate,	simg )  values ('유재석','과장','정규직',1,'2017-11-15','곰돌이.png');
insert into staff ( sname,	sclass,	stype,	fnum,	edate,	simg )  values ('강호동','과장','정규직',2,'2019-07-17','고양이.png');
insert into staff ( sname,	sclass,	stype,	fnum,	edate,	simg )  values ('이수근','과장','정규직',3,'2020-03-15','오리.png');
insert into staff ( sname,	sclass,	stype,	fnum,	edate,	simg )  values ('신동엽','부장','정규직',1,'2019-03-02','고양이.png');
insert into staff ( sname,	sclass,	stype,	fnum,	edate,	simg )  values ('서장훈','부장','정규직',2,'2020-03-15','곰돌이.png');
insert into staff ( sname,	sclass,	stype,	fnum,	edate,	simg )  values ('김희철','부장','정규직',3,'2021-07-20','알리.png');
insert into staff ( sname,	sclass,	stype,	fnum,	edate,	simg )  values ('민경훈','대리','정규직',1,'2022-03-15','스티치.png');
insert into staff ( sname,	sclass,	stype,	fnum,	edate,	simg )  values ('은지원','대리','정규직',2,'2022-05-24','오리.png');
insert into staff ( sname,	sclass,	stype,	fnum,	edate,	simg )  values ('이효리','대리','정규직',3,'2021-06-06','곰돌이.png');
insert into staff ( sname,	sclass,	stype,	fnum,	edate,	simg, ddate, dcontent )  values ('정은지','대리','정규직',3,'2021-07-14','고양이.png','2022-05-25','개인사정');
insert into staff ( sname,	sclass,	stype,	fnum,	edate,	simg, ddate, dcontent )  values ('아이유','대리','정규직',1,'2020-12-04','오리.png' ,'2022-02-10','학업연장');
insert into staff ( sname,	sclass,	stype,	fnum,	edate,	simg, ddate, dcontent )  values ('백지영','대리','정규직',2,'2022-09-17','곰돌이.png','2023-01-25','거주지이전');

select s.sno ,s.sname, s.sclass , s.stype, f.fname ,  s.edate, s.simg, s.ddate, s.dcontent from staff s, field f where s.fnum = f.fnum;
select s.sno ,s.sname, s.sclass , s.stype, f.fname ,  s.edate, s.simg, s.ddate, s.dcontent from staff s, field f where s.fnum = f.fnum and s.sname like '%재%' order by sno asc;
select b.*, m.mid,c.cname, m.mimg from board b, member m, category c where b.mno = m.mno and b.cno = c.cno and bno = 7;


select * from field;
select * from staff;