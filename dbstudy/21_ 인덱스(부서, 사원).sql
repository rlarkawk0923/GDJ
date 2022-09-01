/*
     인덱스
     
    1. INDEX
    2. 빠른 검색을 위해서 특정 칼럼에 인덱스를 등록함
    3. 인덱스가 등록된 칼럼은 검색이 빠름
    4. 인덱스가 자동으로 등록되는 경우
        1) PK로 지정한 칼럼 -- 같은 값이면 PK로 조회
        2) UNIQUE 제약조건을 가진 칼럼
    5. 수정(갱신)이 자주 발생하는 칼럼에 인덱스를 부여하면 도리어 성능이 떨어짐
    6. 인덱스 생성
        1) 비고유 인덱스(칼럼 내용에 중복이 있는 경우) -- 사원번호가 제일 빠르지만 사원이름으로 조회를 제일 많이할때 칼럼 내용에 중복있을 수 있음 중복있기때문에 비고유 인덱스
        CREATE INDEX 인덱스_이름 ON 테이블_이름(어떤칼럼_이름);
        2) 고유 인덱스(칼럼 내용에 중복이 없는 경우) - 자동으로 등록되기때문에 만드는 경우 별로없음
        CREATE UNIQUE INDEX 인덱스_이름 ON 테이블_이름(칼럼_이름);
        

*/

-- 인덱스 조회
-- 접속한 사용자가 작성한 인덱스는 USER_INDEXES 데이터 사전에서 확인
DESC USER_INDEXES;
SELECT INDEX_NAME, TABLE_NAME
    FROM USER_INDEXES;
    
-- 인덱스 칼럼 조회
-- 사용자가 작성한 인덱스가 동작하는 칼럼 확인은 USER_IDN_COLUMNS 데이터 사전에서 확인
DESC USER_IND_COLUMNS;
--인덱스 생성
CREATE INDEX IDX_NAME ON EMPLOYEE(NAME);

-- 인덱스 삭제
DROP INDEX IDX_NAME;

/*
- CODE는 PK, VARCHAR2 타입
WHERE CODE = '1'

WHERE CODE =1(동작함)

WHERE TO_NUMBER(CODE) = 1(내부동작)
- TO_NUMBER() 함수로 인해 CODE의 인덱스를 사용할 수없음-함수개입으로 인덱스를 못씀- 검색 느려짐

- WHERE절 작성시 가급적 등호 왼쪽은 가공 안하는 것이 좋다.
*/