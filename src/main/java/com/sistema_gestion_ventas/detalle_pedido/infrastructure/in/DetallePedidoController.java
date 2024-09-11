package com.sistema_gestion_ventas.detalle_pedido.infrastructure.in;

import com.sistema_gestion_ventas.detalle_pedido.domain.entity.DetallePedido;
import com.sistema_gestion_ventas.detalle_pedido.infrastructure.out.DetallePedidoRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class DetallePedidoController {

    private DetallePedidoRepository detalle_pedidoRepository;

    public DetallePedidoController() {
        this.detalle_pedidoRepository = new DetallePedidoRepository();
        crearVentanaGestionDeDetallePedido();
    }

    private void crearVentanaGestionDeDetallePedido() {
        JFrame gestionDeDetallePedidoFrame = new JFrame("Gestión de DetallePedido");
        gestionDeDetallePedidoFrame.setSize(600, 500);
        gestionDeDetallePedidoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeDetallePedidoFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField pedidoIdField = new JTextField(20);
        JTextField productoIdField = new JTextField(20);
        JTextField cantidadField = new JTextField(20);
        JTextField precioUnitarioField = new JTextField(20);
        JTextField subtotalField = new JTextField(20);

        JButton btnCrear = new JButton("Crear DetallePedido");
        JButton btnActualizar = new JButton("Actualizar DetallePedido");
        JButton btnEliminar = new JButton("Eliminar DetallePedido");
        JButton btnListar = new JButton("Listar DetallePedidos");
        JButton btnBuscarPorId = new JButton("Buscar DetallePedido por ID");

        // Action for Crear
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int pedidoId = Integer.parseInt(pedidoIdField.getText());
                    int productoId = Integer.parseInt(productoIdField.getText());
                    int cantidad = Integer.parseInt(cantidadField.getText());
                    double precioUnitario = Double.parseDouble(precioUnitarioField.getText());
                    double subtotal = Double.parseDouble(subtotalField.getText());

                    if (pedidoIdField.getText().isEmpty() || productoIdField.getText().isEmpty() ||
                        cantidadField.getText().isEmpty() || precioUnitarioField.getText().isEmpty() ||
                        subtotalField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        DetallePedido detalle_pedido = new DetallePedido();
                        detalle_pedido.setPedidoId(pedidoId);
                        detalle_pedido.setProductoId(productoId);
                        detalle_pedido.setCantidad(cantidad);
                        detalle_pedido.setPrecioUnitario(precioUnitario);
                        detalle_pedido.setSubTotal(subtotal);
                        detalle_pedidoRepository.createDetallePedido(detalle_pedido);
                        JOptionPane.showMessageDialog(null, "DetallePedido creado exitosamente.");
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
                    String pedidoIdStr = pedidoIdField.getText();
                    String productoIdStr = productoIdField.getText();
                    String cantidadStr = cantidadField.getText();
                    String precioUnitarioStr = precioUnitarioField.getText();
                    String subtotalStr = subtotalField.getText();

                    if (pedidoIdStr.isEmpty() || productoIdStr.isEmpty() || cantidadStr.isEmpty() ||
                        precioUnitarioStr.isEmpty() || subtotalStr.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        DetallePedido detalle_pedido = new DetallePedido();
                        detalle_pedido.setPedidoId(Integer.parseInt(pedidoIdStr));
                        detalle_pedido.setProductoId(Integer.parseInt(productoIdStr));
                        detalle_pedido.setCantidad(Integer.parseInt(cantidadStr));
                        detalle_pedido.setPrecioUnitario(Double.parseDouble(precioUnitarioStr));
                        detalle_pedido.setSubTotal(Double.parseDouble(subtotalStr));
                        detalle_pedidoRepository.updateDetallePedido(detalle_pedido);
                        JOptionPane.showMessageDialog(null, "DetallePedido actualizado exitosamente.");
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
                    int pedidoId = Integer.parseInt(pedidoIdField.getText());
                    detalle_pedidoRepository.deleteDetallePedido(pedidoId);
                    JOptionPane.showMessageDialog(null, "DetallePedido eliminado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Listar
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<DetallePedido> detalle_pedidoList = detalle_pedidoRepository.getAllDetallePedido();
                StringBuilder sb = new StringBuilder("Lista de DetallePedidos:\n");
                for (DetallePedido detalle_pedido : detalle_pedidoList) {
                    sb.append("ID: ").append(detalle_pedido.getDetallePedidoId()).append(", ");
                    sb.append("pedidoId: ").append(detalle_pedido.getPedidoId()).append(", ");
                    sb.append("productoId: ").append(detalle_pedido.getProductoId()).append(", ");
                    sb.append("cantidad: ").append(detalle_pedido.getCantidad()).append(", ");
                    sb.append("precioUnitario: ").append(detalle_pedido.getPrecioUnitario()).append(", ");
                    sb.append("subtotal: ").append(detalle_pedido.getSubTotal()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        // Action for Buscar por ID
        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int detallePedidoId = Integer.parseInt(pedidoIdField.getText());
                    Optional<DetallePedido> detalle_pedidoOptional = detalle_pedidoRepository.findDetallePedidoById(detallePedidoId);
                    if (detalle_pedidoOptional.isPresent()) {
                        DetallePedido detalle_pedido = detalle_pedidoOptional.get();
                        JOptionPane.showMessageDialog(null, "DetallePedido encontrado:\n" +
                            "ID: " + detalle_pedido.getDetallePedidoId() + "\n" +
                            "pedidoId: " + detalle_pedido.getPedidoId() + "\n" +
                            "productoId: " + detalle_pedido.getProductoId() + "\n" +
                            "cantidad: " + detalle_pedido.getCantidad() + "\n" +
                            "precioUnitario: " + detalle_pedido.getPrecioUnitario() + "\n" +
                            "subtotal: " + detalle_pedido.getSubTotal());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró DetallePedido con ID: " + detallePedidoId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adding components to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("pedidoId de DetallePedido:"), gbc);
        gbc.gridx = 1;
        panel.add(pedidoIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("productoId de DetallePedido:"), gbc);
        gbc.gridx = 1;
        panel.add(productoIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("cantidad de DetallePedido:"), gbc);
        gbc.gridx = 1;
        panel.add(cantidadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("precioUnitario de DetallePedido:"), gbc);
        gbc.gridx = 1;
        panel.add(precioUnitarioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("subtotal de DetallePedido:"), gbc);
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

        gestionDeDetallePedidoFrame.add(panel);
        gestionDeDetallePedidoFrame.setVisible(true);
    }
}

