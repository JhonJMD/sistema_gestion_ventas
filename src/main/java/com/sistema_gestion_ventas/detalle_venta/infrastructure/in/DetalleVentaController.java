package com.sistema_gestion_ventas.detalle_venta.infrastructure.in;

import com.sistema_gestion_ventas.detalle_venta.domain.entity.DetalleVenta;
import com.sistema_gestion_ventas.detalle_venta.infrastructure.out.DetalleVentaRepository;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class DetalleVentaController {

    private DetalleVentaRepository detalle_ventaRepository;
    private JTextField ventaIdField;
    private JTextField productoIdField;
    private JTextField cantidadField;
    private JTextField precioUnitarioField;
    private JTextField subtotalField;
    private JTextField detalleVentaIdField;

    public DetalleVentaController() {
        this.detalle_ventaRepository = new DetalleVentaRepository();
        crearVentanaGestionDeDetalleVenta();
    }

    private void crearVentanaGestionDeDetalleVenta() {
        JFrame gestionDeDetalleVentaFrame = new JFrame("Gestión de DetalleVenta");
        gestionDeDetalleVentaFrame.setSize(600, 500);
        gestionDeDetalleVentaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeDetalleVentaFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ventaIdField = new JTextField(20);
        productoIdField = new JTextField(20);
        cantidadField = new JTextField(20);
        precioUnitarioField = new JTextField(20);
        subtotalField = new JTextField(20);
        detalleVentaIdField = new JTextField(20);

        // Create buttons
        JButton btnCrear = new JButton("Crear DetalleVenta");
        JButton btnActualizar = new JButton("Actualizar DetalleVenta");
        JButton btnEliminar = new JButton("Eliminar DetalleVenta");
        JButton btnListar = new JButton("Listar DetalleVentas");
        JButton btnBuscarPorId = new JButton("Buscar DetalleVenta por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ventaId = Integer.parseInt(ventaIdField.getText());
                    int productoId = Integer.parseInt(productoIdField.getText());
                    int cantidad = Integer.parseInt(cantidadField.getText());
                    double precioUnitario = Double.parseDouble(precioUnitarioField.getText());
                    double subtotal = Double.parseDouble(subtotalField.getText());

                    DetalleVenta detalle_venta = new DetalleVenta();
                    detalle_venta.setVentaId(ventaId);
                    detalle_venta.setProductoId(productoId);
                    detalle_venta.setCantidad(cantidad);
                    detalle_venta.setPrecioUnitario(precioUnitario);
                    detalle_venta.setSubTotal(subtotal);
                    
                    detalle_ventaRepository.createDetalleVenta(detalle_venta);
                    JOptionPane.showMessageDialog(null, "DetalleVenta creado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Datos inválidos. Verifique que todos los campos están correctamente llenos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ventaId = Integer.parseInt(ventaIdField.getText());
                    int productoId = Integer.parseInt(productoIdField.getText());
                    int cantidad = Integer.parseInt(cantidadField.getText());
                    double precioUnitario = Double.parseDouble(precioUnitarioField.getText());
                    double subtotal = Double.parseDouble(subtotalField.getText());

                    DetalleVenta detalle_venta = new DetalleVenta();
                    detalle_venta.setVentaId(ventaId);
                    detalle_venta.setProductoId(productoId);
                    detalle_venta.setCantidad(cantidad);
                    detalle_venta.setPrecioUnitario(precioUnitario);
                    detalle_venta.setSubTotal(subtotal);

                    detalle_ventaRepository.updateDetalleVenta(detalle_venta);
                    JOptionPane.showMessageDialog(null, "DetalleVenta actualizado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Datos inválidos. Verifique que todos los campos están correctamente llenos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int detalleVentaId = Integer.parseInt(detalleVentaIdField.getText());
                    detalle_ventaRepository.deleteDetalleVenta(detalleVentaId);
                    JOptionPane.showMessageDialog(null, "DetalleVenta eliminado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<DetalleVenta> detalle_ventaList = detalle_ventaRepository.getAllDetalleVenta();
                StringBuilder sb = new StringBuilder("Lista de DetalleVentas:\n");
                for (DetalleVenta detalle_venta : detalle_ventaList) {
                    sb.append("ID: ").append(detalle_venta.getDetalleVentaId()).append(", ");
                    sb.append("ventaId: ").append(detalle_venta.getVentaId()).append(", ");
                    sb.append("productoId: ").append(detalle_venta.getProductoId()).append(", ");
                    sb.append("cantidad: ").append(detalle_venta.getCantidad()).append(", ");
                    sb.append("precioUnitario: ").append(detalle_venta.getPrecioUnitario()).append(", ");
                    sb.append("subtotal: ").append(detalle_venta.getSubTotal()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int detalleVentaId = Integer.parseInt(detalleVentaIdField.getText());
                    Optional<DetalleVenta> detalle_ventaOptional = detalle_ventaRepository.findDetalleVentaById(detalleVentaId);
                    if (detalle_ventaOptional.isPresent()) {
                        DetalleVenta detalle_venta = detalle_ventaOptional.get();
                        JOptionPane.showMessageDialog(null, String.format("DetalleVenta encontrado:\nID: %d\nventaId: %d\nproductoId: %d\ncantidad: %d\nprecioUnitario: %.2f\nsubtotal: %.2f",
                                detalle_venta.getDetalleVentaId(),
                                detalle_venta.getVentaId(),
                                detalle_venta.getProductoId(),
                                detalle_venta.getCantidad(),
                                detalle_venta.getPrecioUnitario(),
                                detalle_venta.getSubTotal()));
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró DetalleVenta con ID: " + detalleVentaId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(new JLabel("ventaId de DetalleVenta:"));
        panel.add(ventaIdField);
        panel.add(new JLabel("productoId de DetalleVenta:"));
        panel.add(productoIdField);
        panel.add(new JLabel("cantidad de DetalleVenta:"));
        panel.add(cantidadField);
        panel.add(new JLabel("precioUnitario de DetalleVenta:"));
        panel.add(precioUnitarioField);
        panel.add(new JLabel("subtotal de DetalleVenta:"));
        panel.add(subtotalField);
        panel.add(new JLabel("ID de DetalleVenta para eliminar o buscar:"));
        panel.add(detalleVentaIdField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeDetalleVentaFrame.add(panel);
        gestionDeDetalleVentaFrame.setVisible(true);
    }
}
