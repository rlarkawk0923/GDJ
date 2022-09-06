
/*************************************************************************
* ������ ����Ǿ� �ִ� STUDENT(�л�), PROFESSOR(����), DEPARTMENT(�а�) ���̺� ����
*************************************************************************/
DROP TABLE STUDENT;
DROP TABLE PROFESSOR;
DROP TABLE DEPARTMENT;
/*************************************************************************
*                         STUDNET ���̺� ����
*************************************************************************/
CREATE TABLE STUDENT
        (STUDNO NUMBER(5) NOT NULL,
         NAME VARCHAR2(20 BYTE),
         USERID VARCHAR2(10 BYTE),
         GRADE VARCHAR2(1 BYTE),
         IDNUM VARCHAR2(13 BYTE),
         BIRTHDATE DATE,
         TEL VARCHAR2(13 BYTE),
         HEIGHT NUMBER(5,2),
         WEIGHT NUMBER(5,2),
         DEPTNO NUMBER(4),
         PROFNO NUMBER(4));
/*************************************************************************
*                        STUDNET ���̺� ������ �Է�
*************************************************************************/
INSERT INTO STUDENT VALUES
        (10101, '������', 'jun123', '4', '7907021369824',
        TO_DATE('02-01-1979','DD-MM-YYYY'), '051)781-2158', 176, 72, '101',9903);
INSERT INTO STUDENT VALUES
        (20101, '�̵���', 'Dals', '1', '8312101128467',
         TO_DATE('10-12-1983','DD-MM-YYYY'), '055)426-1752', 172, 64, '201',NULL);
INSERT INTO STUDENT VALUES
        (10102, '�ڹ̰�', 'ansel414', '1', '8405162123648',
        TO_DATE('16-05-1984','DD-MM-YYYY'), '055)261-8947', 168, 52, '101',NULL);
INSERT INTO STUDENT VALUES
        (10103, '�迵��', 'mandu', '3', '8103211063421',
        TO_DATE('11-01-1981','DD-MM-YYYY'), '051)824-9637', 170, 88 ,'101',9906);
INSERT INTO STUDENT VALUES
        (20102, '�ڵ���', 'Ping2', '1', '8511241639826',
        TO_DATE('24-11-1985','DD-MM-YYYY'), '051)742-6384', 182, 70, '201',NULL);
INSERT INTO STUDENT VALUES
        (10201, '������', 'simply', '2', '8206062186327',
        TO_DATE('06-06-1982','DD-MM-YYYY'), '055)419-6328', 164, 48, '102',9905);
INSERT INTO STUDENT VALUES
        (10104, '������', 'Gomo00', '2', '8004122298371',
        TO_DATE('12-04-1980','DD-MM-YYYY'), '055)418-9627', 161, 42, '101',9907);
INSERT INTO STUDENT VALUES
        (10202, '������', 'yousuk', '4', '7709121128379',
        TO_DATE('12-10-1977','DD-MM-YYYY'), '051)724-9618', 177, 92, '102',9905);
INSERT INTO STUDENT VALUES
        (10203, '�ϳ���', 'hanal', '1', '8501092378641',
        TO_DATE('18-12-1984','DD-MM-YYYY'), '055)296-3784', 160, 68, '102',NULL);
INSERT INTO STUDENT VALUES
        (10105, '������', 'YouJin12', '2', '8301212196482',
        TO_DATE('21-01-1983','DD-MM-YYYY'), '02)312-9838', 171, 54, '101',9907);
INSERT INTO STUDENT VALUES
        (10106, '������', 'seolly', '1', '8511291186273',
        TO_DATE('29-11-1985','DD-MM-YYYY'), '051)239-4861', 186, 72, '101',NULL);
INSERT INTO STUDENT VALUES
        (10204, '������', 'Samba7', '3', '7904021358671',
        TO_DATE('02-04-1979','DD-MM-YYYY'), '053)487-2698', 171, 70, '102',9905);
INSERT INTO STUDENT VALUES
        (10107, '�̱���', 'huriky', '4', '8109131276431',
        TO_DATE('13-10-1981','DD-MM-YYYY'), '055)736-4981', 175, 92, '101',9903);
