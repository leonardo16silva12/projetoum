create table cidade(
	id int not null auto_increment primary key,
    nome varchar(100),
    estado char(2)
    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
    
    insert into Cidade(nome, estado) values
    ('Lençóis Paulista','SP'), ('Belo Horizonte','MG'), ('Niterói','RJ'),
    ('Bauru','SP'), ('Agudos','SP'), ('Cabo Frio','RJ'),
    ('Perdeneiras','SP'), ('Pouso Alegre','MG'), ('Petrópolis','RJ'),
    ('Laranjal Paulista','SP'), ('Areiopólis','SP'), ('Macatuba','SP'),
    ('Adamantina','SP'), ('Cafélandia','SP'), ('Fortaleza','CE'),
    ('Manaus','AM'), ('Bom Jesus do Norte','MS'), ('Porto Velho','RO'),
    ('Londrina','PR'), ('Chapecó','RS'), ('Vitória','ES'),
    ('Curitiba','PR'), ('Natal','RN'), ('Salvador','BA');