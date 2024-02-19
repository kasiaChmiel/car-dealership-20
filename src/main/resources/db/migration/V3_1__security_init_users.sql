ALTER TABLE salesman
ADD COLUMN user_id INT, --została dodana kolumna ale bez NOT NULL
ADD FOREIGN KEY (user_id) REFERENCES car_dealership_user (user_id);
--dodajemy kolumne user_id do salesmana jako polączenie z tabelą car_dealership_user jako klucz obcy

ALTER TABLE mechanic
ADD COLUMN user_id INT,
ADD FOREIGN KEY (user_id) REFERENCES car_dealership_user (user_id);

--tutaj wprowadzamy dane do nowo powstałych tabel z warstwy security (car_dealership_user)
insert into car_dealership_user (user_id, user_name, email, password, active) values (1, 'stefan_sprzedawca', 'stefan_sprzedawca@zajavka.pl','$2a$12$sBy/.dKeXXSuWfti1sqyS./7WndvkSjleax6iD8tzyr5UIyKtd68W' , true);
insert into car_dealership_user (user_id, user_name, email, password, active) values (2, 'agnieszka_samochodowa', 'agnieszka_samochodowa@zajavka.pl','$2a$12$sBy/.dKeXXSuWfti1sqyS./7WndvkSjleax6iD8tzyr5UIyKtd68W' , true);
insert into car_dealership_user (user_id, user_name, email, password, active) values (3, 'tomasz_kombi', 'tomasz_kombi@zajavka.pl','$2a$12$sBy/.dKeXXSuWfti1sqyS./7WndvkSjleax6iD8tzyr5UIyKtd68W' , true);
insert into car_dealership_user (user_id, user_name, email, password, active) values (4, 'rafal_dach', 'rafal_dach@zajavka.pl','$2a$12$sBy/.dKeXXSuWfti1sqyS./7WndvkSjleax6iD8tzyr5UIyKtd68W' , true);

insert into car_dealership_user (user_id, user_name, email, password, active) values (5, 'robert_srubokret', 'robert_srubokret@zajavka.pl','$2a$12$sBy/.dKeXXSuWfti1sqyS./7WndvkSjleax6iD8tzyr5UIyKtd68W' , true);
insert into car_dealership_user (user_id, user_name, email, password, active) values (6, 'zygmunt_naprawa', 'zygmunt_naprawa@zajavka.pl','$2a$12$sBy/.dKeXXSuWfti1sqyS./7WndvkSjleax6iD8tzyr5UIyKtd68W' , true);
insert into car_dealership_user (user_id, user_name, email, password, active) values (7, 'remigiusz_alufelga', 'remigiusz_alufelga@zajavka.pl','$2a$12$sBy/.dKeXXSuWfti1sqyS./7WndvkSjleax6iD8tzyr5UIyKtd68W' , true);

-- user_id NIE jest NOT NULL, wiec może miec nullowe wartości dlatego ustawiamy je za pomocą znanych peseli
UPDATE salesman SET user_id = 1 WHERE pesel = '67020499436';
UPDATE salesman SET user_id = 2 WHERE pesel = '73021314515';
UPDATE salesman SET user_id = 3 WHERE pesel = '55091699846';
UPDATE salesman SET user_id = 4 WHERE pesel = '62081825675';

UPDATE mechanic SET user_id = 5 WHERE pesel = '52070997836';
UPDATE mechanic SET user_id = 6 WHERE pesel = '83011863727';
UPDATE mechanic SET user_id = 7 WHERE pesel = '67111396321';

insert into car_dealership_role (role_id, role) values (1, 'SALESMAN'), (2, 'MECHANIC');

--łączymy użytkowników z rolą
insert into car_dealership_user_role (user_id, role_id) values (1, 1), (2,1), (3,1), (4,1);
insert into car_dealership_user_role (user_id, role_id) values (5,2), (6,2), (7,2);

--aby nasza kolumna nie była nullowa później
ALTER TABLE salesman
ALTER COLUMN user_id SET NOT NULL;

ALTER TABLE mechanic
ALTER COLUMN user_id SET NOT NULL;