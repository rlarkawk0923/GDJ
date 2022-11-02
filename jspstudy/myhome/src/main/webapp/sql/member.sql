DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE MEMBER_SEQ NOCACHE;

DROP TABLE MEMBER;
CREATE TABLE MEMBER (
	MEMBER_NO NUMBER NOT NULL,
	ID VARCHAR2(20 BYTE) NOT NULL UNIQUE,
	PW VARCHAR2(20 BYTE) NOT NULL,
	NAME VARCHAR2(20 BYTE),
	EMAIL VARCHAR2(100 BYTE) NOT NULL,
	REGISTED_DATE VARCHAR2(10 BYTE),
	CONSTRAINT PK_MEMBER PRIMARY KEY(MEMBER_NO)
);

INSERT INTO MEMBER VALUES
	(MEMBER_SEQ.NEXTVAL, 'admin', '1111', '관리자', 'admin@myhome.com', TO_CHAR(SYSDATE, 'YYYY-MM-DD'));
COMMIT