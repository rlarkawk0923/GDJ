-- 1. 순위
--  1) RANK() OVER(ORDER BY 순위구할칼럼 ASC)  : 오름차순 순위, 낮은 값이 1등, ASC는 생략 가능 정렬시키고 랭크만 붙이는 늑김~
--  2) RANK() OVER(ORDER BY 순위구할칼럼 DESC) : 내림차순 순위, 높은 값이 1등
--  3) 같은 값이면 같은 등수(동점)로 처리

-- 1) EMPLOYEES 테이블의 사원 정부를 연봉이 높은 순으로 조회하기
--  연봉 순위를 함께 조회하기
SELECT
        RANK() OVER (ORDER BY SALARY DESC) AS 연봉순위
      , EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY
  FROM
        EMPLOYEES;
        
-- 2) EMPLOYEES 테이블의 사원 정보를 입사순으로 조회하기
--  먼저 입사한 사원이 1등
SELECT
        RANK() OVER (ORDER BY HIRE_DATE ASC) AS 입사순위
        , EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY
    FROM
        EMPLOYEES;
        
-- 2. 그룹화
--  OVER(PARTITION BY 그룹화칼럼)
--  그룹화작업을 수행하므로 집계함수(그룹함수)와 함께 사용이 가능합
SELECT 
        DISTINCT DEPARTMENT_ID -- 중복제거
      , SUM(SALARY) OVER(PARTITION BY DEPARTMENT_ID) AS 부서별연봉합계-- SALARY의 합계
      , FLOOR(AVG(SALARY) OVER(PARTITION BY DEPARTMENT_ID)) AS 부서별연봉평균
      , MAX(SALARY) OVER(PARTITION BY DEPARTMENT_ID) AS 부서별최대연봉
      , MIN(SALARY) OVER(PARTITION BY DEPARTMENT_ID) AS 부서별최저연봉
      , COUNT(*)    OVER(PARTITION BY DEPARTMENT_ID) AS 부서별사원수
FROM 
        EMPLOYEES
WHERE
        DEPARTMENT_ID IS NOT NULL; -- NULL값이 빠지면 INDEX사용 가능해짐
        
--RANK() 함수와 PARTITION BY를 함께 사용하면 그룹 내 순위 구하기 가능함
SELECT
        RANK() OVER(PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) AS 부서내연봉순위
      , EMPLOYEE_ID
      , FIRST_NAME
      , LAST_NAME
      , SALARY
      , DEPARTMENT_ID
FROM
        EMPLOYEES
ORDER BY
      DEPARTMENT_ID ASC;
        
    