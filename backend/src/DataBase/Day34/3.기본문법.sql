/*
	SQL
		DDL
			create
				create database DB명;
				create table 테이블명 ( 필드명1 타입 제약조건 );
			drop 
				drop database DB명;
				drop database if exists DB명;
				drop table 테이블명;
				drop table if exists 테이블명;
		DML
		DCL
		TCL
 - 타입 [ DBMS 회사마다 다름 ] 
	1. 정수형 
		tinyint
        smallint
        int
        bigint
	2. 문자형
		char(길이)    : 고정길이
        varchar(길이) : 가변길이
	3. 대용량 [ 긴글 , 첨부파일 ]
		text
        longtext
	4. 실수형
		float
        double
    5. 날짜형
		date
        time
        datetime

- 제약조건
    0. primary key (식별키)  [ 필드내 중복불가능, 공백 불가능 ]
	0. foreign key (외래키)  [ 기본키와 연결된 필드 ]
		-- 해당 pk를 다른 테이블에서 사용하게 되면 fk
    1. not null 
	2. auto_increment : 레코드 추가시 자동번호 부여 [ 무조건 PK 필드만 가능 ] 

*/
drop database market;
drop database if exists market;
-- DB 생성
create database market;
-- DB 선택
use market;
-- 기존 동명 테이블 확인 삭제
drop table if exists member;
-- table 삭제
create table member(
	-- 필드 선언
		-- 필드명은 테이블 앞글자_필드명
	mid   char(8) not null primary key,
		-- char(길이) : 길이만큼 문자 저장 [ 최대 길이 글자 ]
        -- not null  : 공백 저장 불가능  [ 만일 공백이면 저장 실패 ] 
		-- primary key : (기본키)식별키 [ 필드내 중복불가능, 공백 불가능 ]
			-- 주민등록번호, 학번, 회원번호, 사번, 제품번호 
	mname varchar(10) not null,
		-- varchar(길이) : 데이터의 길이가 일정하지 않을때 
			-- 가변길이 : 저장된 데이터 만큼 메모리 할당
				-- varchar(8) 에서 'ABC' 저장시 5칸 메모리 자동 제거
            -- 고정길이 : 선언된 길이 만큼 메모리 할당
				-- char(8) 에서 'ABC' 저장시 8칸 메모리 고정
	mnumber int not null,
			-- int : 정수 +- 20억 정도 저장 가능
    maddr   char(2) not null,	-- 주소 최대 2글자 저장 [ 공백 불가능 ] 
    mphone1 char(3),				-- 국번 최대 3글자 저장 	[ 공백 가능 ]
    mphone2 char(8),				-- 전화번호 최대 8글자 저장 [ 공백 가능 ]
    mheight smallint, 
		-- smallint : +- 3만 정도 저장 가능
	mdebut date
		-- date 날짜
);
select * from member;
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
select * from member;
-- ------------------------------------------------------------
drop table if exists buy;
create table buy(
	-- 1. 구매번호
    bnum int auto_increment primary key,
		-- auto_increment : 레코드 추가시 자동번호 부여 [ 무조건 PK 필드만 가능 ] 
	-- 2. 구매한 회원
	mid char(8),
    -- 3. 구매한 제품 이름
    bpname char(6) not null,
    -- 4. 분류명
    bgname char(4), 
	-- 5. 가격
    bprice int not null, 
    -- 6. 수량
    bamount smallint not null,
    -- 관계
    foreign key(mid) references member(mid)
		-- 외래키 설정필드 (현재테이블의 필드명 ) 참조 PK 테이블명(PK 필드명)
		-- foreign key
        -- references
);
select * from buy;
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);
select * from buy;
-- ER 다이어그램  [ 테이블간 관계 확인 ] 
	-- 메뉴 -> database -> REverse Engineer -> DB 선택 --> finish
-- select: 검색
-- 1. select 필드명1, 필드명2 from 테이블명
select mid from member;
select mid,mname from member;

