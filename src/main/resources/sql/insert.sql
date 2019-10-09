use SConferencedb;

   insert positions (position) 
value('Admin'),
     ('Moderator'),
     ('Speaker'),
     ('User');
     
	insert language (language) 
value('UA'),
     ('EN'),
     ('RU');
     
     
    insert users (name, surname, email, password, position, language,discriminator) 
value('Юій','Юдильцев', 'userudilcev@gmail.com','user1111',4,1,'U'),
     ('Ulia','Ulieva', 'userulieva@gmail.com','user2222',4,2,'U'),
     ('admin','admin', 'admin@ukr.net','admin',1,3,'U'),
     ('moder','moder', 'moder@ukr.net','moder',2,3,'U');
     
     
     
     insert users (name, surname, email, password, position, language, rating, bonuses, discriminator) 
value('Святослав','Семин', 'speakersemin@gmail.com','speaker1111',3,1,1,25,'S'),
     ('Савелий','Синий', 'sinijsavelij@gmail.com','speaker2222',3,3,0,0,'S');
    
     
     insert address (city, street, building, room) 
value('Киев','Донца', '25','18'),
     ('Львов','Шевченко', '5','77');
     
     
    
     insert reports (name, address_id, date, time, speaker_id) 
  value('Java Boot',1, '2019-11-11','10:00:00',6),
       ('Java Boot',1, '2019-11-11','10:00:00',6),
       ('Java Boot',1, '2019-11-11','23:18:00',6),
       ('Java Boot',1, '2019-11-11','10:00:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java Boot',1, '2019-11-11','15:47:00',6),
       ('Java 13',1, '2019-09-09','15:47:00',6),
       ('Java 13',1, '2019-09-09','15:47:00',6),
       ('Java 13',1, '2019-09-09','15:47:00',6),
       ('Java 13',1, '2019-09-09','15:47:00',6),
       ('Java 13',1, '2019-09-09','15:47:00',6),
       ('Java 13',1, '2019-09-09','15:47:00',6),
       ('Java 13',1, '2019-09-09','15:47:00',6),
       ('Java 13',1, '2019-09-09','15:47:00',6),
       ('Java 13',1, '2019-09-09','15:47:00',6),
       ('Java 13',1, '2019-09-09','15:47:00',6),
       ('Java 8',null, null,null,6),
       ('Java 8',null, null,null,6),
       ('Java 8',null, null,null,6),
       ('Java 8',null, null,null,6),
       ('Java 8',null, null,null,6),
       ('Java 8',null, null,null,6),
       ('Java 8',null, null,null,6),
       ('Java 8',null, null,null,6);
     