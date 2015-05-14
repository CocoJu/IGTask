#db name = price_db

CREATE TABLE cat (
  id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(255)
);

CREATE TABLE prod (
  id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  cat_id INTEGER,
  name VarCHAR(255),
  price FLOAT(16,2),
  FOREIGN KEY (cat_id) REFERENCES cat(id)
);