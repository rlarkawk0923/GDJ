-- 날짜 함수

-- 1. 현재 날짜와 시간
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;

-- 2. 원하는 형식으로 날짜와 시간 조회
--    TO_CHAR 함수 : 날짜를 문자로 변환해서 조회
SELECT
        TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS') -- 12시간 AM이나 PM 둘중하나 오전오후
      , TO_CHAR(SYSDATE, 'YYYY-MM-DD PM HH24:MI:SS') --24시간
FROM DUAL;

-- 3. 단위(년,월,일,시,분,초) 추출 함수
--    EXTRACT(단위 FROM 날짜)
SELECT
        EXTRACT(YEAR FROM SYSDATE) AS 년도
      , EXTRACT(MONTH FROM SYSDATE) AS 월
      , EXTRACT(DAY FROM SYSTIMESTAMP) AS 일
      , EXTRACT(HOUR FROM SYSTIMESTAMP) AS 시 -- UTC(세계 표준시) 기준
      , EXTRACT(MINUTE FROM SYSTIMESTAMP) AS 분
      , EXTRACT(SECOND FROM SYSTIMESTAMP) AS 초
      , EXTRACT(TIMEZONE_HOUR FROM SYSTIMESTAMP) AS 시 -- TIMEZONE 설정이 필요
      , FLOOR(EXTRACT(SECOND FROM SYSTIMESTAMP)) AS 초
FROM DUAL;

-- 단위(년,월,일,시,분,초) 추출은 꼭 EXTRACT 쓸 필요는 없음
-- TO_CHAR
SELECT
        TO_CHAR(SYSDATE, 'YYYY')
        , TO_CHAR(SYSDATE, 'MM')
        , TO_CHAR(SYSDATE, 'DD')
        , TO_CHAR(SYSDATE, 'HH24')
        , TO_CHAR(SYSDATE, 'MI')
        , TO_CHAR(SYSDATE, 'SS')
        
FROM DUAL;

-- 4. 날짜 연산
--  1) 하루(1일)를 숫자 1로 처리
--     (12시간을 숫자 0.5로 처리)
--  2) 특정 단위 후 날짜
--      (1)1년 후 : + 365, 별도 함수 없음
--      (2)1개월 후 : ADD_MONTHS 함수 사용
--      (3)1일 후   : +1, 별도 함수 없음

SELECT
        SYSDATE - 1 AS 어제
      , SYSDATE + 1 AS 내일
      , SYSDATE - 0.5 AS "12시간전" --칼럼이름 숫자로 시작할수없음
      , TO_CHAR(SYSDATE - 0.5, 'MM/DD AM HH:MI:SS') AS "12시간전"
      , TO_CHAR(SYSDATE + 0.5, 'MM/DD AM HH:MI:SS') AS "12시간후"
      , TO_CHAR(SYSDATE + (1/ 24), 'MM/DD AM HH:MI:SS') AS "1시간후"
FROM
     DUAL;
     
-- 5. N개월 전후 날짜
--    ADD_MONTHS(날짜, N)
SELECT
      ADD_MONTHS(SYSDATE, -1) AS "1개월전"
    , ADD_MONTHS(SYSDATE, 1) AS "1개월후"
FROM DUAL;

-- 6. 경과한 개월 수
--    MONTHS_BETWEEN(최근날짜, 이전날짜) : 두 날짜 사이의 경과한 개월 수
SELECT
        MONTHS_BETWEEN(SYSDATE, HIRE_DATE)
FROM
        EMPLOYEE;