-- 2. select * from 데이블명;
	-- * 와일드카드 : 모든것 = 모든 필드
select * from member;

-- 3. select 필드명 as '별칭명' from 테이블명;
select mid as '회원아이디' from member;
select mid '회원아이디' from member; -- as 생략 가능

-- 4. select 필드명 from 테이블명 where 조건;
select * from member where mname = '블랙핑크'; 	-- 회원명[필드]이 '블랙핑크'인 레코드 검색
select * from member where mnumber = 4;		  	-- 멤버가 4명인 레코드 검색
select * from member where mheight <= 162;		-- 멤버키가 162 이상인 레코드 검색
select * from member where mheight >= 165 and mnumber > 6;
select * from member where mheight >= 165 or  mnumber > 6;

select * from member where mheight >= 163 and mheight <= 165;	-- 키 필드 163 ~ 165
select * from member where mheight between 163 and 165;			-- 키 필드 163 ~ 165

select * from member where maddr = '경기' or maddr = '전남' or maddr = '경남';
select * from member where maddr in ( '경기','전남','경남');

select * from member where mname = '우주소녀';	--  = 같다 [ 모두 동일할때 ] 
select * from member where mname like '우%';		-- '우'로 시작하는 문자 찾기
select * from member where mname like '%우';		-- '우'로 끝나는 문자 찾기
select * from member where mname like '%우%';	-- '우'가 포함된 문자 찾기
select * from member where mname like '우_';		-- '우'로 시작하는 두글자 찾기
select * from member where mname like '우___';	-- '우'로 시작하는 네글자 찾기
select * from member where mname like '_우';		-- '우'로 끝나는 두글자 찾기
select * from member where mname like '_우_';	-- 가운데 글자가 '우'인 세글자 찾기

select mnumber, mnumber+1, mnumber-1, mnumber*2, mnumber/2 , mnumber div 2,mnumber mod 2  from member;
select mnumber * mheight 멤버키점수 from member;	-- 필드끼리 연산 가능

-- 5. select * from 테이블명 order by 정렬기준필드
-- 조건정렬 : 조건 먼저 거르고 데이터 정렬 // 정렬 후 조건 불가능 !! 순서 주의 !!
-- select * from 테이블명 where 조건 order by 정렬기준필드
-- 다중정렬 : 앞 정렬 후 동일한 데이터가 있을 경우 하위 정렬
-- select * from 테이블명 order by 정렬기준필드1, 정렬기준필드2
select * from member order by mdebut asc;		-- 과거순 오름차순 [ asc 생략 가능 ] 
select * from member order by mdebut desc;		-- 최신순 내림차순 [ 과거날짜 작다 / 최근날짜 크다 ]
select * from member order by mheight desc;

-- select * from member order by mheight desc where mheight >= 164; -- 오류 !! 
select * from member where mheight >= 164 order by mheight desc;	-- 오류 해결 
-- 키를 내림차순으로 정렬 후 동일한 키가 있을 경우 동일한 키 중에서 데뷔날짜 오름차순
select * from member order by mheight desc, mdebut asc;		


/*
	연산자
		1. 산술연산자 : +(더하기)     -(빼기)  	*(곱하기)  	div(몫)  	mod(나머지)
        2. 비교연산자 : >=(이상)     <=(이하)  	> (초과)    < (미만)    	= (같다)    	!= (다르다) 
		3. 논리연산자 : and(그리고)   or(또는)    not			
        4. 기타연산자
			in (값1,값2,값3) 		: 값1 ~ 값3 하나라도 존재하면 true
            between 값1 and 값2  : 값이  값1 부터 값2 사이이면 true
            like 				: 패턴 검색
				% : 모든 문자수 대응
                _ : _ 개수만큼 문자수 대응
		5. null 관련 연산자
			= null [x]
            필드명 is null		: null 이면		[ =null x]
            필드명 is not null 	: null 이 아니면 
		
*/