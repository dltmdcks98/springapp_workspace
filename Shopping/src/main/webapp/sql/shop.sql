계정은 system 계정으로 접속
conn system/1234
계정 비번을 잊었을때 
sqlplus > sys/ as sysdba로 접속 oracle을 설치한 계정만 가능 

tablespace 만들기
경로C:\oraclexe\app\oracle\oradata\XE로 넣어야 안전 
SQL> create tablespace shop
  2  datafile 'C:\oraclexe\app\oracle\oradata\XE\shop.dbf'
  3  size 10M;
  
  유저 생성
  SQL> create user client
  2  identified by 1234
  3  default tablespace shop
  4  quota unlimited on shop;
  
  권한 부여
   grant create table, create sequence, create session to client;
   
   테이블 생성
   create table admin(
 admin_id number primary key,
 user_id varchar(30),
 pass varchar(80),
 name varchar(30)
)

시퀀스 
create sequence seq_admin
increment by 1
start with 1


--상위 카테고리
CREATE TABLE topcategory(
	topcategory_id number primary key,
	category_name varchar(30)
);

--하위 카테고리
CREATE TABLE subcategory(
	subcategory_id number primary key,
	category_name varchar(30),
	topcategory_id number,
	constraint fk_topcategory_subcategory foreign key(topcategory_id) 
	references topcategory(topcategory_id)
);

--상품
CREATE TABLE product(
	product_id number primary key,
	product_name varchar(80),
	brand varchar(30),
	price number default 0,
	discount number default 0,
	memo varchar(1000),
	detail clob,
	product_img varchar(100),
	subcategory_id number,
	constraint fk_subcategory_product foreign key(subcategory_id)
	references subcategory(subcategory_id)
);

--시퀀스
create sequence seq_topcategory
increment by 1 
start with 1;

create sequence seq_subcategory
increment by 1 
start with 1;

create sequence seq_product
increment by 1 
start with 1;



