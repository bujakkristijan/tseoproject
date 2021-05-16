insert into sf82015.user (id, name, surname, index_num, email, password, role) 
values (1, "marko","markovic", "sf5/2015", "marko@email.com", "sifra", "STUDENT");

insert into sf82015.user (id, name, surname, index_num, email, password, role) 
values (2, "pera","petrovic", "sf6/2015", "pera@email.com", "sifra2", "STUDENT");

insert into sf82015.user (id, name, surname, index_num, email, password, role) 
values (3, "zika","zivkovic", "sf7/2015", "zika@email.com", "sifra3", "PROFESSOR");

insert into sf82015.course (id, code, description, name, price) 
values (1, "001","Course description 1", "Matematika", 2000);

insert into sf82015.course (id, code, description, name, price) 
values (2, "002","Course description 2", "Programiranje", 3000);

insert into sf82015.course (id, code, description, name, price) 
values (3, "003","Course description 3", "Muzicko", 2500);

insert into sf82015.user_course (id, date_added, course_id, user_id) 
values (1, null, 1, 1);

insert into sf82015.user_course (id, date_added, course_id, user_id) 
values (2, null, 2, 1);

insert into sf82015.user_course (id, date_added, course_id, user_id) 
values (3, null, 1, 2);

select * from sf82015.user;