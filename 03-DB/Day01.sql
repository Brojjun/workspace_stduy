select *
  from employees
 limit 3;
 
 -- limit 원하는 개수만큼 자르기
 
select *
  from employees
 order by salary desc
 limit 5;
 
select *
  from employees
 order by salary desc
 limit 0, 10;

select *
  from employees
 order by salary desc
 limit 10, 10;
 
select 100
  from departments;
  
select 100 * 263;

select "abcde", reverse("abcde"), concat("abcde", 'fffff');

select (true), (false), (null);
-- null은 값 미정 (정해지지 않아서 모름)

select not true, not false, not null;

select 1 and 1, 1 and 0, 0 and 0, null and 1, 1 and null;

select 1 or 1, 1 or 0, 0 or 0, null or 1, 1 or null;

select *
  from employees
 where null;
-- 1 : 모든 결과 조회, (0, null) : 결과 조회 안됨

select 1 > 2, 1 < 2, 1 < null, 1 = null, 1 != null, null = null;

select 1 + null, 9 * null, 8 - null, 8 / null, 7 % null;

select employee_id, last_name, salary
  from employees
 order by 3;
-- 아무리 편해도 슷자로 하는 것 기피하기

-- like는 패턴 문자가 있을 때

where name = 'a'
   or name = 'b'
  and team = 1;
  
-- or 보다 and가 우선 순위
-- in은 같은 column의 같은 값 비교