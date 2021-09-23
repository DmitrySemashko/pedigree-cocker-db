create table users
(
    id        int          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name varchar(255) not null,
    password  varchar(20)  not null,
    email     varchar(50)  not null

);

CREATE TABLE user_roles
(
    user_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),

    UNIQUE (user_id)
);

CREATE TABLE dog
(
    id            bigint       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name          varchar(255) not null,
    number        varchar(255),
    mother_id     bigint,
    father_id     bigint,
    gender        enum ('male','female'),
    date_birth    date,
    land_birth    varchar(100),
    land_standing varchar(100),
    colour        enum ('black',
        'red',
        'golden',
        'liver',
        'black_and_tan',
        'liver_and_tan',
        'black_and_white',
        'orange_and_white',
        'liver_and_white',
        'lemon_and_white',
        'black_white_and_tan',
        'liver_white_and_tan',
        'blue_roan',
        'orange_roan',
        'lemon_roan',
        'liver_roan',
        'blue_roan_and_tan'),
    titles        varchar(10),
    photo         BLOB,
    owner_id      BIGINT,
    breeder_id    BIGINT,
    kennel_id     BIGINT,
    FOREIGN KEY (mother_id) REFERENCES dog (id),
    FOREIGN KEY (father_id) REFERENCES dog (id),
    FOREIGN KEY (owner_id) REFERENCES owner (id),
    FOREIGN KEY (breeder_id) REFERENCES breeder (id),
    FOREIGN KEY (kennel_id) REFERENCES kennel (id)
);

CREATE TABLE owner
(
    id        BIGINT NOT NULL AUTO_INCREMENT,
    name      varchar(255),
    last_name varchar(255),
    dog_id    BIGINT
);
CREATE TABLE breeder
(
    id        BIGINT NOT NULL AUTO_INCREMENT,
    name      varchar(255),
    last_name varchar(255),
    dog_id    BIGINT
);

CREATE TABLE kennel
(
    id         BIGINT NOT NULL AUTO_INCREMENT,
    name       varchar(255),
    owner_id   BIGINT,
    breeder_id BIGINT,
    FOREIGN KEY (owner_id) REFERENCES owner (id),
    FOREIGN KEY (breeder_id)REFERENCES breeder(id)
);