SET search_path TO application;

CREATE TABLE application.users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT now()
);

CREATE TABLE application.roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE application.user_roles (
    user_id UUID REFERENCES application.users(id) ON DELETE CASCADE,
    role_id INT REFERENCES application.roles(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);
