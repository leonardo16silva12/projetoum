create table cliente(
	id int not null auto_increment primary key,
    nome varchar(150),
    telefone varchar(20),
    cidade_id int not null
    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
    
    
alter table cliente add constraint fk_cliente_cidade 
foreign key(cidade_id) references cidade(id);

insert into cliente(nome, telefone, cidade_id) values
('Leonardo','991348270', 1), ('Vinicius','992143124', 2), ('Renato', '991264536', 3),
('venom_extreme','991348270', 4), ('Sarita','992143124', 5), ('Raimundo', '991264536', 6),
('Luana','991348270', 7), ('Gyovane','992143124', 8), ('Sebastião', '991264536', 9),
('Iasmin','991348270', 10), ('Felipe','992143124', 11), ('Florenzo', '991264536', 12),
('Carla','991348270', 13), ('Alana','992143124', 14), ('Tereza', '991264536', 15),
('Rahul','991348270', 16), ('Gabriela','992143124', 17), ('Astolfo', '991264536', 18),
('Luiz','991348270', 19), ('Emanuelli','992143124', 20), ('Manuel', '991264536', 21),
('Samuel','991348270', 22), ('Mirela','992143124', 23), ('Marilene', '991264536', 24),
('Lucas','991348270', 5), ('Livia','992143124', 10), ('Tiago', '991264536', 2);