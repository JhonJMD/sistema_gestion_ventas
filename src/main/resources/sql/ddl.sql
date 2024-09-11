CREATE DATABASE IF NOT EXISTS db_sistema_gestion;

USE db_sistema_gestion;

-- Tabla País
CREATE TABLE pais (
    paisId INT AUTO_INCREMENT,
    nombre VARCHAR(70),
    CONSTRAINT pk_id_pais PRIMARY KEY (paisId)
);

-- Tabla Ciudad
CREATE TABLE ciudad (
    ciudadId INT AUTO_INCREMENT,
    nombre VARCHAR(70),
    paisId INT,
    CONSTRAINT pk_id_ciudad PRIMARY KEY (ciudadId),
    CONSTRAINT fk_id_pais_ciudad FOREIGN KEY (paisId) REFERENCES pais(paisId)
);

-- Tabla Dirección
CREATE TABLE direccion (
    direccionId INT AUTO_INCREMENT,
    direccionCompleta VARCHAR(100),
    ciudadId INT,
    CONSTRAINT pk_id_direccion PRIMARY KEY (direccionId),
    CONSTRAINT fk_id_ciudad_direccion FOREIGN KEY (ciudadId) REFERENCES ciudad(ciudadId)
);

-- Tabla Tipo Documento
CREATE TABLE tipoDocumento (
    tipoDocumentoId INT AUTO_INCREMENT,
    nombre VARCHAR(30),
    CONSTRAINT pk_id_tipo_documento PRIMARY KEY (tipoDocumentoId)
);

-- Tabla Tipo Persona
CREATE TABLE tipoPersona (
    tipoPersonaId INT AUTO_INCREMENT,
    descripcion VARCHAR(30),
    CONSTRAINT pk_id_tipo_persona PRIMARY KEY (tipoPersonaId)
);

-- Tabla Tipo Teléfono
CREATE TABLE tipoTelefono (
    tipoTelefonoId INT AUTO_INCREMENT,
    descripcion VARCHAR(40),
    CONSTRAINT pk_id_tipo_telefono PRIMARY KEY (tipoTelefonoId)
);

-- Tabla Teléfono
CREATE TABLE telefono (
    telefonoId INT AUTO_INCREMENT,
    tipoTelefonoId INT,
    telefono VARCHAR(40),
    CONSTRAINT pk_id_telefono PRIMARY KEY (telefonoId),
    CONSTRAINT fk_id_tipo_telefono FOREIGN KEY (tipoTelefonoId) REFERENCES tipoTelefono(tipoTelefonoId)
);

-- Tabla Empresa
CREATE TABLE empresa (
    empresaId INT AUTO_INCREMENT,
    nombre VARCHAR(80),
    direccionId INT,
    representanteLegal VARCHAR(80),
    CONSTRAINT pk_id_empresa PRIMARY KEY (empresaId),
    CONSTRAINT fk_id_direccion_empresa FOREIGN KEY (direccionId) REFERENCES direccion(direccionId)
);

-- Tabla Sucursal
CREATE TABLE sucursal (
    sucursalId INT AUTO_INCREMENT,
    direccionId INT,
    descripcion VARCHAR(50),
    CONSTRAINT pk_id_sucursal PRIMARY KEY (sucursalId),
    CONSTRAINT fk_id_direccion_sucursal FOREIGN KEY (direccionId) REFERENCES direccion(direccionId)
);

-- Tabla Tipo Movimiento
CREATE TABLE tipoMovimiento (
    tipoMovimientoId INT AUTO_INCREMENT,
    descripcion VARCHAR(40),
    CONSTRAINT pk_id_tipo_movimiento PRIMARY KEY (tipoMovimientoId)
);

-- Tabla Categoría Producto
CREATE TABLE categoriaProducto (
    categoriaProductoId INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    descripcion TEXT,
    CONSTRAINT pk_id_categoria_producto PRIMARY KEY (categoriaProductoId)
);

-- Tabla Método de Pago
CREATE TABLE metodoPago (
    metodoPagoId INT AUTO_INCREMENT,
    descripcion VARCHAR(40),
    CONSTRAINT pk_id_metodo_pago PRIMARY KEY (metodoPagoId)
);