INSERT INTO STUDENT VALUES
        (20103, '������', 'lovely', '2', '8302282169387',
        TO_DATE('28-02-1983','DD-MM-YYYY'), '052)175-3941', 166, 51, '201',9902);
INSERT INTO STUDENT VALUES
        (20104, '������', 'Rader214', '1', '8412141254963',
        TO_DATE('16-09-1984','DD-MM-YYYY'), '02)785-6984', 184, 62, '201',NULL);
INSERT INTO STUDENT VALUES
        (10108, '������', 'cleanSky', '2', '8108192157498',
        TO_DATE('19-08-1981','DD-MM-YYYY'), '055)248-3679', 162, 72, '101',9907);
/*************************************************************************
*                         PROFESSOR ���̺� ����
*************************************************************************/
CREATE TABLE PROFESSOR
        (PROFNO NUMBER(4) NOT NULL,
         NAME VARCHAR2(10 BYTE),
         USERID VARCHAR2(10 BYTE),
         POSITION VARCHAR2(20 BYTE),
         SAL NUMBER(10),
         HIREDATE DATE,
         COMM NUMBER(2),
         DEPTNO NUMBER(4));
/*************************************************************************
*                        PROFESSOR ���̺� ������ �Է�
*************************************************************************/
INSERT INTO PROFESSOR VALUES
        (9901, '�赵��', 'capool', '����', 500,
        TO_DATE('24-01-1982','DD-MM-YYYY'), 20, 101);
INSERT INTO PROFESSOR VALUES
        (9902, '�����', 'sweat413', '������', 320,
        TO_DATE('12-04-1995','DD-MM-YYYY'), NULL, 201);
INSERT INTO PROFESSOR VALUES
        (9903, '������', 'Pascal', '������', 360,
        TO_DATE('17-05-1993','DD-MM-YYYY'), 15, 101);
INSERT INTO PROFESSOR VALUES
        (9904, '���Ͽ�', 'Blue77', '���Ӱ���', 240,
        TO_DATE('02-12-1998','DD-MM-YYYY'), NULL, 102);
INSERT INTO PROFESSOR VALUES
        (9905, '������', 'Refresh', '����', 450,
        TO_DATE('08-01-1986','DD-MM-YYYY'), 25, 102);
INSERT INTO PROFESSOR VALUES
        (9906, '�̸���', 'Pocari', '�α���', 420,
        TO_DATE('13-09-1988','DD-MM-YYYY'), NULL, 101);
INSERT INTO PROFESSOR VALUES
        (9907, '������', 'Totoro', '���Ӱ���', 210,
        TO_DATE('01-06-2001','DD-MM-YYYY'), NULL, 101);
INSERT INTO PROFESSOR VALUES
        (9908, '������', 'Bird13', '�α���', 400,
        TO_DATE('18-11-1990','DD-MM-YYYY'), 17, 202);
/*************************************************************************
*                          DEPARTMENT ���̺� ����
*************************************************************************/
CREATE TABLE DEPARTMENT
        (DEPTNO NUMBER(4),
         DNAME VARCHAR2(30 BYTE),
         COLLEGE NUMBER(4),
         LOC VARCHAR2(10 BYTE));
/*************************************************************************
*                        DEPARTMENT ���̺� ������ �Է�
*************************************************************************/
INSERT INTO DEPARTMENT VALUES
        (101, '��ǻ�Ͱ��а�', 100, '1ȣ��');
INSERT INTO DEPARTMENT VALUES
        (102, '��Ƽ�̵���а�', 100, '2ȣ��');
INSERT INTO DEPARTMENT VALUES
        (201, '���ڰ��а�', 200, '3ȣ��');
INSERT INTO DEPARTMENT VALUES
        (202, '�����а�', 200, '4ȣ��');
INSERT INTO DEPARTMENT VALUES
        (100, '�����̵���к�', 10, NULL);
INSERT INTO DEPARTMENT VALUES
        (200, '��īƮ�δн��к�', 10, NULL);
INSERT INTO DEPARTMENT VALUES
        (10, '��������', NULL, NULL);
