--함수 확인용 기초데이터

DROP TABLE SAMPLE;
CREATE TABLE SAMPLE(
    NAME VARCHAR2(20 BYTE),
    KOR NUMBER(3),
    ENG NUMBER(3),
    MATH NUMBER(3)
);

INSERT INTO SAMPLE(NAME, KOR, ENG, MATH) VALUES(NULL, 100, 100, 100);
INSERT INTO SAMPLE(NAME, KOR, ENG, MATH) VALUES('영숙',NULL, 100, 100);
INSERT INTO SAMPLE(NAME, KOR, ENG, MATH) VALUES('정수', 100, NULL, 100);
INSERT INTO SAMPLE(NAME, KOR, ENG, MATH) VALUES('지영', 100, 100, NULL);

COMMIT;

-- NULL값의 연산에서 사용되면 결과가 NULL이다.
SELECT 1 + NULL FROM DUAL; --(테이블 명시해야하지만 테이블 생성하지 않는 DUAL)

-- NULL 처리 함수

-- 1. NVL(NULL VALUES) 함수
--    NVL(칼럼, 칼럼값이 NULL일때 대신 사용할 값)

-- NAME이 없으면 '아무개', KOR, ENG, MATH가 없으면 0으로 조회
SELECT
    NVL(NAME, '아무개') AS STU_NAME
   ,NVL(KOR, 0)
   ,NVL(ENG, 0)
   ,NVL(MATH,0)
FROM
    SAMPLE
/*WHERE
    STU_NAME != '아무개'*/--실행안됨 SELECT 절의 실행이 맨 마지막 -1이기때문에
ORDER BY
      STU_NAME ASC;--NVL(NAME, '아무개') ASC;--NULL값은 정렬했을때 맨아래로 정렬됨, 실행순서 기억하기
      
-- 이름과 총점을 조회하기
-- 이름이 없으면 '아무개', 점수가 없으면 0점 처리
-- 결과
-- 아무개 300, 영숙 정수 지영 200

SELECT
      NVL(NAME, '아무개')
     ,NVL(KOR, 0) + NVL(ENG,0) + NVL(MATH, 0) AS 총점
     ,KOR + ENG + MATH-- NULL값이 포함된 연산은 결과 NULL로 뜸
    FROM 
     SAMPLE;
     
-- 2. NVL2 함수 이거 아니면 이거 IF느낌
--    NVL2(칼럼, NULL이 아닐 때 사용할 값, NULL일 때 사용할 값)
--               타입 섞이면 조회 안 됨

SELECT
      NVL2(NAME, NAME || '님', '아무개') --NULL이 아니면 NAME 그대로 써라 NULL이면 아무개로 || = 자바의 '+'
     ,NVL2(KOR, '응시', '결시')
     ,NVL2(ENG, '응시', '결시')
     ,NVL2(MATH, '응시', '결시')
  FROM
      SAMPLE;
      
-- 집계함수 (그룹함수)
-- 1. 통계(합계, 평균, 최대, 최소, 개수 등)
-- 2. NULL값을 연산에서 제외한다.
-- 3. 종류
--    1) SUM(칼럼) : 칼럼 합계
--    2) AVG(칼럼) : 칼럼 평균
--    3) MAX(칼럼) : 칼럼 최대값
--    4) MIN(칼럼) : 칼럼 최소값
--    5) COUNT(칼럼) : 칼럼에 입력된 데이터의 개수

-- 각 칼럼(KOR, ENG, MATH)의 합계
SELECT
      SUM(KOR)
    , SUM(ENG)
    , SUM(MATH)
    , SUM(KOR + ENG + MATH) -- KOR + ENG + MATH와 같은 연산(SUM 함수를 잘 못 사용한 예시) ROW 단위 연산을 위해 사용하는거시아님 칼럼 연산용
--  , SUM(KOR, ENG, MATH) 인수(ARGUMENT)가 3개이므로 불가능함(인수 1개여야함)
    , SUM(KOR)+ SUM(ENG) + SUM(MATH) -- 국어합 + 영어합+수학합
FROM
     SAMPLE;
     
-- 각 칼럼(KOR, ENG, MATH)의 평균
SELECT
      AVG(KOR) -- NULL을 제외한 KOR의 평균
    , AVG(ENG) -- NULL을 제외한 ENG의 평균
    , AVG(MATH) -- NULL을 제외한 MATH의 평균
FROM
     SAMPLE;

-- NULL값은 결시를 의미하므로 0점 처리함
SELECT
      AVG(NVL(KOR, 0))
    , AVG(NVL(ENG, 0))
    , AVG(NVL(MATH, 0))
FROM
     SAMPLE;

-- 각 칼럼(KOR, ENG, MATH)의 최대값
SELECT
        MAX(KOR)
      , MAX(ENG)
      , MAX(MATH)
FROM 
    SAMPLE;

-- 각 칼럼(KOR, ENG, MATH)의 최소값
-- NULL 값은 결시를 의미하므로 0점 처리함
SELECT 
       MIN(NVL(KOR, 0))
     , MIN(NVL(ENG, 0))
     , MIN(NVL(MATH, 0))
FROM
     SAMPLE;
-- 국어 시험을 응시한 학생이 몇 명인가?
SELECT
      COUNT(KOR)
FROM
     SAMPLE;
-- 전체 학생은 몇명인가?(전체 ROW의 개수)
-- 특정 칼럼을 지정하지 않고 전체 칼럼(*)을 이용해서 전체 Row 개수를 구함
SELECT
      COUNT(*)
FROM
     SAMPLE;

-- 성명   국어 영어 수학 합계 평균
-- 아무개 100  100  100  300  100
-- 영숙    0   100  100  200  66.67
-- 정수   100  0    100  200  66.67
-- 지영   100  100  0    200  66.67

SELECT
      NVL(NAME, '아무개') AS 성명
    , NVL(KOR, 0) AS 국어
    , NVL(ENG, 0) AS 영어
    , NVL(MATH, 0) AS 수학
    , NVL(KOR, 0) +  NVL(ENG, 0) + NVL(MATH, 0) AS 합계
    , (NVL(KOR, 0) +  NVL(ENG, 0) + NVL(MATH, 0)) / 3 AS 평균
FROM SAMPLE;
