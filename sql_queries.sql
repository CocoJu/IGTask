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
VALUES ('��������'),
        ('�����'),
        ('����������'),
        ('���������')

INSERT INTO prod(cat_id,name,price)
VALUES (1,'������� Epson L800', 11670.50),
  (1,'������� Epson L200', 8890.50),
  (1,'������� Canon PIXMA MG3540', 3090.20),
  (1,'������� Canon PIXMA MG2440', 1817.00),
  (2,'���� Philips Laserfax 5125', 7400.80),
  (2,'���� Panasonic KX-FLC418 RU', 12500.60),
  (2,'���� Panasonic KX-FP207RU', 5200.10),
  (3,'�������� ASUS ET2322INTH-B001R', 62000.10),
  (3,'�������� ASUS ET2321IUKH-B004R', 45500.10),
  (3,'�������� ASUS ET2321INTH-B020R', 75000.00),
  (4,'�������� Epson T1706 �������� (BK-C-M-Y)', 3200.80),
  (4,'�������� ��� �������� HP 121b', 2500.90),
  (4,'�������� Uniton ��-130', 850.00)