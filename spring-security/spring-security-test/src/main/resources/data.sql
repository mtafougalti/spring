  
insert into users(username,password,enabled) values('admin','test',true);
insert into authorities(username,authority) values('admin','ROLE_USER');
insert into authorities(username,authority) values('admin','ROLE_ADMIN');

  
insert into users(username,password,enabled) values('user','test',true);
insert into authorities(username,authority) values('user','ROLE_USER');