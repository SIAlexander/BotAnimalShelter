-- liquibase formatted sql

-- changeset asmokvin:1
CREATE table pet_shelter
(
    id                    SERIAL PRIMARY KEY,
    name                  TEXT,
    location              TEXT,
    locatinon_explanation TEXT,
    specialists_info      TEXT
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