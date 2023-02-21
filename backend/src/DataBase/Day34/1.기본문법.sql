# 한줄 주석
-- 한줄 주석
/*	여러줄 주석   */

/*
	데이터베이스 : 데이터 [자료] , 베이스 [모임]
		 - 자료들의 모임
	 - 종류 
		1. 계층형 데이터베이스		: 트리 형태
        2. 네트워크형 데이터베이스	: 양방향 형태
        3. **관계형 데이터베이스**	: 행/열 로 구성된 테이블[표] 간의 관계
        4. NOSQL 데이터베이스		: key - value
	
    - DBMS : 데이터베이스 관리 시스템
		MYSQL, oracle, access, MSSQL
	- DBA : 데이터베이스 관리자  = DB 개발자
    
		DB [ DBserver ] <---------- DBMS   		<---------- DBA
		- DB가 설치된 PC				- DB관리 시스템			- SQL[질의어]
        - 데이터 저장 					- DB 서버에 접속
        - 메모리 [기계어/16진수]			- 표준 SQL 사용
  
		DBA 	------------------>	DBMS   		<---------- DB [ DBserver ]
									메모리1 메모리2				메모리1
									메모리3 메모리4				메모리2
															메모리3
															메모리4
        
	- SQL 질의어 [ 대소문자 구분 x ]
    
		1. DDL : 데이터베이스 정의어
			1. CREATE TABLE/DATABASE 이름 	: 생성
				CREATE DATABASE 데이터베이스명;
				USE 데이터베이스명;
				CREATE TABLE 테이블명 ( 필드명 타입 제약조건, 필드명 타입 제약조건 )
            2. DROP TABLE/DATABASE 이름 		: 삭제
            3. ALTER						: 수정
			4. TURNCATE						: 테이블 데이터 영구 삭제
        2. DML : 데이터베이스 조작어
			1. SELECT						: 데이터 검색
            2. INSERT						: 데이터 추가
            3. UPDATE						: 데이터 수정
            4. DELETE						: 데이터 삭제
        3. DCL : 데이터베이스 제어어
			1. GRANT						: 사용자 계정 권한부여
            2. REVOKE 						: 사용자 계정 권한취소
        4. TCL : 트래잭션 제어어
			1. COMMIT 						: 트랜잭션 완료
            2. ROLLBACK 					: 트랜잭션 취소
            
	- 테이블 [표 = 행[레코드] / 열[필드/속성]]
		* 여러개의 자료들을 효율적으로 관리하기 위해서 관계형 데이터베이스[표]
        
		- 필드1[열1 = colume]	필드2[열2]
			아이디 			비밀번호
            qwe				qwe					- 레코드1 [행1 = row]
            asd				asd					- 레코드2 [행2]
            zxc				zxc					- 레코드3 [행3]
            
	- 필드 타입
		1. 정수형 : int 					: 정수
        2. 문자형 : varchar(길이)			: 
        3. 실수형 : float , double		: 
        4. 날짜형 : data, time, datatime	:
        5. 대용량 : text
*/

# 예1 : 데이터베이스 [ 저장소 - 여러개 테이블 저장할 수 있는 공간 ]
create database test;
# create 생성한다.
	# database 데이터베이스를 
		# test	데이터베이스 이름 [아무거나] * 카멜표기법,언더바 권장
			# ; 명령어 마침
				# ctrl + enter : 커서가 위치한 ; 단위 명령 실행
create database test2;
create database java;

# 에2 : 데이터베이스 확인
show databases;

# 예3 : 데이터베이스 사용 [선택] 하기 [* 데이터베이스가 여러개이므로 선택 ]
use test;
use test2;
use java;

# 예4 : 데이터베이스 삭제
drop database test;
drop database test2;
drop database java;

#예5 : 테이블 생성 [ * 데이터베이스 선택 ]
create database java;		-- 1. 데이터베이스 생성
use java;					-- 2. 데이터베이스 선택
create table member(		-- 3. 선택된 데이터베이스에 표 만들기
	-- 필드명 타입 키워드 
    아이디 	text ,
    비밀번호	text
);
# create table 테이블명 ( 필드명 타입 제약조건, 필드명2 타입 제약조건 );
# create 생성한다.
	# table 표 
		# member 테이블 이름 [아무거나] * 카멜표기법,언더바 권장
