CREATE DATABASE  IF NOT EXISTS `terramarket_v1` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `terramarket_v1`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: terramarket_v1
-- ------------------------------------------------------
-- Server version	8.4.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorias_producto`
--

DROP TABLE IF EXISTS `categorias_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias_producto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text,
  `id_categoria_tienda` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FG_CATPRODUCTO_CATTIENDA1_idx` (`id_categoria_tienda`),
  CONSTRAINT `FG_CATPRODUCTO_CATTIENDA1` FOREIGN KEY (`id_categoria_tienda`) REFERENCES `categorias_tienda` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias_producto`
--

LOCK TABLES `categorias_producto` WRITE;
/*!40000 ALTER TABLE `categorias_producto` DISABLE KEYS */;
INSERT INTO `categorias_producto` VALUES (1,'Pollo','Entero, en piezas, alitas, muslos, etc.',1),(2,'Pavo','Carne de pavo.',1),(3,'Codorniz','Carne de codorniz.',1),(4,'Pato','Carne de pato.',1),(5,'Huevos','Huevos de gallina, codorniz, orgánicos.',1),(6,'Carne de res','Filetes, costillas, chuletas, etc.',2),(7,'Carne de cerdo','Costillas, lomo, chuletas, etc.',2),(8,'Carne de cordero','Carne de cordero.',2),(9,'Carne de ternera','Carne de ternera.',2),(10,'Jamones','Serrano, ibérico, cocido, etc.',3),(11,'Embutidos','Chorizo, salchichón, lomo, etc.',3),(12,'Quesos','Curados, frescos, semicurados, de cabra, oveja, vaca.',3),(13,'Patés y foie gras','Variedad de patés y foie gras.',3),(14,'Especias secas','Orégano, tomillo, laurel, albahaca, etc.',4),(15,'Pimientas','Negra, blanca, roja, etc.',4),(16,'Sal','Sal marina, rosa, ahumada, de hierbas.',4),(17,'Salsas','Soja, teriyaki, barbacoa, tabasco.',4),(18,'Hierbas aromáticas frescas','Cilantro, perejil, albahaca.',4),(19,'Frutas','Manzanas, peras, plátanos, uvas, naranjas, etc.',5),(20,'Verduras','Tomates, zanahorias, lechugas, espinacas, cebollas, etc.',5),(21,'Setas y hongos','Variedad de setas y hongos.',5),(22,'Frutos secos enteros','Enteros.',6),(23,'Frutos secos pelados','Pelados.',6),(24,'Frutos secos tostados y salados','Tostados y salados.',6),(25,'Semillas','Calabaza, girasol, chía, lino.',6),(26,'Productos gourmet','Aceites de oliva premium, vinagres, trufas.',7),(27,'Mariscos congelados','Variedad de mariscos congelados.',7),(28,'Helados y sorbetes','Helados y sorbetes.',7),(29,'Panes y pasteles congelados','Variedad de panes y pasteles congelados.',7),(30,'Panes','Baguettes, chapatas, integrales, de molde, etc.',8),(31,'Bollería','Croissants, napolitanas, mantecadas, etc.',8),(32,'Pasteles y tartas','De frutas, chocolate, mousse, etc.',8),(33,'Galletas','Digestive, de chocolate, hojaldradas.',8),(34,'Productos sin gluten','Productos sin gluten.',8),(35,'Sandwiches y bocadillos','Variedad de sandwiches y bocadillos.',9),(36,'Ensaladas','De pasta, atún, pollo.',9),(37,'Platos preparados','Platos preparados.',9),(38,'Zumos y batidos','Variedad de zumos y batidos.',9),(39,'Pescado fresco','Merluza, salmón, atún, dorada, etc.',10),(40,'Mariscos frescos','Langostinos, camarones, almejas, mejillones.',10),(41,'Pescado en conserva','Atún, sardinas, boquerones.',10),(42,'Calamares y sepias','Calamares y sepias.',10),(43,'Alimentos asiáticos','Salsas de soja, arroz jazmín, noodles.',11),(44,'Alimentos latinos','Arepas, plátanos, guanábanas.',11),(45,'Condimentos internacionales','Tandoori, salsa de pescado.',11),(46,'Salazones de pescado','Bacalao, mojama, etc.',12),(47,'Salazones de carne','Jamón, cecina.',12),(48,'Encurtidos','Pepinos, cebollitas, zanahorias.',12),(49,'Aceitunas','Negras, verdes, rellenas.',12),(50,'Bebidas','Gaseosas, jugos, agua, tés.',13),(51,'Accesorios de cocina','Ollas, sartenes, utensilios.',13),(52,'Artículos de hogar','Velas, detergentes, ambientadores.',13),(53,'Otros','Otros artículos no alimentación.',13);
/*!40000 ALTER TABLE `categorias_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias_tienda`
--

DROP TABLE IF EXISTS `categorias_tienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias_tienda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text NOT NULL,
  `icono` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias_tienda`
--

LOCK TABLES `categorias_tienda` WRITE;
/*!40000 ALTER TABLE `categorias_tienda` DISABLE KEYS */;
INSERT INTO `categorias_tienda` VALUES (1,'Aves y derivados','Productos de aves como pollo, pavo, pato y huevos.','icon_aves.png'),(2,'Carnicería','Carne de res, cerdo, cordero y ternera.','icon_carniceria.png'),(3,'Charcutería y quesos','Jamones, embutidos, quesos y patés.','icon_charcuteria.png'),(4,'Especias','Especias, sal, pimientas y hierbas aromáticas.','icon_especias.png'),(5,'Frutas y verduras','Frutas, verduras, setas y hongos.','icon_frutas.png'),(6,'Frutos secos','Frutos secos y semillas.','icon_frutos_secos.png'),(7,'Gourmet y congelados','Productos gourmet, mariscos congelados y helados.','icon_gourmet.png'),(8,'Panadería y pastelería','Panes, bollería, pasteles y productos sin gluten.','icon_panaderia.png'),(9,'Para llevar','Platos preparados, sandwiches y bebidas.','icon_para_llevar.png'),(10,'Pescados y mariscos','Pescado y mariscos frescos o en conserva.','icon_pescados.png'),(11,'Productos internacionales','Alimentos asiáticos, latinos y condimentos.','icon_internacionales.png'),(12,'Salazones y encurtidos','Salazones y encurtidos variados.','icon_salazones.png'),(13,'Varios no alimentación','Artículos de hogar y accesorios de cocina.','icon_varios.png');
/*!40000 ALTER TABLE `categorias_tienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(200) NOT NULL,
  `username` varchar(45) NOT NULL,
  `fechanacimiento` datetime NOT NULL,
  `email` varchar(200) NOT NULL,
  `contrasena` varchar(100) NOT NULL,
  `cp` char(5) NOT NULL,
  `activo` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Juan','Pérez García','juanpe','1985-05-15 00:00:00','juan@example.com','1234','28001',1),(2,'Mario','López Fernández','marialf','1990-10-20 00:00:00','maria@example.com','5678','08001',1),(3,'andrea','prueba','andrea','2025-01-17 00:00:00','prueba2@prueba2.com','1234','46530',0),(4,'andrea prueba','prueba prueba','andrea','2025-01-17 00:00:00','prueba2@prueba2.com','1234','46530',1);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direcciones`
--

DROP TABLE IF EXISTS `direcciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direcciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pais` varchar(100) NOT NULL,
  `provincia` varchar(100) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  `cp` char(5) NOT NULL,
  `calle` varchar(100) NOT NULL,
  `numero` varchar(4) NOT NULL,
  `puerta` varchar(4) DEFAULT NULL,
  `piso` varchar(10) DEFAULT NULL,
  `es_mercado` tinyint NOT NULL,
  `es_tienda` tinyint NOT NULL,
  `es_pr` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones`
--

LOCK TABLES `direcciones` WRITE;
/*!40000 ALTER TABLE `direcciones` DISABLE KEYS */;
INSERT INTO `direcciones` VALUES (1,'España','Madrid','Madrid','28001','Calle Mayor','10','B','2',1,0,0),(2,'España','Barcelona','Barcelona','08001','Passeig de Gràcia','5',NULL,NULL,1,0,0),(3,'España','Valencia','Valencia','46001','Avenida del Oeste','20',NULL,'1',0,1,0),(4,'España','Sevilla','Sevilla','41001','Calle Sierpes','15',NULL,NULL,0,1,0),(5,'España','Madrid','Madrid','28002','Calle Serrano','50',NULL,NULL,0,0,1),(6,'España','Madrid','Madrid','28001','Calle Mayor','5','A','3',1,0,0),(7,'España','Barcelona','Barcelona','08001','Avinguda Diagonal','100','B','1',1,0,0),(8,'España','Valencia','Valencia','46001','Carrer de Xàtiva','25','C','2',1,0,0);
/*!40000 ALTER TABLE `direcciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados_pedido`
--

DROP TABLE IF EXISTS `estados_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estados_pedido` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados_pedido`
--

LOCK TABLES `estados_pedido` WRITE;
/*!40000 ALTER TABLE `estados_pedido` DISABLE KEYS */;
INSERT INTO `estados_pedido` VALUES (1,'Pendiente'),(2,'En Preparación'),(3,'Pendiente de recogida'),(4,'Recogido'),(5,'Cancelado');
/*!40000 ALTER TABLE `estados_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linea_pedidos`
--

DROP TABLE IF EXISTS `linea_pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `linea_pedidos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idpedido` int NOT NULL,
  `idventa` int NOT NULL,
  `cantidad` int NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FG_LINEAPEDIDO_PEDIDO1_idx` (`idpedido`),
  KEY `FG_LINEAPEDIDO_VENTA1_idx` (`idventa`),
  CONSTRAINT `FG_LINEAPEDIDO_PEDIDO1` FOREIGN KEY (`idpedido`) REFERENCES `pedidos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FG_LINEAPEDIDO_VENTA1` FOREIGN KEY (`idventa`) REFERENCES `ventas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linea_pedidos`
--

LOCK TABLES `linea_pedidos` WRITE;
/*!40000 ALTER TABLE `linea_pedidos` DISABLE KEYS */;
INSERT INTO `linea_pedidos` VALUES (1,1,1,3,'2025-01-20 11:51:56'),(2,1,2,1,'2025-01-31 00:00:00');
/*!40000 ALTER TABLE `linea_pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mercados`
--

DROP TABLE IF EXISTS `mercados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mercados` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `direccion_f` varchar(200) NOT NULL,
  `telefono` char(9) NOT NULL,
  `activo` tinyint NOT NULL DEFAULT '1',
  `imagen` varchar(200) DEFAULT NULL,
  `iddireccion` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FG_DIRECCION_MERCADO1_idx` (`iddireccion`),
  CONSTRAINT `FG_DIRECCION_MERCADO1` FOREIGN KEY (`iddireccion`) REFERENCES `direcciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mercados`
--

LOCK TABLES `mercados` WRITE;
/*!40000 ALTER TABLE `mercados` DISABLE KEYS */;
INSERT INTO `mercados` VALUES (1,'Mercado Central Madrid','contacto@mercadocentralmadrid.com','Calle Mayor, 5, A, 3, Madrid, 28001, España','912345678',1,'imagen_mercado_madrid.jpg',6),(2,'Mercado de Barcelona','contacto@mercadobarcelona.com','Avinguda Diagonal, 100, B, 1, Barcelona, 08001, España','933456789',1,'imagen_mercado_barcelona.jpg',7),(3,'Mercado de Valencia','contacto@mercadovalencia.com','Carrer de Xàtiva, 25, C, 2, Valencia, 46001, España','961234567',1,'imagen_mercado_valencia.jpg',8);
/*!40000 ALTER TABLE `mercados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metodos_pago`
--

DROP TABLE IF EXISTS `metodos_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `metodos_pago` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metodos_pago`
--

LOCK TABLES `metodos_pago` WRITE;
/*!40000 ALTER TABLE `metodos_pago` DISABLE KEYS */;
INSERT INTO `metodos_pago` VALUES (1,'Tarjeta de Crédito','Paga con tu tarjeta de crédito habitual'),(2,'Paypal','Paga cómodamente con tu cuenta de Paypal');
/*!40000 ALTER TABLE `metodos_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idcliente` int NOT NULL,
  `idpago` int NOT NULL,
  `idpr` int NOT NULL,
  `fecha_pedido` datetime NOT NULL,
  `fecha_compra` datetime NOT NULL,
  `fecha_entrega` datetime DEFAULT NULL,
  `fecha_max_recogida` date DEFAULT NULL,
  `fecha_factura` date DEFAULT NULL,
  `num_factura` int DEFAULT '1',
  `estado` int DEFAULT NULL,
  `importe` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FG_PEDIDO_CLIENTE1_idx` (`idcliente`),
  KEY `FG_PEDIDO_ESTADO1_idx` (`estado`),
  KEY `FG_PEDIDO_PAGO1_idx` (`idpago`),
  KEY `FG_PEDIDO_PR1_idx` (`idpr`),
  CONSTRAINT `FG_PEDIDO_CLIENTE1` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FG_PEDIDO_ESTADO1` FOREIGN KEY (`estado`) REFERENCES `estados_pedido` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FG_PEDIDO_PAGO1` FOREIGN KEY (`idpago`) REFERENCES `metodos_pago` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FG_PEDIDO_PR1` FOREIGN KEY (`idpr`) REFERENCES `punto_recogida` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,1,1,1,'2024-12-16 12:36:13','2024-12-16 12:36:13',NULL,'2025-02-01',NULL,NULL,1,25.55);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `imagen` varchar(200) DEFAULT NULL,
  `idcategoria` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FG_PRODUCTO_CATEGORIA1_idx` (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Pollo entero','pollo_entero.jpg',1),(2,'Alitas de pollo','alitas_pollo.jpg',1),(3,'Muslos de pollo','muslos_pollo.jpg',1),(4,'Pavo entero','pavo_entero.jpg',2),(5,'Codorniz','codorniz.jpg',3),(6,'Pato','pato.jpg',4),(7,'Huevos orgánicos','huevos_organicos.jpg',5),(8,'Huevos de gallina','huevos_gallina.jpg',5),(9,'Filete de res','filete_res.jpg',6),(10,'Costillas de res','costillas_res.jpg',6),(11,'Chuletas de cerdo','chuletas_cerdo.jpg',7),(12,'Costillas de cerdo','costillas_cerdo.jpg',7),(13,'Carne de cordero','carne_cordero.jpg',8),(14,'Carne de ternera','carne_ternera.jpg',9),(15,'Jamón serrano','jamon_serrano.jpg',10),(16,'Jamón ibérico','jamon_iberico.jpg',10),(17,'Chorizo','chorizo.jpg',11),(18,'Lomo embuchado','lomo_embuchado.jpg',11),(19,'Queso manchego','queso_manchego.jpg',12),(20,'Queso de cabra','queso_cabra.jpg',12),(21,'Paté de hígado','pate_higado.jpg',13),(22,'Orégano seco','oregano_seco.jpg',14),(23,'Pimienta negra','pimienta_negra.jpg',15),(24,'Sal marina','sal_marina.jpg',16),(25,'Salsa de soja','salsa_soja.jpg',17),(26,'Cilantro fresco','cilantro_fresco.jpg',18),(27,'Manzanas','manzanas.jpg',19),(28,'Plátanos','platanos.jpg',19),(29,'Tomates','tomates.jpg',20),(30,'Zanahorias','zanahorias.jpg',20),(31,'Setas shiitake','setas_shiitake.jpg',21),(32,'Almendras enteras','almendras_enteras.jpg',22),(33,'Nueces peladas','nueces_peladas.jpg',23),(34,'Pipas de girasol tostadas','pipas_girasol.jpg',24),(35,'Semillas de chía','semillas_chia.jpg',25),(36,'Aceite de oliva premium','aceite_oliva.jpg',26),(37,'Trufas negras','trufas_negras.jpg',26),(38,'Langostinos congelados','langostinos_congelados.jpg',27),(39,'Helado de vainilla','helado_vainilla.jpg',28),(40,'Pan de molde congelado','pan_molde.jpg',29),(41,'Baguette','baguette.jpg',30),(42,'Croissant','croissant.jpg',31),(43,'Tarta de chocolate','tarta_chocolate.jpg',32),(44,'Galletas de chocolate','galletas_chocolate.jpg',33),(45,'Pan sin gluten','pan_sin_gluten.jpg',34),(46,'Sandwich de jamón y queso','sandwich_jamon_queso.jpg',35),(47,'Ensalada de pasta','ensalada_pasta.jpg',36),(48,'Lasaña preparada','lasagna_preparada.jpg',37),(49,'Zumo de naranja','zumo_naranja.jpg',38),(50,'Merluza fresca','merluza_fresca.jpg',39),(51,'Langostinos frescos','langostinos_frescos.jpg',40),(52,'Atún en lata','atun_lata.jpg',41),(53,'Calamares congelados','calamares_congelados.jpg',42),(54,'Arroz jazmín','arroz_jazmin.jpg',43),(55,'Arepas','arepas.jpg',44),(56,'Salsa tandoori','salsa_tandoori.jpg',45),(57,'Bacalao salado','bacalao_salado.jpg',46),(58,'Jamón curado','jamon_curado.jpg',47),(59,'Pepinillos en vinagre','pepinillos.jpg',48),(60,'Aceitunas rellenas','aceitunas_rellenas.jpg',49),(61,'Botella de agua','botella_agua.jpg',50),(62,'Cacerola','cacerola.jpg',51),(63,'Velas aromáticas','velas_aromaticas.jpg',52),(64,'Otros accesorios','otros_accesorios.jpg',53);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `punto_recogida`
--

DROP TABLE IF EXISTS `punto_recogida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `punto_recogida` (
  `id` int NOT NULL AUTO_INCREMENT,
  `iddireccion` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FG_PR_DIRECCION1_idx` (`iddireccion`),
  CONSTRAINT `FG_PR_DIRECCION1` FOREIGN KEY (`iddireccion`) REFERENCES `direcciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `punto_recogida`
--

LOCK TABLES `punto_recogida` WRITE;
/*!40000 ALTER TABLE `punto_recogida` DISABLE KEYS */;
INSERT INTO `punto_recogida` VALUES (1,5,'Punto de Recogida Madrid Centro');
/*!40000 ALTER TABLE `punto_recogida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_categorias_tienda`
--

DROP TABLE IF EXISTS `rel_categorias_tienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rel_categorias_tienda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_tienda` int DEFAULT NULL,
  `id_categoria` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FG_CATEGORIA_CATEGORIA1_idx` (`id_categoria`),
  KEY `FG_TIENDA_CATEGORIA1_idx` (`id_tienda`),
  CONSTRAINT `FG_CATEGORIA_CATEGORIA1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias_tienda` (`id`),
  CONSTRAINT `FG_TIENDA_CATEGORIA1` FOREIGN KEY (`id_tienda`) REFERENCES `tiendas` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_categorias_tienda`
--

LOCK TABLES `rel_categorias_tienda` WRITE;
/*!40000 ALTER TABLE `rel_categorias_tienda` DISABLE KEYS */;
/*!40000 ALTER TABLE `rel_categorias_tienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `idusuario` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FG_USUARIOS_idx` (`idusuario`),
  CONSTRAINT `FG_USUARIOS` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN',1),(2,'ROLE_USER',1),(3,'ROLE_USER',2);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiendas`
--

DROP TABLE IF EXISTS `tiendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tiendas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `logo` varchar(200) DEFAULT NULL,
  `descripcion` text NOT NULL,
  `activo` tinyint NOT NULL DEFAULT '1',
  `imagen` varchar(200) DEFAULT NULL,
  `iddireccion` int NOT NULL,
  `idmercado` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FG_DIRECCION_TIENDA1_idx` (`iddireccion`),
  KEY `FG_MERCADO_TIENDA1_idx` (`idmercado`),
  CONSTRAINT `FG_DIRECCION_TIENDA1` FOREIGN KEY (`iddireccion`) REFERENCES `direcciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FG_MERCADO_TIENDA1` FOREIGN KEY (`idmercado`) REFERENCES `mercados` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiendas`
--

LOCK TABLES `tiendas` WRITE;
/*!40000 ALTER TABLE `tiendas` DISABLE KEYS */;
INSERT INTO `tiendas` VALUES (1,'Tienda de Embutidos y Jamones','logo_embutidos_madrid.jpg','Embutidos artesanos, jamones curados y chacinas.',1,'imagen_embutidos_madrid.jpg',3,1),(2,'Tienda de Conservas y Delicatessen','logo_conservas_madrid.jpg','Conservas gourmet, aceitunas, patés y productos delicatessen.',1,'imagen_conservas_madrid.jpg',1,1),(3,'Tienda de Chocolates y Dulces','logo_chocolates_barcelona.jpg','Chocolates artesanos, bombones y dulces tradicionales.',1,'imagen_chocolates_barcelona.jpg',2,2),(4,'Tienda de Vinos y Licores','logo_vinos_barcelona.jpg','Vinos de diversas denominaciones de origen, licores y destilados.',1,'imagen_vinos_barcelona.jpg',3,2),(5,'Tienda de Frutas y Verduras Ecológicas','logo_frutas_valencia.jpg','Frutas y verduras frescas y ecológicas de la región.',1,'imagen_frutas_valencia.jpg',4,3),(6,'Tienda de Conservas del Mar','logo_conservas_mar_valencia.jpg','Conservas del mar, mariscos enlatados y pescados en aceite de oliva.',1,'imagen_conservas_mar_valencia.jpg',5,3),(8,'Carne y Charcutería Jose Cosin','logo_josecosin_valencia.jpg','Carnicería familiar abierta desde 1963',1,'imagen_josecosin_valencia.jpg',8,3);
/*!40000 ALTER TABLE `tiendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','1234'),(2,'user','1234');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoraciones`
--

DROP TABLE IF EXISTS `valoraciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valoraciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idtienda` int NOT NULL,
  `idcliente` int NOT NULL,
  `puntuacion` int NOT NULL,
  `resena` text,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FG_VALORACION_CLIENTE1_idx` (`idcliente`),
  KEY `FG_VALORACION_TIENDA1_idx` (`idtienda`),
  CONSTRAINT `FG_VALORACION_CLIENTE1` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FG_VALORACION_TIENDA1` FOREIGN KEY (`idtienda`) REFERENCES `tiendas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoraciones`
--

LOCK TABLES `valoraciones` WRITE;
/*!40000 ALTER TABLE `valoraciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `valoraciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedores`
--

DROP TABLE IF EXISTS `vendedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(200) NOT NULL,
  `dni` char(9) NOT NULL,
  `email` varchar(200) NOT NULL,
  `contrasena` varchar(100) NOT NULL,
  `activo` tinyint NOT NULL DEFAULT '1',
  `idtienda` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FG_VENDEDOR_TIENDA1_idx` (`idtienda`),
  CONSTRAINT `FG_VENDEDOR_TIENDA1` FOREIGN KEY (`idtienda`) REFERENCES `tiendas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedores`
--

LOCK TABLES `vendedores` WRITE;
/*!40000 ALTER TABLE `vendedores` DISABLE KEYS */;
INSERT INTO `vendedores` VALUES (1,'Jose','Cosin','21805739A','josecosin@gmail.com','jose1234',1,8);
/*!40000 ALTER TABLE `vendedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idproducto` int NOT NULL,
  `idtienda` int NOT NULL,
  `fecha_venta` datetime NOT NULL,
  `precio` float NOT NULL,
  `stock` float NOT NULL,
  `precio_kg` float NOT NULL,
  `descuento` float DEFAULT NULL,
  `descripcion` text,
  `activo` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FG_VENTA_PRODUCTO1_idx` (`idproducto`),
  KEY `FG_VENTA_TIENDA1_idx` (`idtienda`),
  CONSTRAINT `FG_VENTA_PRODUCTO1` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FG_VENTA_TIENDA1` FOREIGN KEY (`idtienda`) REFERENCES `tiendas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,1,8,'2025-01-20 11:47:45',6.6,15,3.25,0,'Pollo entero y limpio',1),(2,30,5,'2025-01-31 00:00:00',0.5,100,1,0,'Zanahorias ecológicas',1);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-03 13:52:15
