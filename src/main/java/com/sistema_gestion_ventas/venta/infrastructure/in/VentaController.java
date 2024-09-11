package com.sistema_gestion_ventas.venta.infrastructure.in;

import com.sistema_gestion_ventas.venta.domain.entity.Venta;
import com.sistema_gestion_ventas.venta.infrastructure.out.VentaRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class VentaController {

    private VentaRepository ventaRepository;

    public VentaController() {
        this.ventaRepository = new VentaRepository();
        crearVentanaGestionDeVenta();
    }

    private void crearVentanaGestionDeVenta() {
        JFrame gestionDeVentaFrame = new JFrame("Gestión de Venta");
        gestionDeVentaFrame.setSize(600, 500);
        gestionDeVentaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeVentaFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField pedidoIdField = new JTextField(20);
        JTextField fechaVentaField = new JTextField(20);
        JTextField totalSinDescuentoField = new JTextField(20);
        JTextField clienteIdField = new JTextField(20);
        JTextField estadoIdField = new JTextField(20);
        JTextField empleadoIdField = new JTextField(20);
        JButton btnCrear = new JButton("Crear Venta");
        JButton btnActualizar = new JButton("Actualizar Venta");
        JButton btnEliminar = new JButton("Eliminar Venta");
        JButton btnListar = new JButton("Listar Ventas");
        JButton btnBuscarPorId = new JButton("Buscar Venta por ID");

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("pedidoId de Venta:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(pedidoIdField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("fechaVenta de Venta:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(fechaVentaField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("totalSinDescuento de Venta:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(totalSinDescuentoField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("clienteId de Venta:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(clienteIdField, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(new JLabel("estadoId de Venta:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        panel.add(estadoIdField, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(new JLabel("empleadoId de Venta:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5;
        panel.add(empleadoIdField, gbc);

        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        panel.add(btnCrear, gbc);

        gbc.gridy = 7;
        panel.add(btnActualizar, gbc);

        gbc.gridy = 8;
        panel.add(btnEliminar, gbc);

        gbc.gridy = 9;
        panel.add(btnListar, gbc);

        gbc.gridy = 10;
        panel.add(btnBuscarPorId, gbc);

        gestionDeVentaFrame.add(panel);

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int pedidoId = Integer.parseInt(pedidoIdField.getText());
                    Date fechaVenta = Date.valueOf(fechaVentaField.getText());
                    double totalSinDescuento = Double.parseDouble(totalSinDescuentoField.getText());
                    String clienteId = clienteIdField.getText();
                    int estadoId = Integer.parseInt(estadoIdField.getText());
                    String empleadoId = empleadoIdField.getText();
                    
                    if (isNotEmpty(pedidoIdField, fechaVentaField, totalSinDescuentoField, clienteIdField, estadoIdField, empleadoIdField)) {
                        Venta venta = new Venta();
                        venta.setPedidoId(pedidoId);
                        venta.setFechaVenta(fechaVenta);
                        venta.setTotalSinDescuento(totalSinDescuento);
                        venta.setClienteId(clienteId);
                        venta.setEstadoId(estadoId);
                        venta.setEmpleadoId(empleadoId);
                        ventaRepository.createVenta(venta);
                        JOptionPane.showMessageDialog(null, "Venta creado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la entrada de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String pedidoIdStr = pedidoIdField.getText();
                    Date fechaVenta = Date.valueOf(fechaVentaField.getText());
                    double totalSinDescuento = Double.parseDouble(totalSinDescuentoField.getText());
                    String clienteId = clienteIdField.getText();
                    int estadoId = Integer.parseInt(estadoIdField.getText());
                    String empleadoId = empleadoIdField.getText();
                    
                    if (isNotEmpty(pedidoIdField, fechaVentaField, totalSinDescuentoField, clienteIdField, estadoIdField, empleadoIdField)) {
                        Venta venta = new Venta();
                        venta.setPedidoId(Integer.parseInt(pedidoIdStr));
                        venta.setFechaVenta(fechaVenta);
                        venta.setTotalSinDescuento(totalSinDescuento);
                        venta.setClienteId(clienteId);
                        venta.setEstadoId(estadoId);
                        venta.setEmpleadoId(empleadoId);
                        ventaRepository.updateVenta(venta);
                        JOptionPane.showMessageDialog(null, "Venta actualizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la entrada de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ventaId = Integer.parseInt(pedidoIdField.getText());
                    ventaRepository.deleteVenta(ventaId);
                    JOptionPane.showMessageDialog(null, "Venta eliminado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Venta> ventaList = ventaRepository.getAllVenta();
                StringBuilder sb = new StringBuilder("Lista de Ventas:\n");
                for (Venta venta : ventaList) {
                    sb.append("ID: ").append(venta.getVentaId()).append(", ");
                    sb.append("pedidoId: ").append(venta.getPedidoId()).append(", ");
                    sb.append("fechaVenta: ").append(venta.getFechaVenta()).append(", ");
                    sb.append("totalSinDescuento: ").append(venta.getTotalSinDescuento()).append(", ");
                    sb.append("clienteId: ").append(venta.getClienteId()).append(", ");
                    sb.append("estadoId: ").append(venta.getEstadoId()).append(", ");
                    sb.append("empleadoId: ").append(venta.getEmpleadoId()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ventaId = Integer.parseInt(pedidoIdField.getText());
                    Optional<Venta> ventaOptional = ventaRepository.findVentaById(ventaId);
                    if (ventaOptional.isPresent()) {
                        Venta venta = ventaOptional.get();
                        JOptionPane.showMessageDialog(null, String.format("Venta encontrado:\nID: %d\npedidoId: %d\nfechaVenta: %s\ntotalSinDescuento: %.2f\nclienteId: %s\nestadoId: %d\nempleadoId: %s",
                                venta.getVentaId(), venta.getPedidoId(), venta.getFechaVenta(), venta.getTotalSinDescuento(), venta.getClienteId(), venta.getEstadoId(), venta.getEmpleadoId()));
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró Venta con ID: " + ventaId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gestionDeVentaFrame.setVisible(true);
    }

    private boolean isNotEmpty(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText() == null || field.getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}

