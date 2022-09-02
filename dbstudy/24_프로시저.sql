/*

    프로시저
    
    1. PROCEDURE
    2. 여러 개의 쿼리문을 한 번에 실행
        (이체 : UPDATE문 2개)
    3. 작성된 프로시저는 EXECUTE문으로 실행
        EXECUTE 프로시저();
    4. 형식
        CREATE [OR REPLACE] 프로시저_이름(매개변수)\
        IS  --  AS 가능
            변수선언(DECLARE 대신)
        BEGIN
            프로시저 본문
        [EXCEPTION
            예외처리]
        END 프로시저_이름;
*/