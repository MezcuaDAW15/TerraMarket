DELETE FROM categorias_tienda;
INSERT INTO categorias_tienda (id, nombre, descripcion, icono) VALUES
(1, 'Aves y derivados', 'Productos de aves como pollo, pavo, pato y huevos.', 'icon_aves.png'),
(2, 'Carnicería', 'Carne de res, cerdo, cordero y ternera.', 'icon_carniceria.png'),
(3, 'Charcutería y quesos', 'Jamones, embutidos, quesos y patés.', 'icon_charcuteria.png'),
(4, 'Especias', 'Especias, sal, pimientas y hierbas aromáticas.', 'icon_especias.png'),
(5, 'Frutas y verduras', 'Frutas, verduras, setas y hongos.', 'icon_frutas.png'),
(6, 'Frutos secos', 'Frutos secos y semillas.', 'icon_frutos_secos.png'),
(7, 'Gourmet y congelados', 'Productos gourmet, mariscos congelados y helados.', 'icon_gourmet.png'),
(8, 'Panadería y pastelería', 'Panes, bollería, pasteles y productos sin gluten.', 'icon_panaderia.png'),
(9, 'Para llevar', 'Platos preparados, sandwiches y bebidas.', 'icon_para_llevar.png'),
(10, 'Pescados y mariscos', 'Pescado y mariscos frescos o en conserva.', 'icon_pescados.png'),
(11, 'Productos internacionales', 'Alimentos asiáticos, latinos y condimentos.', 'icon_internacionales.png'),
(12, 'Salazones y encurtidos', 'Salazones y encurtidos variados.', 'icon_salazones.png'),
(13, 'Varios no alimentación', 'Artículos de hogar y accesorios de cocina.', 'icon_varios.png');

DELETE FROM categorias_producto;
INSERT INTO categorias_producto (id, nombre, descripcion, id_categoria_tienda) VALUES
(1, 'Pollo', 'Entero, en piezas, alitas, muslos, etc.', 1),
(2, 'Pavo', 'Carne de pavo.', 1),
(3, 'Codorniz', 'Carne de codorniz.', 1),
(4, 'Pato', 'Carne de pato.', 1),
(5, 'Huevos', 'Huevos de gallina, codorniz, orgánicos.', 1),

(6, 'Carne de res', 'Filetes, costillas, chuletas, etc.', 2),
(7, 'Carne de cerdo', 'Costillas, lomo, chuletas, etc.', 2),
(8, 'Carne de cordero', 'Carne de cordero.', 2),
(9, 'Carne de ternera', 'Carne de ternera.', 2),

(10, 'Jamones', 'Serrano, ibérico, cocido, etc.', 3),
(11, 'Embutidos', 'Chorizo, salchichón, lomo, etc.', 3),
(12, 'Quesos', 'Curados, frescos, semicurados, de cabra, oveja, vaca.', 3),
(13, 'Patés y foie gras', 'Variedad de patés y foie gras.', 3),

(14, 'Especias secas', 'Orégano, tomillo, laurel, albahaca, etc.', 4),
(15, 'Pimientas', 'Negra, blanca, roja, etc.', 4),
(16, 'Sal', 'Sal marina, rosa, ahumada, de hierbas.', 4),
(17, 'Salsas', 'Soja, teriyaki, barbacoa, tabasco.', 4),
(18, 'Hierbas aromáticas frescas', 'Cilantro, perejil, albahaca.', 4),

(19, 'Frutas', 'Manzanas, peras, plátanos, uvas, naranjas, etc.', 5),
(20, 'Verduras', 'Tomates, zanahorias, lechugas, espinacas, cebollas, etc.', 5),
(21, 'Setas y hongos', 'Variedad de setas y hongos.', 5),

(22, 'Frutos secos enteros', 'Enteros.', 6),
(23, 'Frutos secos pelados', 'Pelados.', 6),
(24, 'Frutos secos tostados y salados', 'Tostados y salados.', 6),
(25, 'Semillas', 'Calabaza, girasol, chía, lino.', 6),

(26, 'Productos gourmet', 'Aceites de oliva premium, vinagres, trufas.', 7),
(27, 'Mariscos congelados', 'Variedad de mariscos congelados.', 7),
(28, 'Helados y sorbetes', 'Helados y sorbetes.', 7),
(29, 'Panes y pasteles congelados', 'Variedad de panes y pasteles congelados.', 7),

(30, 'Panes', 'Baguettes, chapatas, integrales, de molde, etc.', 8),
(31, 'Bollería', 'Croissants, napolitanas, mantecadas, etc.', 8),
(32, 'Pasteles y tartas', 'De frutas, chocolate, mousse, etc.', 8),
(33, 'Galletas', 'Digestive, de chocolate, hojaldradas.', 8),
(34, 'Productos sin gluten', 'Productos sin gluten.', 8),

(35, 'Sandwiches y bocadillos', 'Variedad de sandwiches y bocadillos.', 9),
(36, 'Ensaladas', 'De pasta, atún, pollo.', 9),
(37, 'Platos preparados', 'Platos preparados.', 9),
(38, 'Zumos y batidos', 'Variedad de zumos y batidos.', 9),

(39, 'Pescado fresco', 'Merluza, salmón, atún, dorada, etc.', 10),
(40, 'Mariscos frescos', 'Langostinos, camarones, almejas, mejillones.', 10),
(41, 'Pescado en conserva', 'Atún, sardinas, boquerones.', 10),
(42, 'Calamares y sepias', 'Calamares y sepias.', 10),

(43, 'Alimentos asiáticos', 'Salsas de soja, arroz jazmín, noodles.', 11),
(44, 'Alimentos latinos', 'Arepas, plátanos, guanábanas.', 11),
(45, 'Condimentos internacionales', 'Tandoori, salsa de pescado.', 11),

(46, 'Salazones de pescado', 'Bacalao, mojama, etc.', 12),
(47, 'Salazones de carne', 'Jamón, cecina.', 12),
(48, 'Encurtidos', 'Pepinos, cebollitas, zanahorias.', 12),
(49, 'Aceitunas', 'Negras, verdes, rellenas.', 12),

(50, 'Bebidas', 'Gaseosas, jugos, agua, tés.', 13),
(51, 'Accesorios de cocina', 'Ollas, sartenes, utensilios.', 13),
(52, 'Artículos de hogar', 'Velas, detergentes, ambientadores.', 13),
(53, 'Otros', 'Otros artículos no alimentación.', 13);