/*************************************************************************
*                        �⺻Ű, �ܷ�Ű ��������
*************************************************************************/
ALTER TABLE STUDENT ADD CONSTRAINT PK_STUDENT PRIMARY KEY(STUDNO);
ALTER TABLE PROFESSOR ADD CONSTRAINT PK_PROFESSOR PRIMARY KEY(PROFNO);
ALTER TABLE DEPARTMENT ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY(DEPTNO);
ALTER TABLE STUDENT ADD CONSTRAINT FK_STUDENT_PROFESSOR FOREIGN KEY(PROFNO) REFERENCES PROFESSOR(PROFNO);
ALTER TABLE STUDENT ADD CONSTRAINT FK_STUDENT_DEPARTMENT FOREIGN KEY(DEPTNO) REFERENCES DEPARTMENT(DEPTNO);
ALTER TABLE PROFESSOR ADD CONSTRAINT FK_PROFESSOR_DEPARTMENT FOREIGN KEY(DEPTNO) REFERENCES DEPARTMENT(DEPTNO);

SET SERVEROUTPUT ON;

--���ν��� �ۼ�
-- �а���ȣ(DEPTNO) �����ϸ� �Ҽ� �л�, ����, �а�, ��� �����ϴ� ���ν��� �����
-- ���ν��� ������ �а� ��ȣ = 101 �а��� ������� ����
-- ���ν��� �̸��� my_proc
-- ���� �߻� �� �����ڵ� ��� + ���ܸ޽��� ��� + ROLLBACK

CREATE OR REPLACE PROCEDURE MY_PROC(DNO IN DEPARTMENT.DEPTNO%TYPE)
IS -- AS�� ���� DECLARE(X)
BEGIN
    DELETE FROM STUDENT WHERE DEPTNO = DNO;
    DELETE FROM PROFESSOR WHERE DEPTNO = DNO;
    DELETE FROM DEPARTMENT WHERE DEPTNO = DNO;
    COMMIT;
EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE(SQLCODE);
            DBMS_OUTPUT.PUT_LINE(SQLERRM);
END MY_PROC;

EXECUTE MY_PROC(101);

-- ����� �Լ�
-- �л� ���̵� �����ϸ� �ش� �л��� �й��� ��ȯ�ϴ� �Լ� �����
-- ���̵� 'jun123'�� �����ϸ� �й� '10101'�� ��ȯ�Ǵ��� Ȯ��
-- �Լ��̸� GET_STUDENT

CREATE OR REPLACE FUNCTION GET_STUDENT(UID STUDENT.USERID%TYPE)
RETURN NUMBER -- ��ȯ�ϴ� �й��� Ÿ���� NUMBER(5)�̹Ƿ�
IS
    SNO STUDENT.STUDNO%TYPE;
BEGIN
    SELECT STUDNO
    INTO SNO --SNO�� ����
    FROM STUDENT
    WHERE USERID = UID;
    RETURN SNO;
END GET_STUDENT;

SELECT GET_STUDENT('Dals')
FROM STUDENT;

SELECT DISTINCT GET_STUDENT('Dals')--����� �ߺ�����
FROM STUDENT;

SELECT GET_STUDENT(USERID) -- ����� 1��
FROM STUDENT
WHERE USERID = 'Dals';

-- Ʈ����
-- ����SAMPLE ���̺��� ���� ����, ���� ���� 'SampleTrg ����' ���� �޽��� ����ϱ�
CREATE OR REPLACE TRIGGER SampleTrg
    AFTER 
    UPDATE OR DELETE
    ON SAMPLE
    FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('SampleTrg ����');
END SampleTrg;

--�л���, �а���, ��米���� ��ȸ�ϱ� (��������)
--STUDENT   DEPARTMENT PROFESSOR
--DEPTNO    DEPTNO     DEPTNO

--ANSI (JOIN ���)
SELECT S.NAME
      , P.NAME
      , D.DNAME
    FROM STUDENT S INNER JOIN DEPARTMENT D
    ON S.DEPTNO = D.DEPTNO INNER JOIN PROFESSOR P
    ON P.DEPTNO = D.DEPTNO;

-- ORACLE (�޸�)
SELECT S.NAME
      , P.NAME
      , D.DNAME
    FROM STUDENT S, DEPARTMENT D, PROFESSOR P
   WHERE S.DEPTNO = D.DEPTNO
    AND P.DEPTNO = D.DEPTNO;