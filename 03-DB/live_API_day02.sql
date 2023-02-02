use ssafydb;
/*
 Dual 테이블의 정의

 1. 오라클 자체에서 제공되는 테이블

 2. 간단하게 함수를 이용해서 계산 결과값을 확인 할 때 사용하는 테이블

 

 3. SYS사용자가 소유하는 오라클의 표준 테이블 

 4. SYS사용자가 소유하지만 어느 사용자에서 접근 가능함
 */
-- 숫자관련 함수

 
select @@version;

select @@version
from dual;

-- 절대값
select abs(-5), abs(5), abs(+5)
from dual;

-- 올림, 버림(내림)
select ceil(12.912), ceiling(12.912), ceil(-12.912), ceiling(-12.912)
from dual;

select floor(12.912), floor(-12.912)
from dual;

-- 반올림
select round(165.2212), round(1515.1515, 0), round(1622.2225, 1), round(115.1515, -2)
from dual;

select truncate(1515.2525, 0), truncate(1515.1515, 1), truncate(1262.3363, -2)
from dual;


-- 제곱승, 나머지, 최대,  최소값
select pow(2,3), power(2,3)
from dual;

select mod(10,4), 10 % 4
from dual;

select greatest(1,2,3,4,5,6), least(1,2,3,4,5,6)
from dual;


-- 아스키
select ASCII('0')
from dual;

select concat(employee_id, '번 사원의 이름', frist_name, ' ', last_name)
from employees
where employee_id = 100;


select replace('adadadad!!','!!','@@')
from dual;

select instr('hello ssafy !!!!', 'ssafy')
from dual;

select mid('hello ssafy !!!', 7, 5), substring('hello saaffy !!!', 7, 5)
from dual;

-- DATE 관련

SELECT NOW(), sleep(5), now()
from dual;

select sysdata(), sleep(5), sysdate()
from dual;

select year(now()), month(now()), monthname(now())
from dual;

select now(),
		data_format(now(), '%Y')
from dual;

select count(employee_id)
from employees;

select round(avg(salary), 2) 평균급여
from employees;

-- 불가능
select first_name, max(salary), first_name, min(salary)
from employees
where department_id = 80;

-- > 불가능
select department_id, sum(salary), avg(salary)
from employees;

-- > 가능
select department_id, sum(salary), avg(salary)
from employees
group by department_id
order by department_id;


use ssafydb;
-- > select절에는 group by에 있거나, 함수만 사용가능
select department_id, SUM(salary), AVG(salary)
from employees
group by department_id;

-- > group by의 사용이 부적절 why? 
select department_id, SUM(salary), AVG(salary)
from employees
where avg(salary) >= 7000
group by department_id;

-- > group by의 사용이 부적절 why? 
select department_id, SUM(salary), AVG(salary)
from employees
group by department_id
having avg(salary) >= 7000;


select job_id, avg(salary)
from employees
where department_id in (70,80,90)
group by job_id
having sum(salary) > 50000
order by 2 desc;
