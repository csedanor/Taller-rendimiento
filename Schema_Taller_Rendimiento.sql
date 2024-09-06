CREATE SCHEMA electroshopDB;
use electroshopDB;

CREATE TABLE  if NOT EXISTS  `Producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(45) NULL,
  `stock` INT NULL, 
  `precio` FLOAT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table  `Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `correo` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table  `Pedido`
-- -----------------------------------------------------
use electroshopDB;
CREATE TABLE IF NOT EXISTS  `Pedido` (
  `idPedido` INT NOT NULL AUTO_INCREMENT,
  `Cliente_idCliente` INT NOT NULL,
  `total` FLOAT NULL,
  `estado` VARCHAR(10) NULL,
  `Numero_Tarjeta`LONG NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `fk_Pedido_Cliente_idx` (`Cliente_idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_Cliente`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES  `Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table  `Detalle_Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `Detalle_Pedido` (
  `Pedido_idPedido` INT NOT NULL ,
  `Producto_idProducto` INT NOT NULL,
  `cantidad` INT NULL,
  `Valor_Total` FLOAT NULL,

  INDEX `fk_Detalle_Pedido_Pedido1_idx` (`Pedido_idPedido` ASC) VISIBLE,
  INDEX `fk_Detalle_Pedido_Producto1_idx` (`Producto_idProducto` ASC) VISIBLE,
  PRIMARY KEY (`Producto_idProducto`, `Pedido_idPedido`),
  CONSTRAINT `fk_Detalle_Pedido_Pedido1`
    FOREIGN KEY (`Pedido_idPedido`)
    REFERENCES  `Pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detalle_Pedido_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES  `Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- ---------- SCRIPT PARA CLIENTES ----------
BEGIN;
INSERT INTO `Producto` (`nombre`, `descripcion`, `stock`, `precio`) VALUES
('Laptop X100', 'Laptop con procesador i5', 50, 799.99),
('Smartphone Pro 12', 'Smartphone con cámara de 108MP', 30, 999.99),
('Auriculares Bluetooth', 'Auriculares inalámbricos ', 100, 149.99),
('Teclado Mecánico', 'Teclado mecánico retroiluminado', 75, 89.99),
('Monitor 24 pulgadas', 'Monitor Full HD de 24 pulgadas', 40, 199.99),
('Ratón Gaming', 'Ratón con retroiluminación RGB', 60, 59.99),
('Disco Duro SSD 1TB', 'Disco duro SSD de 1TB', 25, 129.99),
('Cámara Web HD', 'Cámara web con calidad HD', 35, 79.99),
('Altavoces Estéreo', 'Altavoces estéreo con sonido envolvente', 45, 119.99),
('Tablet Pro 8', 'Tablet con pantalla de 8 pulgadas', 55, 199.99),
('Consola de Videojuegos', 'Consola de videojuegos', 20, 499.99),
('Impresora Láser', 'Impresora láser monocromática', 20, 129.99),
('Adaptador Wi-Fi', 'Adaptador Wi-Fi USB', 85, 29.99),
('Estación de Acoplamiento', 'Estación de acoplamiento para laptop', 40, 99.99),
('Cable HDMI', 'Cable HDMI de 2 metros', 100, 14.99),
('Mochila para Laptop', 'Mochila con compartimento para laptop', 60, 49.99),
('Hub USB 3.0', 'Hub USB 3.0 de 4 puertos', 90, 22.99),
('Silla Ergonómica', 'Silla de oficina ergonómica', 15, 179.99),
('Proyector HD', 'Proyector con resolución HD', 10, 499.99),
('Teclado y Ratón', 'Combo de teclado y ratón', 70, 39.99);
 -- --------- SCRIPT PARA PRODUCTOS ----------
INSERT INTO `Cliente` (`nombre`, `telefono`, `correo`, `direccion`) VALUES
('Ana Gómez', '555-1234', 'ana.gomez@email.com', 'Calle Falsa 123, Ciudad'),
('Luis Martínez', '555-5678', 'luis.martinez@email.com', 'Avenida Siempre Viva 456, Ciudad'),
('María López', '555-8765', 'maria.lopez@email.com', 'Plaza del Sol 789, Ciudad'),
('Pedro Fernández', '555-4321', 'pedro.fernandez@email.com', 'Calle Real 101, Ciudad'),
('Laura Pérez', '555-3456', 'laura.perez@email.com', 'Calle de la Luna 202, Ciudad'),
('Jorge Ramírez', '555-6543', 'jorge.ramirez@email.com', 'Calle del Sol 303, Ciudad'),
('Isabel Torres', '555-7890', 'isabel.torres@email.com', 'Avenida de la Paz 404, Ciudad'),
('Carlos Sánchez', '555-2345', 'carlos.sanchez@email.com', 'Calle Nueva 505, Ciudad'),
('Patricia Moreno', '555-6789', 'patricia.moreno@email.com', 'Calle de la Estrella 606, Ciudad'),
('Ricardo González', '555-9876', 'ricardo.gonzalez@email.com', 'Calle del Mar 707, Ciudad'),
('Sofia Ruiz', '555-5432', 'sofia.ruiz@email.com', 'Plaza Mayor 808, Ciudad'),
('Alejandro López', '555-3210', 'alejandro.lopez@email.com', 'Calle de la Alegría 909, Ciudad'),
('Gabriela Díaz', '555-4320', 'gabriela.diaz@email.com', 'Calle del Río 1010, Ciudad'),
('Julio Morales', '555-1235', 'julio.morales@email.com', 'Avenida del Norte 1111, Ciudad'),
('Natalia Herrera', '555-5670', 'natalia.herrera@email.com', 'Calle del Valle 1212, Ciudad'),
('Andrés Romero', '555-8760', 'andres.romero@email.com', 'Plaza del Árbol 1313, Ciudad'),
('Claudia Vargas', '555-4325', 'claudia.vargas@email.com', 'Calle del Bosque 1414, Ciudad'),
('Eduardo Fernández', '555-6540', 'eduardo.fernandez@email.com', 'Calle de los Jardines 1515, Ciudad'),
('Mónica Castillo', '555-7891', 'monica.castillo@email.com', 'Avenida del Río 1616, Ciudad'),
('Víctor López', '555-2340', 'victor.lopez@email.com', 'Calle de la Primavera 1717, Ciudad');

COMMIT;

SELECT * FROM electroshopdb.producto


