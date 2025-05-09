# PRODUCTION DB --------------------------------------------------------------------------------------------
DROP DATABASE IF EXISTS SNIPER_DB;
CREATE DATABASE SNIPER_DB;
USE SNIPER_DB;

# def
CREATE TABLE weapon(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
brand 			VARCHAR(255),
serial_number 	VARCHAR(255),
bore_size		DECIMAL(5,2),
bore_unit	 	VARCHAR(255),
type		 	VARCHAR(255),
photo_qr		VARCHAR(255)
);
ALTER TABLE weapon MODIFY COLUMN id BIGINT AUTO_INCREMENT;

INSERT INTO weapon (brand, serial_number, bore_size, bore_unit, type, photo_qr)
VALUES 
('HATSAN ESCORT MAGNUM', 	'19-687616', 	12, 	'gauge', 	'pump-action',			null),
('HUGLU', 					'21C1225', 		12, 	'gauge',	'double-barelled',		null),
('HATSAN', 					'17-463388', 	12, 	'gauge',	'semi-authomatic',		null),
('?', 						'l-0', 			4.5, 	'mm',		'air-bolt',				null)
;

#def
CREATE TABLE weapon_feedback(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    weapon_id				BIGINT,
    user_comment			TEXT
);
ALTER TABLE weapon_feedback MODIFY COLUMN id BIGINT AUTO_INCREMENT;
ALTER TABLE weapon_feedback
	ADD CONSTRAINT fk_weapon_feedback_weapon
		FOREIGN KEY (weapon_id)
		REFERENCES weapon(id);
INSERT INTO weapon_feedback (weapon_id, user_comment)
VALUES 
(1, 		'A reliable rifle with decent accuracy & destructive power. Excellent at using slugs, not recommended for bellet shots'),
(2, 		'Hunting rifle for small games, reliable with 2 triggers. Best for pellet shots, not recommended for slug shooting.'),
(3, 		'Semi authomatic shutgun, reliable enough with 30 gr or heavier ammo. Accuracy is decent. Decent with slugs, not recommended with pellets.'),
(4, 		'Air bolt rifle. A decent price-performance item. Decent accuracy at small ranges.')
;

# iteration
CREATE TABLE shooting(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
distance			DECIMAL(5),				# in meters
distance_category	VARCHAR(255),
weapon_id			BIGINT,
shot_fired			DECIMAL(4),
hit					DECIMAL(4),
date_of_shooting	DATE
);
ALTER TABLE shooting MODIFY COLUMN id BIGINT AUTO_INCREMENT;
ALTER TABLE shooting
	ADD CONSTRAINT fk_shooting_weapon
		FOREIGN KEY (weapon_id)
		REFERENCES weapon(id);

INSERT INTO shooting (distance, distance_category, weapon_id, shot_fired, hit, date_of_shooting)
VALUES
(5, 	'short',		4,  4, 4, '2025-05-07'),
(10, 	'medium',		4,  4, 4, '2025-05-07'),
(15, 	'long',			4,  3, 4, '2025-05-07')
;

# creating combined view of shoting & weapon tables
CREATE VIEW shooting_with_weapon AS
SELECT 
    s.id 					AS shooting_id,
    s.distance 				AS distance,
    s.distance_category		AS distance_category,
    s.shot_fired			AS shot_fired,
    s.hit					AS hit,
    s.date_of_shooting		AS date_of_shooting,
    w.id 					AS weapon_id,
    w.brand 				AS weapon_brand,
    w.serial_number 		AS weapon_serial_number,
    w.bore_size 			AS weapon_bore_size,
    w.bore_unit 			AS weapon_bore_unit,
    w.type 					AS weapon_type,
	w.photo_qr				AS weapon_photo_qr
FROM shooting s
INNER JOIN 
	weapon w 
    ON 
    s.weapon_id = w.id
;

# creating combined view of weapon & weapon_feedback tables
CREATE VIEW weapon_with_feedback AS
SELECT 
    w.id 					AS id,
    w.brand 				AS brand,
    f.user_comment			AS user_comment
FROM weapon w
INNER JOIN 
		weapon_feedback f 
    ON 
		w.id = f.id
;
    
# SELECT * FROM cat_with_price;
# TEST DB --------------------------------------------------------------------------------------------
DROP DATABASE IF EXISTS SNIPER_DB_TEST;
CREATE DATABASE SNIPER_DB_TEST;
USE SNIPER_DB_TEST;

