/*
1.
테이블 이름(TABLE_NAME)이 'EMP'인 테이블에 존재하는 인덱스의 이름(INDEX_NAME)과 해당 인덱스가 설정된 칼럼 이름(COLUMN_NAME)을 조회할 수 있는 쿼리문을 작성하시오.
현재 접속한 사용자(USER)가 작성한 인덱스를 대상으로 조회하시오. (10점)
*/

SELECT INDEX_NAME, COLUMN_NAME
    FROM USER_IND_COLUMNS WHERE TABLE_NAME = 'EMP';


/*
2.
현재 접속한 사용자(USER)가 작성한 모든 VIEW의 목록을 조회할 수 있는 쿼리문을 작성하시오. 모든 칼럼(*)을 조회하도록 처리하시오. (10점)
*/
 SELECT * FROM USER_VIEWS;
 
/*
3.
다음 지시사항을 만족하는 인덱스(INDEX)를 생성하는 DDL 을 작성하시오. (10점)
    1) 대상 테이블 : PRODUCT
    2) 대상 칼럼 : PRODUCT_NAME
    3) 인덱스 이름 : IDN_NAME
    4) 고유/비고유 유무 : 비고유 인덱스(고유 인덱스 아님)
*/

CREATE INDEX IDN_NAME ON PRODUCT(PRODUCT_NAME);

/*
4.
PRODUCT 테이블의 모든 칼럼을 복사하여 NEW_PRODUCT이라는 이름의 새 테이블을 생성하는 쿼리문을 작성하시오.
데이터(행, ROW)는 복사되지 않고 칼럼만 복사되도록 작성하시오.
NOT NULL 이외의 제약조건을 복사할 필요는 없다. (10점)
*/

CREATE TABLE NEW_PRODUCT AS (SELECT * FROM PRODUCT WHERE 1 = 2);

/*
5.
다음 지시사항의 대상 테이블과 대상 칼럼 정보를 이용해서 새로운 뷰(VIEW)를 생성하는 쿼리문을 작성하시오. (10점)
    1) 대상 테이블 : PRODUCT
    2) 대상 칼럼 : PRODUCT_NAME, PRODUCT_PRICE
    3) 뷰 이름 : V_PRODUCT
*/ 

CREATE VIEW V_PRODUCT AS (SELECT PRODUCT_NAME, PRODUCT_PRICE FROM PRODUCT);

/*
6.
현재 접속한 사용자(USER)가 작성한 모든 테이블의 이름을 조회할 수 있는 쿼리문을 작성하시오.
오직 테이블 이름만 조회되도록 작성하시오. (10점)
*/
SELECT TABLE_NAME FROM USER_CONSTRAINTS;

/*
7.
현재 사용자 계정(USER)에 작성된 각종 제약조건을 확인할 수 있는 테이블의 구조를 확인하는 쿼리문을 작성하시오. (5점)
*/
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMPLOYEE';


/*
8.
다음 데이터베이스 구조를 가지고 있는 테이블이 있다고 가정하고 문제에서 요구하는 올바른 쿼리문 2개를 모두 작성하시오. (각 10점, 총 20점)

<< 데이터베이스 구조 >>
    1) 사원테이블
        EMPLOYEE (EMP_ID, EMP_NAME, SALARY, DEPT_ID)
    2) 부서테이블
        DEPARTMENT (DEPT_ID, DEPT_NAME)
    3) EMPLOYEE 테이블의 기본키는 EMP_ID 이다.
    4) DEPARTMENT 테이블의 기본키는 DEPT_ID 이다.
    5) EMPLOYEE 테이블의 DEPT_ID 는 DEPARTMENT 테이블의 DEPT_ID 를 참조하는 외래키이다.

    <<< 문제1 >>>
        가장 높은 연봉(SALARY)을 받는 사원의 부서 이름(DEPT_NAME)을 조회하는 쿼리문을 작성하시오.

    <<< 문제2 >>>
        부서 이름(DEPT_NAME)이 '총무부'인 사원들의 사원번호(EMP_ID), 사원명(EMP_NAME), 연봉(SALARY)을 조회하는 쿼리문을 작성하시오.
*/
-- 문제1
SELECT DEPT_NAME FROM DEPARTMENT WHERE DEPT_ID IN (SELECT MAX(SALARY) FROM EMPLOYEE);

-- 문제2
SELECT EMP_ID, EMP_NAME, SALARY 
FROM EMPLOYEE WHERE DEPT_ID IN(SELECT DEPT_ID
                                 FROM DEPARTMENT
                                 WHERE DEPT_NAME = '총무부');



/*
9.
다음 칼럼 정보를 참고하여 BOARD 테이블을 생성하는 쿼리문을 작성하시오.
오직 CREATE문만 사용하고, ALTER문은 사용하지 마시오. (10점)

<< 칼럼 정보 >>
    1) BOARD_NO : 글번호, 숫자, 필수, 기본키(제약조건이름 : PK_BOARD)
    2) TITLE : 글제목, 가변길이문자열 최대 1000바이트, 필수
    3) CONTENT : 글내용, 가변길이문자열 최대 4000바이트
    4) HIT : 조회수, 숫자
    5) CREATE_DATE : 작성일, 날짜
*/
CREATE TABLE BOARD(
    BOARD_NO NUMBER NOT NULL CONSTRAINT PK_BOARD PRIMARY KEY,
    TITLE VARCHAR2(1000 BYTE) NOT NULL,
    CONTENT VARCHAR2(4000 BYTE),
    HIT NUMBER,
    CREATE_DATE DATE
);

/*
10.
어떤 테이블에 삽입, 수정, 삭제된 행(ROW) 정보를 실제로 DB에 반영하기 위해서 사용하는 쿼리문을 작성하시오. (5점)
*/
COMMIT;
