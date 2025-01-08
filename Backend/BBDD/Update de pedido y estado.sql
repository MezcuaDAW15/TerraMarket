ALTER TABLE `terramarket_v0`.`pedidos` 
CHANGE COLUMN `recogido` `estado` INT NULL DEFAULT NULL ;

CREATE TABLE `terramarket_v0`.`estados_pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `estado` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
  
  ALTER TABLE `terramarket_v0`.`pedidos` 
ADD INDEX `FG_PEDIDO_ESTADO1_idx` (`estado` ASC) VISIBLE;
;
ALTER TABLE `terramarket_v0`.`pedidos` 
ADD CONSTRAINT `FG_PEDIDO_ESTADO1`
  FOREIGN KEY (`estado`)
  REFERENCES `terramarket_v0`.`estados_pedido` (`id`)
  ON DELETE SET NULL
  ON UPDATE CASCADE;