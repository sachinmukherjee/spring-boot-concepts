CREATE TABLE account (
    id BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    balance DECIMAL(19, 2),
    version BIGINT
);
