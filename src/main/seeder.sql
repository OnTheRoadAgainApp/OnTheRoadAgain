USE otratest_db;

-- need to run app first to create db
INSERT INTO users (address, city, email, first_name, last_name, password, phone_number, state, username, zipcode, user_role_id) VALUES ('123 Great Pl.', 'San Antonio', 'tom@auto.com', 'Tom', 'Whitikser', 'tom', 4321238649, 'TX', 'tomw', 78259, 'TECHNICIAN'),
('540 Good Rd.', 'San Antonio', 'willv@auto.com', 'Will', 'Verudian', 'will', 5429128456, 'TX', 'willv', 78323, 'TECHNICIAN'),
('9834 Fun Prom.','San Antonio','jerry@auto.com','Jerry','Mouse','jerry', 9782341836,'TX', 'jerrym', 78934,'TECHNICIAN');

INSERT INTO service_types (id, description) VALUES (1, 'Lube, Oil, and Filter'),( 2, 'Tire Rotation'),(3, 'Fuel System Service'), (4, 'Engine Air Filter Replacement'),
(5, 'Scheduled Maintenance by Mileage'), (6, 'Battery Replacement'), ( 7, 'Brake Service'), (8, 'Diagnostics'), (9, 'Wheel Alignment' );