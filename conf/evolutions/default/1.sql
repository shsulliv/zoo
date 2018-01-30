# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table animals (
  id                            uuid not null,
  animal_name                   varchar(255),
  species_id                    uuid,
  pen_id                        uuid,
  constraint pk_animals primary key (id)
);

create table keepers (
  id                            uuid not null,
  keeper_name                   varchar(255),
  constraint pk_keepers primary key (id)
);

create table pens (
  id                            uuid not null,
  pen_name                      varchar(255),
  pen_type                      varchar(255),
  land_area                     float not null,
  water_area                    float not null,
  air_area                      float not null,
  keeper_id                     uuid,
  constraint pk_pens primary key (id)
);

create table species (
  id                            uuid not null,
  species_name                  varchar(255),
  pen_type                      varchar(255),
  is_petting                    boolean default false not null,
  land_requirement              float not null,
  water_requirement             float not null,
  air_requirement               float not null,
  constraint pk_species primary key (id)
);

alter table animals add constraint fk_animals_species_id foreign key (species_id) references species (id) on delete restrict on update restrict;
create index ix_animals_species_id on animals (species_id);

alter table animals add constraint fk_animals_pen_id foreign key (pen_id) references pens (id) on delete restrict on update restrict;
create index ix_animals_pen_id on animals (pen_id);

alter table pens add constraint fk_pens_keeper_id foreign key (keeper_id) references keepers (id) on delete restrict on update restrict;
create index ix_pens_keeper_id on pens (keeper_id);


# --- !Downs

alter table if exists animals drop constraint if exists fk_animals_species_id;
drop index if exists ix_animals_species_id;

alter table if exists animals drop constraint if exists fk_animals_pen_id;
drop index if exists ix_animals_pen_id;

alter table if exists pens drop constraint if exists fk_pens_keeper_id;
drop index if exists ix_pens_keeper_id;

drop table if exists animals cascade;

drop table if exists keepers cascade;

drop table if exists pens cascade;

drop table if exists species cascade;

