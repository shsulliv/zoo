# --- !Ups

ALTER TABLE species
  ALTER COLUMN id SET DEFAULT uuid_generate_v1();

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement, temperature)
VALUES ('Sloth', 'Dry', FALSE, 3, 0, 0, 30);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement, temperature)
VALUES ('Penguin', 'Hybrid', FALSE, 2, 4, 0, 0);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement, temperature)
VALUES ('Goat', 'Petting', TRUE, 3, 0, 0, 20);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement, temperature)
VALUES ('Dog', 'Petting', TRUE, 3.5, 0, 0, 20);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement, temperature)
VALUES ('Owl', 'Aviary', FALSE, 0, 0, 20, 20);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement, temperature)
VALUES ('Dolphin', 'Aquarium - Salt Water', FALSE, 0, 40, 0, 20);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement, temperature)
VALUES ('Hippo', 'Hybrid', FALSE, 10, 20, 0, 30);

INSERT INTO species (species_name, pen_type, is_petting, land_requirement, water_requirement, air_requirement, temperature)
VALUES ('Cat', 'Petting', TRUE, 4, 0, 0, 20);
