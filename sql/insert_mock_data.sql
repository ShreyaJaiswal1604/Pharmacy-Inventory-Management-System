insert into master_drug_table(drug_name) values('Crocin');
insert into master_drug_table(drug_name) values('Paracetamol');
insert into master_drug_table(drug_name) values('Cetrizon');

insert into person(username, person_name, password, person_role) values("skudli", "Sudarshan Kudli", "password", "PHARMACY_ADMIN");
insert into person(username, person_name, password, person_role) values("shreya98", "Shreya Jaiswal", "password", "STORE_MANAGER");
insert into person(username, person_name, password, person_role) values("alankrutha", "Alankrutha Reddy", "password", "MANUFACTURER_ADMIN");

insert into company(company_name, company_type, registered_date) values("Abbot Laboratories", "manufacturer", "1980-02-13");
insert into company(company_name, company_type, registered_date) values("Johnson and Johnson", "manufacturer", "1985-04-13");
insert into company(company_name, company_type, registered_date) values("Cardinal Health", "distributor", "1990-05-23");
insert into company(company_name, company_type, registered_date) values("King World Medicines Group", "distributor", "2000-12-25");
insert into company(company_name, company_type, registered_date) values("CVS Pharmacy", "pharmacy", "1982-06-04");
insert into company(company_name, company_type, registered_date) values("MedPlus", "pharmacy", "1970-02-16");

insert into manufacturer_inventory(manufacturer_id, drug_id, quantity, cost_price, selling_price) values(1, 1, 100, 3, 4);
insert into manufacturer_inventory(manufacturer_id, drug_id, quantity, cost_price, selling_price) values(1, 2, 120, 4, 4.5);
insert into manufacturer_inventory(manufacturer_id, drug_id, quantity, cost_price, selling_price) values(2, 2, 150, 10, 12.5);
insert into manufacturer_inventory(manufacturer_id, drug_id, quantity, cost_price, selling_price) values(2, 3, 200, 14, 15);

insert into pharmacy_order(pharmacy_id, manufacturer_id, order_date, order_status) values(1, 1, "2021-02-16", "pending");
insert into pharmacy_order(pharmacy_id, manufacturer_id, order_date, order_status) values(2, 2, "2021-04-16", "pending");

insert into pharmacy_order_item(order_id, item_id, quantity) values(1, 1, 5);
insert into pharmacy_order_item(order_id, item_id, quantity) values(1, 2, 10);
insert into pharmacy_order_item(order_id, item_id, quantity) values(2, 2, 8);
insert into pharmacy_order_item(order_id, item_id, quantity) values(2, 3, 3);

insert into pharmacy_inventory(pharmacy_id, drug_id, quantity, cost_price, selling_price) values(1, 1, 5, 4, 6);
insert into pharmacy_inventory(pharmacy_id, drug_id, quantity, cost_price, selling_price) values(1, 2, 10, 4.5, 7);

INSERT INTO pharmacy_store(pharmacy_id, store_name, store_address, store_zip, store_city)
VALUES(1, "CVS 1", "25 Fenway Street", "02118", "Boston");
INSERT INTO pharmacy_store(pharmacy_id, store_name, store_address, store_zip, store_city)
VALUES(1, "CVS 2", "115 Boyleston Street", "02125", "Boston");
INSERT INTO pharmacy_store(pharmacy_id, store_name, store_address, store_zip, store_city)
VALUES(1, "MedPlus 1", "1628 5th Avenue", "02310", "Seattle");