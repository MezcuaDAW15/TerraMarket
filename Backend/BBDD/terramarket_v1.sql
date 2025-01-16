CREATE SCHEMA `terramarket_v1` DEFAULT CHARACTER SET latin1 ;
CREATE TABLE `terramarket_v1`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `apellidos` VARCHAR(200) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `fechanacimiento` DATE NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `contraseña` VARCHAR(100) NOT NULL,
  `cp` CHAR(5) NOT NULL,
  `activo` TINYINT NOT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `terramarket_v1`.`direcciones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pais` VARCHAR(100) NOT NULL,
  `provincia` VARCHAR(100) NOT NULL,
  `ciudad` VARCHAR(100) NOT NULL,
  `cp` CHAR(5) NOT NULL,
  `calle` VARCHAR(100) NOT NULL,
  `numero` VARCHAR(4) NOT NULL,
  `puerta` VARCHAR(4) NULL,
  `piso` VARCHAR(10) NULL,
  `es_mercado` TINYINT NOT NULL,
  `es_tienda` TINYINT NOT NULL,
  `es_pr` TINYINT NOT NULL,
  PRIMARY KEY (`id`));
  CREATE TABLE `terramarket_v1`.`estados_pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `estado` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  CREATE TABLE `terramarket_v1`.`linea_pedidos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idpedido` INT NOT NULL,
  `idventa` INT NOT NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `terramarket_v1`.`mercados` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `direccion_f` VARCHAR(200) NOT NULL,
  `telefono` CHAR(9) NOT NULL,
  `activo` TINYINT NOT NULL DEFAULT 1,
  `imagen` VARCHAR(200) NULL DEFAULT NULL,
  `iddireccion` INT NOT NULL,
  PRIMARY KEY (`id`));
  CREATE TABLE `terramarket_v1`.`metodos_pago` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `descripcion` TEXT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `terramarket_v1`.`pedidos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idcliente` INT NOT NULL,
  `idpago` INT NOT NULL,
  `idpr` INT NOT NULL,
  `fecha_pedido` DATETIME NOT NULL,
  `fecha_compra` DATETIME NOT NULL,
  `fecha_entrega` DATETIME NULL DEFAULT NULL,
  `fecha_max_recogida` DATE NULL DEFAULT NULL,
  `fecha_factura` DATE NULL DEFAULT NULL,
  `num_factura` INT NULL DEFAULT 1,
  `estado` INT NULL,
  `importe` DOUBLE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `terramarket_v1`.`productos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NOT NULL,
  `imagen` VARCHAR(200) NULL,
  `idcategoria` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `terramarket_v1`.`punto_recogoida` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `iddireccion` INT NOT NULL,
  `nombre` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `terramarket_v1`.`rel_categorias_tienda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_tienda` INT NOT NULL,
  `id_categoria` INT NOT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `terramarket_v1`.`tiendas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `logo` VARCHAR(200) NULL DEFAULT NULL,
  `descripcion` TEXT NOT NULL,
  `activo` TINYINT NOT NULL DEFAULT 1,
  `imagen` VARCHAR(200) NULL DEFAULT NULL,
  `iddireccion` INT NOT NULL,
  `idmercado` INT NOT NULL,
  PRIMARY KEY (`id`));
  CREATE TABLE `terramarket_v1`.`valoraciones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idtienda` INT NOT NULL,
  `idcliente` INT NOT NULL,
  `puntuacion` INT NOT NULL,
  `resena` TEXT NULL,
  `fecha` DATETIME NOT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `terramarket_v1`.`vendedores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `apellidos` VARCHAR(200) NOT NULL,
  `dni` CHAR(9) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `contrasena` VARCHAR(100) NOT NULL,
  `activo` TINYINT NOT NULL DEFAULT 1,
  `idtienda` INT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `terramarket_v1`.`ventas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idproducto` INT NOT NULL,
  `idtienda` INT NOT NULL,
  `fecha_venta` DATETIME NOT NULL,
  `precio` FLOAT NOT NULL,
  `stock` FLOAT NOT NULL,
  `precio_kg` FLOAT NOT NULL,
  `descuento` FLOAT NULL,
  `descripcion` TEXT NULL,
  `activo` TINYINT NOT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `terramarket_v1`.`categorias_producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `descripcion` TEXT NULL,
  `id_categoria_tienda` INT NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `terramarket_v1`.`categorias_tienda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `descripcion` TEXT NOT NULL,
  `icono` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

  
  ALTER TABLE `terramarket_v1`.`linea_pedidos` 
ADD INDEX `FG_LINEAPEDIDO_PEDIDO1_idx` (`idpedido` ASC) VISIBLE,
ADD INDEX `FG_LINEAPEDIDO_VENTA1_idx` (`idventa` ASC) VISIBLE;
;
ALTER TABLE `terramarket_v1`.`linea_pedidos` 
ADD CONSTRAINT `FG_LINEAPEDIDO_PEDIDO1`
  FOREIGN KEY (`idpedido`)
  REFERENCES `terramarket_v1`.`pedidos` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FG_LINEAPEDIDO_VENTA1`
  FOREIGN KEY (`idventa`)
  REFERENCES `terramarket_v1`.`ventas` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  ALTER TABLE `terramarket_v1`.`mercados` 
ADD CONSTRAINT `FG_DIRECCION_MERCADO1`
  FOREIGN KEY (`iddireccion`)
  REFERENCES `terramarket_v1`.`direcciones` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  ALTER TABLE `terramarket_v1`.`pedidos` 
ADD INDEX `FG_PEDIDO_CLIENTE1_idx` (`idcliente` ASC) VISIBLE,
ADD INDEX `FG_PEDIDO_ESTADO1_idx` (`estado` ASC) VISIBLE,
ADD INDEX `FG_PEDIDO_PAGO1_idx` (`idpago` ASC) VISIBLE,
ADD INDEX `FG_PEDIDO_PR1_idx` (`idpr` ASC) VISIBLE;
;
ALTER TABLE `terramarket_v1`.`pedidos` 
ADD CONSTRAINT `FG_PEDIDO_CLIENTE1`
  FOREIGN KEY (`idcliente`)
  REFERENCES `terramarket_v1`.`clientes` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FG_PEDIDO_ESTADO1`
  FOREIGN KEY (`estado`)
  REFERENCES `terramarket_v1`.`estados_pedido` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FG_PEDIDO_PAGO1`
  FOREIGN KEY (`idpago`)
  REFERENCES `terramarket_v1`.`metodos_pago` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FG_PEDIDO_PR1`
  FOREIGN KEY (`idpr`)
  REFERENCES `terramarket_v1`.`punto_recogoida` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `terramarket_v1`.`punto_recogoida` 
