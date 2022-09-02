/*
    PL / SQL
    1. 오라클의 프로그래밍 처리가 가능한 SQL
    2. 프로그래밍 형식
        [DECLARE]
            [변수 선언]
        BEGIN
            수행할 PL/SQL
        END;
    3. PL/SQL의 데이터(변수, 상수)는 서버메시지로 출력
    4. 서버메시지 출력을 위해서 최초 1회 설정 필요(디폴트 SET SEVEROUTPUT OFF; 디폴트 세팅이 서버메시지 출력이 안되게 되어있음)
        SET SERVEROUTPUT ON;
*/

-- 기초 데이터 준비
-- HR 계정의 EMPLOYEES 테이블을 SCOTT 계정으로 복사해 오기
-- 기본키, 외래키는 같이 복사되지않음
CREATE TABLE EMPLOYEES 
            AS (SELECT *
                FROM HR.EMPLOYEES);
-- 기본키 다시 생성
ALTER TABLE EMPLOYEES
    ADD CONSTRAINT PK_EMPLOYEES PRIMARY KEY(EMPLOYEE_ID);
    
-- 서버메시지 출력 가능 상태로 변경
-- 한번만 실행하면 됨
SET SERVEROUTPUT ON;

--서버메시지출력
BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO'); -- HELLO 출력후 줄바꿈 오라클의 SYSOUT
END;

-- 스칼라 변수 선언
-- 스칼라 변수 : 직접 타입을 명시하는 변수
-- 대입 연산자 : 콜론등호(:=)
-- 변수 선언은 DECLARE에서 처리
DECLARE
    -- 스칼라 변수 선언
    NAME VARCHAR2(20 BYTE);
    AGE NUMBER(3);
BEGIN
    NAME := '박지원';
    AGE := 27;
    DBMS_OUTPUT.PUT_LINE('내 이름은' || NAME || '입니다.');
    DBMS_OUTPUT.PUT_LINE('내 나이는' || AGE || '살입니다.');
END;

-- 참조 변수 선언
-- 참조 변수 : 특정 칼럼의 타입을 그대로 사용하는 변수
-- 선언 방법
-- 테이블명.칼럼%TYPE

DECLARE
    -- 참조 변수 선언
        NAME EMPLOYEES.FIRST_NAME%TYPE;
BEGIN
    NAME := '박지원';
    DBMS_OUTPUT.PUT_LINE('내 이름은'||NAME||'입니다.');
END;

-- 참조 변수 활용
-- 테이블의 데이터를 읽어 참조 변수에 저장
-- SELECT 칼럼 INTO 변수 FROM

-- 문제. EMPLOYEE_ID가 100인 회원의 FIRST_NAME, LAST_NAME, SALARY 정보를 참조 변수에 저장
DECLARE
    F_NAME EMPLOYEES.FIRST_NAME%TYPE;
    L_NAME EMPLOYEES.LAST_NAME%TYPE;
    V_SALARY EMPLOYEES.SALARY%TYPE;
BEGIN
    SELECT
        FIRST_NAME, LAST_NAME, SALARY 
    INTO 
        F_NAME, L_NAME, V_SALARY
    FROM
        EMPLOYEES
    WHERE
        EMPLOYEE_ID = 100;
    DBMS_OUTPUT.PUT_LINE(F_NAME || L_NAME || V_SALARY);
END;

-- 레코드 변수 선언
-- 레코드 : 필드의 모임(클래스 늑김~)
-- DB에서 레코드란? 행(ROW) 튜플 속성
-- 레코드 변수 : 여러 칼럼을 동시에 저장하는 변수
-- 레코드 변수 정의와 선언 과정으로 진행

DECLARE
        -- 레코드 변수 타입 정의(타입 만들기)
        TYPE MY_TYPE IS RECORD(
            V_FNAME EMPLOYEES.FIRST_NAME%TYPE,
            V_LNAME EMPLOYEES.LAST_NAME%TYPE,
            V_SALARY EMPLOYEES.SALARY%TYPE
    );
    -- 레코드 변수 선언(변수 만들기)
    V_ROW MY_TYPE;
BEGIN
    SELECT
        FIRST_NAME, LAST_NAME, SALARY
        INTO V_ROW
        FROM EMPLOYEES
        WHERE EMPLOYEE_ID = 100;
        DBMS_OUTPUT.PUT_LINE(V_ROW.V_FNAME || V_ROW.V_LNAME || V_ROW.V_SALARY);
