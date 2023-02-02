use ssafydb;

-- null을 무시하니깐 avg에도 null값은 반영x
select sum(salary), sum(commission_pct), avg(commission_pct)
	from employees;

select department_id, sum(salary), sum(commission_pct), avg(commission_pct)
	from employees
	group by department_id;

select *
	from employees
	group by department_id;
    
    select distinct department_id
    from employees;


-- 값이 무조건 들어와야함alter : not null
-- 값이 중복되면 안되 : unique
/*
create table tb_group(
	id int primary key,
    job varchar
    
);
*/

create table tb_group(
	id int,
    job char(1) not null,
    dept_no int not null,
    sal int,
    primary key(id)
);

insert into tb_group(id, job, dept_no, sal)
values (1,'a',10,1000), (2,'b',30,1050), (3,'b',30,1550), (4,'b',20,2550), (5,'a',30,1200);

select *
from tb_group;

select sum(sal), min(sal), max(sal)
from tb_group;

select dept_no, avg(sal)
from tb_group
group by dept_no, job
order by dept_no, job;

-- 트랜잭션
drop table tb_rean;

start transaction;

create table tb_rean(
	val varchar(10)
);

insert into tb_rean(val) values('ssss');
insert into tb_rean(val) values('cccc');

select *
	from tb_rean;
    
rollback;

-- 위에는 롤백
-- 아래는 적용
drop table tb_rean;

start transaction;

create table tb_rean(
	val varchar(10)
);

insert into tb_rean(val) values('ssss');
insert into tb_rean(val) values('cccc');

select *
	from tb_rean;
    
commit;
-- commit하면 트랜잭션 실행
select @@autocommit;
set @@autocommit = 0;

create table tb_test(
	no int auto_increment,
    name varchar(30) not null,
    content varchar(100),
    primary key(no)
);

drop table tb_test;

select *
from tb_test;
