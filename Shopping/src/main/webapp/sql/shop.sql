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