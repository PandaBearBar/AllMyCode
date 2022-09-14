create schema ex1;
create table ex1.GymMembers (
id int,
name varchar(30),
adress varchar(30),
phoneNumber varchar(30),
age double
);
insert into ex1.GymMembers (id,name,adress,phoneNumber,age) values ('100','Kobi','28 Herzel St. TLV','054-9519512','30');
insert into ex1.GymMembers (id,name,adress,phoneNumber,age) values ('101','Daniel','23 MJ St. Chicago','054-1212512','33.4');
insert into ex1.GymMembers (id,name,adress,phoneNumber,age) values ('104','Shimmy','12 Lev St. TLV','052-8412516','19.7');

SELECT * FROM ex1.gymmembers;

select * from ex1.gymmembers where name = 'Shimmy' and id <> 0;

select * from ex1.gymmembers where phoneNumber like '054%';

select * from ex1.gymmembers where phoneNumber like '%12';

select * from ex1.gymmembers where phoneNumber like '%12%';

select * from ex1.gymmembers where age >= 30 ;

update ex1.GymMembers set phoneNumber = '050-9999999' where name = 'Shimmy';

select * from ex1.gymmembers;

delete from ex1.gymmembers where name = 'Shimmy';

insert into ex1.GymMembers (id,name,adress,phoneNumber,age) values ('103','Victor','12 Cool St. TLV','052-4323410','15.2');

select * from ex1.gymmembers;

drop table ex1.gymmembers;

drop schema ex1;
