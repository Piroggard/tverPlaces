CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  mail VARCHAR(255) NOT NULL,
  login VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_check_code (
    id int,
    code int,
    CONSTRAINT FK_idUser
    FOREIGN KEY (id)
    REFERENCES Users (id)
);

CREATE TABLE IF NOT EXCEPT event (
    id int,
    name VARCHAR(255)
);
CREATE TABLE IF NOT EXCEPT tуpe_places (
    id int,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXCEPT address (
    city VARCHAR(255),
    street VARCHAR(255),
    house VARCHAR(255)
);

CREATE TABLE IF NOT EXCEPT places (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(255),
    opening VARCHAR(255),
    closing VARCHAR(255),
);