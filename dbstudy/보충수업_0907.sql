-- 1. ���� ������ �а� ������ ���̺��� �����ϵ�, �⺻Ű/�ܷ�Ű�� ������ �������� ���ÿ�.

DROP TABLE ORDERS;
DROP TABLE CUSTOMER;
DROP TABLE BOOK;

-- 1) BOOK ���̺�
--    (1) BOOK_ID : å ���̵�, ���� (�ִ� 11�ڸ�), �ʼ�
--    (2) BOOK_NAME : å �̸�, ���� ���� ���� (�ִ� 100 BYTE)
--    (3) PUBLISHER : ���ǻ�, ���� ���� ���� (�ִ� 50 BYTE)
--    (4) PRICE : ����, ���� (�ִ� 6�ڸ�)
CREATE TABLE BOOK(
    BOOK_ID   NUMBER(11) NOT NULL,
    BOOK_NAME VARCHAR2(100 BYTE),
    PUBLISHER VARCHAR2(50 BYTE),
    PRICE     NUMBER(6)
);

-- 2) CUSTOMER ���̺�
--    (1) CUSTOMER_ID : �� ���̵�, ���� (�ִ� 11�ڸ�), �ʼ�
--    (2) CUSTOMER_NAME : �� �̸�, ���� ���� ���� (�ִ� 20 BYTE)
--    (3) ADDRESS : �� �ּ�, ���� ���� ���� (�ִ� 50 BYTE)
--    (4) PHONE : �� ��ȭ, ���� ���� ���� (�ִ� 20 BYTE)
CREATE TABLE CUSTOMER(
    CUSTOMER_ID   NUMBER(11) NOT NULL,
    CUSTOMER_NAME VARCHAR2(20 BYTE),
    ADDRESS       VARCHAR2(50 BYTE),
    PHONE         VARCHAR2(20 BYTE)
);

-- 3) ORDERS ���̺�
--    (1) ORDER_ID : �ֹ� ���̵�, ���� (�ִ� 11�ڸ�), �ʼ�
--    (2) CUSTOMER_ID : �� ���̵�, ���� (�ִ� 11�ڸ�)
--    (3) BOOK_ID : å ���̵�, ���� (�ִ� 11�ڸ�)
--    (4) AMOUNT : �Ǹż���, ���� (�ִ� 2�ڸ�)
--    (5) ORDER_DATE : �ֹ���, ��¥
CREATE TABLE ORDERS(
    ORDER_ID    NUMBER(11) NOT NULL,
    CUSTOMER_ID NUMBER(11),
    BOOK_ID     NUMBER(11),
    AMOUNT      NUMBER(2),
    ORDER_DATE  DATE
);

-- 4) �Ʒ� INSERT ���� ���� ���� �״�� ����Ѵ�. (����Ŭ INSERT ���)
INSERT ALL
    INTO BOOK(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES (1, '�౸�ǿ���', '�½�����', 7000)
    INTO BOOK(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES (2, '�౸�ƴ� ����', '������', 13000)
    INTO BOOK(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES (3, '�౸�� ����', '���ѹ̵��', 22000)
    INTO BOOK(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES (4, '���� ���̺�', '���ѹ̵��', 35000)
    INTO BOOK(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES (5, '�ǰ� ����', '�½�����', 6000)
    INTO BOOK(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES (6, '���� �ܰ躰 ���', '�½�����', 6000)
    INTO BOOK(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES (7, '�߱��� �߾�', '�̻�̵��', 20000)
    INTO BOOK(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES (8, '�߱��� ��Ź��', '�̻�̵��', 13000)
    INTO BOOK(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES (9, '�ø��� �̾߱�', '�Ｚ��', 7500)
    INTO BOOK(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES (10,'�ø��� è�Ǿ�', '�Ǿ', 13000)
SELECT * FROM DUAL;

INSERT ALL
    INTO CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME, ADDRESS, PHONE) VALUES (1, '������', '���� ��ü��Ÿ', '000-5000-0001')
    INTO CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME, ADDRESS, PHONE) VALUES (2, '�迬��', '���ѹα� ����', '000-6000-0001')
    INTO CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME, ADDRESS, PHONE) VALUES (3, '��̶�', '���ѹα� ������', '000-7000-0001')
    INTO CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME, ADDRESS, PHONE) VALUES (4, '�߽ż�', '�̱� �ػ罺', '000-8000-0001')
    INTO CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME, ADDRESS, PHONE) VALUES (5, '�ڼ���', '���ѹα� ����', NULL)
SELECT * FROM DUAL;

INSERT ALL 
    INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, AMOUNT, ORDER_DATE) VALUES (1, 1, 1, 1, '2014-07-01')
    INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, AMOUNT, ORDER_DATE) VALUES (2, 1, 3, 2, '2014-07-03')
    INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, AMOUNT, ORDER_DATE) VALUES (3, 2, 5, 1, '2014-07-03')
    INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, AMOUNT, ORDER_DATE) VALUES (4, 3, 6, 2, '2014-07-04')
    INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, AMOUNT, ORDER_DATE) VALUES (5, 4, 7, 3, '2014-07-05')
    INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, AMOUNT, ORDER_DATE) VALUES (6, 1, 2, 5, '2014-07-07')
    INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, AMOUNT, ORDER_DATE) VALUES (7, 4, 8, 2, '2014-07-07')
    INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, AMOUNT, ORDER_DATE) VALUES (8, 3, 10, 2, '2014-07-08')
    INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, AMOUNT, ORDER_DATE) VALUES (9, 2, 10, 1, '2014-07-09')
    INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, AMOUNT, ORDER_DATE) VALUES (10, 3, 6, 4, '2014-07-10')
