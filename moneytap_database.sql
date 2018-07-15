create SCHEMA moneytap;

create table moneytap.bitcoin_rate(
id serial primary key,
USD numeric(10,4) not null,
INR numeric(10,4)not null ,
recorded_time timestamp without time zone unique)