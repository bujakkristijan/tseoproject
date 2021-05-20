insert into sf82015.user (id, name, surname, index_num, email, password, role) 
values (1, "marko","markovic", "sf5/2015", "marko@email.com", "sifra", "STUDENT");

insert into sf82015.user (id, name, surname, index_num, email, password, role) 
values (2, "pera","petrovic", "sf6/2015", "pera@email.com", "sifra2", "STUDENT");

insert into sf82015.user (id, name, surname, index_num, email, password, role) 
values (3, "zika","zivkovic", "sf7/2015", "zika@email.com", "sifra3", "PROFESSOR");

insert into sf82015.user (id, name, surname, index_num, email, password, role) 
values (4, "a","zivkovic", "sf8/2015", "a", "a", "ADMIN");

insert into sf82015.course (id, code, description, name, price) 
values (1, "001","Course description 1", "Matematika", 2000);

insert into sf82015.course (id, code, description, name, price) 
values (2, "002","Course description 2", "Programiranje", 3000);

insert into sf82015.course (id, code, description, name, price) 
values (3, "003","Course description 3", "Muzicko", 2500);

insert into sf82015.user_course (id, date_added, course_id, user_id) 
values (1, null, 1, 3);

insert into sf82015.user_course (id, date_added, course_id, user_id) 
values (2, null, 2, 3);

insert into sf82015.user_course (id, date_added, course_id, user_id) 
values (3, null, 1, 2);

insert into sf82015.payment (id, amount, card_number, date_payed, recipient_number, course_id, user_id) values (1, 2000, 213213, null, 21312312, 1, 2);
insert into sf82015.payment (id, amount, card_number, date_payed, recipient_number, course_id, user_id) values (2, 3000, 213213, null, 21312312, 2, 2);
insert into sf82015.payment (id, amount, card_number, date_payed, recipient_number, course_id, user_id) values (3, 2000, 213213, null, 21312312, 1, 2);

/* za marka paymenti */
insert into sf82015.payment (id, amount, card_number, date_payed, recipient_number, course_id, user_id) values (5, 1500, 213213, null, 21312312, 1, 1);
insert into sf82015.payment (id, amount, card_number, date_payed, recipient_number, course_id, user_id) values (6, 1000, 213213, null, 21312312, 1, 1);
insert into sf82015.payment (id, amount, card_number, date_payed, recipient_number, course_id, user_id) values (7, 1000, 213213, null, 21312312, 3, 1);
insert into sf82015.payment (id, amount, card_number, date_payed, recipient_number, course_id, user_id) values (8, 1000, 213213, null, 21312312, 3, 1);
select * from sf82015.user;