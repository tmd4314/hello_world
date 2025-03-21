select *
from   tab;

select *
from emp
order by empno desc;

select empno, 
       ename, 
       job, 
       mgr, 
       hiredate, 
       sal
from   emp 
order by empno desc;

insert into emp (empno,
                 ename,
                 job,
                 mgr,
                 hiredate,
                 sal)
values (9998, 
       '홍길동', 
       'CLERK', 
       7788, 
       '2020-01-01', 
       1000
    );
    
update emp
set    sal = 2000
       ,deptno = 10
where  empno = 9998;
    
delete from emp
where  empno = 9999;
    
rollback;
commit;


-- table 생성.
-- 도서코드, 도서명, 저자, 출판사, 도서가격
create table tbl_book (
     book_code       varchar2(5) primary key,
     book_title      varchar2(50) not null,
     author          varchar2(30) not null,
     company         varchar2(30) not null,
     price           number default 1000
);

create sequence book_seq;
select book_seq.nextval from dual;

select *
from   tbl_book;    

insert into tbl_book(book_code,
                     book_title,
                     author,
                     company,
                     price)
values (book_seq.nextval,
        '자바1',
        '신용이',
        '한빛출판사',
        25000);

insert into tbl_book(book_code,
                     book_title,
                     author,
                     company,
                     price)
values (book_seq.nextval,
        '이것이 c++',
        '이민수',
        '한빛출판사',
        24000);
        
        
insert into tbl_book(book_code,
                     book_title,
                     author,
                     company,
                     price)
values (book_seq.nextval,
        '자바스크립트',
        '용이권',
        '청빛출판사',
        25000);
        
insert into tbl_book(book_code,
                     book_title,
                     author,
                     company,
                     price)
values (book_seq.nextval,
        '이것이 자바다2',
        '신권이',
        '적빛출판사',
        20000);

insert into tbl_book(book_code,
                     book_title,
                     author,
                     company,
                     price)
values (book_seq.nextval,
        '이것이 자바다',
        '이용권',
        '달빛출판사',
        24000);

rollback;
delete from tbl_book;

commit;

create table  tbl_member(
  user_id    varchar2(10) primary key,
  password   varchar2(30) not null,
  user_name  varchar(50)  not null
);


insert into tbl_member
values ('tmd4314', 
        'dltmdals1@', 
        '이승민');

insert into tbl_member
values ('user1', 
        '1234', 
        '홍길동');

insert into tbl_member
values ('user2', 
        '1111', 
        '강승동');


select *
from   tbl_member;











