-- Poblar la base de datos terramarket_v0 con datos de ejemplo
USE terramarket_v0;

-- Insertar direcciones
INSERT INTO direcciones (id, pais, provincia, ciudad, cp, calle, numero, puerta, piso, es_mercado, es_tienda, es_pr)
VALUES
(1, 'España', 'Madrid', 'Madrid', '28001', 'Calle Mayor', '10', 'B', '2', 1, 0, 0),
(2, 'España', 'Barcelona', 'Barcelona', '08001', 'Passeig de Gràcia', '5', NULL, NULL, 1, 0, 0),
(3, 'España', 'Valencia', 'Valencia', '46001', 'Avenida del Oeste', '20', NULL, '1', 0, 1, 0),
(4, 'España', 'Sevilla', 'Sevilla', '41001', 'Calle Sierpes', '15', NULL, NULL, 0, 1, 0),
(5, 'España', 'Madrid', 'Madrid', '28002', 'Calle Serrano', '50', NULL, NULL, 0, 0, 1);

-- Insertar mercados
INSERT INTO mercados (nombre, email, direccion_f, telefono, activo, imagen, iddireccion)
VALUES
('Mercado Central Madrid', 'contacto@madridcentral.com', 'Calle Mayor, 10', '910000000', 1, NULL, 1),
('Mercado La Boquería', 'info@boqueria.com', 'Passeig de Gràcia, 5', '931000000', 1, NULL, 2);

-- Insertar tiendas
INSERT INTO tiendas (nombre, logo, descripcion, activo, imagen, iddireccion, idmercado)
VALUES
('Frutería Pepito', NULL, 'Frutas frescas de temporada', 1, NULL, 3, 1),
('Carnicería López', NULL, 'Las mejores carnes del mercado', 1, NULL, 4, 2);

-- Insertar vendedores
INSERT INTO vendedores (nombre, apellidos, dni, email, contrasena, activo, idtienda)
VALUES
('Carlos', 'Martínez Gómez', '12345678A', 'carlos@pepito.com', 'pepito123', 1, 1),
('Ana', 'López Sánchez', '87654321B', 'ana@lopezcarnes.com', 'carnes456', 1, 2);

-- Insertar clientes
INSERT INTO clientes (nombre, apellidos, username, fechanacimiento, email, contrasena, cp, activo)
VALUES
('Juan', 'Pérez García', 'juanpe', '1985-05-15', 'juan@example.com', '1234', '28001', 1),
('María', 'López Fernández', 'marialf', '1990-10-20', 'maria@example.com', '5678', '08001', 1);

-- Insertar categorías de tienda
INSERT INTO categorias_tienda (nombre, descripcion, icono)
VALUES
('Frutas y Verduras', 'Productos frescos del huerto', 'frutas.png'),
('Carnicería', 'Carnes de primera calidad', 'carnes.png');

-- Relación categorías_tienda y tiendas
INSERT INTO rel_categorias_tienda (idtienda, idcategoria)
VALUES
(1, 1),
(2, 2);

-- Insertar categorías de productos
INSERT INTO categorias_producto (nombre, descripcion, idcategoria_tienda)
VALUES
('Manzanas', 'Manzanas frescas y crujientes', 1),
('Ternera', 'Carne de ternera de calidad', 2);

-- Insertar productos
INSERT INTO productos (nombre, imagen, idcategoria)
VALUES
('Manzana Golden', NULL, 1),
('Filete de Ternera', NULL, 2);

-- Insertar métodos de pago
INSERT INTO metodos_pago (nombre, descripcion)
VALUES
('Tarjeta de Crédito', 'Paga con tu tarjeta de crédito habitual'),
('Paypal', 'Paga cómodamente con tu cuenta de Paypal');

-- Insertar puntos de recogida
INSERT INTO punto_recogoida (iddireccion, nombre)
VALUES
(5, 'Punto de Recogida Madrid Centro');

-- Insertar pedidos
INSERT INTO pedidos (idcliente, idpago, idpr, fecha_pedido, fecha_compra, importe)
VALUES
(1, 1, 1, NOW(), NOW(), 25.50);

-- Insertar ventas
INSERT INTO ventas (idproducto, idtienda, fecha_venta, precio, stock, descripcion, activo)
VALUES
(1, 1, NOW(), 2.50, 100, 'Manzanas Golden frescas', 1),
(2, 2, NOW(), 10.00, 50, 'Filete de ternera de calidad', 1);

-- Insertar líneas de pedido
INSERT INTO linea_pedidos (idpedido, idventa, cantidad, fecha)
VALUES
(1, 1, 5, NOW()),
(1, 2, 2, NOW());

-- Insertar valoraciones
INSERT INTO valoraciones (idtienda, idcliente, puntacion, resena, fecha)
VALUES
(1, 1, 5, 'Excelente calidad en frutas', NOW()),
(2, 2, 4, 'Buena carne pero algo cara', NOW());
