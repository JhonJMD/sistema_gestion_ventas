/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.sistema_gestion_ventas;

import com.sistema_gestion_ventas.categoria_producto.infrastructure.in.CategoriaProductoController;
import com.sistema_gestion_ventas.ciudad.infrastructure.in.CiudadController;
import com.sistema_gestion_ventas.cliente.infrastructure.in.ClienteController;
import com.sistema_gestion_ventas.compra.infrastructure.in.CompraController;
import com.sistema_gestion_ventas.detalle_compra.infrastructure.in.DetalleCompraController;
import com.sistema_gestion_ventas.detalle_pedido.infrastructure.in.DetallePedidoController;
import com.sistema_gestion_ventas.detalle_venta.infrastructure.in.DetalleVentaController;
import com.sistema_gestion_ventas.devolucion.infrastructure.in.DevolucionController;
import com.sistema_gestion_ventas.direccion.infrastructure.in.DireccionController;
import com.sistema_gestion_ventas.empleado.infrastructure.in.EmpleadoController;
import com.sistema_gestion_ventas.empresa.infrastructure.in.EmpresaController;
import com.sistema_gestion_ventas.estado.infrastructure.in.EstadoController;
import com.sistema_gestion_ventas.factura.infrastructure.in.FacturaController;
import com.sistema_gestion_ventas.historial_movimientos.infrastructure.in.HistorialMovimientosController;
import com.sistema_gestion_ventas.inventario.infrastructure.in.InventarioController;
import com.sistema_gestion_ventas.metodo_pago.infrastructure.in.MetodoPagoController;
import com.sistema_gestion_ventas.pais.infrastructure.in.PaisController;
import com.sistema_gestion_ventas.pedido.infrastructure.in.PedidoController;
import com.sistema_gestion_ventas.producto.infrastructure.in.ProductoController;
import com.sistema_gestion_ventas.proveedor.infrastructure.in.ProveedorController;
import com.sistema_gestion_ventas.sucursal.infrastructure.in.SucursalController;
import com.sistema_gestion_ventas.telefono.infrastructure.in.TelefonoController;
import com.sistema_gestion_ventas.tipo_documento.infrastructure.in.TipoDocumentoController;
import com.sistema_gestion_ventas.tipo_movimiento.infrastructure.in.TipoMovimientoController;
import com.sistema_gestion_ventas.tipo_pedido.infrastructure.in.TipoPedidoController;
import com.sistema_gestion_ventas.tipo_persona.infrastructure.in.TipoPersonaController;
import com.sistema_gestion_ventas.tipo_telefono.infrastructure.in.TipoTelefonoController;
import com.sistema_gestion_ventas.venta.infrastructure.in.VentaController;