END;

-- 4. 행 변수 선언하기
-- 행(ROW) 전체를 저장할 수 있는 타입
-- 선언 방법
-- 테이블%ROWTYPE

DECLARE
-- 행변수 선언
    V_ROW EMPLOYEES%ROWTYPE;
BEGIN
    SELECT *-- 다 긁어오기 FIRST_NAME, LAST_NAME, SALARY...
    INTO V_ROW
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = 100;
  DBMS_OUTPUT.PUT_LINE(V_ROW.FIRST_NAME || V_ROW.LAST_NAME || V_ROW.SALARY);
END;

-- 5. IF
/*
    IF 조건식 THEN
        실행문
    ELSIF 조건식 THEN
        실행문
    ELSE --조건식 있을때만 THEN 씀
        실행문
    END IF;
*/

-- 1) 성인/미성년자
DECLARE
    AGE NUMBER(3);
    RESULT VARCHAR2(20 BYTE);
BEGIN
    AGE := 45;
    IF AGE >= 20 THEN
        RESULT := '성인';
    ELSE RESULT := '미성년자';
    END IF;
    DBMS_OUTPUT.PUT_LINE(AGE || '살은 ' || RESULT || '입니다.');
END;

-- 2) 학점(A,B,C,D,F)
DECLARE
    SCORE NUMBER(3);
    RESULT VARCHAR2(20 BYTE);
BEGIN
    SCORE := 95;
    IF SCORE >= 90 THEN
        RESULT := 'A';
    ELSIF SCORE >= 80 THEN
        RESULT := 'D';
    ELSIF SCORE >= 70 THEN
        RESULT := 'C';
    ELSIF SCORE >= 60 THEN
        RESULT := 'D';
    ELSE RESULT := 'F';
    END IF;
    DBMS_OUTPUT.PUT_LINE(SCORE || '점은 ' || RESULT || '입니다.');
END;

-- 3) EMPLOYEE_ID가 150인 사원의 연봉을 참조하여
-- 15000 이상이면 '고연봉' 10000 이상이면 '중연봉', 나머지는 '저연봉
DECLARE
    SAL EMPLOYEES.SALARY%TYPE;
    RES VARCHAR2(20 BYTE);
BEGIN SELECT SALARY
INTO SAL
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 150;
IF SAL >= 15000 THEN
RES := '고연봉';
ELSIF SAL >= 10000 THEN
RES := '중연봉';
ELSE
RES := '저연봉';
END IF;
DBMS_OUTPUT.PUT_LINE('연봉 ' || SAL || '은 ' || RES || '입니다.');
END;

DECLARE
    F_NAME EMPLOYEES.FIRST_NAME%TYPE;
    L_NAME EMPLOYEES.LAST_NAME%TYPE;
    V_SALARY EMPLOYEES.SALARY%TYPE;
BEGIN
    SELECT
        FIRST_NAME, LAST_NAME, SALARY 
    INTO 
        F_NAME, L_NAME, V_SALARY
    FROM
        EMPLOYEES
    WHERE
        EMPLOYEE_ID = 150;
    DBMS_OUTPUT.PUT_LINE(F_NAME || L_NAME || V_SALARY);
END;


-- 6. CASE문 
/*
    CASE                   --IF대용으로 사용하는 경우 많음
        WHEN 조건식 THEN
            실행문
        WHEN 조건식 THEN
            실행문
        ELSE
            실행문
    END CASE;

*/

-- 주민번호를 이용해 성별 조회하기
DECLARE
    SNO VARCHAR2(14 BYTE);
    GENDER_NUM VARCHAR2(1 BYTE);
    GENDER VARCHAR2(1 BYTE);
BEGIN
    SNO := '901010-1234567';
    --GENDER_NUM = SUBSTR(SNO, 8, 1); --SELECT SUBSTR() FROM DUAL; 서브스트링 확인하고싶으면 쿼리짜야됨--SUBSTR(SNO,8,1) 앞에서부터 8번째 1글자 --SUBSTR(SNO,-7,1) 뒤에서부터 7번째 1글자
    SELECT SUBSTR(SNO, 8, 1)
    INTO GENDER_NUM
    FROM DUAL;
 CASE
    WHEN GENDER_NUM = '1' THEN
    GENDER := 'M';
    WHEN GENDER_NUM = '2' THEN
    GENDER := 'F';
END CASE;
DBMS_OUTPUT.PUT_LINE('성별은 ' || GENDER || '입니다.');
END;

