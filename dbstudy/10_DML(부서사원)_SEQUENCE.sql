DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

CREATE TABLE DEPARTMENT(
    DEPT_NO NUMBER NOT NULL,
    DEPT_NAME VARCHAR2(15 BYTE) NOT NULL,
    LOCATION VARCHAR2(15 BYTE) NOT NULL
);

CREATE TABLE EMPLOYEE(
    EMP_NO NUMBER NOT NULL,
    NAME VARCHAR2(20 BYTE) NOT NULL,
    DEPART NUMBER,
    POSITION VARCHAR2(20),
    GENDER CHAR(2),
    HIRE_DATE DATE,
    SALARY NUMBER
);
--기본키
ALTER TABLE DEPARTMENT
    ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY(DEPT_NO);
ALTER TABLE EMPLOYEE
    ADD CONSTRAINT PK_EMPLOYEE PRIMARY KEY(EMP_NO);
    
--외래키
ALTER TABLE EMPLOYEE
    ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT FOREIGN KEY(DEPART)
        REFERENCES DEPARTMENT(DEPT_NO)
        ON DELETE CASCADE;
        
/***************************************************/

/* 
   시퀀스
   1. SEQUENCE
   2. 일련번호를 생성하는 데이터베이스 객체
   3. 자동으로 증가하는 번호를 생성
   4. 인공키-기본키(PK)로 주로 사용
   5. 만들어진 시퀀스 객체에 NEXTVAL(NEXT VALUE)를 이용하면 새로운 번호가 생성
   6. CURRVAL(CURRENT VALUE)를 이용하면 현재 번호(몇번까지 나갔는지)를 확인
*/
/*
    시퀀스 생성 형식
    CREATE SEQUENCE 시퀀스_이름 (순서 상관무)
        START WITH 시작값          -- 생략하면 1, 생성 이후 수정불가
        INCREMENT BY 증가값        -- 생략하면 1 씩 증가
        MINVALUE 최소값
        MAXVALUE 최대값
        CACHE 사용유무 - 메모리캐시 사용할건지, 미리 기억저장소에서가져오겠다는 개념--NO CACHE 권장 중간에 건너뛰는 현상발생 
        CYCLE 사용유무 --PK에서 사용하거나 생략하면 NOCYCLE(중복이있으면 안되기때문)

*/
 
--부서 테이블에서 사용할 부서_시퀀스
DROP SEQUENCE DEPARTMENT_SEQ;

CREATE SEQUENCE DEPARTMENT_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 100
    NOCACHE
    NOCYCLE;
    
COMMIT;


--부서 테이블에 행(Row) 삽입
--부모(관계에서 PK를 가진 테이븕) 테이블에 먼저 삽입을 해야 함
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '영업부', '대구');
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '인사부', '서울');
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '총무부', '대구');
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '기획부', '서울'); --취소하면 4개 다 취소

-- 작업의 완료
COMMIT; --안 넣으면 저장 안됨


-- 사원 테이블에 사용할 사원_시퀀스
DROP SEQUENCE EMPLOYEE_SEQ;

CREATE SEQUENCE EMPLOYEE_SEQ
    START WITH 1001
    NOCACHE;
-- INCREMENT BY 



-- 사원 테이블에 행(ROW) 삽입
-- 자식 테이블(관계에서 FK를 가진 테이블)은 참조 무결성에 위배되지 않는 데이터만 삽입 가능
-- 부서(부서번호) - 사원(소속부서)
-- PK             - FK
-- 1234           - 1,2,3,4
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '구창민', 1, '과장','M', '95/05/01', 5000000);--날짜 '95-05-01'도 가능

INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '김민서', 1, '사원', 'F', '17/09/01', 2000000);

INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '이은영', 2, '부장', NULL, '90-09-01', 5500000);--90/09/01로 변환하여 저장됨

INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_SEQ.NEXTVAL, '한성일', '2', '과장', 'M', '93-04-01', 5000000);
-- 오류가 발생하는 INSERT
--INSERT는 실패하였으나 시퀀스의 번호는 사용했음
--INSERT INTO
--    EMPLOYEE
--VALUES
--    (EMPLOYEE_SEQ.NEXTVAL, '신현준', '5', '대리', 'M', '98-12-01', 3500000);


COMMIT;
/****************************************************/

DROP TABLE SAMPLE;
CREATE TABLE SAMPLE(
    NO1 NUMBER,
    NO2 NUMBER
);

DROP SEQUENCE SAMPLE_SEQ;
CREATE SEQUENCE SAMPLE_SEQ NOCACHE;

최초 1번은 NEXTVAL를 사용해야 CURRVAL도 사용 가능함
INSERT INTO SAMPLE(NO1) VALUES(SAMPLE_SEQ.CURRVAL);

--NEXTVAL, CURRVAL 함께 사용
INSERT INTO SAMPLE(NO1, NO2) VALUES(SAMPLE_SEQ.NEXTVAL, SAMPLE_SEQ.CURRVAL); --둘다 1들어감

COMMIT;

