-- 테이블 삭제
DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

-- DEPARTMENT 테이블 생성
CREATE TABLE DEPARTMENT(
    DEPT_NO   NUMBER            NOT NULL,
    DEPT_NAME VARCHAR2(15 BYTE) NOT NULL,
    LOCATION  VARCHAR2(15 BYTE) NOT NULL
);

-- EMPLOYEE 테이블 생성
CREATE TABLE EMPLOYEE(
    EMP_NO    NUMBER            NOT NULL,
    NAME      VARCHAR2(20 BYTE) NOT NULL,
    DEPART    NUMBER            NULL,
    POSITION  VARCHAR2(20 BYTE) NULL,
    GENDER    CHAR(2)           NULL,
    HIRE_DATE DATE              NULL, 
    SALARY    NUMBER            NULL
);

-- 기본키
ALTER TABLE DEPARTMENT 
    ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY(DEPT_NO);
ALTER TABLE EMPLOYEE 
    ADD CONSTRAINT PK_EMPLOYEE PRIMARY KEY(EMP_NO);

-- 외래키
ALTER TABLE EMPLOYEE 
    ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT FOREIGN KEY(DEPART) 
        REFERENCES DEPARTMENT(DEPT_NO)
            ON DELETE SET NULL;

-- 부서 테이블에서 사용할 부서_시퀀스
DROP SEQUENCE DEPARTMENT_SEQ;
CREATE SEQUENCE DEPARTMENT_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 100
    NOCACHE
    NOCYCLE;

-- 부서 테이블에 행(Row) 삽입
INSERT INTO DEPARTMENT(DEPT_NO, DEPT_NAME, LOCATION) VALUES(DEPARTMENT_SEQ.NEXTVAL, '영업부', '대구');
INSERT INTO DEPARTMENT(DEPT_NO, DEPT_NAME, LOCATION) VALUES(DEPARTMENT_SEQ.NEXTVAL, '인사부', '서울');
INSERT INTO DEPARTMENT(DEPT_NO, DEPT_NAME, LOCATION) VALUES(DEPARTMENT_SEQ.NEXTVAL, '총무부', '대구');
INSERT INTO DEPARTMENT(DEPT_NO, DEPT_NAME, LOCATION) VALUES(DEPARTMENT_SEQ.NEXTVAL, '기획부', '서울');
COMMIT;


-- 사원 테이블에서 사용할 사원_시퀀스
DROP SEQUENCE EMPLOYEE_SEQ;
CREATE SEQUENCE EMPLOYEE_SEQ
    START WITH 1001
    NOCACHE;

-- 사원 테이블에 행(Row) 삽입
INSERT INTO EMPLOYEE VALUES(EMPLOYEE_SEQ.NEXTVAL, '구창민', 1, '과장', 'M', '95/05/01', 5000000);
INSERT INTO EMPLOYEE VALUES(EMPLOYEE_SEQ.NEXTVAL, '김민서', 1, '사원', 'F', '17/09/01', 2000000);
INSERT INTO EMPLOYEE VALUES(EMPLOYEE_SEQ.NEXTVAL, '이은영', 2, '부장', NULL, '90-09-01', 5500000);
INSERT INTO EMPLOYEE VALUES(EMPLOYEE_SEQ.NEXTVAL, '한성일', 2, '과장', 'M', '93-04-01', 5000000);
COMMIT;

-- 참조무결성 위배 데이터 삽입을 위해서 외래키 일시중지
ALTER TABLE EMPLOYEE
    DISABLE CONSTRAINT FK_EMPLOYEE_DEPARTMENT;

-- 참조무결성 위배 데이터 삽입
INSERT INTO EMPLOYEE VALUES(EMPLOYEE_SEQ.NEXTVAL, '신현준', 5, '대리', 'M', '98-12-01', 3500000);
COMMIT;
/****************************************************/

