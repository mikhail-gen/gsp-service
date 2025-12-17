-- create schema if it doesn't exist
CREATE SCHEMA IF NOT EXISTS gsp;

-- set search path to gsp
SET search_path TO gsp;

-- create users table
CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,

    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,

    email VARCHAR(255) NOT NULL UNIQUE,

    photo_url VARCHAR(512),

    pinfl VARCHAR(14) NOT NULL UNIQUE,

    age INTEGER NOT NULL CHECK (age >= 0 AND age <= 150),

    gender VARCHAR(50) NOT NULL,

    document_type VARCHAR(50) NOT NULL,

    issue_date DATE NOT NULL,

    expiry_date DATE NOT NULL,

    citizenship VARCHAR(100) NOT NULL
);

-- optional: add constraint to ensure expiry_date is after issue_date
ALTER TABLE users
ADD CONSTRAINT chk_expiry_after_issue
CHECK (expiry_date > issue_date);