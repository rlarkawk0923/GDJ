--테이블 삭제
DROP TABLE CUSTOMER;
DROP TABLE BANK;

--테이블 생성
CREATE TABLE BANK(
    BANK_CODE VARCHAR2(20 BYTE) NOT NULL,
    BANK_NAME VARCHAR2(30 BYTE) NULL
);

--테이블 생성
CREATE TABLE CUSTOMER(
    NO        NUMBER            NOT NULL,
    NAME      VARCHAR2(30 BYTE) NOT NULL,
    PHONE     VARCHAR2(30 BYTE) UNIQUE,
    AGE       NUMBER            CHECK(AGE BETWEEN 0 AND 100),
    BANK_CODE VARCHAR2(20 BYTE)
);

--기본키 추가
ALTER TABLE BANK
    ADD CONSTRAINT PK_BANK PRIMARY KEY(BANK_CODE);
ALTER TABLE CUSTOMER
    ADD CONSTRAINT PK_CUSTOMER PRIMARY KEY(NO);


--외래키 추가
ALTER TABLE CUSTOMER
    ADD CONSTRAINT FK_CUSTOMER_BANK FOREIGN KEY(BANK_CODE)
    REFERENCES BANK(BANK_CODE)
        ON DELETE CASCADE;
/*
    FK 옵션
    1. ON DELETE SET NULL
     1) 참조하던 PK의 값이 삭제되면 FK의 값을 NULL로 수정
     2) FK가 필수 설정(NOT NULL)이면 사용할 수 없는 옵션
     
    2. ON DELETE CASCADE
     1) 참조하던 PK의 값이 삭제되면 FK의 값을 함께 삭제
     2) 회원 탈퇴 시 작성한 게시글 모두 삭제, 게시글 삭제 시 달린 댓글 모두 삭제와 같은 경우
*/




-- 테이블 변경하기(ALTER TABLE)

-- 1. BANK 테이블에 BANK_PHONE 칼럼을 추가하시오.


-- 2. CUSTOMER 테이블에 GRADE 칼럼을 추가하시오. ('VIP', 'GOLD', 'SILVER' 중 하나의 값만 가진다.)


-- 3. BANK 테이블의 BANK_NAME 칼럼을 VARCHAR2(15 BYTE)로 수정하시오.


-- 4. BANK 테이블의 BANK_NAME 칼럼을 NOT NULL로 수정하시오.


-- 5. CUSTOMER 테이블의 AGE 칼럼을 삭제하시오.


-- 6. CUSTOMER 테이블의 NO 칼럼과 NAME 칼럼이름을 CUST_NO와 CUST_NAME으로 변경하시오.