create table member2( 아이디 	text , 비밀번호	text );
create table member3( 아이디 	text , 비밀번호	text );
			
# 예6 : 해당 테이블 검색
select  *  from member;
# select
	# * : 와일드카드 [ 모든 필드 ]
		# from 테이블명 ;
# select 필드명  from 테이블명 ; 
select  *  from member2;
select  *  from member3;

# 예7 : 해당 테이블 삭제
drop table member;
drop table member2;
drop table member3;
drop database java;

/*
	문제1 : 웹개발하는데 
		1. DB 저장소[스키마] 'JSP' 이름으로 생성
		2. 테이블 2개 [ 'member', 'board' ] 생성
		3. member 	필드 : id(문자열), 	password(문자열)
        4. board 	필드 : title(문자열), 	content(문자열)
*/
create database JSP;
use JSP;
create table member ( id varchar(100), password varchar(100));
create table board  ( title varchar(100), content varchar(100));
select * from member;
select * from board;
drop database JSP;
/*
	문제2 : 웹개발하는데 
		1. DB 저장소[스키마] 'SPRING' 이름으로 생성
		2. 테이블 2개 [ 'member', 'product' ] 생성
		3. member 	필드 : 회원번호 [정수] , 	id   [문자(20)] 	, pw [문자(20)]
        4. product 	필드 : 제품번호 [정수] , 	name [문자(30)]	, price [정수]
        5. 생성한 테이블 2개 검색
        6. 데이터베이스 삭제
*/
create database spring;
use spring;
create table member  ( mno int , id   varchar(20) , password varchar(20));
create table product ( pno int , name varchar(30) , price int );
select * from member;
select * from product;
drop database spring;

# DML

create database java;
use java;
create table 게시판 ( 제목 varchar(20), 내용 varchar(20));

# 예1 ) INSERT # insert into 테이블명 values ( 데이터1, 데이터2 );
	# 필드명이 명시되어있지 않기 때문에 선언된 필드 순서대로 데이터가 삽입
insert into 게시판 values ('제목구역', '내용구역');
select *  from 게시판;

# 예2 ) INSERT # insert into 테이블명 (필드명1, 필드명2) values ( 데이터1, 데이터2 );
	# 필드명이 명시되어 있기 때문에 명시된 필드순으로 데이터를 삽입
insert into 게시판 (제목 , 내용) values ('제목구역', '내용구역');
select * from 게시판;

# 예3 ) INSERT [ JDBC 사용 예정 ]
	# insert into 테이블명 (필드명1, 필드명2) values ( 매개변수, 매개변수 );
	# ? : 변수가 들어가는 자리를 뜻 함
insert into 게시판 (제목, 내용) values ( ? , ? );
drop database java;
/*
	문제3 : 웹개발하는데 
		1. DB 저장소[스키마] 'JSP' 이름으로 생성
		2. 테이블 1개 [ 'member'] 생성
		3. member 	필드 : 회원번호 [정수] , 	id   [문자(20)] 	, pw [문자(20)]
        4. 회원가입 2명 하기
			insert
            1	, 	이젠		,	1234
            2	, 	삼성		, 	4567
        5. 테이블 확인
        6. 데이터베이스 삭제
*/
create database JSP;
use JSP;
create table member ( mno int, mid varchar(20) , mpw varchar(20));
insert into member (mno , mid, mpw) values ( 1 , '이젠','1234');
insert into member values ( 2, '삼성', '4567');
insert into member (mid) values ('LG');
select * from member;		-- 레코드 생성시 해당 필드의 데이터 생략시 null 대입
drop database JSP;
/*
	문제3 : 웹개발하는데 
		1. DB 저장소[스키마] 'spring' 이름으로 생성
		2. 테이블 1개 ['product' ] 생성
		3. product 	필드 : 제품번호 [정수] , name [문자(20)]	, price [정수]]
        4. 상품등록 3개 하기
			insert
            1	, 	냉장고	,	200000
            2	, 	선풍기	, 	300000
            null, 	컴퓨터	, 	null
        5. 테이블 확인
        6. 데이터베이스 삭제
*/
create database spring;
use spring;
create table product( pno int, name varchar(20) , price int);
insert into product (pno,name,price) values (1,'냉장고',200000);
insert into product (pno,name,price) values (2,'선풍기',300000);
insert into product (name) values ('컴퓨터');
select * from product;
drop database spring;
