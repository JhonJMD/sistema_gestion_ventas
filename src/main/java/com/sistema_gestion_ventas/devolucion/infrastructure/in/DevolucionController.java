package com.sistema_gestion_ventas.devolucion.infrastructure.in;

import com.sistema_gestion_ventas.devolucion.domain.entity.Devolucion;
import com.sistema_gestion_ventas.devolucion.infrastructure.out.DevolucionRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class DevolucionController {

    private DevolucionRepository devolucionRepository;

    public DevolucionController() {
        this.devolucionRepository = new DevolucionRepository();
        crearVentanaGestionDeDevolucion();
    }

    private void crearVentanaGestionDeDevolucion() {
        JFrame gestionDeDevolucionFrame = new JFrame("Gestión de Devolución");
        gestionDeDevolucionFrame.setSize(600, 600);
        gestionDeDevolucionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeDevolucionFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField devolucionIdField = new JTextField(20);
        devolucionIdField.setPreferredSize(new Dimension(200, 30));
        JTextField fechaDevolucionField = new JTextField(20);
        fechaDevolucionField.setPreferredSize(new Dimension(200, 30));
        JTextField motivoField = new JTextField(20);
        motivoField.setPreferredSize(new Dimension(200, 30));
        JTextField estadoIdField = new JTextField(20);
        estadoIdField.setPreferredSize(new Dimension(200, 30));
        JTextField facturaIdField = new JTextField(20);
        facturaIdField.setPreferredSize(new Dimension(200, 30));
        JButton btnCrear = new JButton("Crear Devolución");
        JButton btnActualizar = new JButton("Actualizar Devolución");
        JButton btnEliminar = new JButton("Eliminar Devolución");
        JButton btnListar = new JButton("Listar Devoluciones");
        JButton btnBuscarPorId = new JButton("Buscar Devolución por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Date fechaDevolucion = Date.valueOf(fechaDevolucionField.getText());  // Espera formato yyyy-MM-dd
                    String motivo = motivoField.getText();
                    int estadoId = Integer.parseInt(estadoIdField.getText());
                    int facturaId = Integer.parseInt(facturaIdField.getText());

                    if (!fechaDevolucionField.getText().trim().isEmpty() && !motivo.trim().isEmpty() &&
                        !estadoIdField.getText().trim().isEmpty() && !facturaIdField.getText().trim().isEmpty()) {
                        Devolucion devolucion = new Devolucion();
                        devolucion.setFechaDevolucion(fechaDevolucion);
                        devolucion.setMotivo(motivo);
                        devolucion.setEstadoId(estadoId);
                        devolucion.setFacturaId(facturaId);
                        devolucionRepository.createDevolucion(devolucion);
                        JOptionPane.showMessageDialog(null, "Devolución creada exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Fecha inválida o formato incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Date fechaDevolucion = Date.valueOf(fechaDevolucionField.getText());  // Espera formato yyyy-MM-dd
                    String motivo = motivoField.getText();
                    int estadoId = Integer.parseInt(estadoIdField.getText());
                    int facturaId = Integer.parseInt(facturaIdField.getText());

                    if (!fechaDevolucionField.getText().trim().isEmpty() && !motivo.trim().isEmpty() &&
                        !estadoIdField.getText().trim().isEmpty() && !facturaIdField.getText().trim().isEmpty()) {
                        Devolucion devolucion = new Devolucion();
                        devolucion.setFechaDevolucion(fechaDevolucion);
                        devolucion.setMotivo(motivo);
                        devolucion.setEstadoId(estadoId);
                        devolucion.setFacturaId(facturaId);
                        devolucionRepository.updateDevolucion(devolucion);
                        JOptionPane.showMessageDialog(null, "Devolución actualizada exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Fecha inválida o formato incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String devolucionIdStr = devolucionIdField.getText();
                if (!devolucionIdStr.trim().isEmpty()) {
                    try {
                        int devolucionId = Integer.parseInt(devolucionIdStr);
                        devolucionRepository.deleteDevolucion(devolucionId);
                        JOptionPane.showMessageDialog(null, "Devolución eliminada exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Devolucion> devolucionList = devolucionRepository.getAllDevolucion();
                StringBuilder sb = new StringBuilder("Lista de Devoluciones:\n");
                for (Devolucion devolucion : devolucionList) {
                    sb.append("ID: ").append(devolucion.getDevolucionId()).append(", ");
                    sb.append("fechaDevolucion: ").append(devolucion.getFechaDevolucion()).append(", ");
                    sb.append("motivo: ").append(devolucion.getMotivo()).append(", ");
                    sb.append("estadoId: ").append(devolucion.getEstadoId()).append(", ");
                    sb.append("facturaId: ").append(devolucion.getFacturaId()).append(", ");
                    sb.append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String devolucionIdStr = devolucionIdField.getText();
                if (!devolucionIdStr.trim().isEmpty()) {
                    try {
                        int devolucionId = Integer.parseInt(devolucionIdStr);
                        Optional<Devolucion> devolucionOptional = devolucionRepository.findDevolucionById(devolucionId);
                        if (devolucionOptional.isPresent()) {
                            Devolucion devolucion = devolucionOptional.get();
                            String message = "Devolución encontrada:\n";
                            message += "ID: " + devolucion.getDevolucionId() + "\n";
                            message += "Fecha Devolución: " + devolucion.getFechaDevolucion() + "\n";
                            message += "Motivo: " + devolucion.getMotivo() + "\n";
                            message += "Estado ID: " + devolucion.getEstadoId() + "\n";
                            message += "Factura ID: " + devolucion.getFacturaId();
                            JOptionPane.showMessageDialog(null, message);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró Devolución con ID: " + devolucionId, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        panel.add(new JLabel("ID de Devolución:"));
        panel.add(devolucionIdField);
        panel.add(new JLabel("Fecha Devolución (yyyy-MM-dd):"));
        panel.add(fechaDevolucionField);
        panel.add(new JLabel("Motivo de Devolución:"));
        panel.add(motivoField);
        panel.add(new JLabel("Estado ID de Devolución:"));
        panel.add(estadoIdField);
        panel.add(new JLabel("Factura ID de Devolución:"));
        panel.add(facturaIdField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeDevolucionFrame.add(panel);
        gestionDeDevolucionFrame.setVisible(true);
    }
}

