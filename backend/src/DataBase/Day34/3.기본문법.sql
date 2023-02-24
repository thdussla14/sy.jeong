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

-- 6. select * from  테이블명 limit 레코드수		
	-- select * from 테이블명 limit 시작레코드 , 개수 
select * from member limit 3;	-- 페이징 처리에 사용
select * from member limit 0,3;	-- 에이핑크, 블랙핑크, 소녀시대  ~~~
select * from member limit 5,3;
select * from member order by mheight desc limit 3;	 -- 키 상위 3개 레코드

-- 7. select distinct 필드명 from 테이블명 		: 필드내 데이터 중복 제거 
select maddr from member;
select distinct maddr from member;

-- 8. select * from 테이블명 group by 그룹기준필드
select bamount from buy;		-- 판매수량 필드 검색
select sum(bamount) from buy;	-- 판매수량 필드 합계
select avg(bamount) from buy;	-- 판매수량 필드 평균
select max(bamount) from buy;	-- 판매수량 필드내 최대값
select min(bamount) from buy;	-- 판매수량 필드내 최대값
select count(bamount) from buy;	-- 판매수량 필드의 레코드 수 [ null 미포함 ] 
select count(*) from buy;		-- 전체 레코드 수 		   [ null 포함 ]

-- 1. 회원아이디[그룹]별로  판매수량 합계
select mid 회원아이디,sum(bamount) as 구매수량총합 from buy group by mid;
-- 2. 회원아이디 별 금액 총매출액 [ 가격 * 수량 ]
select mid 회원아이디, sum(bprice*bamount) 총매출액 from buy group by mid; 
-- 3. 회원아이디 별 수량 평균
select mid 회원아이디, avg(bamount) 판매수량평균 from buy group by mid;
-- 4. 회원아이디 별 결제수량 
select mid 회원아이디, count(*) 결제수량 from buy group by mid;

-- 9. select * from 테이블명 group by 그룹기준필드 having 그룹내조건
-- * 회원아이디 별 금액 총매출액 [ 가격 * 수량 ] 합계가 1000 이상 검색 
-- 집계함수는 그룹 후 조건으로 사용 가능 
select mid 회원아이디, sum(bprice*bamount) 총매출액 from buy group by mid having sum(bprice*bamount)>=1000;

select sum(bprice*bamount) 총매출액 from buy ;                   -- 전체 총 매출액 
-- select mid 회원아이디, sum(bprice*bamount) 회원별총매출액 from buy ;  -- 오류 발생 !! 
-- select mid 회원아이디, sum(bprice*bamount) 총매출액 from buy  where sum(bprice*bamount)>=1000 group by mid ; -- 오류 발생 !!

-- 10. [전체]
	-- select * from 테이블명 where 조건 group by 그룹 having 그룹내조건 order by 정렬 limit 레코드수 제한 

-- insert 
	-- 1. 특정필드에 값 삽입시 : insert into 테이블명 (필드명1, 필드명2) values (값1, 값2);
    -- 2. 전체필드에 값 삽입시 : insert into 테이블명 values (값1,값2);
    -- 3. 다중 레코드 삽입 : insert into 테이블명 vlaues (값1,값2) , (값1,값2);
    -- 4. 검색된 결과 삽입 : insert into 테이블명 select [ 조건 : 동일한 테이블내만 가능 ] 
			-- 검색된 필드와 삽입할 테이블내 필드명과 동일한 경우만 가능
	-- 5. 마지막으로 추가된 레코드의 PK 확인 : select last_insert_id();
    
create table maddr(mid char(8),maddr char(2) );		     -- 회원아이디, 주소 필드를 갖는 테이블 
select * from member limit 5;	                         -- 레코드 5개 검색
insert into maddr select mid,maddr from member limit 5;  -- 검색된 회원아이디, 주소 주소테이블에 삽입 [ 필드명 일치 필수!! ] 
select * from maddr;
select last_insert_id();

select * from member;
select * from buy;
select * from maddr;

-- update
	-- update 테이블명 set 필드명 = 수정할값 where 조건식
    -- 1. 해당 테이블에서 주소가 서울이면 'SEOUL'로 변경
    select * from member;
    -- 워크벤치에서 update, delete 기본적으로 사용 불가능 
		-- 메뉴 --> edit -> preference -> 사이드메뉴 SQL editor 선택 -> 가장 아래 safe updates 체크 해제
	update member set maddr = 'se' where maddr = '서울';
    select * from member;

-- delete
	-- delete from 테이블명 where 조건식
    -- * 만일 관계 테이블일 경우 다른 테이블에서 fk필드로 사용된 레코드는 삭제 불가능 [ ** 제약조건 명시 필요 ] 
    -- 만약 핑크가 포함된 이름 삭제
    delete from member where mname like '%핑크%'; -- 오류 [ 관계가 있는 테이블에서 pk 필드가 포함되어있는 레코드는 삭제 불가능 ] 
    delete from member where mname = '잇지';		 -- 성공 [ 관계가 있는 테이블에서 fk 필드가 없을 경우 레코드 삭제 가능 ] 

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
            
	집계함수 [ 2개 이상의 필드 검색시 그룹 필수 ] 
		1. sum ( 필드명 ) : 해당 필드내 데이터 종합
        2. avg ( 필드명 ) : 해당 필드내 데이터 평균
        3. max ( 필드명 ) : 해당 필드내 데이터 최대값
        4. min ( 필드명 ) : 해당 필드내 데이터 최소값
        5. count (필드명) : 해당 필드내 데이터 개수 [ null 제외 ] 
			count (*)	: 레코드 수 [ null 포함 ]
		
*/
drop table if exists testtype;
create table testtype(
	tinyint_col  	tinyint, 		-- 1바이트 +- 128
    smallint_col 	smallint, 		-- 2바이트 +- 3만
	int_col 		int, 			-- 4바이트 +- 21억
    int_col2		int unsigned,	-- 4바이트 + 40억정도 저장 [ unsigned : 음수 사용 x : 음수 용량 -> 양수 용량 증가 ]
    bigint_col		bigint,			-- 4바이트 21억 이상	
	char_col		char(10),		-- char(길이)	: 고정길이 [ 1 ~ 255 ]
    varchar_col 	varchar(10),	-- varchar(길이)	: 가변길이 [ 1 ~ 16383 ] 	* MySQL 5.0 이상인 경우만
	text_col		text,			-- 1 ~ 65535 글자 저장
    longtext_col 	longtext,		-- 1 ~ 42억  글자 저장						-- 게시판 내용은 longtext 주로 사용
	float_col 		float,			-- 소수점 7자리 저장
    double_col		double,			-- 소수점 15자리 저장
    date_col		date,			-- 날짜 저장 [ yyyy - MM - dd ]
    time_col 		time,			-- 시간 저장 [ hh : mm : ss ]
    datetime_col 	datetime		-- 날짜/시간 저장 [ yyyy - MM - dd  hh : mm : ss ]
);
select * from testtype;