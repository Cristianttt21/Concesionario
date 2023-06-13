DROP DATABASE concesionario;


CREATE DATABASE CONCESIONARIO;
USE CONCESIONARIO;

-- Crear la tabla Vehículo
CREATE TABLE Vehiculo (
  placa VARCHAR(10) PRIMARY KEY,
  marca VARCHAR(50),
  tipo VARCHAR(20),
  modelo INT,
  kilometraje INT
);

-- Crear la tabla RegistroVenta
CREATE TABLE RegistroVenta (
  venta_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  monto_venta DECIMAL(10, 2),
  vehiculo_placa VARCHAR(10),
  apellido VARCHAR(50),
  nombre VARCHAR(50),
  documento VARCHAR(20),
  FOREIGN KEY (vehiculo_placa) REFERENCES Vehiculo(placa)
);


ALTER TABLE RegistroVenta AUTO_INCREMENT = 1;