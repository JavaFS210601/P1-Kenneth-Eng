DROP TABLE IF EXISTS food_status;
DROP TABLE IF EXISTS foods;
DROP TABLE IF EXISTS manager;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS food_types;


<-- Hibernate generate my tebles -->


<-- Mannually create demo data -->

INSERT INTO users ( user_name, user_password)
VALUES 
		('ocean','pwd');
	
INSERT INTO ticket_status ( ticket_status )  
VALUES  
		('approved');
		
		 LODGING, TRAVEL, FOOD, or OTHER.
INSERT INTO ticket_type ( ticket_type )
VALUES 
		('lodging'),
		('travel'),
	     ('food'),
	    ('other');	
	   

INSERT INTO tickets (ticket_name , ticket_create_date , ticket_resolve_date , ticket_receipt,
  			ticket_description , user_id, ticket_status_id, ticket_type_id)
VALUES ('logding 1',  '2021-07-15 14:58:57', '2021-07-15 14:58:57', '', 'this is a ticket', 1, 1,1);

UPDATE tickets
SET ticket_type_id = 3 , ticket_name = "ticket for travle"
WHERE ticket_id = 3;

DELETE FROM ticket_type WHERE ticket_type_id >= 6 AND ticket_type_id <=8;
DELETE FROM ticket_status WHERE ticket_status_id >= 2 AND ticket_status_id <=4;	   

INSERT INTO food_status( food_status )  
VALUES  
		('super good'),
		('extremely good');
		
INSERT INTO user_roles ( user_role )
VALUES 
		('customer'),
		('VIP');
		
INSERT INTO food_types ( food_type )
VALUES 
		('protein'),
		('fruits'),
	     ('grains'),
	    ('dairy');
	   
INSERT INTO foods(food_name, food_status_id, food_type_id, manager_id, user_id)
VALUES ('fruit1', 1, 3, 1, 2);


DELETE FROM foods WHERE food_id = 5;
DELETE FROM foods WHERE food_id = 6;
DELETE FROM foods WHERE food_id = 7;
	
UPDATE foods
SET food_type_id = 2
WHERE food_id = 2;

UPDATE foods 
SET user_id = 2
WHERE food_id = 2;

UPDATE foods 
SET food_name = 'protein 2'
WHERE food_id = 2;

UPDATE manager 
SET fist_name = 'ocean', last_name = 'ng'
WHERE manager_id = 2;