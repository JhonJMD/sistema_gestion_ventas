package com.sistema_gestion_ventas.tipo_persona.infrastructure.in;

import com.sistema_gestion_ventas.tipo_persona.domain.entity.TipoPersona;
import com.sistema_gestion_ventas.tipo_persona.infrastructure.out.TipoPersonaRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class TipoPersonaController {

    private TipoPersonaRepository tipoPersonaRepository;

    public TipoPersonaController() {
        this.tipoPersonaRepository = new TipoPersonaRepository();
        crearVentanaGestionDeTipoPersona();
    }

    private void crearVentanaGestionDeTipoPersona() {
        JFrame gestionDeTipoPersonaFrame = new JFrame("Gestión de TipoPersona");
        gestionDeTipoPersonaFrame.setSize(600, 500);
        gestionDeTipoPersonaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeTipoPersonaFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField tipoPersonaIdField = new JTextField(20);
        JTextField descripcionField = new JTextField(20);

        JButton btnCrear = new JButton("Crear TipoPersona");
        JButton btnActualizar = new JButton("Actualizar TipoPersona");
        JButton btnEliminar = new JButton("Eliminar TipoPersona");
        JButton btnListar = new JButton("Listar TipoPersonas");
        JButton btnBuscarPorId = new JButton("Buscar TipoPersona por ID");

        // Layout configuration
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID de TipoPersona:"), gbc);
        gbc.gridx = 1;
        panel.add(tipoPersonaIdField, gbc);

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
                    TipoPersona tipoPersona = new TipoPersona();
                    tipoPersona.setDescripcion(descripcion);
                    tipoPersonaRepository.createTipoPersona(tipoPersona);
                    JOptionPane.showMessageDialog(null, "TipoPersona creado exitosamente.");
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
                String tipoPersonaIdStr = tipoPersonaIdField.getText();
                if (!descripcion.trim().isEmpty() && !tipoPersonaIdStr.trim().isEmpty()) {
                    try {
                        int tipoPersonaId = Integer.parseInt(tipoPersonaIdStr);
                        TipoPersona tipoPersona = new TipoPersona();
                        tipoPersona.setTipoPersonaId(tipoPersonaId);
                        tipoPersona.setDescripcion(descripcion);
                        tipoPersonaRepository.updateTipoPersona(tipoPersona);
                        JOptionPane.showMessageDialog(null, "TipoPersona actualizado exitosamente.");
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
                String tipoPersonaIdStr = tipoPersonaIdField.getText();
                if (!tipoPersonaIdStr.trim().isEmpty()) {
                    try {
                        int tipoPersonaId = Integer.parseInt(tipoPersonaIdStr);
                        tipoPersonaRepository.deleteTipoPersona(tipoPersonaId);
                        JOptionPane.showMessageDialog(null, "TipoPersona eliminado exitosamente.");
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
                List<TipoPersona> tipoPersonaList = tipoPersonaRepository.getAllTipoPersona();
                StringBuilder sb = new StringBuilder("Lista de TipoPersonas:\n");
                for (TipoPersona tipoPersona : tipoPersonaList) {
                    sb.append("ID: ").append(tipoPersona.getTipoPersonaId()).append(", ");
                    sb.append("Descripción: ").append(tipoPersona.getDescripcion()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        // Action for Buscar por ID
        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoPersonaIdStr = tipoPersonaIdField.getText();
                if (!tipoPersonaIdStr.trim().isEmpty()) {
                    try {
                        int tipoPersonaId = Integer.parseInt(tipoPersonaIdStr);
                        Optional<TipoPersona> tipoPersonaOptional = tipoPersonaRepository.findTipoPersonaById(tipoPersonaId);
                        if (tipoPersonaOptional.isPresent()) {
                            TipoPersona tipoPersona = tipoPersonaOptional.get();
                            String message = "TipoPersona encontrado:\n";
                            message += "ID: " + tipoPersona.getTipoPersonaId() + "\n";
                            message += "Descripción: " + tipoPersona.getDescripcion();
                            JOptionPane.showMessageDialog(null, message);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró TipoPersona con ID: " + tipoPersonaId, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gestionDeTipoPersonaFrame.add(panel);
        gestionDeTipoPersonaFrame.setVisible(true);
    }
}

