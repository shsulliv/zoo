# --- !Ups

ALTER TABLE species
  ALTER COLUMN id SET DEFAULT uuid_generate_v1();

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement)
VALUES ('Sloth', 'Dry', FALSE, 3, 0, 0);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement)
VALUES ('Penguin', 'Hybrid', FALSE, 2, 4, 0);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement)
VALUES ('Goat', 'Petting', TRUE, 3, 0, 0);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement)
VALUES ('Dog', 'Petting', TRUE, 3.5, 0, 0);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement)
VALUES ('Owl', 'Aviary', FALSE, 0, 0, 20);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement)
VALUES ('Dolphin', 'Aquarium', FALSE, 0, 40, 0);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement)
VALUES ('Hippo', 'Hybrid', FALSE, 10, 20, 0);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement)
VALUES ('Cat', 'Petting', TRUE, 4, 0, 0);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement)
VALUES ('Tiger', 'Hybrid', FALSE, 30, 10, 0);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement)
VALUES ('Lion', 'Dry', FALSE, 30, 0, 0);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement)
VALUES ('Horse', 'Petting', TRUE, 20, 0, 0);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement)
VALUES ('Crocodile', 'Hybrid', FALSE, 5, 10, 0);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement)
VALUES ('Shark', 'Aquarium', FALSE, 0, 20, 0);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement)
VALUES ('Parrot', 'Aviary', FALSE, 0, 0, 8.5);
