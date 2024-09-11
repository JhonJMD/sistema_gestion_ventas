package com.sistema_gestion_ventas.direccion.infrastructure.in;

import com.sistema_gestion_ventas.direccion.domain.entity.Direccion;
import com.sistema_gestion_ventas.direccion.infrastructure.out.DireccionRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class DireccionController {

    private DireccionRepository direccionRepository;

    public DireccionController() {
        this.direccionRepository = new DireccionRepository();
        crearVentanaGestionDeDireccion();
    }

    private void crearVentanaGestionDeDireccion() {
        JFrame gestionDeDireccionFrame = new JFrame("Gestión de Dirección");
        gestionDeDireccionFrame.setSize(600, 500);
        gestionDeDireccionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeDireccionFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField direccionIdField = new JTextField(20);
        direccionIdField.setPreferredSize(new Dimension(200, 30));
        JTextField direccionCompletaField = new JTextField(20);
        direccionCompletaField.setPreferredSize(new Dimension(200, 30));
        JTextField ciudadIdField = new JTextField(20);
        ciudadIdField.setPreferredSize(new Dimension(200, 30));

        JButton btnCrear = new JButton("Crear Dirección");
        JButton btnActualizar = new JButton("Actualizar Dirección");
        JButton btnEliminar = new JButton("Eliminar Dirección");
        JButton btnListar = new JButton("Listar Direcciones");
        JButton btnBuscarPorId = new JButton("Buscar Dirección por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direccionCompleta = direccionCompletaField.getText();
                String ciudadIdStr = ciudadIdField.getText();
                if (direccionCompleta != null && !direccionCompleta.trim().isEmpty() && ciudadIdStr != null && !ciudadIdStr.trim().isEmpty()) {
                    try {
                        int ciudadId = Integer.parseInt(ciudadIdStr);
                        Direccion direccion = new Direccion();
                        direccion.setDireccionCompleta(direccionCompleta);
                        direccion.setCiudadId(ciudadId);
                        direccionRepository.createDireccion(direccion);
                        JOptionPane.showMessageDialog(null, "Dirección creada exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID de ciudad inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direccionCompleta = direccionCompletaField.getText();
                String ciudadIdStr = ciudadIdField.getText();
                String direccionIdStr = direccionIdField.getText();
                if (direccionCompleta != null && !direccionCompleta.trim().isEmpty() && ciudadIdStr != null && !ciudadIdStr.trim().isEmpty() && direccionIdStr != null && !direccionIdStr.trim().isEmpty()) {
                    try {
                        int ciudadId = Integer.parseInt(ciudadIdStr);
                        int direccionId = Integer.parseInt(direccionIdStr);
                        Direccion direccion = new Direccion();
                        direccion.setDireccionId(direccionId);
                        direccion.setDireccionCompleta(direccionCompleta);
                        direccion.setCiudadId(ciudadId);
                        direccionRepository.updateDireccion(direccion);
                        JOptionPane.showMessageDialog(null, "Dirección actualizada exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direccionIdStr = direccionIdField.getText();
                if (direccionIdStr != null && !direccionIdStr.trim().isEmpty()) {
                    try {
                        int direccionId = Integer.parseInt(direccionIdStr);
                        direccionRepository.deleteDireccion(direccionId);
                        JOptionPane.showMessageDialog(null, "Dirección eliminada exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Direccion> direccionList = direccionRepository.getAllDireccion();
                StringBuilder sb = new StringBuilder("Lista de Direcciones:\n");
                for (Direccion direccion : direccionList) {
                    sb.append("ID: ").append(direccion.getDireccionId()).append(", ");
                    sb.append("Dirección Completa: ").append(direccion.getDireccionCompleta()).append(", ");
                    sb.append("Ciudad ID: ").append(direccion.getCiudadId()).append(", ");
                    sb.append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String direccionIdStr = direccionIdField.getText();
                if (direccionIdStr != null && !direccionIdStr.trim().isEmpty()) {
                    try {
                        int direccionId = Integer.parseInt(direccionIdStr);
                        Optional<Direccion> direccionOptional = direccionRepository.findDireccionById(direccionId);
                        if (direccionOptional.isPresent()) {
                            Direccion direccion = direccionOptional.get();
                            JOptionPane.showMessageDialog(null, "Dirección encontrada:\nID: " + direccion.getDireccionId() +
                                ", Dirección Completa: " + direccion.getDireccionCompleta() +
                                ", Ciudad ID: " + direccion.getCiudadId());
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró dirección con ID: " + direccionId, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        panel.add(new JLabel("ID de Dirección:"));
        panel.add(direccionIdField);
        panel.add(new JLabel("Dirección Completa:"));
        panel.add(direccionCompletaField);
        panel.add(new JLabel("ID de Ciudad:"));
        panel.add(ciudadIdField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeDireccionFrame.add(panel);
        gestionDeDireccionFrame.setVisible(true);
    }
}