SELECT * FROM DUAL;

COMMIT;
-- 2. BOOK, CUSTOMER, ORDERS ���̺��� BOOK_ID, CUSTOMER_ID, ORDER_ID Į���� �⺻Ű�� �߰��Ͻÿ�.
-- �⺻Ű ���������� �̸��� PK_BOOK, PK_CUSTOMER, PK_ORDERS���� �����Ͻÿ�.
ALTER TABLE BOOK
    ADD CONSTRAINT PK_BOOK PRIMARY KEY(BOOK_ID);
ALTER TABLE CUSTOMER
    ADD CONSTRAINT PK_CUSTOMER PRIMARY KEY(CUSTOMER_ID);
ALTER TABLE ORDERS
    ADD CONSTRAINT PK_ORDERS PRIMARY KEY(ORDER_ID);


-- 3. ORDERS ���̺��� CUSTOMER_ID, BOOK_ID Į���� ���� CUSTOMER ���̺�� BOOK ���̺��� ������ �ܷ�Ű�� �߰��Ͻÿ�.
-- �ܷ�Ű ���������� �̸��� FK_ORDERS_CUSTOMER, FK_ORDERS_BOOK�� �����Ͻÿ�.
-- CUSTOMER_ID�� BOOK_ID�� �����Ǵ� ��� �̸� �����ϴ� ORDERS ���̺��� ������ NULL�� ó���Ͻÿ�.
ALTER TABLE ORDERS
    ADD CONSTRAINT FK_ORDERS_CUSTOMER FOREIGN KEY(CUSTOMER_ID)
        REFERENCES CUSTOMER(CUSTOMER_ID)
            ON DELETE SET NULL;
ALTER TABLE ORDERS
    ADD CONSTRAINT FK_ORDERS_BOOK FOREIGN KEY(BOOK_ID)
        REFERENCES BOOK(BOOK_ID)
            ON DELETE SET NULL;


-- 4. 2014�� 7�� 4�Ϻ��� 7�� 7�� ���̿� �ֹ� ���� ������ �����ϰ� ������ ��� �ֹ� ������ ��ȸ�Ͻÿ�.
--    ��ȸ�� ������ : �ֹ���ȣ, �ֹ��ڸ�, å�̸�, �ǸŰ���, �ֹ�����
-- ���Ź�ȣ ������  å�̸�           �ǸŰ��� �ֹ�����
-- 1        ������  �౸�� ����      7000     14/07/01
-- 2        ������  �౸�� ����      44000    14/07/03
-- 3        �迬��  �ǰ� ����        6000     14/07/03
-- 10       ��̶�  ���� �ܰ躰 ��� 24000    14/07/10
-- 9        �迬��  �ø��� è�Ǿ�    13000    14/07/09
-- 8        ��̶�  �ø��� è�Ǿ�    26000    14/07/08
-- ANSI
SELECT O.ORDER_ID AS ���Ź�ȣ
    , C.CUSTOMER_NAME AS ������
    , B.BOOK_NAME AS å�̸�
    , B.PRICE * O.AMOUNT AS �ǸŰ���
    , O.ORDER_DATE AS �ֹ�����
