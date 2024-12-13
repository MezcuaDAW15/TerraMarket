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
  `descripcion` TEXT NOT NULL,vendedores
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