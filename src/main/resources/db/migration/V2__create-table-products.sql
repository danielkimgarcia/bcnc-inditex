CREATE TABLE products(id BIGINT PRIMARY KEY, name VARCHAR(255), brand_id BIGINT, FOREIGN KEY(brand_id) REFERENCES brands)