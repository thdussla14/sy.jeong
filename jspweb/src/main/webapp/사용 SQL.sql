use jspweb;

drop table if exists friend;
drop table if exists mpoint;
drop table if exists board;
drop table if exists category;
drop table if exists member;

-- 회원테이블	( 회원탈퇴시 일반적으로 5년 자료보관 기한 동안 휴면상태 )
create table member(
	mno 	int auto_increment primary key,
    mid		varchar(10) not null unique,	-- 유효성검사 하지만 만일의 사태를 위해 제약조건 추가
    mpwd	varchar(10) not null,
    mimg  	longtext,						-- 웹서버에 저장된 사진 경로 
    memail	varchar(50) not null unique		-- 본인 인증 수단 
);

-- 친추 테이블 ( 수락 기능 추가시 상태 필드 추가 )
 create table friend(
	fno		int auto_increment primary key,
    smno	int ,					-- 친구 신청 보낸 회원
    rmno	int ,					-- 친구 신청 받은 회원
    foreign key (smno) references member (mno) on delete set null,	
    foreign key (rmno) references member (mno) on delete set null	-- 친구 탈퇴시 null
 );
 
-- 포인트 테이블  ( 유효기한 추가시 데이트 추가)
 create table mpoint(
	mpno		int auto_increment primary key,
    mpcomment	varchar(1000) not null,		-- 포인트 내역
	mpamount	int default 0,				-- 누적 포인트
    mpdate		date,						-- 포인트 받은 날짜
    mpmno		int,						-- 포인트 받은 회원
    foreign key (mpmno) references member (mno) on delete cascade
 );

-- 카테고리 테이블 [ 공지사항, 커뮤니티, Q&A , 노하우 등등 ] 
create table category(
	cno			int auto_increment primary key,
    cname		varchar(100)
);

-- 게시물 테이블 [ 번호 , 제목, 내용, 첨부파일 , 작성일 , 조회수, 좋아요수, 싫어요수, 작성자 ] 
create table board(
	bno			int auto_increment primary key,
    btitle		varchar(1000) not null,
    bcontent	longtext	  not null,
    bfile		longtext,
    bdate		datetime 	default now() ,
    bview		int 		default 0,
    blike		int  		default 0,
    bhate		int  		default 0,
    mno			int,
    cno			int,
	foreign key (mno) references member   (mno) on delete cascade,
    foreign key (cno) references category (cno) on delete cascade
);

 /*
	테이블 설계 주의점
		1. 서로 다른 테이블 간의 중복 필드 X
        2. 예외) 서로 다른 테이블 간의 관계 [ 연결 pk-fk ] : 무결성 유지
			테이블당 pk 1개 이상 권장
            
  foreign key (mno_fk)  references member  (mno_pk) on delete cascade,          
		on delete cascade	: pk 삭제시 fk 삭제
        on delete set null	: pk 삭제시 fk 공백
        생략 				: fk 존재하는 pk 삭제 불가 
	
 */

insert into member (mid, mpwd, mimg, memail) values ('admin' ,'1234'  , null     ,'admin@admin.co' );
insert into member (mid, mpwd, mimg, memail) values ('qweqwe','qwe123','알리.png' ,'qweqwe@dodo.com');
insert into member (mid, mpwd, mimg, memail) values ('asdasd','asd123','고양이.png','asdasd@dodo.com');
insert into member (mid, mpwd, mimg, memail) values ('zxczxc','zcx123','스티치.png','zxczxc@dodo.com');
insert into member (mid, mpwd, mimg, memail) values ('bnmbnm','qzv123','곰돌이.png','bnmbnm@dodo.com');
insert into member (mid, mpwd, mimg, memail) values ('dfgdfg','dfg123','스티치.png','dfgdfg@dodo.com');
insert into member (mid, mpwd, mimg, memail) values ('cvbcbv','cvb123','고양이.png','cvbcvb@dodo.com');
insert into member (mid, mpwd, mimg, memail) values ('poipoi','poi123','곰돌이.png','poipoi@dodo.com');
insert into member (mid, mpwd, mimg, memail) values ('mnbmnb','mnb123','오리.png','mnbmnb@dodo.com');

