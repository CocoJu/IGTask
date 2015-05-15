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


INSERT INTO cat (name)
VALUES ('принтеры'),
        ('факсы'),
        ('компьютеры'),
        ('картриджи')

INSERT INTO prod(cat_id,name,price)
VALUES (1,'принтер Epson L800', 11670.50),
  (1,'принтер Epson L200', 8890.50),
  (1,'принтер Canon PIXMA MG3540', 3090.20),
  (1,'принтер Canon PIXMA MG2440', 1817.00),
  (2,'факс Philips Laserfax 5125', 7400.80),
  (2,'факс Panasonic KX-FLC418 RU', 12500.60),
  (2,'факс Panasonic KX-FP207RU', 5200.10),
  (3,'Моноблок ASUS ET2322INTH-B001R', 62000.10),
  (3,'Моноблок ASUS ET2321IUKH-B004R', 45500.10),
  (3,'Моноблок ASUS ET2321INTH-B020R', 75000.00),
  (4,'Картридж Epson T1706 комплект (BK-C-M-Y)', 3200.80),
  (4,'Картридж для принтера HP 121b', 2500.90),
  (4,'Картридж Uniton ТК-130', 850.00)