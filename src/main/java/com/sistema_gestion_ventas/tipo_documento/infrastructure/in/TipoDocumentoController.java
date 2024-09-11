package com.sistema_gestion_ventas.tipo_documento.infrastructure.in;

import com.sistema_gestion_ventas.tipo_documento.domain.entity.TipoDocumento;
import com.sistema_gestion_ventas.tipo_documento.infrastructure.out.TipoDocumentoRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class TipoDocumentoController {

    private TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoController() {
        this.tipoDocumentoRepository = new TipoDocumentoRepository();
        crearVentanaGestionDeTipoDocumento();
    }

    private void crearVentanaGestionDeTipoDocumento() {
        JFrame gestionDeTipoDocumentoFrame = new JFrame("Gestión de TipoDocumento");
        gestionDeTipoDocumentoFrame.setSize(600, 500);
        gestionDeTipoDocumentoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeTipoDocumentoFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField tipoDocumentoIdField = new JTextField(20);
        JTextField nombreField = new JTextField(20);

        JButton btnCrear = new JButton("Crear TipoDocumento");
        JButton btnActualizar = new JButton("Actualizar TipoDocumento");
        JButton btnEliminar = new JButton("Eliminar TipoDocumento");
        JButton btnListar = new JButton("Listar TipoDocumentos");
        JButton btnBuscarPorId = new JButton("Buscar TipoDocumento por ID");

        // Layout configuration
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID de TipoDocumento:"), gbc);
        gbc.gridx = 1;
        panel.add(tipoDocumentoIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(nombreField, gbc);

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
                String nombre = nombreField.getText();
                if (!nombre.trim().isEmpty()) {
                    TipoDocumento tipoDocumento = new TipoDocumento();
                    tipoDocumento.setNombre(nombre);
                    tipoDocumentoRepository.createTipoDocumento(tipoDocumento);
                    JOptionPane.showMessageDialog(null, "TipoDocumento creado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Actualizar
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String tipoDocumentoIdStr = tipoDocumentoIdField.getText();
                if (!nombre.trim().isEmpty() && !tipoDocumentoIdStr.trim().isEmpty()) {
                    try {
                        int tipoDocumentoId = Integer.parseInt(tipoDocumentoIdStr);
                        TipoDocumento tipoDocumento = new TipoDocumento();
                        tipoDocumento.setTipoDocumentoId(tipoDocumentoId);
                        tipoDocumento.setNombre(nombre);
                        tipoDocumentoRepository.updateTipoDocumento(tipoDocumento);
                        JOptionPane.showMessageDialog(null, "TipoDocumento actualizado exitosamente.");
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
                String tipoDocumentoIdStr = tipoDocumentoIdField.getText();
                if (!tipoDocumentoIdStr.trim().isEmpty()) {
                    try {
                        int tipoDocumentoId = Integer.parseInt(tipoDocumentoIdStr);
                        tipoDocumentoRepository.deleteTipoDocumento(tipoDocumentoId);
                        JOptionPane.showMessageDialog(null, "TipoDocumento eliminado exitosamente.");
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
                List<TipoDocumento> tipoDocumentoList = tipoDocumentoRepository.getAllTipoDocumento();
                StringBuilder sb = new StringBuilder("Lista de TipoDocumentos:\n");
                for (TipoDocumento tipoDocumento : tipoDocumentoList) {
                    sb.append("ID: ").append(tipoDocumento.getTipoDocumentoId()).append(", ");
                    sb.append("Nombre: ").append(tipoDocumento.getNombre()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        // Action for Buscar por ID
        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoDocumentoIdStr = tipoDocumentoIdField.getText();
                if (!tipoDocumentoIdStr.trim().isEmpty()) {
                    try {
                        int tipoDocumentoId = Integer.parseInt(tipoDocumentoIdStr);
                        Optional<TipoDocumento> tipoDocumentoOptional = tipoDocumentoRepository.findTipoDocumentoById(tipoDocumentoId);
                        if (tipoDocumentoOptional.isPresent()) {
                            TipoDocumento tipoDocumento = tipoDocumentoOptional.get();
                            String message = "TipoDocumento encontrado:\n";
                            message += "ID: " + tipoDocumento.getTipoDocumentoId() + "\n";
                            message += "Nombre: " + tipoDocumento.getNombre();
                            JOptionPane.showMessageDialog(null, message);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró TipoDocumento con ID: " + tipoDocumentoId, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gestionDeTipoDocumentoFrame.add(panel);
        gestionDeTipoDocumentoFrame.setVisible(true);
    }
}