select count(*) from member;
-- 해당 아이디 비밀번호 , 이메일 수정 
update member set mpwd = 'ert123' , memail = 'asd@dodo.com' where mid = 'bnmbnm';

insert into mpoint (mpcomment,mpamount,mpdate,mpmno) values ('관리자',0,null,1);
insert into mpoint (mpcomment,mpamount,mpdate,mpmno) values ('회원가입축하',300,'2023-03-01',2);
insert into mpoint (mpcomment,mpamount,mpdate,mpmno) values ('회원가입축하',300,'2023-03-01',3);
insert into mpoint (mpcomment,mpamount,mpdate,mpmno) values ('회원가입축하',300,'2023-03-01',4);
insert into mpoint (mpcomment,mpamount,mpdate,mpmno) values ('첫글작성축하',500,'2023-03-03',2);
insert into mpoint (mpcomment,mpamount,mpdate,mpmno) values ('첫글작성축하',500,'2023-03-03',4);
-- 포인트 지급
insert into mpoint (mpcomment,mpamount,mpdate,mpmno) values ('회원가입축하',300,'2023-03-01',5);
-- 포인트 구매
insert into mpoint (mpcomment,mpamount,mpdate,mpmno) values ('포인트구매',5000,'2023-03-03',2);
-- 포인트 사용
insert into mpoint (mpcomment,mpamount,mpdate,mpmno) values ('제품구매' ,-3000,'2023-03-03',2);

-- 아이디에 해당하는 회원정보 호출
select * from member where mid = 'asdasd';

-- 보유포인트 호출
select sum(mpamount) from mpoint where mpmno = 2 ;

-- 조인 후 필요한 필드와 통계 [ !! 두개 이상 필드를 출력시 그룹 필수 ]
select m.mno, m.mid, m.mimg, m.memail,sum(p.mpamount) as mpoint
from member m,mpoint p 
where m.mno = p.mpmno and mid = 'asdasd'
group by mno;

 -- 카테고리 
insert into category (cname) values ('공지사항');
insert into category (cname) values ('커뮤니티');
insert into category (cname) values ('Q&A');
insert into category (cname) values ('노하우');
 
 -- 게시판
