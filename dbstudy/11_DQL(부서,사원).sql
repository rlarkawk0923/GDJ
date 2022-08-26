/*
    DQL
    
    1. Data Query Language
    2. 데이터 질의어
    3. 테이블의 데이터를 조회/검색
    4. 데이터 베이스에 변화가 없으므로 COMMIT 없음
        (트랜잭션의 대상이 아님)
    5. 형식
        SELECT 칼럼1, 칼럼2, ...
         From 테이블
         [WHERE 조건식]
         [GROUP BY 그룹화] -- 함수뽑을때 사용 대상 지정하여 그루핑
         [HAVING 그룹화_조건식]
         [ORDER BY 정렬]
    6. 실행 순서 -- ORACLE은 순서대로 읽기때문에 중요
        ⑤  SELECT 칼럼
        ①    FROM 테이블
        ②   WHERE 조건식
        ③   GROUP BY 그룹화
        ④  HAVING 그룹화 조건식
        ⑥   ORDER BY 정렬 기준
*/


-- 1. 사원 테이블에서 사원명 조회하기
SELECT NAME
  FROM EMPLOYEE;
  
-- 1) 테이블에 오너 명시
SELECT NAME
    FROM SCOTT.EMPLOYEE;
--2) 칼럼에 테이블 명시
SELECT EMPLOYEE.NAME
FROM EMPLOYEE;

--3) 테이블에 별명 지정★중요 필수
SELECT NAME
FROM EMPLOYEE EMP; -- 별명 EMP 지정

--4) 칼럼에 별명(ALIAS) 지정 ★
SELECT NAME AS 사원명 -- 별명 사원명 지정
  FROM EMPLOYEE;
  
--2. 사원 테이블의 모든 칼럼 조회하기
-- 모든 칼럼 : * 애스터리스크
-- 중요 : 실무에서 * 사용 금지 감사걸림ㄷㄷ
SELECT *
 FROM EMPLOYEE;
 
-- 모든 칼럼이 필요하면 모두 명시
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE;
  
-- 3. 부서 테이블에서 지역명 조회하기
-- 단, 동일한 지역은 한 번만 조회하기
-- 중복제거 : DISTINCT
SELECT DISTINCT LOCATION
  FROM DEPARTMENT;
  
SELECT DISTINCT DEPT_NAME, LOCATION --두개이상의 칼럼은 잘 사용하지않음
  FROM DEPARTMENT;
  
--WHERE 절 (조건)
-- 4. 사원테이블에서 직급이 '과장'인 사원 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
WHERE POSITION = '과장';

--5. 사원 테이블에서 급여가 2000000~5000000인 사원 조회하기

--연산자사용
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
WHERE SALARY >= 2000000
  AND SALARY <= 5000000;

-- BETWEEN 범위 사용
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
WHERE SALARY BETWEEN 2000000 AND 5000000; --권장 방법

--6. 사원 테이블에서 소속부서가 1,2인 사원 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
WHERE DEPART = 1
   OR DEPART = 2;
   
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
WHERE DEPART IN( 1 , 2 );

-- 7. 사원 테이블에서 성별이 없는 사원 조회
-- NULL 유무
-- 1) NULL이다 : IS NULL
-- 2) NULL이 아니다 : IS NOT NULL
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
WHERE GENDER IS NULL; -- '=' 사용 불가

-- 8. 사원 테이블에서 김씨 조회
--    1)만능문자(WILD CARD)
--     (1) % : 모든 문자, 글자수 제한 없음
--     (2) _ : 모든 문자, 한 글자로 제한
--    2) 예시
--     (1)김으로 시작하는 이름 찾기 : 김%
--     (2)김으로 끝나는는 이름 찾기 : %김
--     (3)김을 포함하는는 이름 찾기 : %김%
--    3) 만능문자 연산자
--      LIKE, NOT LIKE

SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
WHERE NAME LIKE '김%';


SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
WHERE NAME NOT LIKE '김%';

--9. 사원 테이블에서 사원번호가 1로 시작하는 사원 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
WHERE EMP_NO LIKE '1%'; --캐스팅되어 비교됨/ 넘버와 텍스트가 섞여 있으면 오라클은 스스로 캐스팅하여 비교한다

/*
    ORDER BY 절
    
    ASC : 오름 차순 정렬, 생략 가능
    DESC : 내림 차순 정렬
*/
-- 10. 사원 테이블에서 사원명의 가나다 순으로 조회하기

SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
  ORDER BY NAME; --ASC; 생략가능

-- 사원테이블에서 급여가 높은순으로 조회하기

SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
  ORDER BY SALARY DESC;
  
-- 12. 사원 테이블에서 성별의 가나다 순으로 조회하기

SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
ORDER BY GENDER;


SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
ORDER BY GENDER DESC;

-- 13. 사원 테이블에서 먼저 고용된 순으로 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
ORDER BY HIRE_DATE; -- 문자로 인식하지 않았다(17이 먼저 나오지않음)

-- 14. 사원 테이블에서 소속부서의 오름차순 정렬로 조회하되,
--     같은 소속부서 내에서는 먼저 고용된 순으로 조회하기
--     1차 정렬기준 : 소속 부서
--     2차 정렬기준 : 고용일자
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
ORDER BY DEPART ASC, HIRE_DATE ASC; -- 각 정렬기준마다 ASC 작성

/*WHERE절과 ORDER BY절 함께 사용*/

-- 15. 사원 테이블에서 급여가 5000000 이상인 사원들을 고용된 순으로 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
WHERE SALARY >= 5000000
ORDER BY HIRE_DATE ;

SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE AS HD, SALARY
  FROM EMPLOYEE
WHERE SALARY >= 5000000
ORDER BY HD ;

SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY AS S
  FROM EMPLOYEE
WHERE S >= 5000000
ORDER BY HIRE_DATE ; -- 실행순서 FROM-WHERE-SELECT - ORDER BY 상 EMPLOYEE 에서 S찾기가 먼저 진행되는데 SELECT절이 나중에 진행되기때문에 S를 찾을수 없어 오류 발생