-- WHILE문
/*
    WHILE 조건식 LOOP
        실행문
    END LOOP;
*/
-- 1) 1~5 출력하기
DECLARE
    N NUMBER := 1;
BEGIN
    WHILE N <= 5 LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N:=N +1;
    END LOOP;
END;

-- 2) EMPLOYEES 테이블의 모든 사원의 FIRST_NAME, LAST_NAME 조회
-- FIRST_NAME 과 LAST_NAME을 레코드 변수에 저장하고 해당 값을 조회
-- 레코드 변수는 사원 한명의 정보만 저장할 수 있음, 한 명씩 저장 후 출력하는 방식
-- 사원번호는 100~206 값을 가짐
DECLARE
    -- 참조변수 선언
     EMP_NO EMPLOYEES.EMPLOYEE_ID%TYPE;
    -- 레코드 변수 정의
    TYPE NAME_TYPE IS RECORD(
        FNAME EMPLOYEES.FIRST_NAME%TYPE,
        LNAME EMPLOYEES.LAST_NAME%TYPE
 );
    -- 레코드 변수 선언(변수 만들기)
    FULL_NAME NAME_TYPE;   
BEGIN
    -- 사원번호(100~206) 기준으로 WHILE LOOP 100번~~~101번~~~~...
   EMP_NO := 100;
    WHILE EMP_NO <= 206 LOOP
        SELECT FIRST_NAME, LAST_NAME
        INTO FULL_NAME -- FNAME,LNAME모두 FULLNAME에 저장해라
        FROM EMPLOYEES
    WHERE EMPLOYEE_ID = EMP_NO;
    DBMS_OUTPUT.PUT_LINE(FULL_NAME.FNAME || '' || FULL_NAME.LNAME);
    EMP_NO := EMP_NO + 1;
END LOOP;
END;
-- 8. FOR문

/*
    FOR 변수 IN 시작값..종료값 LOOP
        실행문
    END LOOP;
*/

-- 1) 1~5

DECLARE
    N NUMBER(1);
BEGIN
    FOR N IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;

-- 2) 짝수 / 홀수
DECLARE
    N NUMBER;
    MODULAR NUMBER(1); -- 2로 나눈 나머지 값을 저장
    RESULT VARCHAR2(10 BYTE);
BEGIN
    FOR N IN 1..10 LOOP
        SELECT MOD(N,2)
            INTO MODULAR
            FROM DUAL;
        IF MODULAR = 0 THEN
            RESULT := '짝수';
        ELSE
            RESULT := '홀수';
        END IF;
        DBMS_OUTPUT.PUT_LINE(N || '은 ' || RESULT || '입니다. ');
    END LOOP;
END;

-- 3) EMPLOYEES 테이블의 모든 사원의 연봉합계 / 평균 조회하기
DECLARE
    SAL EMPLOYEES.SALARY%TYPE; --EMPLOYEE의 SALARY 타입과 같은 타입
    EMP_NO EMPLOYEES.EMPLOYEE_ID%TYPE;
    TOTAL NUMBER;
    CNT NUMBER;
    AVERAGE NUMBER; -- 필요한 변수 모두 선언하기
BEGIN
    TOTAL := 0;
    CNT := 0;
    FOR EMP_NO IN 100..206 LOOP
        SELECT SALARY
        INTO SAL
        FROM EMPLOYEES
        WHERE EMPLOYEE_ID = EMP_NO;
        TOTAL := TOTAL + SAL;
        CNT := CNT + 1;
    END LOOP;
    AVERAGE := TOTAL / CNT;
    DBMS_OUTPUT.PUT_LINE('연봉합계 : ' || TOTAL);
    DBMS_OUTPUT.PUT_LINE('연봉평균 : ' || AVERAGE);
END;

-- 4) DEPARTMENT_ID가 50인 사원정보를 DEPT50 테이블에 복사하기
--  (1) EMPLOYEES와 구조가 동일한 DEPT50 테이블 생성
--  (2) 행 변수를 이용해 EMPLOYEES 정보 읽기
--  (3) 행변수의 DEPARTMENT_ID가 50이면 DEPT50에 INSERT
CREATE TABLE DEPT50
    AS (SELECT * FROM EMPLOYEES WHERE 1 =2);

DECLARE
    V_ROW EMPLOYEES%ROWTYPE;