/*
    1. JOIN
    2. 2개 이상을 조회하는 방법
    3. 조회할 테이블들은 서로 관계를 줄 수 있어야함
    4. 종류
        1) 크로스 조인 : 카테젼 곱, 각 테이블의 모든 행을 조인
        - CROSS JOIN
        - 조인 조건이 없으면 됨
        - 많은 행을 순식간에 만들 수 있음(기초데이터 작성용)
        - 조인 조건을 잘 못 지정한 경우
        2) 내부조인
        - INNER JOIN
        - 각 테이블에서 일치하는 모든 행을 조인
        3) 외부조인
        - OUTER JOIN
        - 한 테이블은 일치하는 행을 조인, 한 테이블은 일치하지 않아도 조인
        - 왼쪽 외부조인(LEFT OUTER JOIN), 오른쪽 외부조인(RIGHT OUTER JOIN)
        4) SELF JOIN
            한 테이블에 참조 관계가 있는 경우
            한 테이블의 특정 칼럼과 다른 특정 칼럼을 조인
    5. 형식
        1) JOIN 문법
        SELECT 칼럼
        FROM 테이블1 JOIN 테이블2
            ON 조인조건
        2) 콤마(,) 문법
        SELECT 칼럼
            FROM 테이블1, 테이블2
            WHERE 조인조건

*/
/*
    드라이브(DRIVE) 테이블과 드리븐(DRIVEN) 테이블
    1. 드라이브 테이블
        1) 조인에서 검색할 때 사용하는 테이블
        2) 관계에서 PK를 가진 테이블
        3) 대부분 행(ROW) 개수(CARDINALITY)가 적은 테이블
    2. 드리븐 테이블
        1) 관계에서 FK를 가진 테이블
        2) 대부분 행(ROW)개수가 많은 테이블
    3. 관계를 작성할 때(조인 할 때) 드라이브 테이블을 드리븐 테이블보다 먼저 작성-성능 문제
        
*/

-- 1. 크로스 조인 확인
SELECT E.EMP_NO, E.NAME, E.SALARY, D.DEPT_NO, D.DEPT_NAME --E. D. 으로 어느 칼럼인지 명시
--FROM EMPLOYEE E CROSS JOIN DEPARTMENT D; -- DRIVE/DRIVEN 테이블이 잘못 지정된 조인
FROM DEPARTMENT D CROSS JOIN EMPLOYEE E;


-- 2. 내부 조인 확인
--    사원번호, 사원명, 부서명을 조회하기 /양쪽에 다 있는 데이터로만 비교하는거
SELECT E.EMP_NO, E.NAME, D.DEPT_NAME
--FROM EMPLOYEE E INNER JOIN DEPARTMENT D -- DRIVE/DRIVEN 테이블이 잘못 지정된 조인
FROM DEPARTMENT D INNER JOIN EMPLOYEE E
-- ON E.DEPART = D.DEPT_NO;
  ON D.DEPT_NO =  E.DEPART;

-- 3. 외부 조인 확인
-- 사원번호, 사원명, 부서명을 조회하기
-- 모든 사원을 반드시 조회
-- 사원       - 부서
-- 모두포함   - 일치하는 부서만 포함

-- 모두 포함 시킬 사원테이블을 OUTER JOIN의 왼쪽/오른쪽에 두느냐에 따라
-- 왼쪽 외부 조인 / 오른쪽 외부 조인
SELECT E.EMP_NO, E.NAME, D.DEPT_NAME
FROM EMPLOYEE E LEFT OUTER JOIN DEPARTMENT D -- 왼쪽의 EMPLOYEE 테이블은 모두 조회
ON E.DEPART = D.DEPT_NO; -- 5번부서는 없는 부서라 null값나옴

SELECT E.EMP_NO, E.NAME, D.DEPT_NAME
FROM DEPARTMENT D RIGHT OUTER JOIN EMPLOYEE E -- 오른쪽의 EMPLOYEE 테이블은 모두 조회
ON D.DEPT_NO = E.DEPART;

-- DRIVE/DRIVEN 테이블이 잘 지정된 조인
SELECT E.EMP_NO, E.NAME, D.DEPT_NAME
  FROM DEPARTMENT D RIGHT OUTER JOIN EMPLOYEE E  -- 오른쪽의 EMPLOYEE 테이블은 모두 조회
    ON D.DEPT_NO = E.DEPART;

SELECT EMP_NO, NAME, DEPT_NAME
FROM EMPLOYEE INNER JOIN DEPARTMENT
ON DEPART = DEPT_NO;