FROM CUSTOMER C INNER JOIN ORDERS O
ON C.CUSTOMER_ID = O.CUSTOMER_ID INNER JOIN BOOK B
ON B.BOOK_ID = O.BOOK_ID -- ��ü��ȸ
WHERE O.ORDER_DATE NOT BETWEEN '14/07/04' AND '14/07/07';
-- WHERE TO_DATE(O.ORDER_DATE) NOT BETWEEN TO_DATE('14/07/04', 'YY/MM/DD') AND TO_DATE('17/07/07', 'YY/MM/DD')

-- ORACLE
SELECT O.ORDER_ID AS ���Ź�ȣ
    , C.CUSTOMER_NAME AS ������
    , B.BOOK_NAME AS å�̸�
    , B.PRICE * O.AMOUNT AS �ǸŰ���
    , O.ORDER_DATE AS �ֹ�����
FROM CUSTOMER C, ORDERS O, BOOK B
WHERE C.CUSTOMER_ID = O.CUSTOMER_ID -- �������� ����, �Ϲ����� ���߿� ��ġ
AND B.BOOK_ID = O.BOOK_ID -- ��ü��ȸ
AND O.ORDER_DATE NOT BETWEEN '14/07/04' AND '14/07/07';

-- 5. ��� ���� ���� �̸��� �ѱ��ž�(PRICE * AMOUNT)�� ��ȸ�Ͻÿ�. -- �̸����� ����, GROUP BY ���� �̸� �ٸ���������� ��츦 ����� �̸����� �׷�ȭ�ϴ°��� �ٶ������� ���� ID������ �׷�ȭ�� ��ġ���� ID�� NAME������ �׷�ȭ�ϱ�
-- ���� �̷��� �ִ� ���� ��ȸ�Ͻÿ�.(�ֹ������� �ְ� ����Ͽ�)
-- ����  �ѱ��ž�
-- ������  116000
-- �߽ż�  86000
-- ��̶�  62000
-- �迬��  19000
SELECT C.CUSTOMER_NAME AS ����
    , SUM(B.PRICE * O.AMOUNT) AS �ѱ��ž�
    FROM CUSTOMER C INNER JOIN ORDERS O
    ON C.CUSTOMER_ID = O.CUSTOMER_ID INNER JOIN BOOK B
    ON B.BOOK_ID = O.BOOK_ID
GROUP BY C.CUSTOMER_ID, C.CUSTOMER_NAME;
 
-- 6. ��� ���� ���� �̸��� �ѱ��ž�(PRICE * AMOUNT)�� ����Ƚ���� ��ȸ�Ͻÿ�.
-- ���� �̷��� ���� ���� �ѱ��žװ� ����Ƚ���� 0���� ��ȸ�Ͻÿ�.(���� ��� ��ȸ, �ֹ������� �ִ� �ڷḸ ��ȸ = ���� �ܺ�����)
-- ����ȣ������ �������� �����Ͽ� ��ȸ�Ͻÿ�.
-- ����  �ѱ��ž�  ����Ƚ��
-- ������  116000     3
-- �迬��  19000      2
-- ��̶�  62000      3
-- �߽ż�  86000      2
-- �ڼ���  0          0
SELECT C.CUSTOMER_NAME AS ����
    , NVL(SUM(B.PRICE * O.AMOUNT), 0) AS �ѱ��ž�
    , COUNT(O.ORDER_ID) AS ����Ƚ�� --COUNT(*)(X)���� �������� ���ԵǸ� �ȵ�(���̸��� 1������ ��) �ֹ��� ������ �ο��Ǵ� ��ȣ�� ����
    FROM CUSTOMER C LEFT OUTER JOIN ORDERS O
    ON C.CUSTOMER_ID = O.CUSTOMER_ID LEFT OUTER JOIN BOOK B
    ON B.BOOK_ID = O.BOOK_ID
GROUP BY C.CUSTOMER_ID, C.CUSTOMER_NAME
ORDER BY C.CUSTOMER_ID ASC;

-- 7. '�迬��'�� ������ ���������� ��ȸ�Ͻÿ�.
-- ����  ���ŵ�����
-- �迬��  2
SELECT C.CUSTOMER_NAME AS ���� -- 2�� ����
    , COUNT(*) AS ���ŵ�����
FROM CUSTOMER C INNER JOIN ORDERS O
ON C.CUSTOMER_ID = O.CUSTOMER_ID
WHERE C.CUSTOMER_NAME = '�迬��'-- WHERE�� ���ָ� ��� ��
GROUP BY C.CUSTOMER_ID, C.CUSTOMER_NAME;