insert into board (btitle,bcontent,bfile,mno,cno) values ('3월 시스템 업데이트 안내','업데이트 시간은 PM 02:00 - PM 04:00 입니다.','짱구.png'  ,1,1);
insert into board (btitle,bcontent,bfile,mno,cno) values ('3월 시스템 업데이트 안내','업데이트 시간은 PM 02:00 - PM 04:00 입니다.','흰둥이.png',2,1);
insert into board (btitle,bcontent,bfile,mno,cno) values ('3월 시스템 업데이트 안내','업데이트 시간은 PM 02:00 - PM 04:00 입니다.','흰둥이.png',3,2);
insert into board (btitle,bcontent,bfile,mno,cno) values ('3월 시스템 업데이트 안내','업데이트 시간은 PM 02:00 - PM 04:00 입니다.','흰둥이.png',4,3);
insert into board (btitle,bcontent,bfile,mno,cno) values ('3월 식물   박람회 안내','업데이트 시간은 PM 02:00 - PM 04:00 입니다.','흰둥이.png',1,1);
insert into board (btitle,bcontent,bfile,mno,cno) values ('3월 식물   박람회 안내','업데이트 시간은 PM 02:00 - PM 04:00 입니다.','흰둥이.png',2,1);
insert into board (btitle,bcontent,bfile,mno,cno) values ('3월 식물   박람회 안내','업데이트 시간은 PM 02:00 - PM 04:00 입니다.','짱구.png',4,3);
insert into board (btitle,bcontent,bfile,mno,cno) values ('3월 식물   박람회 안내','업데이트 시간은 PM 02:00 - PM 04:00 입니다.','흰둥이.png',5,4);
insert into board (btitle,bcontent,bfile,mno,cno) values ('3월 시스템 업데이트 안내','업데이트 시간은 PM 02:00 - PM 04:00 입니다.','짱구.png',2,1);
insert into board (btitle,bcontent,bfile,mno,cno) values ('3월 시스템 업데이트 안내','업데이트 시간은 PM 02:00 - PM 04:00 입니다.','흰둥이.png',3,2);
insert into board (btitle,bcontent,bfile,mno,cno) values ('3월 시스템 업데이트 안내','업데이트 시간은 PM 02:00 - PM 04:00 입니다.','짱구.png',1,4);
insert into board (btitle,bcontent,bfile,mno,cno) values ('3월 시스템 업데이트 안내','업데이트 시간은 PM 02:00 - PM 04:00 입니다.','흰둥이.png',2,4);
insert into board (btitle,bcontent,bfile,mno,cno) values ('3월 시스템 업데이트 안내','업데이트 시간은 PM 02:00 - PM 04:00 입니다.','짱구.png',3,4);
insert into board (btitle,bcontent,bfile,mno,cno) values ('3월 시스템 업데이트 안내','업데이트 시간은 PM 02:00 - PM 04:00 입니다.','흰둥이.png',4,4);

select b.bno,b.btitle,b.bcontent,b.bfile,b.bdate,b.bview,b.blike,b.bhate,m.mid,b.cno   from board b, member m  where b.mno = m.mno ;
select b.*,m.mid,c.cname from board b, member m, category c where b.mno = m.mno and b.cno = c.cno;

select b.*, m.mid,c.cname, m.mimg from board b, member m, category c where b.mno = m.mno and b.cno = c.cno and b.btitle like '%a%' ;

update board set bview = (1+1) where bno = 2;
-- 특정 개수만 출력
select b.*, m.mid,c.cname from board b, member m, category c where b.mno = m.mno and b.cno = c.cno order by bno asc limit 0,3;
-- 레코드 수 구하기
select count(*) from board b, member m, category c where b.mno = m.mno and b.cno = c.cno and b.bno like '%%' order by bno asc ;
  
-- 댓글 [ 댓글번호 , 내용, 작성일, 인덱스(계층), 작성자, 게시물 번호 ]
create table reply(
	rno			int auto_increment primary key,
	rcontent	longtext,
    rdate		datetime default now(),
    rindex		int default 0 , -- 0 이명 1계층, 계층구조 단계별로 ++
    mno			int,
    bno			int,
    foreign key (mno) references member(mno) on delete set null,
    foreign key (bno) references board(bno) on delete cascade
);
insert reply (rcontent, rindex, mno,bno) values('안내감사합니다.', 0 , 3, 1);

/*
	3번 게시물 
		1번 댓글 			[ rindex = 0 ] 
			3번 댓글		[ rindex = 1 ] 
            4번 댓글		[ rindex = 1 ] 
				6번 댓글 	[ rindex = 4 ] 
		2번 댓글			[ rindex = 0 ] 
        5번 댓글			[ rindex = 0 ] 
*/


/* 외부 csv 파일의 데이터 */
-- 새로 자동 테이블 생성해도 괜찮으나 데이터 특수문자 표현 존재시 테이블 생성 후 데이터 삽입
create table 아파트실거래가(
	식별번호 	int auto_increment primary key,
    시군구	text,
    단지명	text,
    전용면적	text,
    계약년월	text,
    계약일	text,
    계약금액	text
);

select * from 아파트실거래가;
select * from member;
select * from friend;
select * from mpoint;
select * from category;
select * from board;
select * from reply;