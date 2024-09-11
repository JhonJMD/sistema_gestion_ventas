package com.sistema_gestion_ventas.tipo_telefono.infrastructure.in;

import com.sistema_gestion_ventas.tipo_telefono.domain.entity.TipoTelefono;
import com.sistema_gestion_ventas.tipo_telefono.infrastructure.out.TipoTelefonoRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class TipoTelefonoController {

    private TipoTelefonoRepository tipoTelefonoRepository;

    public TipoTelefonoController() {
        this.tipoTelefonoRepository = new TipoTelefonoRepository();
        crearVentanaGestionDeTipoTelefono();
    }

    private void crearVentanaGestionDeTipoTelefono() {
        JFrame gestionDeTipoTelefonoFrame = new JFrame("Gestión de TipoTelefono");
        gestionDeTipoTelefonoFrame.setSize(600, 500);
        gestionDeTipoTelefonoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeTipoTelefonoFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField tipoTelefonoIdField = new JTextField(20);
        JTextField descripcionField = new JTextField(20);

        JButton btnCrear = new JButton("Crear TipoTelefono");
        JButton btnActualizar = new JButton("Actualizar TipoTelefono");
        JButton btnEliminar = new JButton("Eliminar TipoTelefono");
        JButton btnListar = new JButton("Listar TipoTelefonos");
        JButton btnBuscarPorId = new JButton("Buscar TipoTelefono por ID");

        // Layout configuration
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID de TipoTelefono:"), gbc);
        gbc.gridx = 1;
        panel.add(tipoTelefonoIdField, gbc);

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
                    TipoTelefono tipoTelefono = new TipoTelefono();
                    tipoTelefono.setDescripcion(descripcion);
                    tipoTelefonoRepository.createTipoTelefono(tipoTelefono);
                    JOptionPane.showMessageDialog(null, "TipoTelefono creado exitosamente.");
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
                String tipoTelefonoIdStr = tipoTelefonoIdField.getText();
                if (!descripcion.trim().isEmpty() && !tipoTelefonoIdStr.trim().isEmpty()) {
                    try {
                        int tipoTelefonoId = Integer.parseInt(tipoTelefonoIdStr);
                        TipoTelefono tipoTelefono = new TipoTelefono();
                        tipoTelefono.setTipoTelefonoId(tipoTelefonoId);
                        tipoTelefono.setDescripcion(descripcion);
                        tipoTelefonoRepository.updateTipoTelefono(tipoTelefono);
                        JOptionPane.showMessageDialog(null, "TipoTelefono actualizado exitosamente.");
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
                String tipoTelefonoIdStr = tipoTelefonoIdField.getText();
                if (!tipoTelefonoIdStr.trim().isEmpty()) {
                    try {
                        int tipoTelefonoId = Integer.parseInt(tipoTelefonoIdStr);
                        tipoTelefonoRepository.deleteTipoTelefono(tipoTelefonoId);
                        JOptionPane.showMessageDialog(null, "TipoTelefono eliminado exitosamente.");
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
                List<TipoTelefono> tipoTelefonoList = tipoTelefonoRepository.getAllTipoTelefono();
                StringBuilder sb = new StringBuilder("Lista de TipoTelefonos:\n");
                for (TipoTelefono tipoTelefono : tipoTelefonoList) {
                    sb.append("ID: ").append(tipoTelefono.getTipoTelefonoId()).append(", ");
                    sb.append("Descripción: ").append(tipoTelefono.getDescripcion()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        // Action for Buscar por ID
        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoTelefonoIdStr = tipoTelefonoIdField.getText();
                if (!tipoTelefonoIdStr.trim().isEmpty()) {
                    try {
                        int tipoTelefonoId = Integer.parseInt(tipoTelefonoIdStr);
                        Optional<TipoTelefono> tipoTelefonoOptional = tipoTelefonoRepository.findTipoTelefonoById(tipoTelefonoId);
                        if (tipoTelefonoOptional.isPresent()) {
                            TipoTelefono tipoTelefono = tipoTelefonoOptional.get();
                            String message = "TipoTelefono encontrado:\n";
                            message += "ID: " + tipoTelefono.getTipoTelefonoId() + "\n";
                            message += "Descripción: " + tipoTelefono.getDescripcion();
                            JOptionPane.showMessageDialog(null, message);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró TipoTelefono con ID: " + tipoTelefonoId, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gestionDeTipoTelefonoFrame.add(panel);
        gestionDeTipoTelefonoFrame.setVisible(true);
    }
}

