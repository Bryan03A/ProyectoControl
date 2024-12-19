-- Inserción de datos en la tabla 'clientes'
INSERT INTO clientes (nombre, apellido, email) VALUES ('Juan', 'Pérez', 'juan.perez@example.com');
INSERT INTO clientes (nombre, apellido, email) VALUES ('María', 'García', 'maria.garcia@example.com');
INSERT INTO clientes (nombre, apellido, email) VALUES ('Carlos', 'Sánchez', 'carlos.sanchez@example.com');
INSERT INTO clientes (nombre, apellido, email) VALUES ('Ana', 'Martínez', 'ana.martinez@example.com');
INSERT INTO clientes (nombre, apellido, email) VALUES ('Luis', 'Hernández', 'luis.hernandez@example.com');
INSERT INTO clientes (nombre, apellido, email) VALUES ('Laura', 'López', 'laura.lopez@example.com');
INSERT INTO clientes (nombre, apellido, email) VALUES ('Pedro', 'Gómez', 'pedro.gomez@example.com');
INSERT INTO clientes (nombre, apellido, email) VALUES ('Sofía', 'Rodríguez', 'sofia.rodriguez@example.com');
INSERT INTO clientes (nombre, apellido, email) VALUES ('Javier', 'Fernández', 'javier.fernandez@example.com');
INSERT INTO clientes (nombre, apellido, email) VALUES ('Lucía', 'González', 'lucia.gonzalez@example.com');
-- Inserción de datos en la tabla 'cajeros'
INSERT INTO cajeros (nombre, turno, sucursal) VALUES ('Alejandro', 'Mañana', 'Sucursal Centro');
INSERT INTO cajeros (nombre, turno, sucursal) VALUES ('Beatriz', 'Tarde', 'Sucursal Norte');
INSERT INTO cajeros (nombre, turno, sucursal) VALUES ('Carlos', 'Noche', 'Sucursal Sur');
INSERT INTO cajeros (nombre, turno, sucursal) VALUES ('Diana', 'Mañana', 'Sucursal Este');
INSERT INTO cajeros (nombre, turno, sucursal) VALUES ('Eduardo', 'Tarde', 'Sucursal Oeste');
-- Inserción de datos en la tabla 'productos'
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Laptop', 'Laptop de 15 pulgadas con 16GB de RAM', 1200.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Laptop', 'Laptop de 13 pulgadas con 8GB de RAM', 900.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Laptop', 'Laptop de 17 pulgadas con 32GB de RAM', 1500.00);

INSERT INTO productos (nombre, descripcion, precio) VALUES ('Smartphone', 'Smartphone con 128GB de almacenamiento', 700.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Smartphone', 'Smartphone con 64GB de almacenamiento', 500.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Smartphone', 'Smartphone con 256GB de almacenamiento y cámara dual', 1000.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Smartphone', 'Smartphone con 512GB de almacenamiento y cámara cuádruple', 1200.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Smartphone', 'Smartphone con 32GB de almacenamiento y cámara simple', 300.00);

INSERT INTO productos (nombre, descripcion, precio) VALUES ('Monitor', 'Monitor 4K de 27 pulgadas', 400.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Monitor', 'Monitor Full HD de 24 pulgadas', 200.00);

INSERT INTO productos (nombre, descripcion, precio) VALUES ('Teclado', 'Teclado mecánico retroiluminado', 80.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Teclado', 'Teclado inalámbrico compacto', 60.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Teclado', 'Teclado ergonómico dividido', 100.00);

INSERT INTO productos (nombre, descripcion, precio) VALUES ('Ratón', 'Ratón inalámbrico ergonómico', 50.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Ratón', 'Ratón óptico con cable', 20.00);

INSERT INTO productos (nombre, descripcion, precio) VALUES ('Auriculares', 'Auriculares inalámbricos con cancelación de ruido', 150.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Auriculares', 'Auriculares con cable y micrófono', 40.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Auriculares', 'Auriculares deportivos resistentes al agua', 80.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Auriculares', 'Auriculares de estudio con alta fidelidad de sonido', 200.00);

INSERT INTO productos (nombre, descripcion, precio) VALUES ('Impresora', 'Impresora multifuncional a color', 200.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Impresora', 'Impresora láser monocromática', 150.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Impresora', 'Impresora fotográfica de alta resolución', 300.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Impresora', 'Impresora de etiquetas térmicas', 100.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Impresora', 'Impresora portátil para documentos', 180.00);

INSERT INTO productos (nombre, descripcion, precio) VALUES ('Tablet', 'Tablet con pantalla de 10 pulgadas y 64GB de almacenamiento', 300.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Tablet', 'Tablet con pantalla de 8 pulgadas y 32GB de almacenamiento', 200.00);

INSERT INTO productos (nombre, descripcion, precio) VALUES ('Cámara', 'Cámara digital de 24MP', 500.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Cámara', 'Cámara instantánea analógica', 100.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Cámara', 'Cámara de acción resistente al agua', 250.00);

INSERT INTO productos (nombre, descripcion, precio) VALUES ('Disco Duro Externo', 'Disco duro externo de 1TB', 100.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Disco Duro Externo', 'Disco duro externo de 2TB', 150.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('Disco Duro Externo', 'Disco duro externo SSD de 512GB', 200.00);

INSERT INTO productos (nombre, descripcion, precio) VALUES ('Router', 'Router inalámbrico de doble banda', 60.00);

INSERT INTO productos (nombre, descripcion, precio) VALUES ('SSD', 'Disco SSD interno de 1TB', 120.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('SSD', 'Disco SSD interno de 500GB', 80.00);
INSERT INTO productos (nombre, descripcion, precio) VALUES ('SSD', 'Disco SSD externo de 250GB', 100.00);
-- Inserción de datos en la tabla 'formas_pago'
INSERT INTO formas_pago (nombre, cantidad_pagos) VALUES ('Tarjeta de Crédito', 1);
INSERT INTO formas_pago (nombre, cantidad_pagos) VALUES ('Tarjeta de Débito', 1);
INSERT INTO formas_pago (nombre, cantidad_pagos) VALUES ('Transferencia Bancaria', 1);
INSERT INTO formas_pago (nombre, cantidad_pagos) VALUES ('Pago en Efectivo', 1);
INSERT INTO formas_pago (nombre, cantidad_pagos) VALUES ('Cheque', 1);

INSERT INTO formas_pago (nombre, cantidad_pagos) VALUES ('Plan de Pagos a 12 Plazos', 12);
INSERT INTO formas_pago (nombre, cantidad_pagos) VALUES ('Plan de Pagos a 6 Plazos', 6);
INSERT INTO formas_pago (nombre, cantidad_pagos) VALUES ('Plan de Pagos a 3 Plazos', 3);

INSERT INTO formas_pago (nombre, cantidad_pagos) VALUES ('Pago Mensual', 12);
INSERT INTO formas_pago (nombre, cantidad_pagos) VALUES ('Pago Trimestral', 4);

INSERT INTO formas_pago (nombre, cantidad_pagos) VALUES ('Suscripción Anual', 1);
INSERT INTO formas_pago (nombre, cantidad_pagos) VALUES ('Suscripción Semestral', 2);

INSERT INTO formas_pago (nombre, cantidad_pagos) VALUES ('Prepago', 1);
INSERT INTO formas_pago (nombre, cantidad_pagos) VALUES ('Recarga', 1);