/**
 *
 * @author jhon
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        historialMovimientosBtn = new javax.swing.JButton();
        tipoPersonaBtn = new javax.swing.JButton();
        ciudadBtn = new javax.swing.JButton();
        tipoTelefonoBtn = new javax.swing.JButton();
        sucursalBtn = new javax.swing.JButton();
        tipoDocumentoBtn = new javax.swing.JButton();
        empresaBtn = new javax.swing.JButton();
        tipoMovimientoBtn = new javax.swing.JButton();
        proveedorBtn = new javax.swing.JButton();
        tipoPedidoBtn = new javax.swing.JButton();
        clienteBtn = new javax.swing.JButton();
        paisBtn = new javax.swing.JButton();
        metodoPagoBtn = new javax.swing.JButton();
        direccionBtn = new javax.swing.JButton();
        usuarioBtn = new javax.swing.JButton();
        productoBtn = new javax.swing.JButton();
        pedidoBtn = new javax.swing.JButton();
        proveedorProducto = new javax.swing.JButton();
        inventarioBtn = new javax.swing.JButton();
        compraBtn = new javax.swing.JButton();
        detalleCompraBtn = new javax.swing.JButton();
        ventaBtn = new javax.swing.JButton();
        detalleVentaBtn = new javax.swing.JButton();
        telefonoBtn = new javax.swing.JButton();
        empleadoBtn = new javax.swing.JButton();
        detallePedidoBtn = new javax.swing.JButton();
        estadoBtn = new javax.swing.JButton();
        categoriaProductoBtn = new javax.swing.JButton();
        facturaBtn = new javax.swing.JButton();
        devolucionBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/software(1).png"))); // NOI18N
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 40));

        title.setBackground(new java.awt.Color(0, 0, 0));
        title.setFont(new java.awt.Font("FreeSans", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Sistema de Gestión");
        jPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 60));

        historialMovimientosBtn.setBackground(new java.awt.Color(204, 204, 255));
        historialMovimientosBtn.setFont(new java.awt.Font("Liberation Sans", 0, 9)); // NOI18N
        historialMovimientosBtn.setForeground(new java.awt.Color(0, 0, 0));
        historialMovimientosBtn.setText("Historial Movimientos");
        historialMovimientosBtn.setBorder(null);
        historialMovimientosBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historialMovimientosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialMovimientosBtnActionPerformed(evt);
            }
        });
        jPanel1.add(historialMovimientosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 100, 30));

        tipoPersonaBtn.setBackground(new java.awt.Color(204, 204, 255));
        tipoPersonaBtn.setForeground(new java.awt.Color(0, 0, 0));
        tipoPersonaBtn.setText("Tipo Persona");
        tipoPersonaBtn.setBorder(null);
        tipoPersonaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tipoPersonaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoPersonaBtnActionPerformed(evt);
            }
        });
        jPanel1.add(tipoPersonaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 100, 30));

        ciudadBtn.setBackground(new java.awt.Color(204, 204, 255));
        ciudadBtn.setForeground(new java.awt.Color(0, 0, 0));
        ciudadBtn.setText("Ciudad");
        ciudadBtn.setBorder(null);
        ciudadBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ciudadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciudadBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ciudadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 100, 30));

        tipoTelefonoBtn.setBackground(new java.awt.Color(204, 204, 255));
        tipoTelefonoBtn.setForeground(new java.awt.Color(0, 0, 0));
        tipoTelefonoBtn.setText("Tipo Telefono");
        tipoTelefonoBtn.setBorder(null);
        tipoTelefonoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tipoTelefonoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoTelefonoBtnActionPerformed(evt);
            }
        });
        jPanel1.add(tipoTelefonoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 100, 30));

        sucursalBtn.setBackground(new java.awt.Color(204, 204, 255));
        sucursalBtn.setForeground(new java.awt.Color(0, 0, 0));
        sucursalBtn.setText("Sucursal");
        sucursalBtn.setBorder(null);
        sucursalBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sucursalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucursalBtnActionPerformed(evt);
            }
        });
        jPanel1.add(sucursalBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 100, 30));

        tipoDocumentoBtn.setBackground(new java.awt.Color(204, 204, 255));
        tipoDocumentoBtn.setForeground(new java.awt.Color(0, 0, 0));
        tipoDocumentoBtn.setText("Tipo Documento");
        tipoDocumentoBtn.setBorder(null);
        tipoDocumentoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tipoDocumentoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDocumentoBtnActionPerformed(evt);
            }
        });
        jPanel1.add(tipoDocumentoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 100, 30));

        empresaBtn.setBackground(new java.awt.Color(204, 204, 255));
        empresaBtn.setForeground(new java.awt.Color(0, 0, 0));
        empresaBtn.setText("Empresa");
        empresaBtn.setBorder(null);
        empresaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        empresaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empresaBtnActionPerformed(evt);
            }
        });
        jPanel1.add(empresaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 100, 30));

        tipoMovimientoBtn.setBackground(new java.awt.Color(204, 204, 255));
        tipoMovimientoBtn.setForeground(new java.awt.Color(0, 0, 0));
        tipoMovimientoBtn.setText("Tipo Movimiento");
        tipoMovimientoBtn.setBorder(null);
        tipoMovimientoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tipoMovimientoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoMovimientoBtnActionPerformed(evt);
            }
        });
        jPanel1.add(tipoMovimientoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 100, 30));

        proveedorBtn.setBackground(new java.awt.Color(204, 204, 255));
        proveedorBtn.setForeground(new java.awt.Color(0, 0, 0));
        proveedorBtn.setText("Proveedor");
        proveedorBtn.setBorder(null);
        proveedorBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        proveedorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedorBtnActionPerformed(evt);
            }
        });
        jPanel1.add(proveedorBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 100, 30));

        tipoPedidoBtn.setBackground(new java.awt.Color(204, 204, 255));
        tipoPedidoBtn.setForeground(new java.awt.Color(0, 0, 0));
        tipoPedidoBtn.setText("Tipo Pedido");
        tipoPedidoBtn.setBorder(null);
        tipoPedidoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tipoPedidoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoPedidoBtnActionPerformed(evt);
            }
        });
        jPanel1.add(tipoPedidoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 100, 30));

        clienteBtn.setBackground(new java.awt.Color(204, 204, 255));
        clienteBtn.setForeground(new java.awt.Color(0, 0, 0));
        clienteBtn.setText("Cliente");
        clienteBtn.setBorder(null);
        clienteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clienteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteBtnActionPerformed(evt);
            }
        });
        jPanel1.add(clienteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 100, 30));

        paisBtn.setBackground(new java.awt.Color(204, 204, 255));
        paisBtn.setForeground(new java.awt.Color(0, 0, 0));
        paisBtn.setText("Pais");
        paisBtn.setBorder(null);
        paisBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paisBtnActionPerformed(evt);
            }
        });
        jPanel1.add(paisBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, 30));

        metodoPagoBtn.setBackground(new java.awt.Color(204, 204, 255));
        metodoPagoBtn.setForeground(new java.awt.Color(0, 0, 0));
        metodoPagoBtn.setText("Metodo Pago");
        metodoPagoBtn.setBorder(null);
        metodoPagoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        metodoPagoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metodoPagoBtnActionPerformed(evt);
            }
        });
        jPanel1.add(metodoPagoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 100, 30));

        direccionBtn.setBackground(new java.awt.Color(204, 204, 255));
        direccionBtn.setForeground(new java.awt.Color(0, 0, 0));
        direccionBtn.setText("DIreccion");
        direccionBtn.setBorder(null);
        direccionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        direccionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionBtnActionPerformed(evt);
            }
        });
        jPanel1.add(direccionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 100, 30));

        usuarioBtn.setBackground(new java.awt.Color(204, 204, 255));
        usuarioBtn.setForeground(new java.awt.Color(0, 0, 0));
        usuarioBtn.setText("Usuario");
        usuarioBtn.setBorder(null);
        usuarioBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usuarioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioBtnActionPerformed(evt);
            }
        });
        jPanel1.add(usuarioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 100, 30));

        productoBtn.setBackground(new java.awt.Color(204, 204, 255));
        productoBtn.setForeground(new java.awt.Color(0, 0, 0));
        productoBtn.setText("Producto");
        productoBtn.setBorder(null);
        productoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoBtnActionPerformed(evt);
            }
        });
        jPanel1.add(productoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 100, 30));

        pedidoBtn.setBackground(new java.awt.Color(204, 204, 255));
        pedidoBtn.setForeground(new java.awt.Color(0, 0, 0));
        pedidoBtn.setText("Pedido");
        pedidoBtn.setBorder(null);
        pedidoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedidoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoBtnActionPerformed(evt);
            }
        });
        jPanel1.add(pedidoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 100, 30));

        proveedorProducto.setBackground(new java.awt.Color(204, 204, 255));
        proveedorProducto.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        proveedorProducto.setForeground(new java.awt.Color(0, 0, 0));
        proveedorProducto.setText("Proveedor Producto");
        proveedorProducto.setBorder(null);
        proveedorProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        proveedorProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedorProductoActionPerformed(evt);
            }
        });
        jPanel1.add(proveedorProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 100, 30));

        inventarioBtn.setBackground(new java.awt.Color(204, 204, 255));
        inventarioBtn.setForeground(new java.awt.Color(0, 0, 0));
        inventarioBtn.setText("Inventario");
        inventarioBtn.setBorder(null);
        inventarioBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inventarioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioBtnActionPerformed(evt);
            }
        });
        jPanel1.add(inventarioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 100, 30));

        compraBtn.setBackground(new java.awt.Color(204, 204, 255));
        compraBtn.setForeground(new java.awt.Color(0, 0, 0));
        compraBtn.setText("Compra");
        compraBtn.setBorder(null);
        compraBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        compraBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compraBtnActionPerformed(evt);
            }
        });
        jPanel1.add(compraBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 100, 30));

        detalleCompraBtn.setBackground(new java.awt.Color(204, 204, 255));
        detalleCompraBtn.setForeground(new java.awt.Color(0, 0, 0));
        detalleCompraBtn.setText("Detalle Compra");
        detalleCompraBtn.setBorder(null);
        detalleCompraBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        detalleCompraBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalleCompraBtnActionPerformed(evt);
            }
        });
        jPanel1.add(detalleCompraBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 100, 30));

        ventaBtn.setBackground(new java.awt.Color(204, 204, 255));
        ventaBtn.setForeground(new java.awt.Color(0, 0, 0));
        ventaBtn.setText("Venta");
        ventaBtn.setBorder(null);
        ventaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ventaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ventaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 100, 30));

        detalleVentaBtn.setBackground(new java.awt.Color(204, 204, 255));
        detalleVentaBtn.setForeground(new java.awt.Color(0, 0, 0));
        detalleVentaBtn.setText("Detalle Venta");
        detalleVentaBtn.setBorder(null);
        detalleVentaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        detalleVentaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalleVentaBtnActionPerformed(evt);
            }
        });
        jPanel1.add(detalleVentaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 100, 30));

        telefonoBtn.setBackground(new java.awt.Color(204, 204, 255));
        telefonoBtn.setForeground(new java.awt.Color(0, 0, 0));
        telefonoBtn.setText("Telefono");
        telefonoBtn.setBorder(null);
        telefonoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        telefonoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoBtnActionPerformed(evt);
            }
        });
        jPanel1.add(telefonoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 100, 30));

        empleadoBtn.setBackground(new java.awt.Color(204, 204, 255));
        empleadoBtn.setForeground(new java.awt.Color(0, 0, 0));
        empleadoBtn.setText("Empleado");
        empleadoBtn.setBorder(null);
        empleadoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        empleadoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empleadoBtnActionPerformed(evt);
            }
        });
        jPanel1.add(empleadoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 100, 30));

        detallePedidoBtn.setBackground(new java.awt.Color(204, 204, 255));
        detallePedidoBtn.setForeground(new java.awt.Color(0, 0, 0));
        detallePedidoBtn.setText("Detalle Pedido");
        detallePedidoBtn.setBorder(null);
        detallePedidoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        detallePedidoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detallePedidoBtnActionPerformed(evt);
            }
        });
        jPanel1.add(detallePedidoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 100, 30));

        estadoBtn.setBackground(new java.awt.Color(204, 204, 255));
        estadoBtn.setForeground(new java.awt.Color(0, 0, 0));
        estadoBtn.setText("Estado");
        estadoBtn.setBorder(null);
        estadoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        estadoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoBtnActionPerformed(evt);
            }
        });
        jPanel1.add(estadoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 100, 30));

        categoriaProductoBtn.setBackground(new java.awt.Color(204, 204, 255));
        categoriaProductoBtn.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        categoriaProductoBtn.setForeground(new java.awt.Color(0, 0, 0));
        categoriaProductoBtn.setText("Categoria Producto");
        categoriaProductoBtn.setBorder(null);
        categoriaProductoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        categoriaProductoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaProductoBtnActionPerformed(evt);
            }
        });
        jPanel1.add(categoriaProductoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 100, 30));

        facturaBtn.setBackground(new java.awt.Color(204, 204, 255));
        facturaBtn.setForeground(new java.awt.Color(0, 0, 0));
        facturaBtn.setText("Factura");
        facturaBtn.setBorder(null);
        facturaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        facturaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaBtnActionPerformed(evt);
            }
        });
        jPanel1.add(facturaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 100, 30));

        devolucionBtn.setBackground(new java.awt.Color(204, 204, 255));
        devolucionBtn.setForeground(new java.awt.Color(0, 0, 0));
        devolucionBtn.setText("Devolucion");
        devolucionBtn.setBorder(null);
        devolucionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        devolucionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolucionBtnActionPerformed(evt);
            }
        });
        jPanel1.add(devolucionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void historialMovimientosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialMovimientosBtnActionPerformed
        new HistorialMovimientosController();
    }//GEN-LAST:event_historialMovimientosBtnActionPerformed

    private void tipoPersonaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoPersonaBtnActionPerformed
        new TipoPersonaController();
    }//GEN-LAST:event_tipoPersonaBtnActionPerformed

    private void ciudadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciudadBtnActionPerformed
        new CiudadController();
    }//GEN-LAST:event_ciudadBtnActionPerformed

    private void tipoTelefonoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoTelefonoBtnActionPerformed
        new TipoTelefonoController();
    }//GEN-LAST:event_tipoTelefonoBtnActionPerformed

    private void sucursalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucursalBtnActionPerformed
        new SucursalController();
    }//GEN-LAST:event_sucursalBtnActionPerformed

    private void tipoDocumentoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDocumentoBtnActionPerformed
        new TipoDocumentoController();
    }//GEN-LAST:event_tipoDocumentoBtnActionPerformed

    private void empresaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empresaBtnActionPerformed
        new EmpresaController();
    }//GEN-LAST:event_empresaBtnActionPerformed

    private void tipoMovimientoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoMovimientoBtnActionPerformed
        new TipoMovimientoController();
    }//GEN-LAST:event_tipoMovimientoBtnActionPerformed

    private void proveedorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedorBtnActionPerformed
        new ProveedorController();
    }//GEN-LAST:event_proveedorBtnActionPerformed

    private void tipoPedidoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoPedidoBtnActionPerformed
        new TipoPedidoController();
    }//GEN-LAST:event_tipoPedidoBtnActionPerformed

    private void clienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteBtnActionPerformed
        new ClienteController();
    }//GEN-LAST:event_clienteBtnActionPerformed

    private void paisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paisBtnActionPerformed
        new PaisController();
    }//GEN-LAST:event_paisBtnActionPerformed

    private void metodoPagoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metodoPagoBtnActionPerformed
        new MetodoPagoController();
    }//GEN-LAST:event_metodoPagoBtnActionPerformed

    private void direccionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionBtnActionPerformed
        new DireccionController();
    }//GEN-LAST:event_direccionBtnActionPerformed

    private void usuarioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioBtnActionPerformed

    private void pedidoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoBtnActionPerformed
        new PedidoController();
    }//GEN-LAST:event_pedidoBtnActionPerformed

    private void productoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoBtnActionPerformed
        new ProductoController();
    }//GEN-LAST:event_productoBtnActionPerformed

    private void proveedorProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedorProductoActionPerformed

    }//GEN-LAST:event_proveedorProductoActionPerformed

    private void inventarioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioBtnActionPerformed
        new InventarioController();
    }//GEN-LAST:event_inventarioBtnActionPerformed

    private void compraBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compraBtnActionPerformed
        new CompraController();
    }//GEN-LAST:event_compraBtnActionPerformed

    private void detalleCompraBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalleCompraBtnActionPerformed
        new DetalleCompraController();
    }//GEN-LAST:event_detalleCompraBtnActionPerformed

    private void ventaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaBtnActionPerformed
        new VentaController();
    }//GEN-LAST:event_ventaBtnActionPerformed

    private void detalleVentaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalleVentaBtnActionPerformed
        new DetalleVentaController();
    }//GEN-LAST:event_detalleVentaBtnActionPerformed

    private void telefonoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoBtnActionPerformed
        new TelefonoController();
    }//GEN-LAST:event_telefonoBtnActionPerformed

    private void empleadoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empleadoBtnActionPerformed
        new EmpleadoController();
    }//GEN-LAST:event_empleadoBtnActionPerformed

    private void detallePedidoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detallePedidoBtnActionPerformed
        new DetallePedidoController();
    }//GEN-LAST:event_detallePedidoBtnActionPerformed

    private void estadoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoBtnActionPerformed
        new EstadoController();
    }//GEN-LAST:event_estadoBtnActionPerformed

    private void categoriaProductoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaProductoBtnActionPerformed
        new CategoriaProductoController();
    }//GEN-LAST:event_categoriaProductoBtnActionPerformed

    private void facturaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaBtnActionPerformed
        new FacturaController();
    }//GEN-LAST:event_facturaBtnActionPerformed

    private void devolucionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolucionBtnActionPerformed
        new DevolucionController();
    }//GEN-LAST:event_devolucionBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton categoriaProductoBtn;
    private javax.swing.JButton ciudadBtn;
    private javax.swing.JButton clienteBtn;
    private javax.swing.JButton compraBtn;
    private javax.swing.JButton detalleCompraBtn;
    private javax.swing.JButton detallePedidoBtn;
    private javax.swing.JButton detalleVentaBtn;
    private javax.swing.JButton devolucionBtn;
    private javax.swing.JButton direccionBtn;
    private javax.swing.JButton empleadoBtn;
    private javax.swing.JButton empresaBtn;
    private javax.swing.JButton estadoBtn;
    private javax.swing.JButton facturaBtn;
    private javax.swing.JButton historialMovimientosBtn;
    private javax.swing.JButton inventarioBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton metodoPagoBtn;
    private javax.swing.JButton paisBtn;
    private javax.swing.JButton pedidoBtn;
    private javax.swing.JButton productoBtn;
    private javax.swing.JButton proveedorBtn;
    private javax.swing.JButton proveedorProducto;
    private javax.swing.JButton sucursalBtn;
    private javax.swing.JButton telefonoBtn;
    private javax.swing.JButton tipoDocumentoBtn;
    private javax.swing.JButton tipoMovimientoBtn;
    private javax.swing.JButton tipoPedidoBtn;
    private javax.swing.JButton tipoPersonaBtn;
    private javax.swing.JButton tipoTelefonoBtn;
    private javax.swing.JLabel title;
    private javax.swing.JButton usuarioBtn;
    private javax.swing.JButton ventaBtn;
    // End of variables declaration//GEN-END:variables
}
