package com.sistema_gestion_ventas.ciudad.infrastructure.in;

import com.sistema_gestion_ventas.ciudad.domain.entity.Ciudad;
import com.sistema_gestion_ventas.ciudad.infrastructure.out.CiudadRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class CiudadController {

    private CiudadRepository ciudadRepository;

    public CiudadController() {
        this.ciudadRepository = new CiudadRepository();
        crearVentanaGestionDeCiudad();
    }

    private void crearVentanaGestionDeCiudad() {
        JFrame gestionDeCiudadFrame = new JFrame("Gestión de Ciudad");
        gestionDeCiudadFrame.setSize(600, 500);
        gestionDeCiudadFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeCiudadFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField ciudadIdField = new JTextField(20);
        ciudadIdField.setPreferredSize(new Dimension(200, 30));
        JTextField nombreField = new JTextField(20);
        nombreField.setPreferredSize(new Dimension(200, 30));
        JTextField paisIdField = new JTextField(20);
        paisIdField.setPreferredSize(new Dimension(200, 30));

        JButton btnCrear = new JButton("Crear Ciudad");
        JButton btnActualizar = new JButton("Actualizar Ciudad");
        JButton btnEliminar = new JButton("Eliminar Ciudad");
        JButton btnListar = new JButton("Listar Ciudades");
        JButton btnBuscarPorId = new JButton("Buscar Ciudad por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String paisIdStr = paisIdField.getText();
                if (nombre != null && !nombre.trim().isEmpty() && paisIdStr != null && !paisIdStr.trim().isEmpty()) {
                    try {
                        int paisId = Integer.parseInt(paisIdStr);
                        Ciudad ciudad = new Ciudad();
                        ciudad.setNombre(nombre);
                        ciudad.setPaisId(paisId);
                        ciudadRepository.createCiudad(ciudad);
                        JOptionPane.showMessageDialog(null, "Ciudad creado exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID de país inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String paisIdStr = paisIdField.getText();
                String ciudadIdStr = ciudadIdField.getText();
                if (nombre != null && !nombre.trim().isEmpty() && paisIdStr != null && !paisIdStr.trim().isEmpty() && ciudadIdStr != null && !ciudadIdStr.trim().isEmpty()) {
                    try {
                        int paisId = Integer.parseInt(paisIdStr);
                        int ciudadId = Integer.parseInt(ciudadIdStr);
                        Ciudad ciudad = new Ciudad();
                        ciudad.setCiudadId(ciudadId);
                        ciudad.setNombre(nombre);
                        ciudad.setPaisId(paisId);
                        ciudadRepository.updateCiudad(ciudad);
                        JOptionPane.showMessageDialog(null, "Ciudad actualizado exitosamente.");
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
                String ciudadIdStr = ciudadIdField.getText();
                if (ciudadIdStr != null && !ciudadIdStr.trim().isEmpty()) {
                    try {
                        int ciudadId = Integer.parseInt(ciudadIdStr);
                        ciudadRepository.deleteCiudad(ciudadId);
                        JOptionPane.showMessageDialog(null, "Ciudad eliminado exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Ciudad> ciudadList = ciudadRepository.getAllCiudad();
                StringBuilder sb = new StringBuilder("Lista de Ciudades:\n");
                for (Ciudad ciudad : ciudadList) {
                    sb.append("ID: ").append(ciudad.getCiudadId()).append(", ");
                    sb.append("nombre: ").append(ciudad.getNombre()).append(", ");
                    sb.append("paisId: ").append(ciudad.getPaisId()).append(", ");
                    sb.append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciudadIdStr = ciudadIdField.getText();
                if (ciudadIdStr != null && !ciudadIdStr.trim().isEmpty()) {
                    try {
                        int ciudadId = Integer.parseInt(ciudadIdStr);
                        Optional<Ciudad> ciudadOptional = ciudadRepository.findCiudadById(ciudadId);
                        if (ciudadOptional.isPresent()) {
                            Ciudad ciudad = ciudadOptional.get();
                            JOptionPane.showMessageDialog(null, "Ciudad encontrado:\nID: " + ciudad.getCiudadId() +
                                ", nombre: " + ciudad.getNombre() +
                                ", paisId: " + ciudad.getPaisId());
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró Ciudad con ID: " + ciudadId, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        panel.add(new JLabel("ID de Ciudad:"));
        panel.add(ciudadIdField);
        panel.add(new JLabel("Nombre de Ciudad:"));
        panel.add(nombreField);
        panel.add(new JLabel("ID de País:"));
        panel.add(paisIdField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeCiudadFrame.add(panel);
        gestionDeCiudadFrame.setVisible(true);
    }
}

