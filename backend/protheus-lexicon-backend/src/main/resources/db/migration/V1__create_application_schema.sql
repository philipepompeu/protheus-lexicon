CREATE SCHEMA IF NOT EXISTS application;

SET search_path TO application;

CREATE TABLE IF NOT EXISTS schema_registry (
    id SERIAL PRIMARY KEY,
    schema_name TEXT UNIQUE NOT NULL,
    db_url TEXT NOT NULL,
    db_username TEXT NOT NULL,
    db_password TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT now()
);
