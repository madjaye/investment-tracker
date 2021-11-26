CREATE TABLE category (
    name VARCHAR(100),
    user_id INT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    active BOOLEAN NOT NULL,
    PRIMARY KEY(name, user_id, active)
);