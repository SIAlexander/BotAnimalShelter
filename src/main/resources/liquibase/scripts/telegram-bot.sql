-- liquibase formatted sql

-- changeset asmokvin:1
CREATE table pet_shelter
(
    id                    SERIAL PRIMARY KEY,
    name                    TEXT,
    location                TEXT,
    location_explanation    TEXT,
    specialists_info        TEXT,
    specimen                TEXT
);

-- changeset asmokvin:2
CREATE table users
(
    id             BIGSERIAL PRIMARY KEY,
    id_chat        BIGINT,
    name           TEXT,
    phone          TEXT,
    email          TEXT,
    location       TEXT,
    pet_relation   TEXT,
    loved_specimen TEXT
);

-- changeset asmokvin:3
CREATE table pet
(
    id              BIGSERIAL PRIMARY KEY,
    name            TEXT,
    color           TEXT,
    bread           TEXT,
    birth_date      TIMESTAMP,
    users           TEXT,
    adoption_status TEXT,
    pet_shelter     TEXT
);

-- changeset antonov333:4
ALTER TABLE users ADD pet_shelter BIGSERIAL;

-- changeset antonov333:5
CREATE table volunteers
(
	id              BIGSERIAL PRIMARY KEY,
	name            TEXT,
	chat_id 	    BIGINT,
	phone 		    TEXT,
	email 		    TEXT,
	location 	    TEXT,
	pet_relation 	TEXT,
	loved_specimen 	TEXT,
	petshelter_id 	BIGINT
);

-- changeset antonov333:6
ALTER TABLE pet ADD shelter_id BIGSERIAL;

-- changeset antonov333:7
ALTER TABLE pet ADD specimen TEXT;
ALTER TABLE pet ADD breed TEXT;

-- changeset antonov333:8
ALTER TABLE pet DROP COLUMN bread;
ALTER TABLE pet DROP COLUMN pet_shelter;

-- changeset antonov333:9
ALTER TABLE pet ADD COLUMN adopter_id BIGINT;