CREATE TABLE sort
(sid INT PRIMARY KEY AUTO_INCREMENT,
sname VARCHAR(100),
sprice DOUBLE,
sdesc VARCHAR(4000)
);

INSERT INTO sort(sname,sprice,sdesc) VALUES ('�ҵ�',2000,'�Żݴ����');
INSERT INTO sort(sname,sprice,sdesc) VALUES ('�Ҿ�',5000,'�Ҿ߼۸��ϵ���ԭ�����Ǽ�');
INSERT INTO sort(sname,sprice,sdesc) VALUES ('��ͯ���',300,'��������');
INSERT INTO sort(sname,sprice,sdesc) VALUES ('����',55,'��ζ����');
INSERT INTO sort(sname,sprice,sdesc) VALUES ('ϴ��Һ',10,'ϴ��Һ����');
INSERT INTO sort(sname,sprice,sdesc) VALUES ('��װ',99,'��װ����');


CREATE TABLE USERS(
ID INT PRIMARY KEY AUTO_INCREMENT,
USERNAME VARCHAR(100),
PASSWORD VARCHAR(100));

INSERT INTO USERS (USERNAME,PASSWORD)VALUES('REDSMART','123456');
INSERT INTO USERS (USERNAME,PASSWORD)VALUES('JOHN','654321');

SELECT * FROM USERS
WHERE USERNAME = 'REDSMART'
AND PASSWORD = '1' OR 1=1;