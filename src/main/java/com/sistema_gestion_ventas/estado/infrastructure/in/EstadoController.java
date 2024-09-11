package com.sistema_gestion_ventas.estado.infrastructure.in;

import com.sistema_gestion_ventas.estado.domain.entity.Estado;
import com.sistema_gestion_ventas.estado.infrastructure.out.EstadoRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class EstadoController {

    private EstadoRepository estadoRepository;

    public EstadoController() {
        this.estadoRepository = new EstadoRepository();
        crearVentanaGestionDeEstado();
    }

    private void crearVentanaGestionDeEstado() {
        JFrame gestionDeEstadoFrame = new JFrame("Gestión de Estado");
        gestionDeEstadoFrame.setSize(600, 500);
        gestionDeEstadoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeEstadoFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField descripcionField = new JTextField(20);
        descripcionField.setPreferredSize(new Dimension(200, 30));
        JTextField estadoIdField = new JTextField(20);
        estadoIdField.setPreferredSize(new Dimension(200, 30));
        
        JButton btnCrear = new JButton("Crear Estado");
        JButton btnActualizar = new JButton("Actualizar Estado");
        JButton btnEliminar = new JButton("Eliminar Estado");
        JButton btnListar = new JButton("Listar Estados");
        JButton btnBuscarPorId = new JButton("Buscar Estado por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = descripcionField.getText();
                if (descripcion != null && !descripcion.trim().isEmpty()) {
                    Estado estado = new Estado();
                    estado.setDescripcion(descripcion);
                    estadoRepository.createEstado(estado);
                    JOptionPane.showMessageDialog(null, "Estado creado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = descripcionField.getText();
                String estadoIdStr = estadoIdField.getText();
                if (descripcion != null && !descripcion.trim().isEmpty() && estadoIdStr != null && !estadoIdStr.trim().isEmpty()) {
                    try {
                        int estadoId = Integer.parseInt(estadoIdStr);
                        Optional<Estado> estadoOptional = estadoRepository.findEstadoById(estadoId);
                        if (estadoOptional.isPresent()) {
                            Estado estado = estadoOptional.get();
                            estado.setDescripcion(descripcion);
                            estadoRepository.updateEstado(estado);
                            JOptionPane.showMessageDialog(null, "Estado actualizado exitosamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró Estado con ID: " + estadoId, "Error", JOptionPane.ERROR_MESSAGE);
                        }
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
                String estadoIdStr = estadoIdField.getText();
                if (estadoIdStr != null && !estadoIdStr.trim().isEmpty()) {
                    try {
                        int estadoId = Integer.parseInt(estadoIdStr);
                        estadoRepository.deleteEstado(estadoId);
                        JOptionPane.showMessageDialog(null, "Estado eliminado exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El ID es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Estado> estadoList = estadoRepository.getAllEstado();
                StringBuilder sb = new StringBuilder("Lista de Estados:\n");
                for (Estado estado : estadoList) {
                    sb.append("ID: ").append(estado.getEstadoId()).append(", ");
                    sb.append("descripcion: ").append(estado.getDescripcion()).append(", ");
                    sb.append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String estadoIdStr = estadoIdField.getText();
                if (estadoIdStr != null && !estadoIdStr.trim().isEmpty()) {
                    try {
                        int estadoId = Integer.parseInt(estadoIdStr);
                        Optional<Estado> estadoOptional = estadoRepository.findEstadoById(estadoId);
                        if (estadoOptional.isPresent()) {
                            Estado estado = estadoOptional.get();
                            JOptionPane.showMessageDialog(null, "Estado encontrado:\nID: " + estado.getEstadoId() + 
                                ", descripcion: " + estado.getDescripcion());
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró Estado con ID: " + estadoId, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        panel.add(new JLabel("ID de Estado:"));
        panel.add(estadoIdField);
        panel.add(new JLabel("Descripción de Estado:"));
        panel.add(descripcionField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeEstadoFrame.add(panel);
        gestionDeEstadoFrame.setVisible(true);
    }
}

