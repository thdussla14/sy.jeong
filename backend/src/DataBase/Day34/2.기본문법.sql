/*
	사람[개발자]						DBMS						컴퓨터
	언어 : 영어, 한글 (문자)											기계어 : 0, 1

	표 만들어줘 						create table 회원();
	create table 회원();				기계어로 번역-------------> 	메모리 할당

- SQL 질의어
	1. DDL
		create
			create database DB명;
            create table 테이블명(
				필드명 타입 제약조건
                필드명 타입 제약조건
            );
		drop
			drop DB명;
            drop 테이블명;
		alter
		truncate
    2. DML
		insert
			모든 필드에 데이터 추가할 경우 : insert into 테이블명 values (데이터1, 데이터2 );
            특정 필드에 데이터 추가할 경우 : insert into 테이블명 (필드명1, 필드명2 ) values (데이터1, 데이터2);
        select
			테이블 모든 필드 검색 : select * from 테이블명;
            테이블 특정 필드 검색 : select 필드명, 필드명 from 테이블명;
            테이블 조건 검색 : select * from 테이블명 where 
        update
			모든 레코드에 대한 수정 : update 테이블명 set 필드명1 = 새로운값 , 필드명2 = 새로운값
            특정 레코드에 대한 수정 : update 테이블명 set 필드명1 = 새로운값 , 필드명2 = 새로운값 where 조건
        delete
			모든 레코드 삭제 : delete from 테이블명;
            특정 레코드 삭제 : delete from 테이블명 where 조건;
	3. DCL
		grant
        revoke
	4. TCL
		commit
        rollback
	+그 외 
		use DB명; //해당 DB 선택/사용
        
	- 데이터타입
		정수형 : byte, short, int, long, 
        실수형 : float, double
        문자형 : varchar(길이)
		날짜형 : data , time , datatime
        대용량 : text
 
*/

-- 1. db 생성
create database java;
use java;
create table member(
	mno int auto_increment primary key,
		-- auto_increment : 자동번호 부여 [* pk 같이 사용 ]
        -- primary key    : 식별용도     [* 중복 x, 공백null x ]
	mid 	varchar(20),
    mpw 	varchar(20),
    mname 	varchar(10),
    mphone	varchar(13)  -- 마지막은 , 안함
);
-- 4. 회원가입 1명 ['qwe','qwe','유재석','010-4444-4444']
insert into
Member ( mid, mpw, mname, mphone)
values ('qwe','qwe','유재석','010-4444-4444');

-- 5. 테이블 확인 [ 모든 필드 검색 ]
select * from Member;

-- 6. 회원가입 1명 추가 [ 'asd' , 'asd' , '강호동', '010-5555-5555']
insert into
member ( mid, mpw, mname, mphone)
values ('asd' , 'asd' , '강호동', '010-5555-5555');

-- 7. 로그인하기 [ 'asd' , 'zxc' ]
select * from member where mid = 'asd' and mpw = 'zxc'; -- 레코드가 존재하지 않으면 로그인 실패
-- 8. 로그인하기 [ 'qwe' , 'qwe' ]
select * from member where mid = 'qwe' and mpw = 'qwe'; -- 레코드가 존재하면 로그인 성공

-- 조건 where 절 필드명 = 찾을값 : 해당 필드 값이 찾을값과 같으면 true
-- 조건 and 조건 , 조건 or 조건 
-- 검색된 결과 [ 레코드 - 행 ] 가 존재하면 로그인 성공, 없으면 실패

-- 9. 특정 회원의 모든 정보 호출 [ 회원번호 : 3 ]
select * from member where mno = 3; 		-- 3번 회원의 레코드 [행] 확인 --> 없다
select * from member where mno = 2; 		-- 2번 회원의 레코드 [행] 확인 --> 있다

-- 10. 특정 회원의 비밀번호 변경 [ 2번 회원의 비밀번호 'zxc' 변경 ]
update member set mpw = 'zxc';				-- 모든 회원 비밀번호를 'zxc'로 변경
update member set mpw = 'zxc' where mno=2;  -- 2번 회원 비밀번호를 'zxc'로 변경

-- 11. 특정 회원의 탈퇴
delete from member;							-- 모든 회원 탈퇴
delete from member where mno = 2 ; 			-- 2번 회원 탈퇴
