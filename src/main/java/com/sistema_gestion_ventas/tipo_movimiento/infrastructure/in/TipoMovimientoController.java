package com.sistema_gestion_ventas.tipo_movimiento.infrastructure.in;

import com.sistema_gestion_ventas.tipo_movimiento.domain.entity.TipoMovimiento;
import com.sistema_gestion_ventas.tipo_movimiento.infrastructure.out.TipoMovimientoRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class TipoMovimientoController {

    private TipoMovimientoRepository tipoMovimientoRepository;

    public TipoMovimientoController() {
        this.tipoMovimientoRepository = new TipoMovimientoRepository();
        crearVentanaGestionDeTipoMovimiento();
    }

    private void crearVentanaGestionDeTipoMovimiento() {
        JFrame gestionDeTipoMovimientoFrame = new JFrame("Gestión de TipoMovimiento");
        gestionDeTipoMovimientoFrame.setSize(600, 500);
        gestionDeTipoMovimientoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeTipoMovimientoFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField tipoMovimientoIdField = new JTextField(20);
        JTextField descripcionField = new JTextField(20);

        JButton btnCrear = new JButton("Crear TipoMovimiento");
        JButton btnActualizar = new JButton("Actualizar TipoMovimiento");
        JButton btnEliminar = new JButton("Eliminar TipoMovimiento");
        JButton btnListar = new JButton("Listar TipoMovimientos");
        JButton btnBuscarPorId = new JButton("Buscar TipoMovimiento por ID");

        // Layout configuration
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID de TipoMovimiento:"), gbc);
        gbc.gridx = 1;
        panel.add(tipoMovimientoIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Descripción:"), gbc);
        gbc.gridx = 1;
        panel.add(descripcionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(btnCrear, gbc);
        gbc.gridx = 1;
        panel.add(btnActualizar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(btnEliminar, gbc);
        gbc.gridx = 1;
        panel.add(btnListar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(btnBuscarPorId, gbc);

        // Action for Crear
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = descripcionField.getText();
                if (!descripcion.trim().isEmpty()) {
                    TipoMovimiento tipoMovimiento = new TipoMovimiento();
                    tipoMovimiento.setDescripcion(descripcion);
                    tipoMovimientoRepository.createTipoMovimiento(tipoMovimiento);
                    JOptionPane.showMessageDialog(null, "TipoMovimiento creado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Descripción es obligatoria.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Actualizar
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = descripcionField.getText();
                String tipoMovimientoIdStr = tipoMovimientoIdField.getText();
                if (!descripcion.trim().isEmpty() && !tipoMovimientoIdStr.trim().isEmpty()) {
                    try {
                        int tipoMovimientoId = Integer.parseInt(tipoMovimientoIdStr);
                        TipoMovimiento tipoMovimiento = new TipoMovimiento();
                        tipoMovimiento.setTipoMovimientoId(tipoMovimientoId);
                        tipoMovimiento.setDescripcion(descripcion);
                        tipoMovimientoRepository.updateTipoMovimiento(tipoMovimiento);
                        JOptionPane.showMessageDialog(null, "TipoMovimiento actualizado exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoMovimientoIdStr = tipoMovimientoIdField.getText();
                if (!tipoMovimientoIdStr.trim().isEmpty()) {
                    try {
                        int tipoMovimientoId = Integer.parseInt(tipoMovimientoIdStr);
                        tipoMovimientoRepository.deleteTipoMovimiento(tipoMovimientoId);
                        JOptionPane.showMessageDialog(null, "TipoMovimiento eliminado exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Listar
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<TipoMovimiento> tipoMovimientoList = tipoMovimientoRepository.getAllTipoMovimiento();
                StringBuilder sb = new StringBuilder("Lista de TipoMovimientos:\n");
                for (TipoMovimiento tipoMovimiento : tipoMovimientoList) {
                    sb.append("ID: ").append(tipoMovimiento.getTipoMovimientoId()).append(", ");
                    sb.append("Descripción: ").append(tipoMovimiento.getDescripcion()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        // Action for Buscar por ID
        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoMovimientoIdStr = tipoMovimientoIdField.getText();
                if (!tipoMovimientoIdStr.trim().isEmpty()) {
                    try {
                        int tipoMovimientoId = Integer.parseInt(tipoMovimientoIdStr);
                        Optional<TipoMovimiento> tipoMovimientoOptional = tipoMovimientoRepository.findTipoMovimientoById(tipoMovimientoId);
                        if (tipoMovimientoOptional.isPresent()) {
                            TipoMovimiento tipoMovimiento = tipoMovimientoOptional.get();
                            String message = "TipoMovimiento encontrado:\n";
                            message += "ID: " + tipoMovimiento.getTipoMovimientoId() + "\n";
                            message += "Descripción: " + tipoMovimiento.getDescripcion();
                            JOptionPane.showMessageDialog(null, message);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró TipoMovimiento con ID: " + tipoMovimientoId, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gestionDeTipoMovimientoFrame.add(panel);
        gestionDeTipoMovimientoFrame.setVisible(true);
    }
}