BEGIN
    FOR V_ROW IN(SELECT * FROM EMPLOYEES) LOOP
        IF V_ROW.DEPARTMENT_ID = 50 THEN
            INSERT INTO DEPT50 VALUES V_ROW;
        END IF;
    END LOOP;
    COMMIT;
END;


-- 9. EXIT문
--LOOP 종료
DECLARE
    N NUMBER;
BEGIN
    N := 1;
    WHILE TRUE LOOP
        IF N> 100 THEN
            EXIT;
        END IF;
        N := N + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(N);
END;

-- 10. CONTINUE문
-- LOOP문의 시작부터 다시 시작

-- DEPARTMENT_ID가 50인 사원을 제외하고 연봉합계 조회하기

DECLARE
    EMP_NO EMPLOYEES.EMPLOYEE_ID%TYPE;
    SAL EMPLOYEES.SALARY%TYPE;
    DEPT_ID EMPLOYEES.DEPARTMENT_ID%TYPE; -- 문제흐름만들기
    TOTAL NUMBER;
BEGIN
    TOTAL := 0;
    FOR EMP_ID IN 100..206 LOOP
        SELECT SALARY, DEPARTMENT_ID
          INTO SAL, DEPT_ID
          FROM EMPLOYEES
         WHERE EMPLOYEE_ID = EMP_ID;
        IF DEPT_ID = 50 THEN
            CONTINUE;
        END IF;
        TOTAL := TOTAL + SAL;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('연봉합계 : ' || TOTAL); -- NULL값 포함 됨 부서번호가 없는 사람 포함
END;
SELECT SUM(SALARY) FROM EMPLOYEES WHERE DEPARTMENT_ID != 50; -- NULL값 포함 안됨 부서번호가 없는 사람 포함안됨

-- 11. 배열 선언하기
-- 테이블 타입 : 특정 칼럼의 모든 데이터를 배열에 저장
DECLARE
    -- SALARY 칼럼의 모든 값을 저장할 배열(SALARIES) 생성
    
    -- 배열의 타입 정의
    TYPE SALARY_TYPE IS TABLE OF EMPLOYEES.SALARY%TYPE INDEX BY BINARY_INTEGER; --BIN =BINARY_INTEGER
    
    -- 배열의 선언
    SALARIES SALARY_TYPE;
    
    -- 인덱스 선언
    I BINARY_INTEGER;
    
    -- 행(ROW) 변수 선언
    V_ROW EMPLOYEES%ROWTYPE;
    
BEGIN
    I := 0;
    FOR V_ROW IN(SELECT * FROM EMPLOYEES) LOOP-- SALARY를 가져와서 SAL에 넣어라
        SALARIES(I) := V_ROW.SALARY; --()=[]
        I := I + 1;
    END LOOP;
    
    FOR I IN 0..106 LOOP
        DBMS_OUTPUT.PUT_LINE(SALARIES(I));
    END LOOP;
END;

-- 12. 예외처리

--  형식
/*
    EXCEPTION
        WHEN 예외 THEN
            예외처리
        WHEN 예외 THEN
            예외처리
        WHEN OTHERS THEN
            예외처리
-- 예외는 END가 없음
*/
DECLARE
    FNAME EMPLOYEES.FIRST_NAME%TYPE;
BEGIN
    SELECT FIRST_NAME
    INTO FNAME
    FROM EMPLOYEES
    --WHERE EMPLOYEE_ID = 0; -- 존재하지 않는 사원 조회
    WHERE DEPARTMENT_ID = 50; -- 변수에 저장할 데이터가 너무 많음
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('예외코드 ' || SQLCODE);
        DBMS_OUTPUT.PUT_LINE('예외메시지 ' || SQLERRM);
END;

DECLARE
    FNAME EMPLOYEES.FIRST_NAME%TYPE;
BEGIN
    SELECT FIRST_NAME
    INTO FNAME
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = 0; -- 존재하지 않는 사원 조회
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('조회된 데이터가 없음');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('예외코드 ' || SQLCODE);
        DBMS_OUTPUT.PUT_LINE('예외메시지 ' || SQLERRM);
END;

DECLARE
    FNAME EMPLOYEES.FIRST_NAME%TYPE;
BEGIN
    SELECT FIRST_NAME
    INTO FNAME
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = 0; -- 존재하지 않는 사원 조회
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('조회된 데이터가 없음');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('예외코드 ' || SQLCODE);
        DBMS_OUTPUT.PUT_LINE('예외메시지 ' || SQLERRM);
END;

