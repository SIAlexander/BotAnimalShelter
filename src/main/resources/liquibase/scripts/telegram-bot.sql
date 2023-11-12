-- liquibase formatted sql

-- changeset asmokvin:20
CREATE table users
(
    id       BIGSERIAL PRIMARY KEY,
    id_chat  BIGINT,
    name     TEXT,
    phone    TEXT,
    email    TEXT,
    location TEXT
);


-- changeset asmokvin:21
CREATE table shelters
(
    id       SERIAL PRIMARY KEY,
    name     TEXT,
    location TEXT,
    phone    TEXT
);

-- changeset asmokvin:22
CREATE table pet
(
    id         BIGSERIAL PRIMARY KEY,
    name       TEXT,
    color      TEXT,
    birth_date TIMESTAMP
);

-- changeset asmokvin:23
CREATE table volunteers
(
    id    BIGSERIAL PRIMARY KEY,
    name  TEXT,
    phone TEXT
);

-- changeset asmokvin:24
ALTER TABLE shelters DROP id;
ALTER TABLE shelters ADD COLUMN id BIGSERIAL PRIMARY KEY;

-- changeset asmokvin:25
ALTER TABLE volunteers ADD COLUMN shelter_id BIGINT REFERENCES shelters (id);

-- changeset asmokvin:26
ALTER TABLE shelters ADD COLUMN contacts_security TEXT;

-- changeset asmokvin:27
ALTER TABLE pet ADD COLUMN shelter_id BIGINT REFERENCES shelters (id);

-- changeset asmokvin:28
ALTER TABLE shelters ADD COLUMN schemes_path TEXT;

-- changeset asmokvin:29
ALTER TABLE shelters ADD COLUMN work_schedule TEXT;

-- changeset asmokvin:30
ALTER TABLE pet ADD COLUMN user_id BIGINT REFERENCES users (id);

-- changeset asmokvin:31
CREATE table handlers
(
    id    BIGSERIAL PRIMARY KEY,
    name  TEXT,
    phone TEXT,
    shelter_id BIGINT REFERENCES shelters(id)
);

-- changeset asmokvin:32
CREATE table recommendations_shelters
(
    id    BIGSERIAL PRIMARY KEY,
    name_shelter TEXT,
    animal_transportation  TEXT,
    home_improvement TEXT,
    home_improvement_adult_animal TEXT,
    home_improvement_animal_with_disabilities TEXT,
    list_reasons_refuse_and_not_up_animal TEXT,
    recommendations_handler TEXT,
    shelter_id BIGINT REFERENCES shelters(id)
);

-- changeset asmokvin:33
ALTER TABLE recommendations_shelters ADD COLUMN dating_rules TEXT;

-- changeset asmokvin:34
ALTER TABLE shelters ADD COLUMN story_shelter TEXT;

-- changeset asmokvin:35
CREATE table list_documents
(
    id    BIGSERIAL PRIMARY KEY,
    document TEXT,
    shelter_id BIGINT REFERENCES shelters(id)
);