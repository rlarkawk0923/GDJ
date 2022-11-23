--회원 - 접속기록
--접속한 기록이 없는 회원도 조회할 수 있는 방법 : 외부조인

INSERT INTO SLEEP_USERS(USER_NO, ID, PW, NAME, GENDER, EMAIL, MOBILE, BIRTHYEAR, BIRTHDAY, POSTCODE, ROAD_ADDRESS, JIBUN_ADDRESS, DETAIL_ADDRESS, AGREE_CODE, SNS_TYPE, JOIN_DATE, LAST_LOGIN_DATE)
(SELECT U.USER_NO, U.ID, U.PW, U.NAME, U.GENDER, U.EMAIL, U.MOBILE, U.BIRTHYEAR, U.BIRTHDAY, U.POSTCODE, U.ROAD_ADDRESS, U.JIBUN_ADDRESS, U.DETAIL_ADDRESS, U.AGREE_CODE, U.SNS_TYPE, U.JOIN_DATE, A.LAST_LOGIN_DATE
  FROM USERS U LEFT OUTER JOIN ACCESS_LOG A
    ON U.ID = A.ID
 WHERE MONTHS_BETWEEN(SYSDATE, A.LAST_LOGIN_DATE) >= 12  -- 접속기록이 있는 회원
    OR (MONTHS_BETWEEN(SYSDATE, U.JOIN_DATE) >=12 AND A.LAST_LOGIN_DATE IS NULL));  -- 접속기록이 없는 회원
    
   <!-- 휴면처리2: 1년 이상 로그인 기록이 없으면 회원테이블에서 삭제 -->
      DELETE 
          FROM USERS
        WHERE ID IN (SELECT U.ID
                        FROM USERS U LEFT OUTER JOIN ACCESS_LOG A
                          ON U.ID = A.ID
                       WHERE MONTHS_BETWEEN(SYSDATE, A.LAST_LOGIN_DATE) >= 12
                          OR (MONTHS_BETWEEN(SYSDATE, U.JOIN_DATE) >=12 AND A.LAST_LOGIN_DATE IS NULL));

