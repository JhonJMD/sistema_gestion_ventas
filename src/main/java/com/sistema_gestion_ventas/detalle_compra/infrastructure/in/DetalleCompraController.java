package com.sistema_gestion_ventas.detalle_compra.infrastructure.in;

import com.sistema_gestion_ventas.detalle_compra.domain.entity.DetalleCompra;
import com.sistema_gestion_ventas.detalle_compra.infrastructure.out.DetalleCompraRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class DetalleCompraController {

    private DetalleCompraRepository detalle_compraRepository;

    public DetalleCompraController() {
        this.detalle_compraRepository = new DetalleCompraRepository();
        crearVentanaGestionDeDetalleCompra();
    }

    private void crearVentanaGestionDeDetalleCompra() {
        JFrame gestionDeDetalleCompraFrame = new JFrame("Gestión de DetalleCompra");
        gestionDeDetalleCompraFrame.setSize(600, 500);
        gestionDeDetalleCompraFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeDetalleCompraFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField compraIdField = new JTextField(20);
        JTextField productoIdField = new JTextField(20);
        JTextField cantidadField = new JTextField(20);
        JTextField precioUnitarioField = new JTextField(20);
        JTextField subtotalField = new JTextField(20);
        JButton btnCrear = new JButton("Crear DetalleCompra");
        JButton btnActualizar = new JButton("Actualizar DetalleCompra");
        JButton btnEliminar = new JButton("Eliminar DetalleCompra");
        JButton btnListar = new JButton("Listar DetalleCompras");
        JButton btnBuscarPorId = new JButton("Buscar DetalleCompra por ID");

        // Action for Crear
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int compraId = Integer.parseInt(compraIdField.getText());
                    int productoId = Integer.parseInt(productoIdField.getText());
                    int cantidad = Integer.parseInt(cantidadField.getText());
                    double precioUnitario = Double.parseDouble(precioUnitarioField.getText());
                    double subtotal = Double.parseDouble(subtotalField.getText());

                    if (compraIdField.getText().trim().isEmpty() || productoIdField.getText().trim().isEmpty() ||
                        cantidadField.getText().trim().isEmpty() || precioUnitarioField.getText().trim().isEmpty() ||
                        subtotalField.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        DetalleCompra detalle_compra = new DetalleCompra();
                        detalle_compra.setCompraId(compraId);
                        detalle_compra.setProductoId(productoId);
                        detalle_compra.setCantidad(cantidad);
                        detalle_compra.setPrecioUnitario(precioUnitario);
                        detalle_compra.setSubtotal(subtotal);
                        detalle_compraRepository.createDetalleCompra(detalle_compra);
                        JOptionPane.showMessageDialog(null, "DetalleCompra creado exitosamente.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en los datos ingresados.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Actualizar
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int compraId = Integer.parseInt(compraIdField.getText());
                    int productoId = Integer.parseInt(productoIdField.getText());
                    int cantidad = Integer.parseInt(cantidadField.getText());
                    double precioUnitario = Double.parseDouble(precioUnitarioField.getText());
                    double subtotal = Double.parseDouble(subtotalField.getText());

                    if (compraIdField.getText().trim().isEmpty() || productoIdField.getText().trim().isEmpty() ||
                        cantidadField.getText().trim().isEmpty() || precioUnitarioField.getText().trim().isEmpty() ||
                        subtotalField.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        DetalleCompra detalle_compra = new DetalleCompra();
                        detalle_compra.setCompraId(compraId);
                        detalle_compra.setProductoId(productoId);
                        detalle_compra.setCantidad(cantidad);
                        detalle_compra.setPrecioUnitario(precioUnitario);
                        detalle_compra.setSubtotal(subtotal);
                        detalle_compraRepository.updateDetalleCompra(detalle_compra);
                        JOptionPane.showMessageDialog(null, "DetalleCompra actualizado exitosamente.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en los datos ingresados.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int compraId = Integer.parseInt(compraIdField.getText());
                    detalle_compraRepository.deleteDetalleCompra(compraId);
                    JOptionPane.showMessageDialog(null, "DetalleCompra eliminado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Listar
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<DetalleCompra> detalle_compraList = detalle_compraRepository.getAllDetalleCompra();
                StringBuilder sb = new StringBuilder("Lista de DetalleCompras:\n");
                for (DetalleCompra detalle_compra : detalle_compraList) {
                    sb.append("ID: ").append(detalle_compra.getDetalleCompraId()).append(", ");
                    sb.append("compraId: ").append(detalle_compra.getCompraId()).append(", ");
                    sb.append("productoId: ").append(detalle_compra.getProductoId()).append(", ");
                    sb.append("cantidad: ").append(detalle_compra.getCantidad()).append(", ");
                    sb.append("precioUnitario: ").append(detalle_compra.getPrecioUnitario()).append(", ");
                    sb.append("subtotal: ").append(detalle_compra.getSubtotal()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        // Action for Buscar por ID
        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int compraId = Integer.parseInt(compraIdField.getText());
                    Optional<DetalleCompra> detalle_compraOptional = detalle_compraRepository.findDetalleCompraById(compraId);
                    if (detalle_compraOptional.isPresent()) {
                        DetalleCompra detalle_compra = detalle_compraOptional.get();
                        JOptionPane.showMessageDialog(null, "DetalleCompra encontrado:\n" +
                            "ID: " + detalle_compra.getDetalleCompraId() + "\n" +
                            "compraId: " + detalle_compra.getCompraId() + "\n" +
                            "productoId: " + detalle_compra.getProductoId() + "\n" +
                            "cantidad: " + detalle_compra.getCantidad() + "\n" +
                            "precioUnitario: " + detalle_compra.getPrecioUnitario() + "\n" +
                            "subtotal: " + detalle_compra.getSubtotal());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró DetalleCompra con ID: " + compraId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adding components to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("compraId de DetalleCompra:"), gbc);
        gbc.gridx = 1;
        panel.add(compraIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("productoId de DetalleCompra:"), gbc);
        gbc.gridx = 1;
        panel.add(productoIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("cantidad de DetalleCompra:"), gbc);
        gbc.gridx = 1;
        panel.add(cantidadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("precioUnitario de DetalleCompra:"), gbc);
        gbc.gridx = 1;
        panel.add(precioUnitarioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("subtotal de DetalleCompra:"), gbc);
        gbc.gridx = 1;
        panel.add(subtotalField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(btnCrear, gbc);
        gbc.gridx = 1;
        panel.add(btnActualizar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(btnEliminar, gbc);
        gbc.gridx = 1;
        panel.add(btnListar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(btnBuscarPorId, gbc);

        gestionDeDetalleCompraFrame.add(panel);
        gestionDeDetalleCompraFrame.setVisible(true);
    }
}

