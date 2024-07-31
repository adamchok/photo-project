CREATE TABLE IF NOT EXISTS PHOTOS (
    id SERIAL PRIMARY KEY,
    file_name VARCHAR(255),
    content_type VARCHAR(255),
    data BYTEA
);
