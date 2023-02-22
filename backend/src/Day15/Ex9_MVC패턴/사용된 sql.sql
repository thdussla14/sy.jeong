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
-- 4. 회원가입
String sql = "insert into member (mid, mpw) values (?,?)";	
-- 5. 모든 회원 출력
String sql = "select * from member";
-- 6. 특정 회원 비밀번호 수정
String sql = "update member set mpw = ? where mno = ? ";
-- 7. 특정 회원 삭제
String sql = "delete from member where mno = ? ";		

