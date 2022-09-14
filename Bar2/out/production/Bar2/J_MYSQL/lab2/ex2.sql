create schema ex2;
create table ex2.gymmembers (id int primary key auto_increment , name varchar(30), adress varchar(30),phoneNumber varchar (30) , age double );

insert into ex2.gymmembers (name, adress,phoneNumber,age) values ('Kobi','28 Herzel St. TLV','054-9519512','30');
insert into ex2.gymmembers (name, adress,phoneNumber,age) values ('Daniel','23 MJ St. Chicago','054-1212512','33.4');
insert into ex2.gymmembers (name, adress,phoneNumber,age) values ('Shimmy','12 Lev St. TLV','052-8412516','19.7');
select * from ex2.gymmembers;
select * from ex2.gymmembers where name = 'Shimmy' and id <> 0;
select * from ex2.gymmembers where phoneNumber like '054%';
select * from ex2.gymmembers where phoneNumber like '%12';
select * from ex2.gymmembers where phoneNumber like '%12%';
select * from ex2.gymmembers where age >= 30;
update ex2.gymmembers set phoneNumber = '050-9999999' where id = 3;
select*from ex2.gymmembers ;
select*from ex2.gymmembers where name = 'Daniel';
insert into ex2.GymMembers (name,adress,phoneNumber,age) values ('Victor','12 Cool St. TLV','052-4323410','15.2');
select*from ex2.gymmembers ;
select*from ex2.gymmembers where name = 'Kobi';
drop table ex2.gymmembers;
drop schema ex2;

