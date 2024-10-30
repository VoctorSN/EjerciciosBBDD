create schema bbdd if not exists;
USE bbdd;

CREATE TABLE Paises if not exists(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_pais VARCHAR(100) NOT NULL,
    numero_habitantes BIGINT,
    nombre_capital VARCHAR(100),
    nombre_moneda VARCHAR(50)
);


INSERT INTO Paises (nombre_pais, numero_habitantes, nombre_capital, nombre_moneda) 
VALUES 
('Estados Unidos', 331002651, 'Washington, D.C.', 'Dólar estadounidense'),
('Brasil', 212559417, 'Brasilia', 'Real brasileño'),
('India', 1380004385, 'Nueva Delhi', 'Rupia india'),
('China', 1439323776, 'Pekín', 'Renminbi'),
('Alemania', 83783942, 'Berlín', 'Euro'),
('Reino Unido', 67886011, 'Londres', 'Libra esterlina'),
('Francia', 65273511, 'París', 'Euro'),
('Italia', 60461826, 'Roma', 'Euro'),
('Canadá', 37742154, 'Ottawa', 'Dólar canadiense'),
('Australia', 25499884, 'Canberra', 'Dólar australiano');
