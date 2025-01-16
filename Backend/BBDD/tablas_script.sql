CREATE TABLE `terramarket_v0`.`mercados` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `direccion_f` VARCHAR(200) NOT NULL,
  `telefono` CHAR(9) NOT NULL,
  `activo` TINYINT NOT NULL DEFAULT 1,
  `imagen` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `terramarket_v0`.`tiendas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `logo` VARCHAR(200) NULL,
  `descripcion` TEXT NOT NULL,
  `activo` TINYINT NOT NULL DEFAULT 1,
  `imagen` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));
  CREATE TABLE `terramarket_v0`.`vendedores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `apellidos` VARCHAR(200) NOT NULL,
  `dni` CHAR(9) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `contrasena` VARCHAR(100) NOT NULL,
  `activo` TINYINT NULL DEFAULT 1,
  PRIMARY KEY (`id`));
  CREATE TABLE `terramarket_v0`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `apellidos` VARCHAR(200) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `fechanacimiento` DATE NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `contrasena` VARCHAR(100) NOT NULL,
  `cp` CHAR(5) NOT NULL,
  `activo` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`));
  CREATE TABLE `terramarket_v0`.`direcciones` (
  `id` INT NOT NULL,
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
  CREATE TABLE `terramarket_v0`.`categorias_tienda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `descripcion` TEXT NOT NULL,
  `icono` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));
  
  ALTER TABLE `terramarket_v0`.`mercados` 
ADD COLUMN `iddireccion` INT NOT NULL AFTER `imagen`,
ADD INDEX `FG_DIRECCION_MERCADO1_idx` (`iddireccion` ASC) VISIBLE;
;
ALTER TABLE `terramarket_v0`.`mercados` 
ADD CONSTRAINT `FG_DIRECCION_MERCADO1`
  FOREIGN KEY (`iddireccion`)
  REFERENCES `terramarket_v0`.`direcciones` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE `terramarket_v0`.`tiendas` 
ADD COLUMN `iddireccion` INT NOT NULL AFTER `imagen`,
ADD COLUMN `idmercado` INT NOT NULL AFTER `iddireccion`,
ADD INDEX `FG_DIRECCION_TIENDA1_idx` (`iddireccion` ASC) VISIBLE,
ADD INDEX `FG_MERCADO_TIENDA1_idx` (`idmercado` ASC) VISIBLE;
;
ALTER TABLE `terramarket_v0`.`tiendas` 
ADD CONSTRAINT `FG_DIRECCION_TIENDA1`
  FOREIGN KEY (`iddireccion`)
  REFERENCES `terramarket_v0`.`direcciones` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FG_MERCADO_TIENDA1`
  FOREIGN KEY (`idmercado`)
  REFERENCES `terramarket_v0`.`mercados` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
CREATE TABLE `terramarket_v0`.`rel_categorias_tienda` (
  `idtienda` INT NOT NULL,
  `idcategoria` INT NOT NULL,
  PRIMARY KEY (`idtienda`, `idcategoria`),
  INDEX `FG_CATEGORIA_CATEGORIA1_idx` (`idcategoria` ASC) VISIBLE,
  CONSTRAINT `FG_CATEGORIA_TIENDA1`
    FOREIGN KEY (`idtienda`)
    REFERENCES `terramarket_v0`.`tiendas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FG_CATEGORIA_CATEGORIA1`
    FOREIGN KEY (`idcategoria`)
    REFERENCES `terramarket_v0`.`categorias_tienda` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;
ALTER TABLE `terramarket_v0`.`vendedores` 
ADD COLUMN `idtienda` INT NOT NULL AFTER `activo`,
ADD INDEX `FG_VENDEDOR_TIENDA1_idx` (`idtienda` ASC) VISIBLE;
;
ALTER TABLE `terramarket_v0`.`vendedores` 
ADD CONSTRAINT `FG_VENDEDOR_TIENDA1`
  FOREIGN KEY (`idtienda`)
  REFERENCES `terramarket_v0`.`tiendas` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
CREATE TABLE `terramarket_v0`.`punto_recogoida` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `iddireccion` INT NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FG_PR_DIRECCION1_idx` (`iddireccion` ASC) VISIBLE,
  CONSTRAINT `FG_PR_DIRECCION1`
    FOREIGN KEY (`iddireccion`)
    REFERENCES `terramarket_v0`.`direcciones` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE TABLE `terramarket_v0`.`productos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `imagen` VARCHAR(200) NULL,
  `idcategoria` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

CREATE TABLE `terramarket_v0`.`categorias_producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `descripcion` TEXT NULL,
  PRIMARY KEY (`id`));
  
