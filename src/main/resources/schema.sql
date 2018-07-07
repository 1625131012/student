drop table if exists hquer;
drop table if exists host_house;
create table hquer (
  id identity,
  firstname varchar(25) not null,
  lastname varchar(25)  not null,
  usernamestu varchar(25) not null,
  usernamehou varchar(25) not null,
  address varchar(50) not null,
  address_stu varchar(50) not null,
  birthday varchar(10) not null,
  sex varchar(10) not null,
  phonestu varchar(20) not null,
  phonehou varchar(20) not null,
  passwordstu varchar(25) not null,
  passwordhou varchar(25) not null
);

create table host_house (
  id integer identity primary key,
  host_house varchar(2000) not null,
);