# def
CREATE TABLE weapon(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
brand 			VARCHAR(255),
serial_number 	VARCHAR(255),
bore_size		DECIMAL(5,2),
bore_unit	 	VARCHAR(255),
type		 	VARCHAR(255),
photo_qr		VARCHAR(255)
);
ALTER TABLE weapon MODIFY COLUMN id BIGINT AUTO_INCREMENT;

INSERT INTO weapon (brand, serial_number, bore_size, bore_unit, type, photo_qr)
VALUES 
('HATSAN ESCORT MAGNUM', 	'19-687616', 	12, 	'gauge', 	'pump-action',			null),
('HUGLU', 					'21C1225', 		12, 	'gauge',	'double-barelled',		null),
('HATSAN', 					'17-463388', 	12, 	'gauge',	'semi-authomatic',		null),
('?', 						'l-0', 			4.5, 	'mm',		'air-bolt',				null)
;

#def
CREATE TABLE weapon_feedback(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    weapon_id				BIGINT,
    user_comment			TEXT
);
ALTER TABLE weapon_feedback MODIFY COLUMN id BIGINT AUTO_INCREMENT;
ALTER TABLE weapon_feedback
	ADD CONSTRAINT fk_weapon_feedback_weapon
		FOREIGN KEY (weapon_id)
		REFERENCES weapon(id);
INSERT INTO weapon_feedback (weapon_id, user_comment)
VALUES 
(1, 		'A reliable rifle with decent accuracy & destructive power. Excellent at using slugs, not recommended for bellet shots'),
(2, 		'Hunting rifle for small games, reliable with 2 triggers. Best for pellet shots, not recommended for slug shooting.'),
(3, 		'Semi authomatic shutgun, reliable enough with 30 gr or heavier ammo. Accuracy is decent. Decent with slugs, not recommended with pellets.'),
(4, 		'Air bolt rifle. A decent price-performance item. Decent accuracy at small ranges.')
;

# iteration
CREATE TABLE shooting(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
distance			DECIMAL(5),				# in meters
distance_category	VARCHAR(255),
weapon_id			BIGINT,
shot_fired			DECIMAL(4),
hit					DECIMAL(4),
date_of_shooting	DATE
);
ALTER TABLE shooting MODIFY COLUMN id BIGINT AUTO_INCREMENT;
ALTER TABLE shooting
	ADD CONSTRAINT fk_shooting_weapon
		FOREIGN KEY (weapon_id)
		REFERENCES weapon(id);

INSERT INTO shooting (distance, distance_category, weapon_id, shot_fired, hit, date_of_shooting)
VALUES
(5, 	'short',		4,  4, 4, '2025-05-07'),
(10, 	'medium',		4,  4, 4, '2025-05-07'),
(15, 	'long',			4,  3, 4, '2025-05-07')
;

# creating combined view of shoting & weapon tables
CREATE VIEW shooting_with_weapon AS
SELECT 
    s.id 					AS shooting_id,
    s.distance 				AS distance,
    s.distance_category		AS distance_category,
    s.shot_fired			AS shot_fired,
    s.hit					AS hit,
    s.date_of_shooting		AS date_of_shooting,
    w.id 					AS weapon_id,
    w.brand 				AS weapon_brand,
    w.serial_number 		AS weapon_serial_number,
    w.bore_size 			AS weapon_bore_size,
    w.bore_unit 			AS weapon_bore_unit,
    w.type 					AS weapon_type,
    w.photo_qr				AS weapon_photo_qr
FROM shooting s
INNER JOIN 
	weapon w 
    ON 
    s.weapon_id = w.id
;

# creating combined view of weapon & weapon_feedback tables
CREATE VIEW weapon_with_feedback AS
SELECT 
    w.id 					AS id,
    w.brand 				AS brand,
    f.user_comment			AS user_comment
FROM weapon w
INNER JOIN 
		weapon_feedback f 
    ON 
		w.id = f.id
;

# PRIVILEGES -----------------------------------------------------------------------------------------
CREATE USER IF NOT EXISTS 'myuser'@'%' IDENTIFIED BY 'Light80s!';
GRANT ALL PRIVILEGES ON SNIPER_DB.*	 		TO 		'myuser'@'%';
GRANT ALL PRIVILEGES ON SNIPER_DB_TEST.* 	TO		 'myuser'@'%';
FLUSH PRIVILEGES;
COMMIT;