ADD INDEX `FG_PR_DIRECCION1_idx` (`iddireccion` ASC) VISIBLE;
;
ALTER TABLE `terramarket_v1`.`punto_recogoida` 
ADD CONSTRAINT `FG_PR_DIRECCION1`
  FOREIGN KEY (`iddireccion`)
  REFERENCES `terramarket_v1`.`direcciones` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  ALTER TABLE `terramarket_v1`.`categorias_producto` 
ADD INDEX `FG_CATPRODUCTO_CATTIENDA1_idx` (`id_categoria_tienda` ASC) VISIBLE;
;
ALTER TABLE `terramarket_v1`.`categorias_producto` 
ADD CONSTRAINT `FG_CATPRODUCTO_CATTIENDA1`
  FOREIGN KEY (`id_categoria_tienda`)
  REFERENCES `terramarket_v1`.`categorias_tienda` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `terramarket_v1`.`rel_categorias_tienda` 
ADD INDEX `FG_CATEGORIA_CATEGORIA1_idx` (`id_categoria` ASC) VISIBLE;
;
ALTER TABLE `terramarket_v1`.`rel_categorias_tienda` 
ADD CONSTRAINT `FG_CATEGORIA_CATEGORIA1`
  FOREIGN KEY (`id_categoria`)
  REFERENCES `terramarket_v1`.`categorias_tienda` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FG_CATEGORIA_TIENDA1`
  FOREIGN KEY (`id_tienda`)
  REFERENCES `terramarket_v1`.`tiendas` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `terramarket_v1`.`tiendas` 
ADD INDEX `FG_DIRECCION_TIENDA1_idx` (`iddireccion` ASC) VISIBLE,
ADD INDEX `FG_MERCADO_TIENDA1_idx` (`idmercado` ASC) VISIBLE;
;
ALTER TABLE `terramarket_v1`.`tiendas` 
ADD CONSTRAINT `FG_DIRECCION_TIENDA1`
  FOREIGN KEY (`iddireccion`)
  REFERENCES `terramarket_v1`.`direcciones` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FG_MERCADO_TIENDA1`
  FOREIGN KEY (`idmercado`)
  REFERENCES `terramarket_v1`.`mercados` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE `terramarket_v1`.`valoraciones` 
ADD INDEX `FG_VALORACION_CLIENTE1_idx` (`idcliente` ASC) VISIBLE,
ADD INDEX `FG_VALORACION_TIENDA1_idx` (`idtienda` ASC) VISIBLE;
;
ALTER TABLE `terramarket_v1`.`valoraciones` 
ADD CONSTRAINT `FG_VALORACION_CLIENTE1`
  FOREIGN KEY (`idcliente`)
  REFERENCES `terramarket_v1`.`clientes` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FG_VALORACION_TIENDA1`
  FOREIGN KEY (`idtienda`)
  REFERENCES `terramarket_v1`.`tiendas` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `terramarket_v1`.`vendedores` 
ADD INDEX `FG_VENDEDOR_TIENDA1_idx` (`idtienda` ASC) VISIBLE;
;
ALTER TABLE `terramarket_v1`.`vendedores` 
ADD CONSTRAINT `FG_VENDEDOR_TIENDA1`
  FOREIGN KEY (`idtienda`)
  REFERENCES `terramarket_v1`.`tiendas` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  ALTER TABLE `terramarket_v1`.`ventas` 
ADD INDEX `FG_VENTA_PRODUCTO1_idx` (`idproducto` ASC) VISIBLE,
ADD INDEX `FG_VENTA_TIENDA1_idx` (`idtienda` ASC) VISIBLE;
;
ALTER TABLE `terramarket_v1`.`ventas` 
ADD CONSTRAINT `FG_VENTA_PRODUCTO1`
  FOREIGN KEY (`idproducto`)
  REFERENCES `terramarket_v1`.`productos` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FG_VENTA_TIENDA1`
  FOREIGN KEY (`idtienda`)
  REFERENCES `terramarket_v1`.`tiendas` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE `terramarket_v1`.`productos` 
CHANGE COLUMN `idcategoria` `idcategoria` INT NULL ,
ADD INDEX `FG_PRODUCTO_CATEGORIA1_idx` (`idcategoria` ASC) VISIBLE;
;
ALTER TABLE `terramarket_v1`.`productos` 
ADD CONSTRAINT `FG_PRODUCTO_CATEGORIA1`
  FOREIGN KEY (`idcategoria`)
  REFERENCES `terramarket_v1`.`categorias_producto` (`id`)
  ON DELETE SET NULL
  ON UPDATE CASCADE;