package com.sistema_gestion_ventas.compra.infrastructure.in;

import com.sistema_gestion_ventas.compra.domain.entity.Compra;
import com.sistema_gestion_ventas.compra.infrastructure.out.CompraRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class CompraController {

    private CompraRepository compraRepository;

    public CompraController() {
        this.compraRepository = new CompraRepository();
        crearVentanaGestionDeCompra();
    }

    private void crearVentanaGestionDeCompra() {
        JFrame gestionDeCompraFrame = new JFrame("Gestión de Compra");
        gestionDeCompraFrame.setSize(600, 500);
        gestionDeCompraFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeCompraFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField pedidoIdField = new JTextField(20);
        pedidoIdField.setPreferredSize(new Dimension(200, 30));
        JTextField fechaCompraField = new JTextField(20);
        fechaCompraField.setPreferredSize(new Dimension(200, 30));
        JTextField estadoIdField = new JTextField(20);
        estadoIdField.setPreferredSize(new Dimension(200, 30));
        JTextField totalSinDescuentoField = new JTextField(20);
        totalSinDescuentoField.setPreferredSize(new Dimension(200, 30));
        JTextField empleadoIdField = new JTextField(20);
        empleadoIdField.setPreferredSize(new Dimension(200, 30));
        JTextField compraIdField = new JTextField(20);
        compraIdField.setPreferredSize(new Dimension(200, 30));

        JButton btnCrear = new JButton("Crear Compra");
        JButton btnActualizar = new JButton("Actualizar Compra");
        JButton btnEliminar = new JButton("Eliminar Compra");
        JButton btnListar = new JButton("Listar Compras");
        JButton btnBuscarPorId = new JButton("Buscar Compra por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int pedidoId = Integer.parseInt(pedidoIdField.getText());
                    Date fechaCompra = Date.valueOf(fechaCompraField.getText()); // Espera formato yyyy-MM-dd
                    int estadoId = Integer.parseInt(estadoIdField.getText());
                    double totalSinDescuento = Double.parseDouble(totalSinDescuentoField.getText());
                    int empleadoId = Integer.parseInt(empleadoIdField.getText());

                    Compra compra = new Compra();
                    compra.setPedidoId(pedidoId);
                    compra.setFechaCompra(fechaCompra);
                    compra.setEstadoId(estadoId);
                    compra.setTotalSinDescuento(totalSinDescuento);
                    compra.setEmpleadoId(empleadoId);
                    compraRepository.createCompra(compra);

                    JOptionPane.showMessageDialog(null, "Compra creada exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la entrada de datos. Asegúrese de que los IDs y los números sean válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Fecha inválida. Asegúrese de usar el formato yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int pedidoId = Integer.parseInt(pedidoIdField.getText());
                    Date fechaCompra = Date.valueOf(fechaCompraField.getText());
                    int estadoId = Integer.parseInt(estadoIdField.getText());
                    double totalSinDescuento = Double.parseDouble(totalSinDescuentoField.getText());
                    int empleadoId = Integer.parseInt(empleadoIdField.getText());

                    Compra compra = new Compra();
                    compra.setPedidoId(pedidoId);
                    compra.setFechaCompra(fechaCompra);
                    compra.setEstadoId(estadoId);
                    compra.setTotalSinDescuento(totalSinDescuento);
                    compra.setEmpleadoId(empleadoId);

                    compraRepository.updateCompra(compra);
                    JOptionPane.showMessageDialog(null, "Compra actualizada exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la entrada de datos. Asegúrese de que los IDs y los números sean válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Fecha inválida. Asegúrese de usar el formato yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int compraId = Integer.parseInt(compraIdField.getText());
                    compraRepository.deleteCompra(compraId);
                    JOptionPane.showMessageDialog(null, "Compra eliminada exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Compra> compraList = compraRepository.getAllCompra();
                StringBuilder sb = new StringBuilder("Lista de Compras:\n");
                for (Compra compra : compraList) {
                    sb.append("ID: ").append(compra.getCompraId()).append(", ");
                    sb.append("pedidoId: ").append(compra.getPedidoId()).append(", ");
                    sb.append("fechaCompra: ").append(compra.getFechaCompra()).append(", ");
                    sb.append("estadoId: ").append(compra.getEstadoId()).append(", ");
                    sb.append("totalSinDescuento: ").append(compra.getTotalSinDescuento()).append(", ");
                    sb.append("empleadoId: ").append(compra.getEmpleadoId()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int compraId = Integer.parseInt(compraIdField.getText());
                    Optional<Compra> compraOptional = compraRepository.findCompraById(compraId);
                    if (compraOptional.isPresent()) {
                        Compra compra = compraOptional.get();
                        String message = String.format("Compra encontrada:\nID: %d\npedidoId: %d\nfechaCompra: %s\nestadoId: %d\ntotalSinDescuento: %.2f\nempleadoId: %d",
                                compra.getCompraId(), compra.getPedidoId(), compra.getFechaCompra(), compra.getEstadoId(), compra.getTotalSinDescuento(), compra.getEmpleadoId());
                        JOptionPane.showMessageDialog(null, message);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró Compra con ID: " + compraId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(new JLabel("Compra ID:"));
        panel.add(compraIdField);
        panel.add(new JLabel("Pedido ID:"));
        panel.add(pedidoIdField);
        panel.add(new JLabel("Fecha Compra (yyyy-MM-dd):"));
        panel.add(fechaCompraField);
        panel.add(new JLabel("Estado ID:"));
        panel.add(estadoIdField);
        panel.add(new JLabel("Total Sin Descuento:"));
        panel.add(totalSinDescuentoField);
        panel.add(new JLabel("Empleado ID:"));
        panel.add(empleadoIdField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeCompraFrame.add(panel);
        gestionDeCompraFrame.setVisible(true);
    }
}

