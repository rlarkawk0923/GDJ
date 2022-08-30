-- 그룹(GROUP BY)
-- 1. GROUP BY절에서 지정한 칼럼의 데이터는 하나로 모아서 한 번만 조회가 됨
-- 2. SELECT절에서 조회할 칼럼은 "반드시" GROUP BY절에 존재해야 함



-- EMPLOYEES 테이블

-- 1. 동일한 부서번호(DEPARTMENT_ID)로 그룹화하여 조회

SELECT DEPARTMENT_ID
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID;
 
-- 2. 그룹화 실패
--  EMPLOYEE_ID를 조회하려면 GROUP BY절에 EMPLOYEE_ID가 있어야 함
 SELECT EMPLOYEE_ID
   FROM EMPLOYEES
  GROUP BY DEPARTMENT_ID; --부서를 한번만 보여줌- 한 부서에 여러명의 사원이 있어서 부서가 여러번 출력됨
  
-- 3. 그룹화 함수 사용
-- 집계함수(그룹함수)는 GROUP BY절에 해당 칼럼이 없어도 SELECT절에서 조회 가능함
SELECT
        DEPARTMENT_ID
      , SUM(SALARY) AS 부서별연봉합계
      , FLOOR(AVG(SALARY)) AS 부서별연봉평균
      , MAX(SALARY) AS 부서별최대연봉
      , MIN(SALARY) AS 부서별최소연봉
      , COUNT(*) AS 부서별사원수 -- 참조하는 SALARY은 조회가능
    FROM
        EMPLOYEES
GROUP BY
        DEPARTMENT_ID;
        
-- 4. 조건 지정
--    1) GROUP BY로 처리할 행(ROW)은 적을수록 성능에 유리함
--    2) WHERE절 : GROUP BY 이전에 처리되므로 가능한 모든 조건은 WHERE절에서 처리함
--    3) HAVING절 : WHERE절에서 처리할 수 없는 조건만 HAVING절로 처리함 똑같은 조건을 WHERE이나 HAVING절에 넣으면 실행되는데 최대한 WHERE절에 넣음 ROW수를 줄이기 위핵서

--  1) 부서번호가 100 미만인 부서들의 연봉평균을 조회하기(WHERE절, HAVING절 모두 가능한 조건)
--      WHERE절 : 성능이 더 우수한 쿼리
SELECT
        DEPARTMENT_ID
      , FLOOR(AVG(SALARY)) AS 부서별연봉평균
    FROM
        EMPLOYEES
WHERE
        DEPARTMENT_ID < 100 -- 분리할 필요없는 애들은 그룹 대상에서 미리 빼놓는 느낌
  GROUP BY
        DEPARTMENT_ID; 
        
-- HAVING절 : 가능하지만 성능이 떨어지는 쿼리       
SELECT
        DEPARTMENT_ID
      , FLOOR(AVG(SALARY)) AS 부서별연봉평균
    FROM
        EMPLOYEES
  
  GROUP BY
        DEPARTMENT_ID
  HAVING
        DEPARTMENT_ID < 100; -- 분리작업하고 정리하는 느낌
        
--  2) 소속된 사원 수가 10명 이상인 부서의 연봉평균 조회 (HAVING절에서만 가능한 조건 : GROUPING 해야만 가능한 조건)
-- 소속된 사원수는 GROUP BY 이후에만 알 수 있기 때문에 WHERE절로 처리가 불가능
SELECT
       DEPARTMENT_ID
     , COUNT(*) AS 부서별사원수
     , FLOOR(AVG(SALARY)) AS 부서별연봉평균
     FROM 
        EMPLOYEES
GROUP BY
        DEPARTMENT_ID
HAVING
        COUNT(*) >= 10;
        
--        실행해보기

-- 연습

-- 1. 급여평균이 10000 이상인 부서의 부서번호와 급여평균을 조회하기
SELECT
      DEPARTMENT_ID
    , FLOOR(AVG(SALARY)) AS 급여평균
FROM
        EMPLOYEES
-- WHERE
--  ABG(SALARY) AVG는 HAVING절에 쓴다
GROUP BY 
      DEPARTMENT_ID
HAVING
      AVG(SALARY) >= 10000;
      
-- 2. 동일한 부서번호(DEPARTMENT_ID)로 그룹화하기
--    동일한 부서번호를 기잔 사원들을 직업아이디(JOB_ID)로 다시 그룹화하기
--    즉, 부서별 직업아이디별로 그룹화하기
--    부서별 직업 아이디별로 그룹화하여 각 그룹의 사원수 조회하기
--    부서번호가 없는 사원은 제외하기

SELECT 
      DEPARTMENT_ID -- GROUP이 두개 있으면 둘다와도 되고 하나만 와도 됨 GROUP BY에는 꼭 두개 다 쓰기 
    , JOB_ID
    , COUNT(*) AS 사원수
FROM 
      EMPLOYEES
WHERE
      DEPARTMENT_ID IS NOT NULL
GROUP BY 
      DEPARTMENT_ID, JOB_ID
ORDER BY COUNT(*) ASC;

-- DEPARTMENT 테이블 연습
-- 1. 동일한 지역(LOCATION_ID)으로 그룹화하여 조회하기
SELECT 
        LOCATION_ID
    FROM
        DEPARTMENTS
        GROUP BY LOCATION_ID;

-- 2. 동일한 지역(LOCATION_ID)으로 그룹화하여 각 지역별 존재하는 부서수 조회하기
--      부서수가 2 이상인 지역만 조회하기
SELECT  LOCATION_ID, COUNT(*) AS 부서수
FROM    DEPARTMENTS
GROUP BY LOCATION_ID
HAVING COUNT(*) >= 2; --COUNT(*) -> 부서수 안됨

-- 3. 동일한 지역(LOCATION_ID)으로 그룹화하여 각 지역별 존재하는 부서수 조회하기
--    MANAGER_ID가 없는 지역은 제외하고 조회하기
SELECT LOCATION_ID, COUNT(*)
FROM DEPARTMENTS
WHERE MANAGER_ID IS NOT NULL
GROUP BY LOCATION_ID;

-- 4. 부서명(DEPARTMENT_NAME)의 첫 2글자로 그룹화하여 해당 그룹의 개수 조회하기
SELECT SUBSTR(DEPARTMENT_NAME, 1, 2), COUNT(*)
FROM DEPARTMENTS
GROUP BY SUBSTR(DEPARTMENT_NAME, 1, 2);

-- 5. 부서명(DEPARTMENT_NAME)의 첫 2글자로 그룹화하여 해당 그룹의 개수 조회하기
--    부서명의 첫 2글자가 'IT', 'Co'인 부서만 조회하기
SELECT SUBSTR(DEPARTMENT_NAME, 1, 2), COUNT(*)
FROM DEPARTMENTS
WHERE SUBSTR(DEPARTMENT_NAME, 1, 2) = 'IT'
   OR SUBSTR(DEPARTMENT_NAME, 1, 2) = 'Co'
GROUP BY SUBSTR(DEPARTMENT_NAME, 1, 2);

SELECT SUBSTR(DEPARTMENT_NAME, 1, 2), COUNT(*)
FROM DEPARTMENTS
WHERE SUBSTR(DEPARTMENT_NAME, 1, 2) IN('IT', 'Co') -- 못쓸때도 있음 NAME LILE IN('김%', '이%')
GROUP BY SUBSTR(DEPARTMENT_NAME, 1, 2);