-- Tabla Estado
CREATE TABLE estado (
    estadoId INT AUTO_INCREMENT,
    descripcion VARCHAR(40),
    CONSTRAINT pk_id_estado PRIMARY KEY (estadoId)
);

-- Tabla Proveedor
CREATE TABLE proveedor (
    proveedorId VARCHAR(30),
    tipoDocumentoId INT,
    tipoPersonaId INT,
    nombre VARCHAR(80),
    direccionId INT,
    telefonoId INT,
    email VARCHAR(80),
    CONSTRAINT pk_id_proveedor PRIMARY KEY (proveedorId),
    CONSTRAINT fk_id_tipo_documento_proveedor FOREIGN KEY (tipoDocumentoId) REFERENCES tipoDocumento(tipoDocumentoId),
    CONSTRAINT fk_id_tipo_persona_proveedor FOREIGN KEY (tipoPersonaId) REFERENCES tipoPersona(tipoPersonaId),
    CONSTRAINT fk_id_direccion_proveedor FOREIGN KEY (direccionId) REFERENCES direccion(direccionId),
    CONSTRAINT fk_id_telefono_proveedor FOREIGN KEY (telefonoId) REFERENCES telefono(telefonoId)
);

-- Tabla Tipo Pedido
CREATE TABLE tipoPedido (
    tipoPedidoId INT AUTO_INCREMENT,
    descripcion VARCHAR(40),
    CONSTRAINT pk_id_tipo_pedido PRIMARY KEY (tipoPedidoId)
);

-- Tabla Cliente
CREATE TABLE cliente (
    clienteId VARCHAR(30),
    tipoDocumentoId INT,
    tipoPersonaId INT,
    nombre VARCHAR(70),
    apellido VARCHAR(70),
    direccionId INT,
    telefonoId INT,
    email VARCHAR(50),
    totalGastado DECIMAL(16,2),
    comprasRealizadas INT,
    CONSTRAINT pk_id_cliente PRIMARY KEY (clienteId),
    CONSTRAINT fk_id_tipo_persona_cliente FOREIGN KEY (tipoPersonaId) REFERENCES tipoPersona(tipoPersonaId),
    CONSTRAINT fk_id_tipo_documento_cliente FOREIGN KEY (tipoDocumentoId) REFERENCES tipoDocumento(tipoDocumentoId),
    CONSTRAINT fk_id_direccion_cliente FOREIGN KEY (direccionId) REFERENCES direccion(direccionId)
);

-- Tabla Empleado
CREATE TABLE empleado (
    empleadoId VARCHAR(30),
    tipoDocumentoId INT,
    nombre VARCHAR(30),
    apellido VARCHAR(30),
    direccionId INT,
    sucursalId INT,
    email VARCHAR(80),
    CONSTRAINT pk_id_empleado PRIMARY KEY (empleadoId),
    CONSTRAINT fk_id_tipo_documento_empleado FOREIGN KEY (tipoDocumentoId) REFERENCES tipoDocumento(tipoDocumentoId),
    CONSTRAINT fk_id_direccion_empleado FOREIGN KEY (direccionId) REFERENCES direccion(direccionId),
    CONSTRAINT fk_id_sucursal_empleado FOREIGN KEY (sucursalId) REFERENCES sucursal(sucursalId)
);

-- Tabla Usuario (para empleados y administradores)
CREATE TABLE usuario (
    usuarioId INT AUTO_INCREMENT,
    empleadoId VARCHAR(30),
    username VARCHAR(50) UNIQUE,
    passwordHash VARCHAR(255),
    rol ENUM('ADMIN_GENERAL', 'ADMIN_SUCURSAL', 'EMPLEADO'),
    CONSTRAINT pk_id_usuario PRIMARY KEY (usuarioId),
    CONSTRAINT fk_id_empleado_usuario FOREIGN KEY (empleadoId) REFERENCES empleado(empleadoId)
);