-- 8. '������'�� ������ ������ �߰��� ���ǻ�(PUBLISHER) ������ ��ȸ�Ͻÿ�. --3�� ����
-- ����  ���ǻ��
-- ������  3
SELECT C.CUSTOMER_NAME AS ����
    ,COUNT(DISTINCT B.PUBLISHER) AS ���ǻ�� -- DISTINCT Į�� �̸� �տ� ��,COUNT�ȿ� �� �� ����
    FROM CUSTOMER C INNER JOIN ORDERS O
    ON C.CUSTOMER_ID = O.CUSTOMER_ID INNER JOIN BOOK B
    ON B.BOOK_ID = O.BOOK_ID
    WHERE C.CUSTOMER_NAME = '������'   
GROUP BY C.CUSTOMER_ID, C.CUSTOMER_NAME;

-- 9. �ֹ��� �̷��� ���� ���� �̸��� ��ȸ�Ͻÿ�.
-- ����
-- �ڼ���
SELECT C.CUSTOMER_NAME AS ����
FROM CUSTOMER C LEFT OUTER JOIN ORDERS O
ON C.CUSTOMER_ID = O.CUSTOMER_ID
GROUP BY C.CUSTOMER_ID, C.CUSTOMER_NAME-- �ߺ�����
HAVING COUNT(O.ORDER_ID) = 0;-- �����Լ��� WHERE���ȵż� HAVING��

SELECT C.CUSTOMER_NAME AS ����
FROM CUSTOMER C LEFT OUTER JOIN ORDERS O
ON C.CUSTOMER_ID = O.CUSTOMER_ID
WHERE O.ORDER_ID IS NULL
GROUP BY C.CUSTOMER_ID, C.CUSTOMER_NAME;-- �ߺ�����


-- 10. ���� �ֱٿ� ������ ���� �̸��� ���ų���(å�̸�, �ֹ�����)�� ��ȸ�Ͻÿ�.
-- ����  å�̸�            �ֹ�����
-- ��̶�  ���� �ܰ躰 ���  14/07/10
SELECT C.CUSTOMER_NAME AS ����
    , B.BOOK_NAME AS å�̸�
    , O.ORDER_DATE AS �ֹ�����
    FROM CUSTOMER C INNER JOIN ORDERS O
    ON C.CUSTOMER_ID = O.CUSTOMER_ID INNER JOIN BOOK B
    ON B.BOOK_ID = O.BOOK_ID
    WHERE O.ORDER_DATE = (SELECT MAX(O.ORDER_DATE) FROM ORDERS);

-- 11. �����ϴ� ��� ���� �߿��� ���� ��� ������ ������ ���� �̸��� ���ų���(å�̸�, ����)�� ��ȸ�Ͻÿ�.
-- ������ ���� ���ٸ� �� �̸��� NULL�� ó���Ͻÿ�.(å LEFT OUTER JOIN �ֹ� ...)
-- ����  å�̸�       å����
-- NULL    ���� ���̺�  35000
SELECT C.CUSTOMER_NAME AS ����
    , B.BOOK_NAME AS å�̸�
    , B.PRICE AS å����
    FROM BOOK B LEFT OUTER JOIN ORDERS O
    ON B.BOOK_ID = O.BOOK_ID LEFT OUTER JOIN CUSTOMER C
    ON C.CUSTOMER_ID = O.CUSTOMER_ID
    WHERE B.PRICE = (SELECT MAX(PRICE) FROM BOOK);

-- 12. �ѱ��ž��� 2~3���� ���� �̸��� �ѱ��ž��� ��ȸ�Ͻÿ�.
-- ROWNUM PSEUDO-COLUMN�� �̿��Ͻÿ�.
-- ����  �ѱ��ž�
-- �߽ż�  86000
-- ��̶�  62000
SELECT B.����
    , B.�ѱ��ž�
FROM(SELECT ROWNUM AS ROW_NUM
              , A.����
         , A.�ѱ��ž�
    FROM(SELECT C.CUSTOMER_NAME AS ����
            , SUM(B.PRICE * O.AMOUNT) AS �ѱ��ž�
             FROM CUSTOMER C INNER JOIN ORDERS O
             ON C.CUSTOMER_ID = O.CUSTOMER_ID INNER JOIN BOOK B
            ON B.BOOK_ID = O.BOOK_ID
                GROUP BY C.CUSTOMER_ID, C.CUSTOMER_NAME) A) B
WHERE B.ROW_NUM BETWEEN 2 AND 3;