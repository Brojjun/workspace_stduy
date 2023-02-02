drop table board;

create table board
(
	no int auto_increment primary key,
    subject varchar(100) not null,
    register_time timestamp default current_timestamp
);

insert into board (subject, register_time)
values ('제목1', DATE_add(now(), interval 3 day));

insert into board (subject, register_time)
values ('제목2', DATE_add(now(), interval 2 day));

insert into board (subject, register_time)
values ('제목3', DATE_add(now(), interval 12 hour));

insert into board (subject, register_time)
values ('제목4', DATE_add(now(), interval 2 hour));

insert into board (subject)
values ('제목5');

select *
from board;

-- 참 - 시분초 / 거짓 - 년월일
-- select no, subject, CASE
-- 						WHEN (year(now()) = year(register_time)) then format(register_time, '%K-%i-$S')
-- 						ELSE format(registre_time,'%Y-%m-%d')
--                         end as "가입일"
-- from board b;

select now();

select b.no, b.subject, if(datediff(now(), register_time) >= 0, date_format(register_time, '%H시%i분%S초'), date_format(register_time,'%Y년%m월%d일')) as register_date
from board b;