-- Tabla Pedido
CREATE TABLE pedido (
    pedidoId INT AUTO_INCREMENT,
    tipoPedidoId INT,
    clienteId VARCHAR(30),
    fechaPedido DATE,
    estadoId INT,
    totalEstimado DECIMAL(16,2),
    fechaConfirmacion DATE,
    usuarioId INT,
    CONSTRAINT pk_id_pedido PRIMARY KEY (pedidoId),
    CONSTRAINT fk_id_tipo_pedido FOREIGN KEY (tipoPedidoId) REFERENCES tipoPedido(tipoPedidoId),
    CONSTRAINT fk_id_cliente_pedido FOREIGN KEY (clienteId) REFERENCES cliente(clienteId),
    CONSTRAINT fk_id_estado_pedido FOREIGN KEY (estadoId) REFERENCES estado(estadoId),
    CONSTRAINT fk_id_usuario_pedido FOREIGN KEY (usuarioId) REFERENCES usuario(usuarioId)
);

-- Tabla Producto
CREATE TABLE producto (
    productoId INT AUTO_INCREMENT,
    codigoBarras VARCHAR(50) UNIQUE,
    nombre VARCHAR(80),
    descripcion TEXT,
    precio DECIMAL(16,2),
    categoriaProductoId INT,
    CONSTRAINT pk_id_producto PRIMARY KEY (productoId),
    CONSTRAINT fk_id_categoria_producto FOREIGN KEY (categoriaProductoId) REFERENCES categoriaProducto(categoriaProductoId)
);

-- Tabla Detalle Pedido
CREATE TABLE detallePedido (
    detallePedidoId INT AUTO_INCREMENT,
    pedidoId INT,
    productoId INT,
    cantidad INT,
    precioUnitario DECIMAL(16,2),
    subtotal DECIMAL(16,2),
    CONSTRAINT pk_id_detalle_pedido PRIMARY KEY (detallePedidoId),
    CONSTRAINT fk_id_pedido_detalle FOREIGN KEY (pedidoId) REFERENCES pedido(pedidoId),
    CONSTRAINT fk_id_producto_detalle FOREIGN KEY (productoId) REFERENCES producto(productoId)
);

-- Tabla Proveedor Producto (relación muchos a muchos entre Proveedor y Producto)
CREATE TABLE proveedorProducto (
    proveedorId VARCHAR(30),
    productoId INT,
    precioCompra DECIMAL(16,2), 
    tiempoEntrega INT, 
    cantidadMinimaPedido INT,
    descuentoVolumen DECIMAL(5,2),
    moneda VARCHAR(10), 
    condicionesPago VARCHAR(50), 
    fechaUltimaCompra DATE, 
    calificacionProveedor DECIMAL(3,2), 
    CONSTRAINT pk_proveedor_producto PRIMARY KEY (proveedorId, productoId),
    CONSTRAINT fk_proveedor_producto_proveedor FOREIGN KEY (proveedorId) REFERENCES proveedor(proveedorId),
    CONSTRAINT fk_proveedor_producto_producto FOREIGN KEY (productoId) REFERENCES producto(productoId)
);


-- Tabla Inventario
CREATE TABLE inventario (
    productoId INT,
    sucursalId INT,
    stock INT,
    CONSTRAINT pk_id_producto_sucursal_inventario PRIMARY KEY (productoId, sucursalId),
    CONSTRAINT fk_id_producto_inventario FOREIGN KEY (productoId) REFERENCES producto(productoId),
    CONSTRAINT fk_id_sucursal_inventario FOREIGN KEY (sucursalId) REFERENCES sucursal(sucursalId)
);

-- Tabla Compra
CREATE TABLE compra (
    compraId INT AUTO_INCREMENT,
    pedidoId INT,
    fechaCompra DATE,
    estadoId INT,
    totalSinDescuento DECIMAL(10,2),
    empleadoId VARCHAR(30),
    CONSTRAINT pk_id_compra PRIMARY KEY (compraId),
    CONSTRAINT fk_id_pedido_compra FOREIGN KEY (pedidoId) REFERENCES pedido(pedidoId),
    CONSTRAINT fk_id_estado_compra FOREIGN KEY (estadoId) REFERENCES estado(estadoId),
    CONSTRAINT fk_id_empleado_compra FOREIGN KEY (empleadoId) REFERENCES empleado(empleadoId)
);

