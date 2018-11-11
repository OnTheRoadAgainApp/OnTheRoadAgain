USE otra_db;

-- need to run app first to create db
INSERT INTO users (address, city, email, first_name, last_name, password, phone_number, state, username, zipcode, user_role_id) VALUES ('123 Great Pl.', 'San Antonio', 'tom@auto.com', 'Tom', 'Whitikser', 'tom', 4321238649, 'TX', 'tomw', 78259, 'TECHNICIAN'),
('540 Good Rd.', 'San Antonio', 'willv@auto.com', 'Will', 'Verudian', 'will', 5429128456, 'TX', 'willv', 78323, 'TECHNICIAN'),
('9834 Fun Prom.','San Antonio','jerry@auto.com','Jerry','Mouse','jerry', 9782341836,'TX', 'jerrym', 78934,'TECHNICIAN');