ALTER TABLE `terramarket_v0`.`categorias_producto` 
ADD COLUMN `idcategoria_tienda` INT NOT NULL AFTER `descripcion`,
ADD INDEX `FG_CATPRODUCTO_CATTIENDA1_idx` (`idcategoria_tienda` ASC) VISIBLE;

ALTER TABLE `terramarket_v0`.`categorias_producto` 
ADD CONSTRAINT `FG_CATPRODUCTO_CATTIENDA1`
  FOREIGN KEY (`idcategoria_tienda`)
  REFERENCES `terramarket_v0`.`categorias_tienda` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
CREATE TABLE `terramarket_v0`.`metodos_pago` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `descripcion` TEXT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `terramarket_v0`.`pedidos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idcliente` INT NOT NULL,
  `idpago` INT NOT NULL,
  `idpr` INT NOT NULL,
  `fecha_pedido` DATETIME NOT NULL,
  `fecha_compra` DATETIME NOT NULL,
  `fecha_entrega` DATETIME NULL,
  `fecha_max_recogida` DATE NULL,
  `fecha_factura` DATE NULL,
  `num_factura` INT NULL,
  `recogido` TINYINT NULL,
  `importe` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FG_PEDIDO_CLIENTE1_idx` (`idcliente` ASC) VISIBLE,
  INDEX `FG_PEDIDO_PAGO1_idx` (`idpago` ASC) VISIBLE,
  INDEX `FG_PEDIDO_PR1_idx` (`idpr` ASC) VISIBLE,
  CONSTRAINT `FG_PEDIDO_CLIENTE1`
    FOREIGN KEY (`idcliente`)
    REFERENCES `terramarket_v0`.`clientes` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FG_PEDIDO_PAGO1`
    FOREIGN KEY (`idpago`)
    REFERENCES `terramarket_v0`.`metodos_pago` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FG_PEDIDO_PR1`
    FOREIGN KEY (`idpr`)
    REFERENCES `terramarket_v0`.`punto_recogoida` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `terramarket_v0`.`ventas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idproducto` INT NOT NULL,
  `idtienda` INT NOT NULL,
  `fecha_venta` DATETIME NOT NULL,
  `precio` FLOAT NOT NULL,
  `stock` FLOAT NOT NULL,
  `precio_kg` FLOAT NULL,
  `descuento` FLOAT NULL,
  `descripcion` TEXT NOT NULL,
  `activo` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `FG_VENTA_PRODUCTO1_idx` (`idproducto` ASC) VISIBLE,
  INDEX `FG_VENTA_TIENDA1_idx` (`idtienda` ASC) VISIBLE,
  CONSTRAINT `FG_VENTA_PRODUCTO1`
    FOREIGN KEY (`idproducto`)
    REFERENCES `terramarket_v0`.`productos` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FG_VENTA_TIENDA1`
    FOREIGN KEY (`idtienda`)
    REFERENCES `terramarket_v0`.`tiendas` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `terramarket_v0`.`linea_pedidos` (
  `idpedido` INT NOT NULL,
  `idventa` INT NOT NULL,
  `cantidad` FLOAT NOT NULL,
  `fecha` DATETIME NOT NULL,
  PRIMARY KEY (`idpedido`, `idventa`),
  INDEX `FG_LINEAPEDIDO_VENTA1_idx` (`idventa` ASC) VISIBLE,
  CONSTRAINT `FG_LINEAPEDIDO_PEDIDO1`
    FOREIGN KEY (`idpedido`)
    REFERENCES `terramarket_v0`.`pedidos` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FG_LINEAPEDIDO_VENTA1`
    FOREIGN KEY (`idventa`)
    REFERENCES `terramarket_v0`.`ventas` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `terramarket_v0`.`valoraciones` (
  `idtienda` INT NOT NULL,
  `idcliente` INT NOT NULL,
  `puntacion` INT NOT NULL,
  `resena` TEXT NULL,
  `fecha` DATETIME NOT NULL,
  PRIMARY KEY (`idtienda`, `idcliente`),
  INDEX `FG_VALORACION_CLIENTE1_idx` (`idcliente` ASC) VISIBLE,
  CONSTRAINT `FG_VALORACION_TIENDA1`
    FOREIGN KEY (`idtienda`)
    REFERENCES `terramarket_v0`.`tiendas` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FG_VALORACION_CLIENTE1`
    FOREIGN KEY (`idcliente`)
    REFERENCES `terramarket_v0`.`clientes` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    ALTER TABLE `terramarket_v0`.`punto_recogoida` 
RENAME TO  `terramarket_v0`.`punto_recogida` ;