-- Tabla Detalle Compra (relación Compra con Producto)
CREATE TABLE detalleCompra (
    detalleCompraId INT AUTO_INCREMENT,
    compraId INT,
    productoId INT,
    cantidad INT,
    precioUnitario DECIMAL(16,2),
    subtotal DECIMAL(16,2),
    CONSTRAINT pk_id_detalle_compra PRIMARY KEY (detalleCompraId),
    CONSTRAINT fk_id_compra_detalle FOREIGN KEY (compraId) REFERENCES compra(compraId),
    CONSTRAINT fk_id_producto_detalle_compra FOREIGN KEY (productoId) REFERENCES producto(productoId)
);

-- Tabla Venta
CREATE TABLE venta (
    ventaId INT AUTO_INCREMENT,
    pedidoId INT,
    fechaVenta DATE,
    totalSinDescuento DECIMAL(16,2),
    clienteId VARCHAR(30),
    estadoId INT,
    empleadoId VARCHAR(30),
    CONSTRAINT pk_id_venta PRIMARY KEY (ventaId),
    CONSTRAINT fk_id_pedido_venta FOREIGN KEY (pedidoId) REFERENCES pedido(pedidoId),
    CONSTRAINT fk_id_cliente_venta FOREIGN KEY (clienteId) REFERENCES cliente(clienteId),
    CONSTRAINT fk_id_estado_venta FOREIGN KEY (estadoId) REFERENCES estado(estadoId),
    CONSTRAINT fk_id_empleado_venta FOREIGN KEY (empleadoId) REFERENCES empleado(empleadoId)
);

-- Tabla Detalle Venta (relación Venta con Producto)
CREATE TABLE detalleVenta (
    detalleVentaId INT AUTO_INCREMENT,
    ventaId INT,
    productoId INT,
    cantidad INT,
    precioUnitario DECIMAL(16,2),
    subtotal DECIMAL(16,2),
    CONSTRAINT pk_id_detalle_venta PRIMARY KEY (detalleVentaId),
    CONSTRAINT fk_id_venta_detalle FOREIGN KEY (ventaId) REFERENCES venta(ventaId),
    CONSTRAINT fk_id_producto_detalle_venta FOREIGN KEY (productoId) REFERENCES producto(productoId)
);

-- Tabla Factura
CREATE TABLE factura (
    facturaId INT AUTO_INCREMENT,
    ventaId INT,
    fechaFactura DATE,
    metodoPagoId INT,
    descuentoPorcentaje DECIMAL(16,2),
    CONSTRAINT pk_id_factura PRIMARY KEY (facturaId),
    CONSTRAINT fk_id_venta_factura FOREIGN KEY (ventaId) REFERENCES venta(ventaId),
    CONSTRAINT fk_id_metodo_pago_factura FOREIGN KEY (metodoPagoId) REFERENCES metodoPago(metodoPagoId)
);

-- Tabla Devolución
CREATE TABLE devolucion (
    devolucionId INT AUTO_INCREMENT,
    fechaDevolucion DATE,
    motivo TEXT,
    estadoId INT,
    facturaId INT,
    CONSTRAINT pk_id_devolucion PRIMARY KEY (devolucionId),
    CONSTRAINT fk_id_estado_devolucion FOREIGN KEY (estadoId) REFERENCES estado(estadoId),
    CONSTRAINT fk_id_factura_devolucion FOREIGN KEY (facturaId) REFERENCES factura(facturaId)
);

-- Tabla Historial de Movimientos (para registrar entradas, salidas y ajustes de inventario)
CREATE TABLE historialMovimientos (
    movimientoId INT AUTO_INCREMENT,
    productoId INT,
    sucursalId INT,
    tipoMovimientoId INT,
    cantidad INT,
    fechaMovimiento DATE,
    CONSTRAINT pk_id_historial_movimientos PRIMARY KEY (movimientoId),
    CONSTRAINT fk_id_producto_movimiento FOREIGN KEY (productoId) REFERENCES producto(productoId),
    CONSTRAINT fk_id_sucursal_movimiento FOREIGN KEY (sucursalId) REFERENCES sucursal(sucursalId),
    CONSTRAINT fk_id_tipo_movimiento_historial FOREIGN KEY (tipoMovimientoId) REFERENCES tipoMovimiento(tipoMovimientoId)
);


