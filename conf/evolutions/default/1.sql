# --- !Ups

CREATE TABLE animals (
  id          UUID NOT NULL,
  animal_name VARCHAR(255),
  species_id  UUID,
  pen_id      UUID,
  CONSTRAINT pk_animals PRIMARY KEY (id)
);

CREATE TABLE keepers (
  id          UUID NOT NULL,
  keeper_name VARCHAR(255),
  pen_type    VARCHAR(255),
  CONSTRAINT pk_keepers PRIMARY KEY (id)
);

CREATE TABLE pens (
  id          UUID  NOT NULL,
  pen_name    VARCHAR(255),
  pen_type    VARCHAR(255),
  land_area   FLOAT NOT NULL,
  water_area  FLOAT NOT NULL,
  air_area    FLOAT NOT NULL,
  temperature FLOAT NOT NULL,
  keeper_id   UUID,
  CONSTRAINT pk_pens PRIMARY KEY (id)
);

CREATE TABLE species (
  id                UUID                  NOT NULL,
  species_name      VARCHAR(255),
  pen_type          VARCHAR(255),
  is_petting        BOOLEAN DEFAULT FALSE NOT NULL,
  land_requirement  FLOAT                 NOT NULL,
  water_requirement FLOAT                 NOT NULL,
  air_requirement   FLOAT                 NOT NULL,
  temperature       FLOAT                 NOT NULL,
  CONSTRAINT pk_species PRIMARY KEY (id)
);

ALTER TABLE animals
  ADD CONSTRAINT fk_animals_species_id FOREIGN KEY (species_id) REFERENCES species (id) ON DELETE RESTRICT ON UPDATE RESTRICT;
CREATE INDEX ix_animals_species_id
  ON animals (species_id);

ALTER TABLE animals
  ADD CONSTRAINT fk_animals_pen_id FOREIGN KEY (pen_id) REFERENCES pens (id) ON DELETE RESTRICT ON UPDATE RESTRICT;
CREATE INDEX ix_animals_pen_id
  ON animals (pen_id);

ALTER TABLE pens
  ADD CONSTRAINT fk_pens_keeper_id FOREIGN KEY (keeper_id) REFERENCES keepers (id) ON DELETE RESTRICT ON UPDATE RESTRICT;
CREATE INDEX ix_pens_keeper_id
  ON pens (keeper_id);


# --- !Downs

ALTER TABLE IF EXISTS animals
  DROP CONSTRAINT IF EXISTS fk_animals_species_id;
DROP INDEX IF EXISTS ix_animals_species_id;

ALTER TABLE IF EXISTS animals
  DROP CONSTRAINT IF EXISTS fk_animals_pen_id;
DROP INDEX IF EXISTS ix_animals_pen_id;

ALTER TABLE IF EXISTS pens
  DROP CONSTRAINT IF EXISTS fk_pens_keeper_id;
DROP INDEX IF EXISTS ix_pens_keeper_id;

DROP TABLE IF EXISTS animals CASCADE;

DROP TABLE IF EXISTS keepers CASCADE;

DROP TABLE IF EXISTS pens CASCADE;

DROP TABLE IF EXISTS species CASCADE;

